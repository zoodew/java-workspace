package com.kh.lambda.standard;

import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class B_Supplier {
	
// 230127 5교시
	
	/*
	 * Supplier
	 * 
	 * 	- Supplier 함수적 인터페이스는 매개변수가 없고 리턴 값이 있는 get() 추상 메소드를 가지고 있다.
	 * 	- get() 추상 메소드는 메소드 실행 후 호출한 곳으로 데이터를 공급(리턴)하는 역할을 한다.
	 * 	- Supplier, LongSupplier, BooleanSupplier, DoubleSupplier, IntSupplier 가 있음
	 */
	
	public void method1 () {
// 230127 6교시

	// 기본 Supplier
		
//		Supplier<String> supplier = () -> {
//		// ㄴ에 ctrl해서 클릭해서 나온 거 보고 참조해서 작성. T get(); 반환 타입을 지정하게 되어있음. 여기서는 <타입파라미터>를 String으로 줘서 똑같이 Stirng
//			return "Supplier는 제네릭으로 지정된 타입의 인스턴스를 리턴한다.";
//		};

		Supplier<String> supplier = () -> "Supplier는 제네릭으로 지정된 타입의 인스턴스를 리턴한다.";
		
		
		System.out.println(supplier.get());
		
		
	// LongSupplier
		// long 타입으로 반환을 하도록 만들어주는 Supplier
		// getAsLong(); 메소드를 통해 호출한 곳으로 데이터를 리턴함.

//		LongSupplier longSupplier = () -> {
//			return 23456789034567L;	// long타입이라는 걸 나타내기 위해 맨 뒤에 L 붙여줌
//		};

		LongSupplier longSupplier = () -> 23456789034567L;
		
		System.out.println(longSupplier.getAsLong());
	};

}
