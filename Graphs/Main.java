public class Main {
    public static void main(String[] args) {

        
        Graphs g = new Graphs(5, false);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 4, 1);

        g.printGraph();
        g.bfs(0);
        g.dfs(0);
        System.out.println("Has Cycle? " + g.hasCycleUndirected());

        System.out.println();

        
        Graphs dg = new Graphs(5, true);
        dg.addEdge(0, 1, 10);
        dg.addEdge(0, 2, 3);
        dg.addEdge(2, 1, 4);
        dg.addEdge(1, 3, 2);
        dg.addEdge(2, 3, 8);
        dg.addEdge(3, 4, 5);

        dg.dijkstra(0);

        System.out.println();

        
        Graphs dag = new Graphs(6, true);
        dag.addEdge(5, 2, 1);
        dag.addEdge(5, 0, 1);
        dag.addEdge(4, 0, 1);
        dag.addEdge(4, 1, 1);
        dag.addEdge(2, 3, 1);
        dag.addEdge(3, 1, 1);

        dag.topologicalSort();
    }
}
