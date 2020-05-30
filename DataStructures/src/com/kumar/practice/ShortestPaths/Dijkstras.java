package com.kumar.practice.ShortestPaths;

import com.kumar.practice.Graphs.Nodes;
import com.kumar.practice.Graphs.Traversal;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstras {
    class IndexHelper{
        int i, d;
        public IndexHelper(int i,int d)
        {
            this.i=i;
            this.d=d;
        }
    }
    LinkedList<Nodes>[] adjList=Traversal.getAdjList();
    public void FindPath(int s, int d)
    {
        int length=adjList.length;
        int[] distance=new int[length];
        boolean[] visited=new boolean[length];


    }
    private void getMin(int[] distance)
    {
        
    }
}
