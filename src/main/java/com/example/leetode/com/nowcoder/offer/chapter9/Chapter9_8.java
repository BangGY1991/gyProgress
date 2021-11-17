package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.HashMap;

/**
 * @Author guoyu
 * @Date 2021/11/17 10:01
 * @Version 1.0
 * 设计有setAll功能的哈希表
 */
public class Chapter9_8 {
    public class MyValue<V> {
        private V value;
        private long time;

        public V getValue() {
            return value;
        }

        public long getTime() {
            return time;
        }

        public MyValue(V value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    public class MyHashMap<K, V> {
        private HashMap<K, MyValue<V>> baseMap;
        private long time;
        private MyValue<V> setAll;

        public MyHashMap() {
            this.baseMap = new HashMap<K, MyValue<V>>();
            this.time = 0;
            this.setAll = new MyValue<>(null, -1);
        }

        public boolean containsKey(K key) {
            return this.baseMap.containsKey(key);
        }

        public void put(K key, V value) {
            this.baseMap.put(key, new MyValue<V>(value, this.time++));
        }

        public void setAll(V value) {
            this.setAll = new MyValue<V>(value, this.time++);
        }

        public V get(K key) {
            if (this.containsKey(key)) {
                if (this.baseMap.get(key).getTime() > this.setAll.getTime()) {
                    return this.baseMap.get(key).getValue();
                } else {
                    return this.setAll.getValue();
                }
            } else {
                return null;
            }
        }
    }


}
