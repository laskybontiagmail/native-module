package com.lasky;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		new NativeModule().hello();
		System.out.println("This is the process ID: " + new NativeModule().get_tid());
	}
}
