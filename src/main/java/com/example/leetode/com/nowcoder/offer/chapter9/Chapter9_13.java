package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/11/19 15:59
 * @Version 1.0
 */
public class Chapter9_13 {
    public class Element<V>{
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }
    public class UnionFindSet<V>{
        public HashMap<V,Element<V>> elementMap;
        public HashMap<Element<V>,Element<V>> fatherMap;
        public HashMap<Element<V>,Integer> rankMap;

        public UnionFindSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fatherMap=new HashMap<>();
            this.rankMap=new HashMap<>();
            for (V value:list) {
            Element<V> element=new Element<V>(value);
            elementMap.put(value,element);
            fatherMap.put(element,element);
            rankMap.put(element,1);
            }
        }

        private Element<V> findHead(Element<V> element)
        {
            Stack<Element<V>> path=new Stack<>();
            while(element!=fatherMap.get(element)){
                path.push(element);
                element=fatherMap.get(element);
            }
            while(!path.isEmpty())
            {
                fatherMap.put(path.pop(),element);
            }
        return element;
        }

         public boolean isSameSet(V a, V b)
         {
             if (elementMap.containsKey(a)&& elementMap.containsKey(b))
             {
                 return findHead(elementMap.get(a))==findHead(elementMap.get(b));
             }
             return false;
         }
         public void union(V a,V b)
         {
             if (elementMap.containsKey(a)&& elementMap.containsKey(b))
             {
                 Element aF=findHead(elementMap.get(a));
                 Element bF=findHead(elementMap.get(b));
                 if (aF!=bF)
                 {
                     Element<V> big=rankMap.get(aF)>rankMap.get(bF)?aF:bF;
                     Element<V> small= big==aF?bF:aF;
                     fatherMap.put(small,big);
                     rankMap.put(big,rankMap.get(aF)+ rankMap.get(bF));
                     rankMap.remove(small);
                 }
             }
         }

    }
}
