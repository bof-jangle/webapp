package xyz.jangle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.service.A;
import xyz.jangle.service.B;

@Service
public class BImpl implements B {
	@SuppressWarnings("unused")
	@Autowired
	private A a;

	@Override
	public void testB() {
		System.out.println("bbb");
//		a.testA();
	}
	
	

}
