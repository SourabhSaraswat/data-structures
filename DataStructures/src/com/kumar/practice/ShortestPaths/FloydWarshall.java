package com.kumar.practice.ShortestPaths;

import com.kumar.practice.Graphs.Nodes;
import com.kumar.practice.Graphs.Traversal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class FloydWarshall {
    private LinkedList<Nodes>[] adjList= Traversal.getAdjList();
    public FloydWarshall() {
        int n = adjList.length;
        int distance[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i]=0;
        }
        for (int i = 0; i < n; i++) {
            Iterator<Nodes> x = adjList[i].listIterator();
            while ((x.hasNext())) {
                Nodes N = x.next();
                distance[N.source][N.destination] = N.weight;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(distance[i][k]!=Integer.MAX_VALUE && distance[k][j]!=Integer.MAX_VALUE&& distance[i][k]+distance[k][j]<distance[i][j])
                    {
                        distance[i][j]=distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        printDistance(distance);
    }
    private void printDistance(int[][] distance)
    {
        for(int i=0;i<distance.length;i++)
        {
            for (int j=0;j<distance[i].length;j++)
            {
                System.out.print(distance[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
