package com.example.leetode.com.nowcoder.offer.chapter5;

import java.util.*;

/**
 * @program: gyProgress
 * @description: 字符串的转换路径问题
 * @author: GuoYu
 * @create: 2021-06-10 17:47
 **/


public class Chapter5_12 {
    public List<List<String>> findMinPahts( String start,String to,List<String> list)
    {
        list.add(start);
        HashMap<String, ArrayList<String>> nexts=getNexts(list);
        HashMap<String,Integer> distances=getDistances(start,nexts);
        LinkedList<String> pathList=new LinkedList<>();
        List<List<String>> res= new ArrayList<>();
        getShortestPaths(start,to,nexts,distances,pathList,res);
        return res;
    }

    public HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), new ArrayList<>());
        }
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNexts(words.get(i), dict));
        }

        return null;
    }

    private ArrayList<String> getNexts(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != cur) {
                    char temp = chs[i];
                    chs[i] = cur;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = temp;
                }
            }
        }
        return res;
    }

    public HashMap<String, Integer> getDistances(String start, HashMap<String, ArrayList<String>> nexts) {
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(start, 0);
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        HashSet<String> set = new HashSet<String>();
        set.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String str : nexts.get(cur)) {
                if (!set.contains(str)) {
                    distance.put(str, distance.get(cur) + 1);
                    queue.add(str);
                    set.add(str);
                }
            }
        }
        return distance;
    }

    private void getShortestPaths(String cur, String to, HashMap<String, ArrayList<String>> nexts,
                                  HashMap<String, Integer> distance, LinkedList<String> solution,
                                  List<List<String>> res) {
        solution.add(cur);
        if (to.equals(cur)) {
            res.add(new LinkedList<String>(solution));
        } else {
            for (String next : nexts.get(cur)) {
                if (distance.get(next)==distance.get(cur)+1)
                {
                    getShortestPaths(next,to,nexts,distance,solution,res);
                }

            }

        }
        solution.pollLast();
    }


}
