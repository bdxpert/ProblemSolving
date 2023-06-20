package com.problem.solve.v2.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class SanBFS {
    int V;
    LinkedList<Integer> node[];
    public SanBFS(int v)
    {
        this.V = v;
        this.node = new LinkedList[v];
        for(int i=0;i<v; i++){
            this.node[i]= new LinkedList<>();
        }
    }
    void addEdge(int v, int w)
    {
        this.node[v].add(w);
    }
    void traverse(int vertex)
    {
        Boolean[] mark = new Boolean[this.V];
        LinkedList<Integer> queue = new LinkedList<>();
        mark[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print(vertex + " - vertex -");
            Iterator<Integer> iterator = node[vertex].iterator();
            while(iterator.hasNext()) {
               int n = iterator.next();
               if(!mark[n]) {
                   mark[n] = true;
                   queue.add(n);
               }
            }

        }
    }

    public static void main(String args[])
    {
        SanBFS sanBFS = new SanBFS(4);
        sanBFS.addEdge(0, 1);
        sanBFS.addEdge(0, 2);
        sanBFS.addEdge(1, 2);
        sanBFS.addEdge(2, 0);
        sanBFS.addEdge(2, 3);
        sanBFS.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        sanBFS.traverse(2);
    }
}
