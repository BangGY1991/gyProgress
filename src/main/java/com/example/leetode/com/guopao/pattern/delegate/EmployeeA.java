package com.example.leetode.com.guopao.pattern.delegate;
//import lombok.extern.slf4j.Slf4j;
public class EmployeeA implements IEmployee {

	@Override
	public void doWork(String command) {
		// TODO Auto-generated method stub
		 System.out.printf("我是员工A，我现在开始干{}工作", command);
	}

}
