package com.example.leetode.gupaohomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GroupAnagrams49 {
	  public List<List<String>> groupAnagrams1(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String key = String.valueOf(ca);
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }
	  public List<List<String>> groupAnagrams11(String[] strs) {
		  if (strs.length==0) {
			  return new ArrayList();			
		}
		  Map<String, List> ans=new HashMap<>();
		  for (String s: strs) {
			char[] ca=s.toCharArray();
			Arrays.sort(ca);
			  String key = String.valueOf(ca);
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList<>());
				
			}
			ans.get(key).add(s);
		}
		  return new ArrayList(ans.values());
	  }
	  public List<List<String>> groupAnagrams12(String[] strs) {
		  if (strs.length==0) {
			  return new ArrayList();			
		}
		  Map<String, List> ans=new HashMap<>();
		  for (String s : strs) {
			  char[] ca=s.toCharArray();
			  Arrays.sort(ca);
			  String key = String.valueOf(ca);
			  if(!ans.containsKey(key))
			  {
				  ans.put(key, new ArrayList<>());
			  }
			  ans.get(key).add(s);
			
		}
		  return  new ArrayList(ans.values());
		  
	  }
	  public List<List<String>> groupAnagrams13(String[] strs) {
		  if(strs.length==0)
		  {
			  return new ArrayList<>();
		  }
		  Map<String, List<String>> ans =new HashMap<>();
		  for(String s:strs)
		  {
			  char[] ca=s.toCharArray();
			  Arrays.sort(ca);
			  String key = String.valueOf(ca);
			  if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList<>());
			}
			  ans.get(key).add(s);
		  }
		  return new ArrayList(ans.values());
	  }
	  
	  public List<List<String>> groupAnagrams2(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        int[] count = new int[26];
	        for (String s : strs) {
	            Arrays.fill(count, 0);
	            for (char c : s.toCharArray()) count[c - 'a']++;

	            StringBuilder sb = new StringBuilder("");
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }
	  public List<List<String>> groupAnagrams21(String[] strs) {
		  if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        int[] count=new int[26];
	        for (String s : strs) {
				Arrays.fill(count, 0);
				for(char c:s.toCharArray()) count[c-'a']++;
				StringBuilder sb=new StringBuilder();
				   for (int i = 0; i < 26; i++) {
		                sb.append('#');
		                sb.append(count[i]);
		            }
				      String key = sb.toString();
			            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
			            ans.get(key).add(s);
			}
		  return new ArrayList(ans.values());
	  }

	}
