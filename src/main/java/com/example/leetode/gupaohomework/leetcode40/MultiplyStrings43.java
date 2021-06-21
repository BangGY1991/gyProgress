package com.example.leetode.gupaohomework.leetcode40;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class MultiplyStrings43 {

	

	public String multiply1(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] res = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';
				int sum = (res[i + j + 1] + n1 * n2);
				res[i + j + 1] = sum % 10;
				res[i + j] += sum / 10;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0)
				continue;
			result.append(res[i]);
		}
		return result.toString();
	}
	public String multiply2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] res=new int[num1.length()+num2.length()];
		for (int i = num1.length()-1; i >=0; i--) {
			int n1=num1.charAt(i)-'0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';
				int sum = (res[i + j + 1] + n1 * n2);
				res[i+j+1]=sum%10;
				res[i+j]=sum/10;
			}
		}
			StringBuilder result=new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0)
				continue;
			result.append(res[i]);
		}
		return result.toString();
		
	}
	public String multiply3(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] res=new int[num1.length()+num2.length()];
		for(int i=num1.length()-1;i>=0;i--)
		{
			int n1=num1.charAt(i)-'0';
			for(int j=num2.length()-1;j>=0;i--)
			{
				int n2=num2.charAt(j)-'0';
				int sum=(res[i+j+1]+n1*n2);
				res[i+j+1]=sum%10;
				res[i+j]=sum/10;
			}
		}
		StringBuilder reulst=new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0)
				continue;
			reulst.append(res[i]);
		}
		return reulst.toString();
	}
}
