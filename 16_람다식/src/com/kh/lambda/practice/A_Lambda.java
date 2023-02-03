package com.kh.lambda.practice;

public class A_Lambda {
	
// 230127 2교시
	public void method1() {
		// 익명 구현 객체를 사용한 스레드 생성
		
		Thread thread;
								// Runnable이라는 인터페이스가 있음 ctrl click 해보기
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("익명 구현 객체를 사용한 Thread 생성");				
			}
		});
		
		thread.start();
		
		// 람다식을 통해 스레드 생성 (위와 똑같은데 람다식을 통해)
		
		thread = new Thread(() -> {
			System.out.println("람다식을 활용한 Thread 생성 1");
		});
			// 자바스크립트의 함수 만들어서 넘기는 것처럼 보임.
			// 자바스크립트는 가능한데 자바에서는 메소드를 만들어서 변수를 넘기는 거 불가능함
			// 화살표 함수랑 비슷해보이지만 보이기만 그런 것!
			// 람다식은 매개변수를 가지는 함수와 같은 코드 블록이지만 런타임 시에는 인터페이스의 익명 구현 객체를 생성한다.
		 	//	(자바스크립트의 화살표 함수처럼 메소드를 만들어서 변수에 담는 것처럼 보이고 매개 변수에 담는 것처럼 보이고 리턴하는 것처럼 보이는데
			//	 자바스크립트에서는 그게 되지만 자바에서는 안 됨. 실제로는 익명 구현 객체를 만들어서 넘기는 것
			//	 실제로 동작되는 원리는 다르다!!!!!!!) 
		
		thread.start();
		
		thread = new Thread(() -> System.out.println("람다식을 활용한 Thread 생성 2"));
		
		thread.start();
		
		// Runnable 참조변수에는 인스턴스의 주소값만 올 수 있음. 람다식은 메소드를 만들어서 넘기는 것처럼 보임(자바에서는 불가능한 것)
		// Runnable 인터페이스에는 추상 메소드가 있는데 이 추상메소드에 매개값을 넣어줘서 사용하는 것
		Runnable runnable = () -> System.out.println("람다식을 사용한 Thread 생성 2");
		
		thread = new Thread(runnable);
		
		thread.start();
	}

}
