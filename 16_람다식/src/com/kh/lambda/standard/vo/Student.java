package com.kh.lambda.standard.vo;

public class Student {

// 230127 6교시
	
	// 필드 생성
	private String name;

	private int age;
	
	private String gender;
	
	private int math;
	
	private int english;
	
	
	// 기본 생성자
	public Student() {
		
	}
	
	// alt shift s	generate constructor using fields

//	C_Function의 Function & C_MethodReference의 57~67행 할 때 씀(Application의 95행 참조)
	public Student(String name, int age, String gender, int math, int english) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.math = math;
		this.english = english;
	}

//	C_Function의 BiFunction 할 때 씀
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	// alt shift s	generate getters and setters
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	// alt shift s	generate toString
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", math=" + math + ", english="
				+ english + "]";
	}



	
	
	
}
