package xyz.jangle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.service.A;
import xyz.jangle.service.B;

@Service
public class AImpl implements A {
	
	@Autowired
	private B b;

	@Override
	public void testA() {
		System.out.println("aaa");
		b.testB();
	}
	

}
