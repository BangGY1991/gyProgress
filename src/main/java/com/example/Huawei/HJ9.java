package com.example.Huawei;
import java.util.*;
/**
 * @Author guoyu
 * @Date 2021/10/10 13:34
 * @Version 1.0
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            HashSet<Character> set = new HashSet<>();
            ArrayList<Character> list = new ArrayList<>();
            for(int i = s.length() - 1; i >= 0; --i){
                if(!set.contains(s.charAt(i))){
                    set.add(s.charAt(i));
                    list.add(s.charAt(i));
                }
            }
            for(int i = 0; i < list.size(); ++i){
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }

}
