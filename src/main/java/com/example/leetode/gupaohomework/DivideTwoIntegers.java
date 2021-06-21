package com.example.leetode.gupaohomework;

import javax.swing.table.TableModel;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/*采用二分法的思想，dividend每次减去2^n个divisor（尽可能多），同时reslut每次加2^n*/
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE&&divisor==-1)
			return Integer.MAX_VALUE;
		
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
                divisor=-Math.abs(divisor);//补充一点： dividend=-Math.abs(dividend);和divisor=-Math.abs(divisor); 在值为Integer.MIN_VALUE时仍然成立，是因为-Math.abs(Integer.MIN_VALUE)结果仍为Integer.MIN_VALUE； 否则最小值的绝对值直接符号取反会超过可以表示的最大值。
		while(dividend<=divisor) {
			int temp=divisor;
			int c=1;
			while(dividend-temp<=temp) {
				temp=temp<<1;
				c=c<<1;
			}
			dividend-=temp;
			result+=c;
		}
		return k?result:-result;
	}
	public int divide1(int dividend, int divisor) {
		if (dividend==Integer.MIN_VALUE&&dividend==-1) {
			return Integer.MAX_VALUE;
		}
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
		divisor=-Math.abs(divisor);
		while (dividend<=divisor) {
			int temp=divisor;
			int c=1;
			while (dividend-temp<=temp) {
				temp=temp<<1;
				c=c<<1;
				
			}
			dividend-=temp;
			result+=c;
		}
		return k?result:-result;
	}
	public int divide2(int dividend, int divisor) {
		if (dividend==Integer.MIN_VALUE&&dividend==-1) {
			return Integer.MAX_VALUE;
		}
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
		divisor=-Math.abs(divisor);
		while (dividend<=divisor) {
			int temp=divisor;
			int c=1;
			while (dividend-temp<=temp) {
				temp=temp<<1;
				c=c<<1;
				
			}
			dividend-=temp;
			result+=c;
		}
		return k?result:-result;
	}
	public int divide3(int dividend, int divisor) {
		if (dividend==Integer.MIN_VALUE&&dividend==-1) {
			return Integer.MAX_VALUE;
		}
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
		divisor=-Math.abs(divisor);
		while(dividend<=divisor)
		{
			int temp=divisor;
			int c=1;
			while(dividend-temp<=temp)
			{
				temp=temp<<1;c=c<<1;
			}
			dividend-=temp;
			result+=c;
	}
		return k?result:-result;
	}
	public int divide4(int dividend, int divisor) {
		if (dividend==Integer.MIN_VALUE&&dividend==-1) {
			return Integer.MAX_VALUE;
		}
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
		divisor=-Math.abs(divisor);
		while (dividend<=divisor) {
			int temp=divisor;
			int c=1;
			while(dividend-temp<=temp)
			{
				temp=temp<<1;c=c<<1;
			}
			dividend-=temp;
			result+=c;
			
		}
		return k?result:-result;
	}
	
}
