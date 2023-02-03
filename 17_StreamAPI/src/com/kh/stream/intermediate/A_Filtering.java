package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.vo.Student;

public class A_Filtering {
	
// 230130 5교시
	
	/*
	 * 필터링
	 * 
	 * 	- 필터링은 중간 처리 기능으로 요소를 걸러내는 역할을 한다.
	 * 	- distinct()			: 중복을 제거하는 메소드이다.
	 * 							  hashCode and equals 메소드가 재정의 되어있어야 사용이 가능하다.
	 *  - filtering(Predicate)	: 매개값으로 전달되는 Predicate가 false를 리턴하는 요소를 제거한다.
	 * 
	 */

	
// 230130 5교시
	// 중복 제거
	public void method1() {

// 230130 5교시
		// https://live-everyday.tistory.com/187
		// 스트림의 과정을 잘 나타낸 그림
		
			// 값의 목록을 students 인스턴스 생성해서 하나하나 나열
		List<Student> students = Arrays.asList(
			new Student("문인수", 20, "남자", 80, 70),
			new Student("문인수", 20, "남자", 80, 70),
			new Student("문인수", 20, "남자", 80, 70),
			new Student("이몽룡", 24, "남자", 80, 80),
			new Student("홍길동", 30, "남자", 90, 80)
		);
				
		List<String> names = Arrays.asList("문인수", "이몽룡", "문인수", "홍길동");
		//List 요소에 하나씩 접근해 반복 작업해주는 stream 생성
		Stream<String> stream = names.stream();
		
		// forEach : 람다식 형태로 list 요소를 받아 처리
		// forEach() 최종처리 메소드
		stream.forEach(System.out::println);
		
		// 이미 최종 처리 메소드까지 호출된 스트림은 다시 사용할 수 없다. (다시 스트림을 얻어와야 한다.)
//		stream.distinct().forEach(System.out::println);	// 에러 발생
		
		System.out.println();
		
		names.stream().distinct().forEach(System.out::println);

		System.out.println();
		
		// students List 출력
//		students.stream().forEach((Student student) -> {System.out.println(student);});
		
		students.stream().distinct().forEach(student -> System.out.println(student));
		// disticnt()를 썼는데 중복 제거가 되지 않음 > 왜? > hashCode and equals 메소드가 재정의되어있지 않아서. Student 클래스의 80행
	
	}

	
	// 필터 메소드
	public void method2() {
		
		// 값의 목록을 students 인스턴스 생성해서 하나하나 나열
		List<Student> students = Arrays.asList(
			new Student("문인수", 20, "남자", 80, 50),
			new Student("문인수", 20, "남자", 80, 50),
			new Student("문인수", 20, "남자", 80, 50),
			new Student("이몽룡", 24, "남자", 80, 80),
			new Student("성춘향", 20, "여자", 90, 90),
			new Student("홍길동", 30, "남자", 50, 80)
		);
		
		List<String> names = Arrays.asList("문인수", "이몽룡", "성춘향", "문인수", "성춘향", "이순신", "변사또");
	
//		names.stream().forEach(name -> System.out.println(name));
	
		// 이씨 성을 가진 이름만 출력
		names.stream()
//				.filter((String name) -> {return name.startsWith("이");})
				.filter(name -> name.startsWith("이"))
				.forEach(name -> System.out.println(name));	
			// 중간처리 메소드 filter()를 통해 내가 원하는 조건을 걸 수 있음
		
		System.out.println();
		

// 230130 6교시		
		// 성이 성씨인 이름 출력 중복까지 제거해서 출력하기
		names.stream()
				// distinct를 먼저 쓸지 filter()를 먼저 쓸지는 순서 중요하지 않음.
				// 최종 처리 메소드(여기서는 forEach) 전에만 써주면 위치 상관없이 사용할 수 있다.
				// 중간 처리 메소드는 최종 처리 메소드를 쓰기 전에는 여러 개 사용 가능하다.
//				.distinct()	
				.filter(name -> name.startsWith("성"))
				.distinct()
				.forEach(name -> System.out.println(name));	
		
		System.out.println();
		
		// 성별이 여자인 학생만 출력
		students.stream()
				.filter((Student student) -> {
					return student.getGender().equals("여자");
				})
				// .filter Predicate를 리턴하도록 매개값을 넣어주기	???????????????? 찾아보고 다시 정리
				.forEach((Student student) -> {System.out.println(student);});
		
		System.out.println();
		
		// 수학 점수, 영어 점수 둘 다 60점 이상인 학생만 출력
		students.stream()
				.distinct()
				.filter((Student student) -> {
					return student.getEnglish() >= 60 && student.getMath() >= 60;
				})
				.forEach(System.out::println);
	
	}


}
