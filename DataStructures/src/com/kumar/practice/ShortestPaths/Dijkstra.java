package com.kumar.practice.ShortestPaths;
import com.kumar.practice.Graphs.Nodes;
import com.kumar.practice.Graphs.Traversal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import static java.lang.Integer.*;

public class Dijkstra {
    private LinkedList<Nodes>[] adjList=Traversal.getAdjList();
    public void FindPath(int s, int d)
    {
        int length=adjList.length;
        int[] distance=new int[length];
        int[] parent=new int[length];
        boolean[] visited=new boolean[length];
        MarkInfinity(distance);
        visited[s]=true;
        distance[s]=0;
        parent[s]=-1;
        LinkedList<LinkedList<Nodes>> queue=new LinkedList<>();
        queue.add(adjList[s]);
        while(!queue.isEmpty())
        {
            Iterator<Nodes> i=queue.poll().listIterator();
            while(i.hasNext())
            {
                Nodes n=i.next();
                int source=n.source, destination=n.destination, weight=n.weight;
//                Check if the value current distance is minimum from the distance table
                if( !visited[destination] && distance[source]+weight<distance[destination])
                {
                    distance[destination]=distance[s]+weight;
                    parent[destination]=source;
                    int index=getMin(distance,visited);
                    queue.add(adjList[index]);
                    visited[destination]=true;
                }
            }
        }
        System.out.println("Printing Path");
        printParent(parent,d);
    }
    private int getMin(int[] distance,boolean[] visited)
    {
        int min= MAX_VALUE, index=-1;
        for(int i=0;i<distance.length;i++)
        {
            if(distance[i]<min && !visited[i])
            {
                min=distance[i];
                index=i;
            }
        }
        return index;
    }
    private void MarkInfinity(int[] distance)
    {
        Arrays.fill(distance, MAX_VALUE);
    }
    private void printParent(int[] parent,int d)
    {
        if(parent[d]!=-1)
        {
            printParent(parent,parent[d]);
        }
        System.out.println(d);
    }
    private void print1D(int[] arr)
    {
        for (int i : arr) {
//            if(arr[i]!=MAX_VALUE)
//            {
                System.out.println(i+"-->"+arr[i]+"\t");
//            }
        }
        System.out.println();

    }
}
