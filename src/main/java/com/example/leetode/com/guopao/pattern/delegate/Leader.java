package com.example.leetode.com.guopao.pattern.delegate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Leader implements IEmployee{

	
		// TODO Auto-generated method stub
		private Map<String, IEmployee> map = new ConcurrentHashMap<>();

	    public Leader() {
	        init();
	    }

	    private void init() {
	        map.put("login", new EmployeeA());
	        map.put("ssh", new EmployeeB());
	    }

	    @Override
	    public void doWork(String command) {
	        this.map.get(command).doWork(command);
	    
	}

}
