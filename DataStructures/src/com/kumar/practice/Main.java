package com.kumar.practice;

import com.kumar.practice.Graphs.Graph;
import com.kumar.practice.Graphs.Traversal;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph g=new Graph(9);
        g.addEdgeUndirected(0,1,4);
        g.addEdgeUndirected(0,7,8);
        g.addEdgeUndirected(1,2,8);
        g.addEdgeUndirected(1,7,11);
        g.addEdgeUndirected(2,3,7);
        g.addEdgeUndirected(2,8,2);
        g.addEdgeUndirected(3,4,9);
        g.addEdgeUndirected(3,5,14);
        g.addEdgeUndirected(4,5,10);
        g.addEdgeUndirected(5,6,2);
        g.addEdgeUndirected(6,8,6);
        g.addEdgeUndirected(6,7,1);
        g.addEdgeUndirected(7,8,7);
        Traversal.DFS(0);
    }
}
