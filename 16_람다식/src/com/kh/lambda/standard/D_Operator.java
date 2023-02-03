package com.kh.lambda.standard;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import com.kh.lambda.standard.vo.Student;

public class D_Operator {
	
// 230127 7교시
	
	/*
	 * Operator
	 * 
	 * 	- Operator 함수적 인터페이스는 매개값과 리턴 값이 있는 apply() 메소드를 가지고 있다.
	 * 	- apply() 추상 메소드는 주로 매개값을 이용해서 연산을 하고 동일한 타입으로 결과를 리턴하는 역할을 한다.
	 * 
	 */
	public void method1() {

// 230127 7교시
		Student student1 = new Student("문인수", 20, "남자", 70, 80);
		Student student2 = new Student("홍길동", 30, "남자", 100, 100);
		
		
	// IntBinaryOperator
		//두 개의 int형 타입을 매개값으로 받아 실행하고 연산한 후 int형으로 리턴
//		IntBinaryOperator intBinaryOperator = (int a, int b) -> {
//			return a + b;
//		};
		
		IntBinaryOperator intBinaryOperator = (a, b) -> a + b;

		System.out.println(intBinaryOperator.applyAsInt(10, 20));
		
		
		IntUnaryOperator intUnaryOperator = (int a) -> {
			return a * a;
		};
		
		System.out.println(intUnaryOperator.applyAsInt(3));
	
	
	// BinaryOperator
		//BiFunction을 상속하고 있다.
		//수학 점수가 더 큰 스튜던트 객체 리턴
//		BinaryOperator<Student> binaryOperator = (Student s1, Student s2) -> {
//			return s1.getMath() > s2.getMath() ? s1: s2;
//		};

		BinaryOperator<Student> binaryOperator = (s1, s2) -> s1.getMath() > s2.getMath() ? s1: s2;
		
		System.out.println(binaryOperator.apply(student1, student2));
		
	
	
	}
}
