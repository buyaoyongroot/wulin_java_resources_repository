package cn.itcast.java.proxy.exe2;

//Ŀ�����
public class Liyuchun implements Star {
	public void sing(String money) {
		System.out.println("���糪��");
	}
	public void dance(String money, String what) {
		System.out.println("�������裬����Ϊ" + what);
	}
	public void eat(String money) {
		System.out.println("�������");
	}
}
