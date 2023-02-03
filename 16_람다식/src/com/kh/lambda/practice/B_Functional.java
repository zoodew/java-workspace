package com.kh.lambda.practice;

import com.kh.lambda.practice.functional.A_FunctionalInterface;
import com.kh.lambda.practice.functional.B_FunctionalInterface;
import com.kh.lambda.practice.functional.C_FunctionalInterface;

public class B_Functional {
	private int num = 100;
	// 필드 생성. 메소드 어디에서든 접근 가능

// 230127 3교시
	public void method1() {
		
		A_FunctionalInterface fi;
		
		fi = new A_FunctionalInterface() {
			
			@Override
			public void method() {
				System.out.println("익명 구현 객체를 통한 인터페이스 구현");
			}
		};
		
		fi.method();	// 출력
		
		// 람다식을 통해 인스턴스 만듦(A_FunctionalInterface를 구현하는 인스턴스)
			// 람다식 구현 때 실제로 재정의해야 할 추상메소드를 참조
			// 추상메소드에는 매개값도 없고 반환타입도 없음 있을면 에러 발생
		fi = () -> {
			System.out.println("매개변수와 반환값이 없는 람다식 1");
		};
		
		fi.method();
	
		// 실행문이 한 줄이라면 중괄호 생략 가능
		fi = () -> System.out.println("매개변수와 반환값이 없는 람다식 2");
		
		fi.method();
	}


// 230127 3교시
	public void method2() {
		
	//B_FunctionalInterface를 익명구현객체로 만드는 법
		B_FunctionalInterface fi;
		
		fi = new B_FunctionalInterface() {
			
			@Override
			public void method(int a) {
				System.out.println(a *2);
			}
		};
		
		fi.method(5);
		
		
	// B_FunctionalInterface를 람다식으로 만드는 법
		// 매개변수를 갖지만 반환값은 없는 추상 메소드를 람다식으로 표현
			
		// B_FunctionalInterface가 매개변수를 갖기 때문에 람다식도 매개변수 넣어줌
		fi = (int a) -> {
			System.out.println(a * 2);
		};
		
		// 참조변수를 가지고 인스턴스의 추상메소드를 호출
		fi.method(10);
		
		
		// 매개변수의 자료형 생략 가능 생략해도 실행하는 시점에 알아서 판단함
		// 매개변수가 하나이면 소괄호() 생략 가능
		fi = a -> System.out.println(a * 2);
		
		fi.method(40);
	}
	

// 230127 3교시
	public void method3() {
		
		int result = 0;
		C_FunctionalInterface fi;
		
		// 인터페이스를 가지고 인스턴스를 만들 수 없음 아래 두 가지 방법을 사용
		
		// new 연산자를 통해 인스턴스가 가지고 있는 추상메소드 재정의
		fi = new C_FunctionalInterface() {
			
			@Override
			public int method(int a, int b) {
				
				return a + b;
			}
		};
		
		// 재정의한 메소드 호출하려면 
		result = fi.method(10, 20);
		
		System.out.println(result);
		
		
		// C_FunctionalInterface를 람다식으로 만드는 법
			//람다식으로 할 때 인터페이스가 갖고있는 추상메소드 항상 참조하기 추상메소드의 선언부랑 항상 동일하게. 매개변수가 있으면 매개변수 넣고 리턴값있으면 리턴값 넣고
			//		public int method(int a, int b) {	
			//			return a + b;
			//		}	88행
		
		fi = (int x, int y) -> {
			return x + y;
		};
		
		result = fi.method(20, 30);
		
		System.out.println(result);

		
// 230127 4교시
		// 매개변수의 자료형, return문, 중괄호 생략 가능
		fi = (x, y) -> x + y;
		
		result = fi.method(50, 50);
		
		System.out.println(result);
	
	}
	

// 230127 4교시
	public void method4() {
	
	// 람다식에서 필드와 지역 변수(로컬 변수) 사용하기 
	// 람다식의 실행 블록에서는 필드와 지역 변수를 사용할 수 있다.
	// 필드는 제약 없이 사용하지만 지역 변수는 제약이 따른다.
	
		int num = 200;
		
		A_FunctionalInterface fi;
		
		System.out.println(num);		// 메소드 내 int num(136행)이 있다면 클래스 내에 num 필드가 있어도 메소드 내 num을 먼저 데려옴
		System.out.println(this.num);	// this.를 적어주면 클래스 내 num 필드를 가져온다.
		
		// 람다식에서 사용되는 this는 람다식을 통해서 구현되는 인스턴스의 참조가 아닌 람다식을 실행하는 인스턴스의 참조 이다.
		// 람다식에서 지역변수를 이용할 때는 지역변수가 final, effectively final이어야 한다.(지역변수를 람다식 내에서 사용은 가능하나 변경이 불가능하다는 뜻)
		// 지역 변수는 람다식에서 읽는 것은 허용하지만, 람다식 내부 또는 외부에서 변경할 수 없다.
		// 	effectively fianl : 초기화 된 이후에 값이 한 번도 변경되지 않은 변수		[너무 자세히 공부하려하면 깊게 파야함 그냥 외우기]
		
		//num = 400;				// 람다식 내에서 지역 변수를 사용하면 지역 변수 변경이 불가능하다. 지역변수는 처음에 초기화한 그대로 사용해야 한다.
		fi = () -> {
			//num = 400;			// 람다식 내에서 지역 변수를 사용하면 지역 변수 변경이 불가능하다. 지역변수는 처음에 초기화한 그대로 사용해야 한다.
			this.num = 300;		// 클래스에 있는 필드의 값을 변경할 수도 있다. 주석 풀고 묶고 비교해보기
			
			System.out.println(num);
			System.out.println(this.num);
		};
		
		fi.method();
		
		// 익명 구현 객체에서 사용되는 this는 익명 구현 개체로 생성된 인스턴스의 참조이다. 이건 참조만 하기
		// 에러가 남
//		fi = new A_FunctionalInterface() {
//			
//			@Override
//			public void method() {
//				//System.out.println(this.num);	// 익명 구현 객체에서 사용되는 this는 익명 구현 개체로 생성된 인스턴스의 참조이다. 에러 발생
//				System.out.println(num);		// 클래스 내 필드 num	
//			}
//		};
	
	}
}
