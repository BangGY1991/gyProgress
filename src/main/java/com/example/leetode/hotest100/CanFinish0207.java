package com.example.leetode.hotest100;

import java.util.*;
import java.util.List;

public class CanFinish0207 {
    //入度表（广度优先遍历）
    //初始时，所有入度为
    //0的节点都被放入队列中，它们就是可以作为拓扑排序最前面的节点，并且它们之间的相对顺序是无关紧要的。
    //在广度优先搜索的每一步中，我们取出队首的节点 u
//    我们将u 放入答案中
    //我们移除u的所有出边，也就是将u 的所有相邻节点的入度减少 1
    //如果某个相邻节点v 的入度变为0那么我们就将v 放入队列中。
//如果答案中包含了这n 个节点，那么我们就找到了一种拓扑排序，否则说明图中存在环，也就不存在拓扑排序了。

    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
          edges.add(new ArrayList<Integer>());
        }
        indeg=new int[numCourses];
        for (int[] info: prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        for (int i = 0; i <numCourses ; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited=0;
        while(!queue.isEmpty()){
            ++visited;
            int u=queue.poll();
            for (int v:edges.get(u)) {
                -- indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited==numCourses;
    }

}
