package com.example.leetode.com.guopao.pattern.delegate;

public class EmployeeB implements IEmployee {

	@Override
	public void doWork(String command) {
		// TODO Auto-generated method stub
		System.out.printf("我是员工B，我现在开始干{}工作", command);
	}

}
