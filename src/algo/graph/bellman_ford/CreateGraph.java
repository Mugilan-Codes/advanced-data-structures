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

    private void printSolution(int[] distArr, int vertices) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; ++i) {
            System.out.println(i + "\t\t" + distArr[i]);
        }
    }

}
