package cn.scxh.util;

public class ConstantConver {
	public static String getHobby(String hobby){
		String s = hobby.replaceAll("00", "����").replaceAll("01", "����").replaceAll("02", "ƹ����")
		             .replaceAll("03", "�߶���").replaceAll("\\[", "").replaceAll("\\]", "");
		return s;
	}

}
