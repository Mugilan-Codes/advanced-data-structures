package algo.graph.bellman_ford;

public class CreateGraph {

    class CreateEdge {
        int src, dest, weight;

        CreateEdge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    CreateEdge[] edge;

    CreateGraph(int vertices, int edges) {
        V = vertices;
        E = edges;
        edge = new CreateEdge[E];
        for (int i = 0; i < E; ++i) {
            edge[i] = new CreateEdge();
        }
    }

    void BellmanFord(CreateGraph graph, int source) {
        int V = graph.V, E = graph.E;
        int[] distance = new int[V];

        for (int i = 0; i < V; ++i) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int s = graph.edge[j].src;
                int d = graph.edge[j].dest;
                int w = graph.edge[j].weight;
                if (distance[s] != Integer.MAX_VALUE && distance[s] + w < distance[d]) {
                    distance[d] = distance[s] + w;
                }
            }
        }

        for (int j = 0; j < E; ++j) {
            int s = graph.edge[j].src;
            int d = graph.edge[j].dest;
            int w = graph.edge[j].weight;
            if (distance[s] != Integer.MAX_VALUE && distance[s] + w < distance[d]) {
                System.out.println("CreateGraph contains negative weight cycle");
                return;
            }
        }

        printSolution(distance, V);
    }

    void printSolution(int[] distArr, int vertices) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; ++i) {
            System.out.println(i + "\t\t" + distArr[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        CreateGraph graph = new CreateGraph(V, E);

        // edge 0 --> 1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 5;

        // edge 0 --> 2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // edge 1 --> 3
        graph.edge[2].src = 1;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 3;

        // edge 2 --> 1
        graph.edge[3].src = 2;
        graph.edge[3].dest = 1;
        graph.edge[3].weight = 6;

        // edge 3 --> 2
        graph.edge[4].src = 3;
        graph.edge[4].dest = 2;
        graph.edge[4].weight = 2;

        graph.BellmanFord(graph, 0);
    }

}
