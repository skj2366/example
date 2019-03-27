package osf.db.con2;

public class Student {

	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "해당 학생의 이름은 " + name + "이며 나이는 " + age + "입니다." ;
	}
	
}
