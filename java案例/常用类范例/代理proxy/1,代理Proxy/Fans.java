package cn.itcast.java.proxy.exe2;

//��/����
public class Fans {
	public static void main(String[] args) {
		//�����������
		LiyuchunProxy liyuchunProxy = new LiyuchunProxy();
		//ͨ�����������Ŀ�����
		Star star = liyuchunProxy.getProxy();
		//ҵ�񷽷�
		star.sing("3");
		//ҵ�񷽷�
		star.dance("5","ǡǡ��");
		//ҵ�񷽷�
		star.eat("8");
	}
}
