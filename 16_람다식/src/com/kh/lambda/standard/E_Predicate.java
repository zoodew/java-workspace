package com.kh.lambda.standard;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.kh.lambda.standard.vo.Student;

public class E_Predicate {

// 230130 1교시
	/*
	 * Predicate
	 * 
	 * 	- Predicate 함수적 인터페이스는 매개변수와 boolean 값을 리턴하는 test() 추상 메소드를 가지고 있다.
	 *  - test() 추상 메소드는 매개값을 조사(매개값이 숫자면 0보다 큰지, 100보다 작은지 등등 다양하게 조사)해서 true / false를 리턴하는 역할을 한다.
	 * 
	 */
	
// 230130 1교시	
	public void method1() {
		// Student 객체 생성
		Student student1 = new Student("문인수", 20, "남자", 80, 70);
		Student student2 = new Student("성춘향", 20, "여자", 100, 100);
		
	
	// 기본 Predicate
		// Predicate 함수적 인터페이스 생성 남자이면 true 여자이면 false
//		Predicate<Student> predicate = (Student student) -> {
//			
//			// 자바에서 문자열 비교는 동등 연산자가 아닌 equals() 메소드 사용해야 함
//			return student.getGender().equals("남자");
//		};
		
		Predicate<Student> predicate = student -> student.getGender().equals("남자");
		
												// 람다식으로 구현된 메소드에 test() 메소드 사용
		System.out.println("문인수는 남자입니까? : " + predicate.test(student1));
		System.out.println("성춘향은 남자입니까? : " + predicate.test(student2));
		
		
// 230130 2교시
		
	// BiPredicate 두 개의 매개변수를 받는 함수적 인터페이스
//		BiPredicate<Student, Student> biPredicate = (Student s1, Student s2) -> {
//			
//			// 두 학생의 성별이 같은지 비교하는 코드
//			return s1.getGender().equals(s2.getGender());
//		};
		
		BiPredicate<Student, Student> biPredicate = (s1, s2) -> s1.getGender().equals(s2.getGender());
		
		System.out.println("두 학생의 성별이 동일합니까? : " + biPredicate.test(student1, student2));
		
	// IntPredicate
		// 정수값 하나 매개변수로 받아서 그 값이 100보다 크면 true, 100보다 작으면 false
//		IntPredicate intPredicate = (int a) -> {
//			return a > 100;
//		};
		
		IntPredicate intPredicate = a -> a > 100;
		
		System.out.println(intPredicate.test(100));
		System.out.println(intPredicate.test(101));
	
	
	}

	
	
	
	



}
