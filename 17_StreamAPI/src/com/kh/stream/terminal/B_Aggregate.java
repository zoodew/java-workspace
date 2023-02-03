package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class B_Aggregate {

// 230131 4교시
	/*
	 * 기본 집계
	 * 
	 * 	- 최종 처리 기능으로 요소들의 개수, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 역할을 한다.
	 * 		count()		: 요소들의 개수를 리턴한다.
	 * 		sum()		: 요소들의 합계를 리턴한다.
	 * 		average()	: 요소들의 평균을 리턴한다.
	 * 		max()		: 최대 요소를 리턴한다.
	 * 		min()		: 최소 요소를 리턴한다.
	 *		findFirst()	: 요소들 중 첫 번째 요소를 리턴한다.
	 *
	 * 커스텀 집계
	 * 
	 * 	- 스트림에서 기본 집계 메소드를 제공하지만 다양한 집계 결과물을 만들 수 있도록 reduce() 메소드를 제공한다.
	 *
	 */

	public void method1() {
		
// 230131 4교시
		// 정수형 배열 생성
		int[] array = {1, 2, 3, 4, 5, 6};
//		int[] array = {1, 3, 5};
		
	// 2의 배수의 개수 구하기
			// r 왜 long이냐 마지막 .count() ctrl로 눌러보면 count 타입이 long 인 거 알 수 있음
		long count = Arrays.stream(array)
						   .filter(value -> value % 2 == 0).count();
		
		System.out.println(count);
		
		
		System.out.println();
// 230131 5교시
	// 2의 배수의 합
		
		int sum = Arrays.stream(array).filter(value -> value % 2 == 0).sum();
		
		System.out.println(sum);
		
		System.out.println();
		
	// 2의 배수의 평균
		
		/*
		 * Optional 클래스
		 * 		- 스트림의 결과 값을 저장하는 인스턴스이다. (결과값을 갖고 있는 객체(인스턴스))
		 * 		- 단순히 값만 저장하는 것이 아니라, 값의 존재 여부를 확인하고 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있는 인스턴스이다.
		 * 
		 * 왜 위의 sum이나 count처럼 그대로를 넣는 게 아니라 Optional로 나오나? 값이 없을 가능성이 있기 때문에 Optinal 단계를 거치게 해주는 것
		 */
		
		OptionalDouble average = Arrays.stream(array).filter(value -> value % 2 == 0).average();
		
		// OptionalDouble로 변수가 생성되면 syso에 sum이나 count처럼 sum,count를 넣어주는 게 아니라, average.getAsDouble()을 통해 평균값을 가져온다.
		// Optional 인스턴스에 저장된 값을 가져온다. OptionalDouble ctrl 클릭에 들어가서 126행 보기
//		System.out.println(average.getAsDouble());
		
		// 값의 존재 여부를 확인하고(ifPresent()) Optional에서 값을 가져온다.
//		if(average.isPresent()) {							// 값이 짝수가 있으면 평균 출력. 값이 홀수만 있으면 데이터가 없음 출력
//			System.out.println(average.getAsDouble());
//		} else {
//			System.out.println("데이터가 없음");
//		}
		
		// 집계 값을 처리하는 Consumer를 등록한다. (Consumer는 값이 존재해야 실행된다.)
//		average.ifPresent(d -> System.out.println(d));		// 값이 짝수가 있으면 평균 출력. 값이 홀수만 있으면 출력 없음
		
		// orElse(디폴트값)
		// get() 메소드와 동일하게 저장되어 있는 값을 얻어오는 메소드로 값이 저장되어 있지 않을 경우 디폴트 값을 지정한다.
		System.out.println(average.orElse(0.0));			// 값이 짝수가 있으면 평균 출력. 값이 홀수만 있으면 0.0 출력. (orElse(매개값) 매개값을 값이 없을 때 기본값으로 출력)

		System.out.println();
	
	// 2의 배수의 최대값
		OptionalInt max = Arrays.stream(array).filter(value -> value % 2 == 0).max();
		
		System.out.println(max.orElse(0));
		
		System.out.println();
	
	// 2의 배수의 최소값
		OptionalInt min = Arrays.stream(array).filter(value -> value % 2 == 0).min();
		
		System.out.println(min.orElse(0));
		
		System.out.println();
		
	// 2의 배수의 첫 번째 요소
		OptionalInt findFirst = Arrays.stream(array).filter(value -> value % 2 == 0).findFirst();
		
		System.out.println(findFirst.orElse(0));
		
		System.out.println();
		
	// 	
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
		
		sum = stream.mapToInt(i -> i.intValue()).sum();
		
		System.out.println(sum);
		
		
	}	


	public void method2() {

// 230131 5교시
		int[] array = {1, 2, 3, 4, 5, 6};
		
	// 커스텀 집계 reduce()
		
	// 요소들의 곱 구하기
		OptionalInt reduce = Arrays.stream(array).reduce((int left, int right) -> {return left * right;});
														// 0 배열 값과 1 배열 값 곱하고 그 값에 2 배열 값 곱하고 그 값에 3 배열 값 곱하고...
		System.out.println(reduce.getAsInt());
						// 값이 있으면 출력

		System.out.println();
	
//		Arrays.stream(array).reduce(1, (int left, int right) -> {return left * right;});
		// 처음 값(reduce([처음 값],))이 딱 정해져 있기 때문에 Optional이 아니라 정수값으로 변수 바로 가져옴
		int result = Arrays.stream(array).reduce(1, (left, right) -> left * right);
											//   ㄴ 제일 첫 번째 수를 지정. 1과 배열 첫 번째 값인 1 곱하기. 그 값(1)에 두 번째 배열 값 2 곱하기. 그 값에(2) 세 번째 배열 값 3 곱하기... 
		
		System.out.println(result);
		

	}
}
