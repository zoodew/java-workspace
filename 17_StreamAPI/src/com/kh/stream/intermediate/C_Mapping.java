package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.vo.Student;

public class C_Mapping {
	
// 230131 2교시
	
	/*
	 * 매핑
	 * 
	 * 	- 중간 처리 기능으로 스트림의 요소를 다른 타입의 요소로 대체하는 역할을 한다.
	 * 		map()			: 요소를 대체하는 요소로 구성된 새로운 스트림을 생성한다.
	 * 		flatMap()		: 하나의 요소를 복수의 요소로 구성된 새로운 스트림을 생성한다. 
	 * 		asDoubleStream(): IntStream을 DoubleStream으로 변환해서 리턴한다.
	 * 		asLongStream()	: IntStream을 LongStream으로 변환해서 리턴한다.
	 * 		boxed()			: int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 스트림을 생성한다.
	 */
	
	public void method1() {
		
// 230131 2교시
		List<Student> students = Arrays.asList(				
				new Student("홍길동", 30, "남자", 50, 80),
				new Student("성춘향", 20, "여자", 90, 90),
				new Student("문인수", 20, "남자", 80, 50),
				new Student("이몽룡", 24, "남자", 80, 80)
		);
		
		students.stream()
				// name만 모아서 새로운 stream 생성
				.map((Student student) -> {return student.getName();})
				.forEach(System.out::println);
		
		System.out.println();
		
		// .mapToInt() int정수형타입으로 변경
		// 학생들의 수학 점수 평균
		double avg = students.stream()
							 .mapToInt((Student student) -> {return student.getMath();})
							 .average()			// average()		: 평균 구하는 메소드
							 .getAsDouble();	// getAsDouble()	: 메소드까지 써줘야 평균값 낼 수 있듬
		
		System.out.println("수학 점수의 평균 : " + avg);
		
	}

	
	public void method2() {

// 230131 2교시
		List<String> list = Arrays.asList("Java11 Lambda", "StreamAPI Filtering Mapping");
		
		list.stream().forEach(System.out::println);
	
		System.out.println();
		
		list.stream()
			.flatMap((String str)-> {
				String[] array = str.split(" ");		// split() 매개값을 기준(여기서는 공백)으로 값을 잘라 나눠서 배열을 생성함
				
				return Arrays.stream(array);
			})
//			.flatMap(str -> Arrays.stream(str.split(" ")))	// 바로 위 식 한 줄로 줄임
			.forEach(System.out::println);
		
	
	}


	public void method3() {

// 230131 3교시
		// 배열 생성
		// 정수형 배열
		int[] array1 = {1, 2, 3, 4, 5};
		// 실수형 배열
		double[] array2 = {1.1, 2.2, 3.3, 4.4, 5.5};

		Arrays.stream(array1)
//			  .asDoubleStream()		// {1, 2, 3, 4, 5}를 실수형 데이터로 변환해서 반환 1.0 2.0 3.0 4.0 5.0
			  .asLongStream()		// {1, 2, 3, 4, 5}를 Long 데이터로 변환해서 반환 1 2 3 4 5
//			  .asDoubleStream()
			  .forEach(value -> System.out.print(value + " "));
		
		System.out.println();
		
		Arrays.stream(array2)
			  .boxed()				// 기본타입이라서 바로 sorted 매개값 줘서 내림차순 불가. 그래서 boxed() 사용 후 sorted(Comparator.reverseOrder()) 사용 해야 함
			  						// 기본 타입을 인스턴스 타입으로 변환 한 것
			  .sorted(Comparator.reverseOrder())
			  .mapToDouble(value -> value.doubleValue())	// boxed로 인스턴스 타입이 된 요소를 다시 Double 타입으로 변환
			  .forEach(value -> System.out.print(value + " "));

	
	}
	
	
	
}
