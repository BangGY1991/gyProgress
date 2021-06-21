package com.example.leetode.gupaohomework;

public class ZigzagConversion06 {
	 public String convert(String s, int numRows) {

	        if (numRows == 1) return s;

	        StringBuilder ret = new StringBuilder();
	        int n = s.length();
	        int cycleLen = 2 * numRows - 2;

	        for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j + i < n; j += cycleLen) {
	                ret.append(s.charAt(j + i));
	                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
	                    ret.append(s.charAt(j + cycleLen - i));
	            }
	        }
	        return ret.toString();
	    }
	   public String convert1(String s,int numRows) {
		   if(numRows==1) return s;
		   StringBuilder ret=new StringBuilder();
		   int n=s.length();
		   int cycleLen=2*numRows-2;
		   for (int i = 0; i < numRows; i++) {
			   for(int j=0;j+i<n;j+=cycleLen)
			   {
				   ret.append(s.charAt(j+i));
				   if (i!=0&&i!=numRows-1&&j+cycleLen-i<n) {
					   ret.append(s.charAt(j+cycleLen-i));
					
				}
			   }
			
		}
		   return ret.toString();
				   
	   }
	   public String convert2(String s,int numRows)
	   {
		   if(numRows==1) return s;
		   StringBuilder ret=new StringBuilder();
		   int n=s.length();
		   int cycleLen=2*numRows-2;
		   for (int i = 0; i <numRows; i++) {
			   for (int j = 0; j+i<n; j+=cycleLen) {
				   ret.append(s.charAt(j+i));
				   if (i!=0&&i!=numRows-1&&j+cycleLen-i<n) {
					   
					   ret.append(s.charAt(j+cycleLen-i));
				}
			}
			
		}
		   
		   return ret.toString();
		 
	   }
	   public String convert3(String s,int numRows)
	   {
		   if(numRows==1) return s;
		   StringBuilder ret=new StringBuilder();
//		   int n=s.length();
//		   int cycleLen=2*numRows-2;
//		   for (int i = 0; i <numRows; i++) {
//			   for (int j = 0; j+i<n; j+=cycleLen) {
//				   ret.append(s.charAt(j+i));
//				   if (i!=0&&i!=numRows-1&&j+cycleLen-i<n) {
//					   
//					   ret.append(s.charAt(j+cycleLen-i));
//				}
//			}
//			
//		}
//		   int n=s.length();
//		   int cycleLen=2*numRows-2;
//		   for(int i=0;i<numRows;i++)
//		   {
//			   for (int j = 0;j+i<n; j+=cycleLen) {
//				ret.append(s.charAt(i+j));
//				if (i!=0&&i!=numRows-1&&j+cycleLen-i<n) {
//					ret.append(s.charAt(j+cycleLen-i));
//				}
//			}
//		   }
		   int n=s.length();
		   int cycleLen=2*numRows-2;
		   for(int i=0;i<numRows;i++)
		   {
			   for(int j=0;j+i<n;j+=cycleLen)
			   {
				   ret.append(s.charAt(i+j));
				   if(i!=0&&i!=numRows-1&&j+cycleLen-i<n)
				   {
					   ret.append(s.charAt(j+cycleLen-i));
				   }
			   }
		   }
		   
		   return ret.toString();
	   }
	   
    

}
