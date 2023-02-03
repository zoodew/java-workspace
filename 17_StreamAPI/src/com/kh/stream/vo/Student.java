package com.kh.stream.vo;

import java.util.Objects;

// 230130 5교시
// 230131 1교시
public class Student implements Comparable<Student>{
			// 에러 발생 왜? implements는 추상메소드가 있으면 안 됨 113행 만들어줌
	
	// 필드
	private int idx;		// 230131 6교시에 추가	terminal C_Collect
	
	private String name;
	
	private int age;
	
	private String gender;
	
	private int math;
	
	private int english;

	
	// ctrl space
	// 기본 생성자
	public Student() {
	}	
	
	
	// shift alt s
	// 모든 필드를 갖는 생성자(idx 제외)
	public Student(String name, int age, String gender, int math, int english) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.math = math;
		this.english = english;
	}

	// 모든 필드를 갖는 생성자(idx 포함)	230131 6교시에 idx 추가	terminal C_Collect
	public Student(int idx, String name, int age, String gender, int math, int english) {
		super();
		this.idx = idx;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.math = math;
		this.english = english;
	}


	// 게터세터
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

	// idx 게터 세터 추가		230131 6교시			terminal C_Collect
	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	// generate hashCode and equals
	// 이름 나이 성별 성적,,, 필드값이 다 동일하면 동일하게 볼 수 있게 하는 메소드
	// 이 메소드가 재정의 되어 있어야 중복 제거가 가능함 A_Filtering의 61행
	@Override
	public int hashCode() {
		return Objects.hash(age, english, gender, math, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && english == other.english && Objects.equals(gender, other.gender)
				&& math == other.math && Objects.equals(name, other.name);
	}


	// toString() 메소드
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", math=" + math + ", english="
//				+ english + "]";
//	}
	
	// toString() 230131 idx추가해서 다시 생성
	@Override
	public String toString() {
		return "Student [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", math=" + math
				+ ", english=" + english + "]";
	}
	

// 230131 1교시		B_Sorted students 정렬
	@Override
	public int compareTo(Student student) {
		return this.age - student.age;
	}

	
	
	

}
