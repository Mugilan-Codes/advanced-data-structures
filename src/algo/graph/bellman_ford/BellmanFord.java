package algo.graph.bellman_ford;

public class BellmanFord {

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
