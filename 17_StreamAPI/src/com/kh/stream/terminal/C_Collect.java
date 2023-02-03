package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.vo.Student;

public class C_Collect {

// 230131 6교시
	/*
	 * 수집
	 * 
	 * 	- 최종 처리 기능으로 필터링 또는 매핑한 요소들을 새로운 컬렉션으로 담아서 리턴 받을 수 있다.
	 */
	
	
	public void method1() {

// 230131 6교시
		List<Student> students = Arrays.asList(				
				new Student(1, "홍길동", 30, "남자", 50, 80),
				new Student(2, "성춘향", 19, "여자", 90, 90),
				new Student(3, "문인수", 19, "남자", 80, 50),
				new Student(4, "이몽룡", 24, "남자", 80, 80),
				new Student(5, "심청이", 16, "여자", 90, 90)
		);
		
		
	// List로 수집(남학생만 새로운 List 컬렉션으로 받기)
	// .collect(Collectors.toList())	: 출력한 요소를 통해 새로운 List 객체 생성
		
		// students List에서 stream을 통해 남학생만 걸러내서 출력
//		students.stream()
//				.filter((Student student) -> {return student.getGender().equals("남자");})
//				.forEach(System.out::println);
				
		// .collect(Collectors.toList())	: 출력한 요소를 통해 새로운 List 객체 생성
		List<Student> list = students.stream()
				.filter((Student student) -> {return student.getGender().equals("남자");})
				.collect(Collectors.toList());
		
		list.stream().forEach(System.out::println);
//		System.out.println(list);
		
		System.out.println();
		
		
	// Set으로 수집(여학생만 Set 컬렉션으로 받기)
	// .collect(Collectors.toSet()		: 출력한 요소를 통해 새로운 set 객체 생성
		
		// students List에서 stream을 통해 여학생만 걸러내서 출력
		Set<Student> set = students.stream()
				.filter(student -> student.getGender().equals("여자"))
				.collect(Collectors.toSet());
		
		set.stream().forEach(System.out::println);
//		System.out.println(set);
		
		System.out.println();
		
		
	// Map으로 수집									Student 클래스 바꾸는 거 확인하기!!!!
	//Collectors.toMap(key값으로 받는 매개값, value값으로 받는 매개값)
		
		// idx를 key, name을 value로 갖는 Map 생성
		
		//
		Map<Integer, String> map = students.stream()
				.collect(Collectors.toMap(		// Collectors.toMap(key값으로 받는 매개값, value값으로 받는 매개값)
								(Student student) -> {return student.getIdx();},
								(Student student) -> {return student.getName();}						
						)
				);
//				.collect(Collectors.toMap(student -> student.getIdx(), student -> student.getName()));
		
		System.out.println(map);
		
		System.out.println();
		
		// .collect(Collectors.groupingBy(매개값))	: 매개값을 기준으로 그루핑	
		// 앞에서 뽑은 남자 List를 가져와서 key 값으로 남자, value에 남자 List를 넣고
		//	여자 Set을 가져와서 key 값으로 여자, value에 여자 Set 넣기
		
		Map<String, List<Student>> studentMap = students.stream()
					.collect(Collectors.groupingBy(student -> student.getGender()));
								// 같은 성별을 가진 사람끼리 묶기
		System.out.println(studentMap);
		
		
		
		
		
		
		
		
		
		
	}
}
