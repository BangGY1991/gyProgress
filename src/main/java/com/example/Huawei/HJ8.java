package com.example.Huawei;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/10/10 13:22
 * @Version 1.0
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int tableSize=scanner.nextInt();
        Map<Integer,Integer> table=new HashMap<>(tableSize);
        for (int i = 0; i <tableSize ; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (table.containsKey(key)) {
                table.put(key, table.get(key) + value);

            } else {
                table.put(key, value);
            }
        }
            for (Integer key: table.keySet()
                 ) {

                System.out.println(key+" "+table.get(key));
            }

    }
}
