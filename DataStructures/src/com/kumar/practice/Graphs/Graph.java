package com.kumar.practice.Graphs;
import java.util.LinkedList;

public class Graph {
    LinkedList<Nodes>[] adjList;
    public Graph(int x)
    {
        adjList=new LinkedList[x];
        for(int i=0;i<x;i++)
        {
            adjList[i]=new LinkedList<Nodes>();
        }
        Traversal.setAdjList(adjList);
    }
    public void addEdgeDirected(int s,int d, int w)
    {
        if(s<adjList.length && d<adjList.length) {
            adjList[s].add(new Nodes(s, d, w));
        }
        Traversal.setAdjList(adjList);
    }
    public void addEdgeUndirected(int s,int d,int w)
    {
        if(s<adjList.length && d<adjList.length)
        {
            adjList[s].add(new Nodes(s,d,w));
            adjList[d].add(new Nodes(d,s,w));
        }
        Traversal.setAdjList(adjList);
    }
    public void BFS(int s)
    {
        Traversal.BFS(s);
    }
}
