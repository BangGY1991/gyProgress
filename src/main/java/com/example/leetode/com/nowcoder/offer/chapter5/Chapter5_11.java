package com.example.leetode.com.nowcoder.offer.chapter5;/**
 * @program: demo2
 * @description: minDistance
 * @author: GuoYu
 * @create: 2021-06-07 17:30
 **/

import java.util.HashMap;
import java.util.Map;
public class Chapter5_11 {

    public int minDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strs[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last1 = 2;
            }

        }
        return min == Integer.MIN_VALUE ? -1 : min;
    }

    public class Record {
        private HashMap<String, HashMap<String, Integer>> record;

        public Record(String[] strArr) {
            record = new HashMap<String, HashMap<String, Integer>>();
            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            for (int i = 0; i != strArr.length; i++) {
                String curStr = strArr[i];
                update(indexMap, curStr, i);
            }
        }

        private void update(HashMap<String, Integer> indexMap, String str, int i) {
            if (!record.containsKey(str)) {
                record.put(str, new HashMap<String, Integer>());
            }
            HashMap<String, Integer> strMap = record.get(str);
           /* for (Map.Entry<String, Integer> lastEntry : indexMap.entrySet()) {
                String key = lastEntry.getKey();
                int index = lastEntry.getValue();
                if (!key.equals(str)) {
                    HashMap<String, Integer> lastMap = record.get(key);
                    int curMin = i - index;
                    if (strMap.containsKey(key)) {
                        int preMin = strMap.get(key);
                        if (curMin < preMin) {
                            strMap.put(key, curMin);
                            lastMap.put(str, curMin);
                        }
                    } else {
                        strMap.put(key, curMin);
                        lastMap.put(str, curMin);
                    }
                }
            }*/
              for(Map.Entry<String,Integer> lastEntry: indexMap.entrySet())
              {
                  String key = lastEntry.getKey();
                  int index = lastEntry.getValue();
                  if(!key.equals(str))
                  {
                      HashMap<String,Integer> lastMap=record.get(key);
                      int curMin=i-index;
                      if (strMap.containsKey(key))
                      {
                        int preMin=strMap.get(key);
                        if (curMin<preMin)
                        {
                            strMap.put(key, curMin);
                            lastMap.put(str, curMin);
                        }
                      }
                      else
                      {
                          strMap.put(key, curMin);
                          lastMap.put(str, curMin);
                      }
                  }

              }


        }
        public int minDistance(String str1,String str2)
        {
            if (str1 == null || str2 == null) {
                return -1;
            }
            if (str1.equals(str2)) {
                return 0;
            }
            if(record.containsKey(str1)&&record.get(str1).containsKey(str2))
            {
                return record.get(str1).get(str2);
            }
            return -1;

        }
    }

}
