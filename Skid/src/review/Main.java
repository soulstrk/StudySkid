package review;

public class Main {

	public static void main(String[] args) {
//		Student s1 = new Student("Skid");
//		Student s2 = new Student("Skid");
//		System.out.println(s1 == s2);
//		System.out.println(s1.equals(s2)); //equal 메소드 설명시에 필요한 로직
		
		Student s1 = new Student("Skid");
		//clone은 protected 접근제어자를 사용하고 있다 그러므로 오브젝트 클래스는 다른 패키지에 소속되있기 때문에 설정을 필요로함.
		try {
			Student s2 = (Student)s1.clone();
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
// Cloneable 이란 인터페이스는 어떤 클래스가 복제가능하다는 사실을 명시해주는 역할을 할 뿐이다. (약속)
class Student extends Object implements Cloneable{
	String name;
	
	Student(String name){
		this.name = name;
	}
	public boolean equals(Object obj) {
		Student s = (Student)obj; // 부모가 자식에게 들어 갈때는 형변환이 꼭 필요하다 !!	
			return this.name == s.name;  // equals 라는 오브젝트클래스의 메서드를 오버라이딩해서 사용하는법
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone(); // public으로 바꿔줌
	}
}



