package com.kumar.practice.ShortestPaths;

import com.kumar.practice.Graphs.Nodes;
import com.kumar.practice.Graphs.Traversal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BellMan {
    private LinkedList<Nodes>[] adjList= Traversal.getAdjList();
    public void DetectNegativeEdge(int s, int d)
    {
//        visited tracker
        boolean[] visited=new boolean[adjList.length];
//        distance tracker
        int[] distance=new int[adjList.length];
        infinitify(distance);
//        Path tracker
        int[] parent=new int[adjList.length];
//        QUEUE
        LinkedList<LinkedList<Nodes>> queue=new LinkedList<>();
        queue.add(adjList[s]);
        distance[s]=Integer.MIN_VALUE;
        visited[s]=true;
        while (!queue.isEmpty())
        {
            Iterator<Nodes> i=queue.poll().listIterator();
            while(i.hasNext())
            {
                Nodes n=i.next();
                int source=n.source, destination=n.destination, weight=n.weight;
                if(!visited[destination] && distance[source]+weight<distance[destination])
                {
                    distance[destination]=weight+distance[source];
                    parent[destination]=source;
                    queue.add(adjList[getMinEdge(distance,visited)]);
                    visited[destination]=true;

                    if(distance[source]>distance[destination])
                    {
                        System.out.println("Negative edge detected");
                    }
                }
            }
        }
        printPath(distance,s);
    }
    private int getMinEdge(int[] distance,boolean[] visited)
    {
        int index=-1,min=Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if(min>distance[i]&& !visited[i])
            {
                min=distance[i];
                index=i;
            }

        }
        return index;
    }
    private void infinitify(int[] distance)
    {
        Arrays.fill(distance,Integer.MAX_VALUE);
    }
    private void printPath(int[] path,int d)
    {
        if(path[d]==Integer.MIN_VALUE)
        {
            return;
        }
        printPath(path,path[d]);
        System.out.println(d);
    }
}
