import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public static void main(String[] args) {

		// ���Դ�ͼƬ�ļ�ת��ΪBase64����
		//String imageStr = GetImageStr("http://localhost:8080/openPicture/image/IMG_0073.JPG");

		///System.out.println(imageStr);

		// ���Դ�Base64����ת��ΪͼƬ�ļ�

		// String strImg = "�����64λ����";
		///GenerateImage(imageStr, "D:\\dress88.jpg");
		getImageStr("http://localhost:8080/openPicture/image/IMG_0073.JPG","D:\\dress88.jpg");

	}

	/**
	 * ��ͼƬת��Ϊbase64����
	 * 
	 * @param imgFilePath
	 *            ͼƬ�����·��
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
		byte[] data = null;

		// ��ȡͼƬ�ֽ�����
		try {
			URL url = new URL(imgFilePath);
			InputStream in = url.openStream();
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}

	/**
	 * ����base64�����ַ���ת��ΪͼƬ
	 * 
	 * @param imgStr
	 *            ��base64���������ַ���
	 * @param imgFilePath
	 *            ͼƬ���·��
	 * @return
	 */
	public static boolean GenerateImage(String imgStr, String imgFilePath) {// ���ֽ������ַ�������Base64���벢����ͼƬ
		if (imgStr == null) // ͼ������Ϊ��
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// �����쳣����
					bytes[i] += 256;
				}
			}
			// ����jpegͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void getImageStr (String _path, String _savePath) {
		String savePath = _savePath;
		String path = _path;
		int BYTE_SIZE = 1;
		int SAVE_SIZE = 1024;
		byte[] buff = new byte[BYTE_SIZE]; // ÿ�ζ��Ļ���
		byte[] save = new byte[SAVE_SIZE]; // ����ǰ����
		BufferedInputStream bf = null;
		FileOutputStream file;
		URL url = null;
		String imgBase64 = "";
		HttpURLConnection httpUrl;
		try {
			// ���ֽ�����Base64����
			BASE64Encoder encoder = new BASE64Encoder();

			url = new URL(path);
			httpUrl = (HttpURLConnection) url.openConnection();
			bf = new BufferedInputStream(httpUrl.getInputStream());
			file = new FileOutputStream(savePath);
	
			int i = 0;
			while (bf.read(buff) != -1) { // һ���ֽ�һ���ֽڶ�
				save[i] = buff[0];
				if (i == SAVE_SIZE - 1) { // �ﵽ���泤��ʱ��ʼ����
					imgBase64 += encoder.encode(save);
					file.write(save, 0, SAVE_SIZE);
					save = new byte[SAVE_SIZE];
					i = 0;
				} else {
					i++;
				}
			}
			// ���������û�ﵽ���泤�ȣ���Ҫ��ǰ��ı�������
			if (i > 0) {
				imgBase64 += encoder.encode(save);
				file.write(save, 0, i - 1);
			}
			httpUrl.disconnect();
			file.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				bf.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
