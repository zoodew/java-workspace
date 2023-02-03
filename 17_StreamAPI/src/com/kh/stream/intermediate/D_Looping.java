package com.kh.stream.intermediate;

import java.util.Arrays;

public class D_Looping {
	
// 230131 3교시
	/*
	 * 반복
	 * 	
	 * 	- 요소 전체를 반복하는 역할을 한다.
	 *  	peek()
	 *  		- "중간" 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용한다.
	 *  	forEach()
	 *  		- "최종" 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용한다.
	 *  
	 */
	
	public void method1() {
		
// 230131 3교시
		
		int sum = 0;
		int [] array = {1, 2, 3, 4, 5};

		// 짝수만 더하기
		// 최종 처리 메소드(forEach)를 호출한 이후에 다른 최종 처리 메소드(sum)를 호출할 수 없다.
//		sum = Arrays.stream(array)	// 스트림 생성 :  Arrays.stream(array)
//					.filter((int i) -> {return i % 2 == 0;})
//					.forEach(System.out::println)
//					.sum();

		sum = Arrays.stream(array)
//				.filter((int i) -> {return i % 2 == 0;})
				.filter(i -> i % 2 == 0)
				.peek(System.out::println)	// 필터를 통해 걸러진 요소들을 반복해서 출력하는 메소드. 2 4 출력됨
				.sum();
		
		// 최종 처리 메소드가 호출 되어야 동작한다.
		// 최종 처리 메소드가 실행 된 후 중간 처리 메소드 실행!
//		Arrays.stream(array)
//			  .filter((int i) -> {return i % 2 == 0;})
//			  //.filter(i -> i % 2 == 0)
//			  .peek(System.out::println);
		
		System.out.println("Sum : " + sum);
		
	}

}
