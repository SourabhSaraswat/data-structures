package com.kumar.practice.Graphs;
import java.util.Iterator;
import java.util.LinkedList;

public class Traversal {
//    Singleton  for working on a single graph (only for my practice)
    public static Traversal instance=new Traversal();

    public static LinkedList<Nodes>[] getAdjList() {
        return adjList;
    }

    private static LinkedList<Nodes>[] adjList;
    public static void BFS(int s)
    {
        LinkedList<LinkedList<Nodes>> queue=new LinkedList<LinkedList<Nodes>>();
        queue.add(adjList[s]);
        boolean[] visited=new boolean[adjList.length];
        visited[s]=true;
        while(!queue.isEmpty())
        {
            Iterator<Nodes> i=queue.poll().listIterator();
            while(i.hasNext())
            {
                Nodes n=i.next();
                int source=n.source,destination=n.destination,weight=n.weight;
                if(!visited[destination])
                {
                    System.out.println(source+"-->"+destination+'('+weight+')');
                    queue.add(adjList[destination]);
                    visited[destination]=true;
                }
            }
        }
    }
    public static void DFS(int s)
    {
        boolean[] visited=new boolean[adjList.length];
        DFS(s,visited);
    }
    private static void DFS(int s,boolean[] visited)
    {

        Iterator<Nodes> i=adjList[s].listIterator();
        while(i.hasNext()) {
            Nodes n = i.next();
            int source = n.source, destination = n.destination, weight = n.weight;
            if (!visited[destination]) {
                System.out.println(source + "-->" + destination + " ("+ weight + ')');
                visited[destination] = true;
                DFS(destination,visited);
            }
        }
    }

    public static void setAdjList(LinkedList<Nodes>[] adjList) {
        Traversal.adjList = adjList;
    }
    public static void PrintAll()
    {
        for(int i=0;i<adjList.length;i++)
        {
            Iterator<Nodes> iterator=adjList[i].listIterator();
            while(iterator.hasNext())
            {
                Nodes N=iterator.next();
                int u=N.source, v=N.destination, w=N.weight;
                System.out.print(u+" --> "+v+" ("+w+") "+"\t");
            }
            System.out.println();
        }
    }

}
