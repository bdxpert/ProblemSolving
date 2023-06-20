package com.problem.solve.v2.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class SanDFS {
    Boolean[] visited ;
    LinkedList<Integer> edges[];

    public SanDFS(int v)
    {
       visited = new Boolean[v];
       edges = new LinkedList[v];
       for (int i=0;i<v;i++) {
           edges[i] = new LinkedList<>();
       }
    }
    public void DFS(int v)
    {
        visited[v] = true;
        Iterator<Integer> iterator = edges[v].iterator();
        while(iterator.hasNext()) {
            int edge = iterator.next();
            if(!visited[edge]) {
                DFS(edge);
            }
        }
    }
}
