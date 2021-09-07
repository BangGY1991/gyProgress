package com.example.leetode.com.nowcoder.offer.chapter8;

import java.util.*;

/**
 * @program: gyProgress
 * @description: 大楼轮廓问题
 * @author: GuoYu
 * @create: 2021-09-07 12:05
 **/
public class Chapter8_28 {
    public class Node{
        public int x;//x 轴上的值
        public boolean isAdd;//true 为加入，false为删除
        public int h;

        public Node(int x, boolean isAdd, int h) {
            this.x = x;
            this.isAdd = isAdd;
            this.h = h;
        }

    }
      /*第二步：将描述高度变化的对象数组排序，排序的比较策略如下。
        1.第一个维度的值从小到大排序。2.如果第一个维度的值相等，看第二个维度的值，“加入”排在前，“删除”排在后。
        3.如果两个对象第一维度和第二个维度的值都相等，则认为两个对象相等，谁在前都行。*/

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            /**o1-o2为升序序排列，o2-o1为降序排列，若具体到某一字段，则根据该字段进行排列*/
            if (o1.x != o2.x) {
                return o1.x-o2.x;
            }
            if (o1.isAdd != o2.isAdd) {
                return o1.isAdd?-1:1;
            }
            return 0;
        }
    }
    public List<List<Integer>> buildingOutLine(int[][] matrix)
    {
        Node[] nodes=new Node[matrix.length*2];
        for (int i = 0; i < matrix.length; i++) {
            nodes[i * 2] = new Node(matrix[i][0], true, matrix[i][2]);
            nodes[i * 2 + 1] = new Node(matrix[i][1], false, matrix[i][2]);
        }
            Arrays.sort(nodes,new NodeComparator());
            TreeMap<Integer,Integer> mapHeightTimes=new TreeMap<>();
            TreeMap<Integer,Integer> mapXvalueHeight=new TreeMap<>();
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].isAdd) {
                    if (!mapHeightTimes.containsKey(nodes[i].h)){
                        mapHeightTimes.put(nodes[i].h,1);
                    }else{
                        mapHeightTimes.put(nodes[i].h,mapHeightTimes.get(nodes[i].h)+1);
                    }
                }else {
                    if (mapHeightTimes.get(nodes[i].h) == 1) {
                        mapHeightTimes.remove(nodes[i].h);
                    }else{
                        mapHeightTimes.put(nodes[i].h,mapHeightTimes.get(nodes[i].h)-1);
                    }
                }
                if (mapHeightTimes.isEmpty()) {
                  mapXvalueHeight.put(nodes[i].x,0);
                }else {
                    mapXvalueHeight.put(nodes[i].x,mapHeightTimes.lastKey());
                }
                
        }
        List<List<Integer>> res=new ArrayList<>();
            int start=0;
            int preHeight=0;
        for (Map.Entry<Integer,Integer> entry : mapXvalueHeight.entrySet()
             ) {
            int curX=entry.getKey();
            int curMaxHeight= entry.getValue();
            if (preHeight!=curMaxHeight)
            {
                if (preHeight != 0) {
                    res.add(new ArrayList<>(Arrays.asList(start,curX,preHeight)));
                }

            }
            start=curX;
            preHeight=curMaxHeight;
            
        }
        return res;
    }

}
