package com.example.leetode.com.guopao.pattern.delegate;

public class Boss {

	public void command(String command, Leader leader) {
		// TODO Auto-generated method stub
		  leader.doWork(command);
	}

}
