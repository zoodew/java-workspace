package com.kh.lambda.practice;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

import com.kh.lambda.standard.vo.Student;

public class C_MethodReference {

// 230130 2교시
	public void method1() {

// 230130 2교시
	// 메소드 참조(Method Reference)
		// 두 개의 정수값을 받아 더 큰 값을 리턴
//		IntBinaryOperator binaryOperator = (int a, int b) -> {
//			// a가 b보다 크면 a를 리턴, 작으면 b를 리턴
//			return Math.max(a, b);
//		};
		
		// 람다식을 통해 줄이기
//		IntBinaryOperator binaryOperator = (a, b) -> Math.max(a, b);

	// 메소드 참조(Method Reference)를 통해 더 간략히
		// 정적(static) 메소드(ex. max())를 참조할 경우에는 클래스 이름 뒤에 ::를 붙이고 정적 메소드 이름을 기술하면 된다.
		// 불필요한 매개변수를 제거해 좀 더 깔끔하게 작성이 가능함
		IntBinaryOperator binaryOperator = Math::max;
		
		System.out.println(binaryOperator.applyAsInt(10, 20));
		
	// 인스턴스의 메소드를 참조할 경우에는 참조 변수 뒤에 ::를 붙이고 메소드 이름을 기술하면 된다.
//		Consumer<String> consumer = str -> System.out.println(str);
	
		Consumer<String> consumer = System.out::println;
		
		consumer.accept("안녕하세요.");
		
		// 매개변수의 메소드를 참조할 경우에는 매개변수 클래스 이름 뒤에 ::을 붙이고 메소드 이름을 기술하면 된다.
//		Function<Student, String> function = (s) -> s.getName();
		Function<Student, String> function = Student::getName;
		
		System.out.println(function.apply(new Student("홍길동", 30)));
		
		// 람다식
//		Supplier<Student> supplier = () -> new Student();
	// 생성자 참조	
		// 생성자 참조는 클래스 이름 뒤에 :: 붙이고 new 연산자를 기술하면 된다.
		// 기본적으로 기본 생성자가 있어야 함 Student 클래스에 Student 기본 생성자(18행) 있는 거 확인
		Supplier<Student> supplier = Student::new;
		
		System.out.println(supplier.get());
		
// 230130 3교시
		// 람다식
		// 두 개의 매개값을 받아서 Student 타입으로 return
//		BiFunction<String, Integer, Student> biFunction = (String name, Integer age) -> {
//			return new Student(name, age);
//		};
//		BiFunction<String, Integer, Student> biFunction = (name, age) -> new Student(name, age);
		
	//생성자 참조
		BiFunction<String, Integer, Student> biFunction = Student::new;
		
		System.out.println(biFunction.apply("홍길동", 30));
	
	} 

}
