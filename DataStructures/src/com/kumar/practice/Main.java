package com.kumar.practice;

import com.kumar.practice.Graphs.Graph;
import com.kumar.practice.ShortestPaths.Dijkstra;
import com.kumar.practice.ShortestPaths.Johnson;


public class Main {

    public static void main(String[] args) {
        Graph g=new Graph(4);
//        g.addEdgeUndirected(0,1,4);
//        g.addEdgeUndirected(0,7,8);
//        g.addEdgeUndirected(1,2,8);
//        g.addEdgeUndirected(1,7,11);
//        g.addEdgeUndirected(2,3,7);
//        g.addEdgeUndirected(2,5,4);
//        g.addEdgeUndirected(2,8,2);
//        g.addEdgeUndirected(3,4,9);
//        g.addEdgeUndirected(3,5,14);
//        g.addEdgeUndirected(4,5,10);
//        g.addEdgeUndirected(5,6,2);
//        g.addEdgeUndirected(6,8,6);
//        g.addEdgeUndirected(6,7,1);
//        g.addEdgeUndirected(7,8,7);
        g.addEdgeDirected(0,1,-5);
        g.addEdgeDirected(0,2,2);
        g.addEdgeDirected(0,3,3);
        g.addEdgeDirected(1,2,4);
        g.addEdgeDirected(2,3,1);
        Dijkstra shortestPath=new Dijkstra();
//        Uncomment for dijkstra='s
//        shortestPath.FindPath(0,8);
//        All pairs shortest path
//        new FloydWarshall();
        new Johnson();
//        Traversal.PrintAll();
    }
}
