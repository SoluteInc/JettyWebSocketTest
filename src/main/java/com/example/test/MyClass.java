package com.example.test;

import org.apache.commons.lang3.event.EventListenerSupport;

public class MyClass {
	private EventListenerSupport<MyInterface> listeners;
	
	public MyClass() {
		listeners = new EventListenerSupport<MyInterface>(MyInterface.class);
	}
	
	public void test() {
		listeners.fire().test();
	}
}
