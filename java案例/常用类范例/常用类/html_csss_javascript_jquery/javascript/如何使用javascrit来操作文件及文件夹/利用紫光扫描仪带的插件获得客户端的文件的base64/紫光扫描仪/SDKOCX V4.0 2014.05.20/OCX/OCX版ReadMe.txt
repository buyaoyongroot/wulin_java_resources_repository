ʹ��ǰ��Ҫ��ע��SDKOCX2.0.ocx�������ǣ���WIN+R����ݼ��򿪡����С����ڡ��򿪡��������롰regsvr32 ��,�϶�SDKOCX2.0.ocx�����򿪡����ڣ����Զ���ʾ�ļ�����·��������ENTER�������ע�ᡣ

1.   LoadDll()
����Ҫ��װ��dll�ļ�
����ֵ��
  1 ���ɹ�
  0�� ʧ��

2.long SelectScanner(CHAR* pSourceName)
˵����ѡ��ɨ���ǣ�������δִ��ǰ���������ϵͳĬ��ɨ������Ϊʹ�ö���
����ֵ��BOOL �ͣ�1 ����ɹ���
����[in]���ַ����ͣ��������壬�Ƽ��ÿ��ַ�����

��ͨ�������豸�ͺ����ƣ�����Ĭ�ϵ�ɨ�����豸
����SelectScanner("Uniscan B6800");
    SelectScanner("Uniscan F25A");
ע���ֶ�������Ҫ��EnConnect������������ǰ������SelectScanner("...");������...Ϊ��Ҫ���õ��豸�ͺ����ơ���ͨ��MFCDEMOforSDK.exe�鿴��Ҫ������ַ�����ѡ���豸���ڶԻ�������ʾ�ļ�Ϊ��Ҫ������ַ�����

3.long EnConnect(LONG iValue)
˵�������ӵ�ɨ���ǣ���disconnect ���ʹ�ã���ȷ��ִ��scan ����ǰ��������ִ�У�
����ֵ��BOOL �ͣ�0 ����ʧ�ܣ�1 ����ɹ���
����[in]���ַ����ͣ����ڴ��ݴ��ھ����SDK ����ʹ�ã�

4.long DisConnect()
˵�������ӵ�ɨ���ǣ���EnConnect ���ʹ�ã�
����ֵ��BOOL �ͣ�0 ����ʧ�ܣ�1 ����ɹ���

5.long SetScanner(LONG ImageIndex, LONG FileType, LONG nParam1, LONG nParam2, FLOAT Param3)
˵��������ɨ�貿�ֲ���
ImageIndex���ļ���������������0�����������ļ�·��ΪX:\XXX\XX0000.xxx����׺���ݸ�ʽȷ����
FileType��ͼƬ�ļ���ʽ����
	-0Ϊbmp
	-1Ϊtiff
	-2Ϊjpeg
	-3Ϊgif
	-4Ϊpdf
	-5Ϊpng
�ļ��������ݴ��趨ָ����λ��׺
nParam1 ����ͼ��ѹ����(JPG��TIF,PDF��Ч)ȡֵΪ1~100;
nParam2 �����Ƿ����ɶ�ҳ�ļ�(������PDF,TIF�ļ���ʽ��ADFӲ������)��0Ϊ���ɵ�ҳ�ļ���1Ϊ���ɶ�ҳ�ļ�;
Param3 ����ͼ����ת�Ƕȣ�ȡֵ0~360����תΪ������

6.LONG StartScanner(LPCTSTR path, LPCTSTR filename);
˵����ִ��ɨ�蹦��
����ֵ������ֵ����0 ʱ��ʾɨ��ɹ���������ֵ����1ʱ������ֵ��Ϊɨ��ҳ��
����ֵΪ0 ʱɨ���ǲ�������
����ֵΪ��1 ʱ�ڴ����
����ֵΪ��2 ʱ���̴���
����ֵΪ��3 ʱ��ȡͼ��ʧ�ܴ���
����ֵΪ��4 ʱ�������ô���
����[in]��
path�� ָ��ɨ����ļ������ֺ����·�����磺C:\TEST\������ȷ���趨��·����д���Ѿ�����;
fileName��ָ��ɨ���ļ�������aaa��,���������ļ���׺����׺������ͼƬ��ʽ��������;

7.long SetScannerSource(LONG Sourece)
˵��������ɨ��Դ��
����ֵ��BOOL �ͣ�0 ����ʧ�ܣ�
����[in]��long�ͣ�Ĭ��Ϊ0��ADFɨ���ǽ�������Ϊ1��˫��ADFΪ2;

8.long SetScannerContrast(LONG Contrast)
˵��������ɨ��Աȶȣ��ڰ�ģʽʱʧЧ
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[in]��long�ͣ�ȡֵ��Χ��-1000~1000;

9.long SetScannerBright(LONG Bright)
˵��������ɨ�����ȣ��ڰ�ģʽʱʧЧ
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[in]��long�ͣ�ȡֵ��Χ��-1000~1000;

10.long SetThreshold(LONG Threshold)
˵��������ɨ����ֵ��ֻ�ںڰ�ɨ��ģʽ(��ֵģʽ)ʱ������;
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[in]��long�ͣ�ȡֵ��Χ��1~255;

11.long SetScannerImageType(LONG ScannerImageType)
˵��������ɨ������;
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[in]��long��
-0Ϊ�ڰ�ģʽ
-1Ϊ�Ҷ�ģʽ
-2Ϊ��ɫģʽ
-3Ϊ������ɨ��

12.long SetScannerDPI(LONG ScanDPI)
˵��������ɨ��DPI;
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[in]��long�ͣ�ȡֵ��Χ100dpi~4800dpi;

13.SetScannerScanRgn(LONG Left, LONG Top, LONG Right, LONG Bottom)
˵��������ɨ�����򣬵�λ�����ף�ȡֵ��Χ��420mm��600mm��A4 ����Ϊ210��300��
���η�Χ�����ϵ�λ�ú����µ�λ�þ���;
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[in]��long��
Left:���ϵ������(ɨ����߼�)
Top:���ϵ�������(ɨ���ϱ߼�)
Right:���µ�������(ɨ���ұ߼�)
Bottom:���µ�������(ɨ���±߼�)

14.long  GetDsName(CHAR* DSName)
˵�������ɨ���豸(Data Source,DS)����;
����ֵ��BOOL �ͣ�0 ����ʧ��;
����[out]��char*�ͣ���õ��豸���Ʊ����ַ��������DSName��;

15.long  SetScanInvert(LONG bInvert)
˵��������ȡ��ɫ��������δִ��ǰ��Ĭ��Ϊ��ȡ��ɫ��
����ֵ��BOOL �ͣ�0 ����ʧ�ܣ�
����[in]��BOOL�ͣ��Ƿ�ȡ��ɫɨ�裬1Ϊ���У�0Ϊ�����У�


16.LONG PostFile(LPCTSTR strURL, LPCTSTR strFileName, LPCTSTR strRecord, BSTR FAR* strResponse)

	˵�����������ļ�ͨ��Post��ʽ�ϴ�����������

	������	
		strURL��	�ϴ��ķ�������ҳ��ַ��
		strFileName��	��Ҫ�ϴ��ı����ļ�����Ӧ��Ϊ�ļ������ƣ���Ҫ��д�����ľ���·��������"c:\image.jpg";
		strRecord��	��װForm��ĵ�һ����¼���ݣ�
		strResponse��	Post�ķ���Response���ݣ�
	
	����ֵ��BOOL�ͣ�0����ʧ�ܣ�1�ɹ�;

	
	Form�ṹ��
		�ֶ�һ��FileID��  ���ݣ�strRecord;
		�ֶζ���Filedata�����ݣ��ļ���;
		�ֶ��������������ݣ��ļ��Ķ�������;


function PostFile()
{
  var strFileName = "c:\\image0000.pdf";
  var strURL= "http://.../xxx.jsp";
  var strRecord = "FileName";
  var strResponse;
  var re = DOcxtest1.PostFile(strURL, strFileName, strRecord, strResponse);
}

17.BSTR GetFileName(void)
˵������������ͼ����
����ֵ��BSTR�ͣ��ַ�������

18.BSTR GetFullFileName(void)
˵��������������ͼ��·����ͼ����
����ֵ��BSTR�ͣ��ַ�������	

19.BSTR FileToBase64(LPCTSTR filePath)
	���ڻ�ö�Ӧ�ļ���base64������
	������	 filePath ������base64�����ļ�����Ϊ�ͻ��˱����ļ�(����ɨ����ļ�),����д��Ч·����ȫ�ļ�����
	����ֵ�� Base64����Ϊ��ʱ��ʾת��ʧ�ܣ�

20.long SetOCXSize(long nWidth, long nHeight)
	�趨ActiveX�����С
	������	nWidth  ����Ŀ�
		nHeight ����ĸ�

21.long SetCoverFile(long bCover)
˵���������Ƿ񸲸�ͬ���ļ���������δִ��ǰ��Ĭ��Ϊ�����ǣ�
����ֵ��BOOL �ͣ�1����������0 ����ʧ�ܣ�
����[in]��BOOL�ͣ��Ƿ񸲸�ͬ���ļ���1Ϊ���ǣ�0Ϊ�����ǣ�

22.long RotateImage(LPCTSTR strFileName,float RotateAngle)
˵������תͼ��
����ֵ��BOOL �ͣ�1����������0 ����ʧ�ܣ�
����[in]��
strFileName ��Ҫ��ת��ͼ���ȫ·����
RotateImage ��ת�Ƕȣ�˳ʱ����ת����

23.long GetImageNumber()
˵����������ɨ��ҳ��
����ֵ��long�ͣ���ֵΪ��ɨ���ҳ����0����ʧ�ܣ�
��������










