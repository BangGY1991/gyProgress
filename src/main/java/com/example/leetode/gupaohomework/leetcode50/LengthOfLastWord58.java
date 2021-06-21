package com.example.leetode.gupaohomework.leetcode50;

public class LengthOfLastWord58 {
	public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
	public int lengthOfLastWord1(String s) {
	int end=s.length()-1;
	while(end>=0&&s.charAt(end)==' ') end--;;
	if (end<0) {
		return 0;
		
	}
	int start=end;
	while(start>=0&&s.charAt(start)!=' ') start--;
	return end-start;
	}
}
