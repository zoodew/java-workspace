package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.vo.Student;

public class A_Match {

// 230131 3교시
	
	/*
	 * 매칭
	 * 
	 * 	- 최종 처리 단계에서 요소들이 특정 조건을 만족하는지 조사하는 역할을 한다.
	 *  	allMatch(Predicate)	 : "모든" 요소들이 매개값으로 주어진 Predicate의 조건을 만족하는지 조사한다.
	 *  	anyMatch(Predicate)	 : "최소한 한 개의" 요소가 매개값으로 주어진 Predicate의 조건을 만족하는지 조사한다.
	 *  	noneMatch(Predicate) : "모든" 요소들이 매개값으로 주어진 Predicate의 조건을 만족하지 "않는지" 조사한다.
	 */
	
	public void method1() {

// 230131 3교시
		
		boolean result = false;
		int[] array = {2, 4, 6};
		
		// allMatch() 모든 요소들이 짝수인지 확인 (모든 요소가 짝수여야 true)
		result = Arrays.stream(array)
					   .allMatch((int i) -> {return i % 2 == 0;});
//					   .allMatch(i -> i % 2 == 0);
		
		System.out.println(result);
		
		// anyMatch() 요소 중에 3의 배수가 있는지 확인	(하나라도 있으면 true)
		result = Arrays.stream(array)
				   	   .anyMatch((int i) -> {return i % 3 == 0;});
//					   .anyMatch(i -> i % 3 == 0);
		
		System.out.println(result);
		
		// noneMatch() 5의 배수인 요소가 없는지 확인(없어야 true 있으면 false)
		
		result = Arrays.stream(array)
					   .noneMatch((int i) -> {return i % 5 == 0;});
//		   			   .anyMatch(i -> i % 5 == 0);		
		System.out.println(result);
	}
	
	
	public void method2() {

// 230131 4교시
		
	// 실습
		boolean result = false;
		
		List<Student> students = Arrays.asList(				
				new Student("홍길동", 30, "남자", 50, 80),
				new Student("성춘향", 20, "여자", 90, 90),
				new Student("문인수", 19, "남자", 80, 50),
				new Student("이몽룡", 24, "남자", 80, 80)
		);
				
//		 나이가 20살 이상인 학생들이 모두 남자인지 확인하시오.
		result = students.stream()
//			    		 .filter((Student student) -> {return student.getAge() >= 20;})
			    		 .filter(student -> student.getAge() >= 20)
			    		 .peek(student -> System.out.println(student))
//			    		 .allMatch((Student student) -> {return student.getGender().equals("남자");});
						 .allMatch(student -> student.getGender().equals("남자"));
		
		System.out.println(result);
		// 몽룡이 어디...? peek()은 중간처리메소드이나 중간에 실행되는 게 아니라 allMatch까지 실행된 후에 peek이 실행됨.
		//				그래서 peek은 filter 단계가 아닌 allMath 단계에서의 추출 단계를 보여줌
		// 	????????????????????????????????????????????????????????????????????????????????
		
		System.out.println();
				
		// 남학생들 중에 평균이 70점 이상인 학생이 한 명이라도 존재하는지 확인하시오.
		result = students.stream()
//						 .filter((Student student) -> {return student.getGender().equals("남자");})
						 .filter(student -> student.getGender().equals("남자"))
						 .peek(student -> System.out.println(student))
//						 .anyMatch((Student student) -> {return ((student.getMath() + student.getEnglish()) / 2) >= 70;});
						 .anyMatch(student -> ((student.getMath() + student.getEnglish()) / 2) >= 70);
		
		System.out.println(result);	
		
	}
}
