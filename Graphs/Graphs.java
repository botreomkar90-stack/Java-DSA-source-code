import java.util.*;

class Graphs{
    private int vertices;
    private List<List<int[]>> adjList; 
    private boolean isDirected;

    public Graphs(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        if (!isDirected)
            adjList.get(v).add(new int[]{u, weight});
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Node " + i + " -> ");
            for (int[] neighbor : adjList.get(i))
                System.out.print("[" + neighbor[0] + ", w=" + neighbor[1] + "] ");
            System.out.println();
        }
    }

        public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int[] neighbor : adjList.get(node)) {
                if (!visited[neighbor[0]]) {
                    visited[neighbor[0]] = true;
                    queue.add(neighbor[0]);
                }
            }
        }
        System.out.println();
    }

   
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int[] neighbor : adjList.get(node)) {
            if (!visited[neighbor[0]])
                dfsHelper(neighbor[0], visited);
        }
    }

    
    public boolean hasCycleUndirected() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            if (!visited[i] && dfsCycleUndirected(i, visited, -1))
                return true;
        return false;
    }

    private boolean dfsCycleUndirected(int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int[] neighbor : adjList.get(node)) {
            if (!visited[neighbor[0]]) {
                if (dfsCycleUndirected(neighbor[0], visited, node)) return true;
            } else if (neighbor[0] != parent) return true;
        }
        return false;
    }

    
    public void topologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                topoHelper(i, visited, stack);

        System.out.print("Topological Sort: ");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    private void topoHelper(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int[] neighbor : adjList.get(node))
            if (!visited[neighbor[0]])
                topoHelper(neighbor[0], visited, stack);
        stack.push(node);
    }

    
    public void dijkstra(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];

            if (d > dist[u]) continue; 

            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        System.out.println("Dijkstra from node " + src + ":");
        for (int i = 0; i < vertices; i++)
            System.out.println("  Node " + i + " -> dist = " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
    }
}