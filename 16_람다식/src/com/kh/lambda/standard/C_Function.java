package com.kh.lambda.standard;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.kh.lambda.standard.vo.Student;

public class C_Function {
	
// 230127 6교시
	
	/*
	 * Function
	 * 	
	 * 	- Function 함수적 인터페이스는 매개값과 리턴값이 있는 apply() 추상 메소드를 가지고 있다.
	 * 	- apply() 추상 메소드는 주로 매개값을 리턴값으로 매핑(타입 변환)하는 역할을 한다.
	 * 	- Function, BiFunction
	 */
	
	public void method1() {
		
		// student 객체 생성
		Student student = new Student("문인수", 20, "남자", 70, 80);
		
	// Function
		
		// <T,R> T 매개값으로 받을 타입, R 리턴 타입	// r Student 타입으로 매개값 받음 변수명 s
//		Function<Student, String> function = (Student s) -> {
//				// ㄴ Sutdent 타입으로 인스턴스를 매개값으로 받아서 String 타입으로 리턴해줌
//			return s.getName();
//		};
		
		Function<Student, String> function = (s) -> s.getName();

		System.out.println("너의 이름은? : " + function.apply(student));
		
		
	// BiFunction<T, U, R>
		//T, U 두 개의 인스턴스를 받아서 R 타입으로 변환

		BiFunction<String, Integer, Student> biFunction = (String name, Integer age) -> {
			return new Student(name, age);
		};
		
		System.out.println(biFunction.apply("홍길동", 30));
			
		
// 230127 7교시
//		바로 밑의 72행 printValue를 갖고 만들기
		
		System.out.print("[수학 점수] : ");
//		printValue((Student s) -> {return s.getMath();}, student);
		printValue(s -> s.getMath(), student);
		
		System.out.print("[영어 점수] : ");
//		printValue((Student s) -> {return s.getEnglish();}, student);
		printValue(s -> s.getEnglish(), student);
		
		System.out.print("[수학 영어 합계] : ");
//		printValue((Student s) -> {return s.getMath() + s.getEnglish();}, student);
		printValue(s -> s.getMath() + s.getEnglish(), student);
		
		System.out.print("[수학 영어 평균] : ");
//		printValue((Student s) -> {return (s.getMath() + s.getEnglish())/2;}, student);
		printValue(s -> (s.getMath() + s.getEnglish())/2, student);
	}

// 230127 6,7교시

	public void printValue(ToIntFunction<Student> function, Student student) {
		System.out.println(function.applyAsInt(student));

		// 하나의 메소드에 어떤 람다식을 주느냐에 따라 수학점수를 가져올 수도 평균 점수를 가져올 수도 있게 만들기
	}
	
}