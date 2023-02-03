package com.kh.lambda.standard;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class A_Consumer {

// 230127 5교시
	
	/*
	 * Consumer
	 * 	
	 * 	- Consumer 함수적 인터페이스는 리턴 값이 없는 accept() 추상 메소드를 가지고 있다.
	 * 	- accept() 추상 메소드는 단지 매개값을 받아서 소비하는 역할을 한다.
	 */
	
	public void method1() {

		// 기본 Consumer
			// Consumer 치고 ctrl space 인터페이스 누르기(java.util.function인 애들만 표준 함수적 인터페이스임) <T>를 String으로 변경
//		Consumer<String> consumer = (String str) -> {
//			System.out.println(str);	// ㄴ Consumer<T(타입 파라미터)>가 String이라 그에 대한 매개변수()도 String 타입으로
//		};
		
		Consumer<String> consumer = str -> System.out.println(str);
		// 18행과 같음 생략 가능한 것들 생략한 형태
		
		consumer.accept("Consumer는 한 개의 매개값을 받아서 소비한다.");
		
		
		// 두 개의 매개변수를 받는 BiConsumer
//		BiConsumer<String, String> biConsumer = (String str1, String str2) -> {
//			System.out.println(str1 + str2);
//		};
		
		BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + str2);
		
		biConsumer.accept("BiConsumer는 ", "두 개의 매개값을 받아서 소비한다.");
		
		
		// 더블 타입으로 고정되어있는 DoubleConsumer. 타입 파라미터 지정해줄 필요 없음
//		DoubleConsumer doubleConsumer = (double value) -> {
//			System.out.println("DoubleConsumer는 하나의 double 타입의 값을 받아서 소비한다. : " + value);
//		};
		
		DoubleConsumer doubleConsumer =
				(value) -> System.out.println("DoubleConsumer는 하나의 double 타입의 값을 받아서 소비한다. : " + value);
		
		doubleConsumer.accept(3.14);
		
		
		// 하나의 인스턴스, ObjIntConsumer
					// r 인스턴스(object)의 자료형을 지정하는 타입 파라미터, 두 번째 매개변수는 정수형으로 자료형 지정 
//		ObjIntConsumer<String> objIntConsumer = (String str, int i) -> {
//			System.out.println("ObjIntConsumer는 두 개의 매개값(제네릭으로 지정된 타입, Int 타입)을 받아서 소비한다.");
//			System.out.println(str + i);
//		};
		
		ObjIntConsumer<String> objIntConsumer = (str, i) -> {
			System.out.println("ObjIntConsumer는 두 개의 매개값(제네릭으로 지정된 타입, Int 타입)을 받아서 소비한다.");
			System.out.println(str + i);
		};
		
		objIntConsumer.accept("Java", 11);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
