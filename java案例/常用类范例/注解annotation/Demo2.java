package cn.itcast.java.annotation;

public class Demo2 {
	@MyAnnotation(who="jack",age=30,gender="male")
	public void jump(){
	}
	
	@YouAnnotation
	public void sleep(){
	}
	
	@TheyAnnotation(value={"����","ϴ�»�"})
	public void buy(){
		
	}
	
	@TheyAnnotation({"����","��Ϸ"})
	public void play(){
		
	} 
	
	public static void main(String[] args) {
		Demo2 demo = new Demo2();
		demo.jump();
	}
}
