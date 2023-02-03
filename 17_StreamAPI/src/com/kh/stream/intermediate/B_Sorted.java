package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.vo.Student;

public class B_Sorted {
	
// 230130 6교시
	/*
	 * 정렬
	 * 
	 * 	- 스트림의 요소들이 최종 처리 되기 전에 중간 단계에서 요소들을 정렬해서 최종 처리 순서를 변경할 수 있다.
	 *  - IntStream, LongStream, DoubleStream은 요소를 오름차순으로 정렬한다.
	 *  - Stream<T>은 요소가 Comparable 인터페이스를 구현해야 정렬할 수 있다.(구현하지 않은 경우 예외가 발생한다.)
	 *
	 */
	
// 230130 6교시
	public void method1() {
		
		// 230131 1교시
		List<Student> students = Arrays.asList(				
				new Student("홍길동", 30, "남자", 50, 80),
				new Student("성춘향", 20, "여자", 90, 90),
				new Student("문인수", 20, "남자", 80, 50),
				new Student("이몽룡", 24, "남자", 80, 80)
		);
		
		List<String> names = Arrays.asList("문인수", "이몽룡", "성춘향", "문인수", "성춘향", "이순신", "변사또");
		
		// Comparable 인터페이스 구현 내용에 따라서 정렬(.sorted() 오름차순 정렬[기본])
		names.stream()
			 .distinct()
			 .sorted()
			 .forEach(name -> System.out.print(name + " "));

		System.out.println();

		// Comparable 인터페이스 구현과 반대로 정렬(내림차순 정렬)
		names.stream()
			 .distinct()
			 // 방법 1
//			 .sorted((name1, name2) -> {
//				 return name2.compareTo(name1);
//			 })
			 // 방법 2
			 //.sorted(Comparator.reverseOrder())
			 .sorted(Comparator.reverseOrder())
			 .forEach(name -> System.out.print(name + " "));
		
	
		System.out.println();
		
// 230131 1교시
		// students 정렬
		students.stream()
				//.sorted()							// 정렬이 될 기준을 정해주지 않아서 에러가 발생
				.sorted(Comparator.reverseOrder())	// Comparable 인터페이스를 꼭 구현해야함. 구현 전이라 안 나옴
													// Student 클래스에서 Comparable 인터페이스를 구현(113행) 하면 에러 발생 없이 잘 나옴
			// 오름차순 정렬	
//				.sorted((Student s1, Student s2) -> {return s1.getAge() - s2.getAge();})
//				.sorted((s1, s2) -> s1.getAge() - s2.getAge())
			// 내림차순 정렬	
//				.sorted((s1, s2) -> s2.getAge() - s1.getAge())
				.forEach(student -> System.out.println(student));
		
		
	}


// 230131 1교시 2교시
	public void method2() {
		
		//정수형 배열 생성
//		int[] array = /*new int[]*/ {3, 5, 1, 4, 2};
		
//		int[] array;
//		array = new int[] {3, 5, 1, 4, 2};
		
		// 오름차순 정렬
		Arrays.stream(new int[] {3, 5, 1, 4, 2})	// 위의 배열 생성 따로 하는 과정 없이 바로 배열 생성과 동시에 정렬
//		Arrays.stream(array)						// 위의 배열 생성 후 만든 array 배열을 stream에 매개값으로 넣어서 사용
			  .sorted()			// 기본타입의 자료형을 가지는 stream 같은 경우에는 매개값을 받는 게 없어서 .sort()로는 무조건 오름차순으로만 정렬.
			  .forEach(value -> System.out.print(value + " "));
		
		System.out.println();
		
		// 내림차순 정렬
		Arrays.stream(new int[] {3, 5, 1, 4, 2})
//		Arrays.stream(array)
			  .boxed()	// 기본타입의 데이터들을 인스턴스 타입으로 박싱해줌(인스턴스 타입으로 만듦). 이 중간처리메소드를 사용하면 sorted()를 사용해서 내림차순 정렬 가능
			  .sorted(Comparator.reverseOrder())
			  .forEach(value -> System.out.print(value + " "));
	
	
	}

}
