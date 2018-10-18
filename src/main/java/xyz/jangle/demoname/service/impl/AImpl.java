package xyz.jangle.demoname.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.service.A;
import xyz.jangle.demoname.service.B;

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
