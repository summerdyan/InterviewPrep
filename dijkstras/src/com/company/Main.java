package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // graph representation
        int[][] graph =
                {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        int source = 0;

        int[] dist = Dijkstra(graph, source);
        for(int i : dist)
            System.out.println(i);

    }

    // function to perform dijkstra's
    public static int[] Dijkstra(int[][] graph, int source) {
        // array that stores distance of other vertices from source
        int[] dist = new int[graph.length];
        // array that stores the previous vertex in the shortest path
        int[] prev = new int[graph.length];
        // keeps track of the vertices
        HashSet<Integer> Q = new HashSet<>();

        // iterate through the vertices in the graph
        for(int i = 0; i < graph.length; i++) {
            // put infinity as the default for the distance array
            dist[i] = Integer.MAX_VALUE;
            // put undefined as the default for the previous array
            prev[i] = -1;
            // add the vertex to Q
            Q.add(i);
        }
        // set the distance from source to 0 because it's in the same position
        // as itself
        dist[source] = 0;

        // iterate through Q while not empty
        while(!Q.isEmpty()) {
            // find the vertex present in Q that has the minimum distance to the source vertex
            int u = findMin(dist, Q);
            // remove that vertex from Q
            Q.remove(u);

            // find the neighbors of u still in Q
            ArrayList<Integer> neighbors = findNeighbors(u, Q, graph);
            for(int n : neighbors) {
                // length of path from root node to node n through node u
                // distance of source -> u -> n
                int alt = dist[u] + graph[u][n];

                // if alt is less than the current shortest path to n
                if(alt < dist[n]) {
                    dist[n] = alt;
                    prev[n] = u;
                }
            }
        }
        return dist;
    }

    // function to find the vertex present in Q that has the minimum
    // distance to the source vertex
    public static int findMin(int[] dist, HashSet<Integer> Q) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i : Q) {
            if(dist[i] < min) {
                min = dist[i];
                pos = i;
            }
        }
        return pos;
    }

    // function to find the neighbors to u that's still in Q
    public static ArrayList<Integer> findNeighbors(int u, HashSet<Integer> Q, int[][] graph) {
        // the nearest neighbor is the vertex with the least amount
        // of distance to the vertex u

        // distances must be greater than 0 to be valid

        // look through graph[u] at the vertices specified in Q
        // whichever one is the smallest is our nearest neighbor

        // Note: based on assumption that connections between
        // nodes are two-sided

        // array to store distances of vertices from u
        int[] u_distances = graph[u];

        ArrayList<Integer> neighbors = new ArrayList<>();
        for(int i : Q) {
            // want to avoid adding vertices that aren't actually
            // connected to u (distances of 0)
            if(u_distances[i] > 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
