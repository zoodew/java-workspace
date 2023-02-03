package com.kh.stream;

import com.kh.stream.terminal.A_Match;
import com.kh.stream.terminal.C_Collect;

public class Application {

	public static void main(String[] args) {

// 230130 3교시
	
	/*
	 * Stream API
	 * 
	 * 	- 스트림은 자바 8부터 추가된 기능으로 컬렉션(배열)에 저장된 요소들을 하나씩 참조해서
	 * 	  람다식으로 처리할 수 있도록 해주는 반복자이다.
	 *  	(처리할 코드만 람다식으로 제공해주면 내부적으로 알아서 반복함)
	 *  - 스트림은 Iterator와 비슷한 역할을 하지만 람다식으로 요소 처리 코드를 제공할 수 있고,
	 *    내부 반복자를 사용해서 병렬 처리와 중간 처리, 최종 처리 작업을 수행할 수 있다.
	 *    	  (내부 반복자 : 개발자가 직접 반복 코드를 작성하지 않고 컬렉션 내부에서 반복을 진행해 주는 것
	 *     cf) 외부 반복자 : 개발자가 직접 반복 코드를 작성해 반복을 진행)
	 *  - 스트림은 컬렉션 요소에 대해서 중간 처리와 최종 처리를 할 수 있다.(메소드로)
	 *  	> 중간 처리에서는 반복, 매핑(타입 변환), 필터링, 정렬 등을 수행한다.
	 *  	  최종 처리에서는 반복, 카운팅, 평균, 통합 등의 집계 처리를 수행한다.
	 *  
	 */

		// Stream 생성
//		new A_Create().method1();
//		new A_Create().method2();
//		new A_Create().method3();
		
		
		// 중간 처리 메소드
//		new A_Filtering().method1();
//		new A_Filtering().method2();

//		new B_Sorted().method1();
//		new B_Sorted().method2();

//		new C_Mapping().method1();
//		new C_Mapping().method2();
//		new C_Mapping().method3();

//		new D_Looping().method1();
		
		
		// 최종 처리 메소드
//		new A_Match().method1();
//		new A_Match().method2();

//		new B_Aggregate().method1();
//		new B_Aggregate().method2();
		
		new C_Collect().method1();

	
	
	
	}

}
