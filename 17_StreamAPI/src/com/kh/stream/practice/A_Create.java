package com.kh.stream.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A_Create {

// 230130 3교시
	/*
	 * 스트림의 종류
	 * 
	 * 	- java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 해서 자식 인터페이스들이 상속 관계를 이루고 있다.
	 *  - Stream<t>, IntStream, LongStream, DoubleStream 네 가지의 스트림이 존재
	 *  
	 *  
	 * 스트림의 생성
	 * 	
	 * 	- 숫자 범위로 스트림을 생성하는 방법
	 * 		- IntStream, LongStream의 range(), rangeClosed() 메소드를 이용해서 생성한다.
	 *  - 배열로부터 스트림을 생성하는 방법
	 *  	- Arrays.stream(배열) 메소드로 스트림을 생성한다.
	 *   	- 각 스트림(Stream<t>, IntStream, LongStream, DoubleStream)의 of(배열) 메소드로 스트림을 생성한다.
	 *  - 컬렉션으로부터 스트림을 생성하는 방법
	 *   	- 컬렉션의 stream() 메소드를 이용해서 생성한다. (java.util.Collection.stream())
	 * 
	 */
	
	
// 230130 3교시
	// 숫자 범위로 스트림을 생성하는 방법
	public void method1() {
		
// 230130 3교시
		// range()
		// 첫 번째 매개값부터 두 번째 매개값 이전까지의 값을 요소로 가지는 스트림 객체를 생성
			//IntStream.range(1, 10); 여기다가 alt shift l 치면 이 값을 받는 변수 생성
		IntStream stream = IntStream.range(1, 10);
		
		//1 ~ 9까지 합 구하기
			// IntStream stream = IntStream.range(1, 10);를 통해 내부적으로 값을 가져다가 반복해서 합계 구해줌
			// for 문 없이 메소드 호출로만 반복이 가능
//		int sum = stream.sum();
		
		// peek() : 요소에 접근해 한 번씩 반복해서 반복적으로 가져와 출력. 람다식으로 입력 받음
		int sum = stream.peek((value) -> {System.out.print(value + " ");}).sum();

		System.out.println("\nsum : " + sum);	// \n 한 줄 바꿈
		
// 230130 4교시
		
		// rangeClosed()
		// 첫 번째 매개값 ~ 두 번째 매개값까지 값을 요소로 가지는 스트림 객체를 생성
		// 1 ~ 10까지 합 구하기
		stream = IntStream.rangeClosed(1, 10);
	
		sum = stream.peek(value -> System.out.print(value + " ")).sum();
		
		System.out.println("\nsum : " + sum);	// \n 한 줄 바꿈
		
	}
	
	
	
// 230130 4교시
	// 배열로부터 스트림을 생성하는 방법
	public void method2() {
		
// 230130 4교시

		// 배열 생성
		String[] names = {"문인수", "홍길동", "이몽룡", "성춘향", "문인수", "성춘향"};
		
		// 향상된 for 문을 사용하여 출력 (외부 반복문 : 직접 반복문을 사용해서 출력)
		for (String name : names) {
			System.out.print(name + " ");
		}
		
		System.out.println();
	
		// 스트림을 사용하여 출력
//		Arrays.<String>stream(names);						// 정석 표기법. 타입 파라미터 생략 가능 알아서 배열 타입에 맞게 타입 지정
						//		Arrays.<String>stream(names); 여기에 alt shift l 배열 생성
//		Stream<String> stream = Arrays.<String>stream(names);

		// of() 사용시 배열을 직접 넘겨도 되고 배열의 값을 가변인자로 직접 넘겨도 됨
//		Stream<String> stream = Stream.<String>of(names);	// 정석 표기법. 타입 파라미터 생략 가능 알아서 배열 타입에 맞게 타입 지정
//		Stream<String> stream = Stream.of(names);
		Stream<String> stream = Stream.of("문인수", "홍길동", "이몽룡", "성춘향", "문인수", "성춘향");
		
		// forEach() (내부 반복문 : 직접 반복문을 작성하지 않고 처리 코드만 작성해주면 내부에서 알아서 반복 처리)
//		stream.forEach((String name) -> {System.out.print(name + " ");});
//		stream.forEach(name -> System.out.print(name + " "));
//		stream.parallel().forEach((String name) -> {System.out.print(name + " ");});		// 병렬 처리
		
		// distinct() 메소드 : 중복 제거 메소드
		stream.distinct().forEach(name -> System.out.print(name + " "));					// 중복 제거 출력
	
				
	}
	
	
	
// 230130 4교시
	// 컬렉션으로부터 스트림을 생성하는 방법
	public void method3() {
		
// 230130 4교시
		
		List<String> names = Arrays.asList("문인수", "홍길동", "이몽룡", "성춘향", "문인수", "성춘향");
							// Arrays.asLis() 매개값으로 받은 가변인자를 통해 List name를 생성
		
		// for 문을 사용하여 list에서 요소를 하나씩 가져와 출력
		// list는 length가 아니라 size로 길이를 가져옴
		// list는 get()을 통해 값을 가져옴
		for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }

		System.out.println();
		
		// 스트림을 사용하여 출력
		Stream<String> stream = names.stream();
//		Stream<String> stream = names.parallelStream();		// 병렬 처리
		
//		stream.forEach(name -> System.out.print(name));
		stream.distinct().forEach(System.out::print);		// 중복 제거
		
	}

	
}
