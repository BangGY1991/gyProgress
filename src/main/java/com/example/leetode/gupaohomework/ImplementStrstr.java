package com.example.leetode.gupaohomework;

public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
	    int L = needle.length(), n = haystack.length();
	    if (L == 0) return 0;

	    int pn = 0;
	    while (pn < n - L + 1) {
	      // find the position of the first needle character
	      // in the haystack string
	      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

	      // compute the max match string
	      int currLen = 0, pL = 0;
	      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
	        ++pn;
	        ++pL;
	        ++currLen;
	      }

	      // if the whole needle string is found,
	      // return its start position
	      if (currLen == L) return pn - L;

	      // otherwise, backtrack
	      pn = pn - currLen + 1;
	    }
	    return -1;
	  }
	public int strStr1(String haystack, String needle) {
		  int L = needle.length(), n = haystack.length();
		    if (L == 0) return 0;
		    int pn=0;
//		    while (pn<n-L+1) {
//		    	while (pn<n-L+1&&haystack.charAt(pn)!=needle.charAt(0)) {
//		    		++pn;
//					
//				}
//		    	int currLen=0,pL=0;
//		    	while (pL<L&&pn<n&&haystack.charAt(pn)==needle.charAt(pL)) {
//		    		++pn;
//		    		++pL;
//		    		++currLen;
//					
//				}
//		    	if (currLen==L) {
//		    		return pn-L;
//					
//				}
//		    	pn=pn-currLen+1;
//				
//			}
//		    while (pn<n-L+1) {
//		    	while (pn<n-L+1&&haystack.charAt(pn)!=needle.charAt(0)) {
//					++pn;
//				}
//		    	int currLen=0,pL=0;
//		    	while (pL<L&&pn<n&&haystack.charAt(pn)==needle.charAt(pL)) {
//		    		++pn;
//		    		++pL;
//		    		++currLen;
//					
//				}
//		    	if (currLen==L) {
//		    		return pn-L;
//				}
//		    	pn=pn-L+1;
//			}
		    int currLen;
		    int pL;
		    while (pn<n-L+1) {
		    	while (pn<n-L+1&&haystack.charAt(pn)!=needle.charAt(0)) {
		    		pn++;
					
					
				}
		        currLen=0;
		        pL=0;
		    	while (pL<L&&pn<n&&haystack.charAt(pn)==needle.charAt(pL)) {
		    		++pn;
		    		pL++;
		    		currLen++;
				}
		    	if (currLen==L) {
		    		return pn-L;
					
				}
		    	pn=pn-L+1;
			}
		return -1;
	}

}
