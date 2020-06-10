package com.kumar.practice.ShortestPaths;

import com.kumar.practice.Graphs.Nodes;
import com.kumar.practice.Graphs.Traversal;
import org.w3c.dom.Node;

import java.util.*;

// For Handling Negative Weights

public class Johnson {
    private LinkedList<Nodes>[] adjList= Traversal.getAdjList();
    public Johnson()
    {
        int n=adjList.length;
        int[] temp=new int[n];
        int[][] AllPair=new int[n][n];
        for(int i=0;i<temp.length;i++)
        {
            DijkstraAllPair(i,temp);
        }
//        Reweighed to all positive
        ReWeight(temp);
//        To call Dijkstra's for every vertex
        for(int i=0;i<n;i++)
        {
            Arrays.fill(AllPair[i],Integer.MAX_VALUE);
            Iterator<Nodes> x=adjList[i].listIterator();
            AllPair[i][i]=0;
            while(x.hasNext())
            {
                Nodes N=x.next();
                int u=N.source, v=N.destination, w=N.weight;
                AllPair[u][v]=w;
            }

        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++) {
                DijkstraAllPair(j, AllPair[i]);
            }
        }
        PrintDistance(AllPair);
    }
    private void PrintDistance(int[][] distance)
    {
        for (int i=0;i<distance.length;i++)
        {
            System.out.println(Arrays.toString(distance[i]));
        }
    }
    private void DijkstraAllPair(int s ,int[] temp)
    {
        boolean[] visited=new boolean[temp.length];
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(s);
        visited[s]=true;
        while (!queue.isEmpty())
        {
            s=queue.poll();
            Iterator<Nodes> i=adjList[s].listIterator();
            while(i.hasNext())
            {
                Nodes n=i.next();
                int w=n.weight,u=n.source, v=n.destination;
                if(!visited[v] && temp[u]!=Integer.MAX_VALUE && (temp[u]+w<temp[v]) )
                {
                    temp[v]=temp[u]+w;
//                    System.out.printf("%d ---> %d (%d,%d)%n",u,v,w,temp[v]);
                    queue.add(getMin(temp,visited));
                    visited[v]=true;
                }
            }
        }
    }
    private int getMin(int[] temp,boolean[] visited)
    {
        class Pair
        {
            private int key,value;
            private Pair(int k, int v)
            {
                key=k;
                value=v;
            }
        }
        PriorityQueue<Pair> minHeap=new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.value>p2.value)
                {
                    return 1;
                }
                return 0;
            }
        });
        for(int i=0;i<temp.length;i++)
        {
            if(!visited[i])
            minHeap.add(new Pair(i,temp[i]));
        }
        return minHeap.poll().key;
    }
    private void print(int[] temp)
    {
        for (int i:temp)
        {
            System.out.println(i);
        }
    }
    private void ReWeight(int[] temp)
    {
        for(int i=0;i<temp.length;i++)
        {
            Iterator<Nodes> iterator=adjList[i].listIterator();
            while(iterator.hasNext())
            {
                Nodes N=iterator.next();
                int u=N.source, v=N.destination, w=N.weight;
                N.weight=w+temp[u]-temp[v];
//                System.out.println(u+" ("+v+") "+w+"-->"+N.weight);
            }
        }
    }
    private void printAdjList()
    {
        for (int i=0;i<adjList.length;i++)
        {
            Iterator<Nodes> x=adjList[i].listIterator();
            while (x.hasNext())
            {
                Nodes N=x.next();
            }
        }
    }
}
