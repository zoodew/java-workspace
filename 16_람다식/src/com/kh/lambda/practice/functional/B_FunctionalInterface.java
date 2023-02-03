package com.kh.lambda.practice.functional;

@FunctionalInterface
/*
 * @FunctionalInterface > 함수적 인터페이스인지 아닌지 알려주기 위한 어노테이션,
 * 						  추상 메소드가 없거나 두 개 이상이지 않게 해주는 어노테이션
 */


//매개변수(int a)가 있고 반환값이 없는 추상 메소드를 갖고 있는 함수적 인터페이스
public interface B_FunctionalInterface {

// 230127 3교시
	
	// 매개변수(int a)가 있고 반환값이 없는 추상 메소드
	public void method(int a);
}
