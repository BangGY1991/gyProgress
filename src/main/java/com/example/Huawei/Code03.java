package com.example.Huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author guoyu
 * @Date 2021/10/17 15:41
 * @Version 1.0
 */
public class Code03 {
    static class Memory
    {
        private TreeMap<Integer,Integer> hasAllocated;
        private int Address_head=0;
        private int Address_end=100;
        Memory()
        {
            hasAllocated=new TreeMap<>();
        }
        String request(int size)
        {
            int addressHead=Address_head;
            if(size<=0||size>100)
            {
                return "error";
            }
            if(hasAllocated.isEmpty())
            {
                hasAllocated.put(Address_head,size);
            }else
            {
                List<Integer> headList=new ArrayList<>(hasAllocated.keySet());
                for (int i = 0; i < headList.size(); i++) {
                    if(headList.get(i)-addressHead>=size)
                    {
                        hasAllocated.put(addressHead,addressHead+size);
                    }else
                    {
                        addressHead=hasAllocated.get(headList.get(i));
                    }

                }
                if(size<=Address_end-addressHead)
                {
                    hasAllocated.put(addressHead,addressHead+size);
                }
                else
                {
                    return "error";
                }
            }
            return String.valueOf(addressHead);
        }
        boolean release( int startAddress)
        {
            if(hasAllocated.containsKey(startAddress))
            {
                hasAllocated.remove(startAddress);
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Memory memory=new Memory();
        Scanner sc=new Scanner(System.in);
        int line=Integer.parseInt(sc.nextLine());
        String[][] ins=new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i]=sc.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST"))
            {
                System.out.println(memory.request(Integer.parseInt(ins[i][1])));
            }else
            {
                boolean res=memory.release(Integer.parseInt(ins[i][1]));
                if ( !res) {
                    System.out.println("error");
                }
            }
        }
        sc.close();
    }
}
