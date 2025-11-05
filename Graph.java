import java.util.*;
import java.util.LinkedList;

public class Graph {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // // 0 -> vertex
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // // 1 -> vertex
        // graph[1].add(new Edge(1, 3, 1));
        // graph[1].add(new Edge(1, 0, 1));

        // // 2 -> vertex
        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // // 3 -> vertex
        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        // // 4 -> vertex
        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 5, 1));
        // graph[4].add(new Edge(4, 3, 1));

        // // 5 -> vertex
        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // 6 -> vertex
        // graph[6].add(new Edge(6, 5, 1));

        // 2's neighbours
        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge e = graph[2].get(i);
        // System.out.println(e.dest);
        // }

        // // 1 --> 0,2
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));

        // // 0 --> 1,2,3
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // graph[0].add(new Edge(0, 3, 1));

        // // 2 --> 1,0
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 0, 1));

        // // 3 --> 0,4
        // graph[3].add(new Edge(3, 0, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // // 4 --> 3
        // graph[4].add(new Edge(4, 3, 1));

        // // 0 -> vertex
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // // 1 -> vertex
        // graph[1].add(new Edge(1, 3, 1));
        // graph[1].add(new Edge(1, 0, 1));

        // // 2 -> vertex
        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // // 3 -> vertex
        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        // // 4 -> vertex
        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 5, 1));
        // graph[4].add(new Edge(4, 3, 1));

        // // 5 -> vertex
        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // // 6 -> vertex
        // graph[6].add(new Edge(6, 5, 1));

        // 0 -- 1, 3
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 3, 1));

        // // 1 -- 0, 2
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));

        // // 2 -- 1, 4
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // // 3 -- 0, 4
        // graph[3].add(new Edge(3, 0, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // // 4 -- 2, 3
        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));

        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));

        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 0, 1));

        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 1, 1));

        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));

        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

        // graph[0].add(new Edge(0, 3, 1));
        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 1, 1));

        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));

        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));

        // graph[0].add(new Edge(0, 1, 10));
        // graph[0].add(new Edge(0, 2, 15));
        // graph[0].add(new Edge(0, 3, 30));

        // graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 3, 40));

        // graph[2].add(new Edge(2, 0, 15));
        // graph[2].add(new Edge(2, 3, 50));

        // graph[3].add(new Edge(3, 1, 40));
        // graph[3].add(new Edge(3, 2, 50));

        // kosaraju algo.
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

    }

    // bfs traversal
    public static void bfs(ArrayList<Edge> graph[]) { // Tc -> O(V + E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // dfs traversal TC -> O(V+E)
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visut curr ele
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    // has path exist ?
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            // here e.dest = neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    // -------------------------- connected components
    // -------------------------------------------------------------------

    // connected components bfs traversal
    public static void bfs1(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsutil(graph, vis);
            }
        }
    }

    public static void bfsutil(ArrayList<Edge> graph[], boolean vis[]) { // Tc -> O(V + E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // source = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // connected comonents dfs traversal
    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dfsutil(graph, i, vis);
        }
    }

    public static void dfsutil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visut curr ele
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfsutil(graph, e.dest, vis);
            }
        }
    }

    // -------------------Cycle Detection--------------------------------

    public static boolean cycleDetect(ArrayList<Edge> graph[]) { // TC -> O(E+V)
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleDetectUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                if (cycleDetectUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            else if (vis[e.dest] && e.dest != par) {
                return true;
            }

            // case 2 -> do nothing -> continue -> this loop autometically do continue
        }
        return false;
    }

    // bipartite graph
    public static boolean bipartiteGraph(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];

        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // bfs perform
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        // case 1:
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }

                        // case 2:
                        else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // cycle detection ---> directed graph
    public static boolean cycleDetectDirected(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleDetectDirectedUtill(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean cycleDetectDirectedUtill(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            }

            if (!vis[e.dest] && cycleDetectDirectedUtill(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    // topological sort
    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) { //
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    // topological sort with BFS
    public static void calcIndx(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;

            }
        }

    }

    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndx(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // All paths from src to dest
    public static void allPathSrcDest(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPathSrcDest(graph, e.dest, dest, path + src);
        }
    }

    // Dijkastra's Algoritham
    static class Pair implements Comparable<Pair> {
        int m;
        int path;

        public Pair(int m, int path) {
            this.m = m;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkastra(ArrayList<Edge> graph[], int src) { // TC---> O(V + ElogV)
        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.m]) {
                vis[curr.m] = true;

                // neighbours
                for (int i = 0; i < graph[curr.m].size(); i++) {
                    Edge e = graph[curr.m].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all sorces to vertices shortest path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Ballman Ford Algorithem
    public static void ballmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxation step
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Prims Algorithm
    static class Pair1 implements Comparable<Pair1> {
        int v;
        int cost;

        public Pair1(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair1 p2) {
            return this.cost - p2.cost;
        }
    }

    public static void primsAlgorithm(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair1> pq = new PriorityQueue<>();

        pq.add(new Pair1(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair1 curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair1(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final cost of MST = " + finalCost);
    }

    // chepest flight within k stops
    public static void creategraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        creategraph(flights, graph);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            // stps checking
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // relaxation step
                if (curr.cost + wt < dist[v]) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        // distanc efinding of dest
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // connect cities with minimum cost
    static class Edge1 implements Comparable<Edge1> {
        int dest;
        int cost;

        public Edge1(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge1 e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge1> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge1(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge1 curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge1(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    // kruskal's Algorithm
    static class Edge2 implements Comparable<Edge2> {
        int src;
        int dest;
        int wt;

        public Edge2(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge2 e2) {
            return this.wt - e2.wt;
        }
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalAlgo(ArrayList<Edge2> edges, int V) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) {
            Edge2 e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    // flood fill algorithm
    public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
        if (sr < 0 || sr == image.length || sc < 0 || sc == image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;

        helper(image, sr, sc - 1, color, vis, orgCol);
        helper(image, sr, sc + 1, color, vis, orgCol);
        helper(image, sr - 1, sc, color, vis, orgCol);
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    static void creategraph(ArrayList<Edge2> edges) {
        edges.add(new Edge2(0, 1, 10));
        edges.add(new Edge2(0, 2, 15));
        edges.add(new Edge2(0, 3, 30));
        edges.add(new Edge2(1, 3, 40));
        edges.add(new Edge2(2, 3, 50));
    }

    // kosaraju algo.
    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V) {
        // step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil1(graph, i, vis, s);
            }
        }

        // step 2 :- transpose
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); i++) {
                Edge e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));
            }
        }

        // step 3 :- rev dfs
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC -> ");
                dfs1(transpose, curr, vis);
                System.out.println();
            }
        }

    }

    public static void topSortUtil1(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) { //
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topSortUtil1(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs1(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visut curr ele
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    /// graph in bridge -> targan's algo.
    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;

        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs3(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void dfs3(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                dfs3(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge: " + curr + " - " + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    // articulation point
    static class Graph1 {
        private int V; // number of vertices
        private ArrayList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        Graph1(int v) {
            V = v;
            adj = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u); // undirected graph
        }

        void findArticulationPoints() {
            boolean[] visited = new boolean[V];
            int[] disc = new int[V]; // discovery time
            int[] low = new int[V]; // lowest discovery time reachable
            int[] parent = new int[V]; // parent of node in DFS
            boolean[] ap = new boolean[V]; // articulation point marker
            Arrays.fill(parent, -1);

            int time = 0; // DFS discovery time counter
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfsAP(i, visited, disc, low, parent, ap, time);
                }
            }

            System.out.println("Articulation Points:");
            for (int i = 0; i < V; i++) {
                if (ap[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        private void dfsAP(int u, boolean[] visited, int[] disc, int[] low,
                int[] parent, boolean[] ap, int time) {
            visited[u] = true;
            disc[u] = low[u] = ++time; // initialize discovery and low time
            int children = 0; // count children in DFS tree

            for (int v : adj[u]) {
                if (!visited[v]) {
                    children++;
                    parent[v] = u;
                    dfsAP(v, visited, disc, low, parent, ap, time);

                    // update low value of u
                    low[u] = Math.min(low[u], low[v]);

                    // articulation point conditions:
                    // 1. u is root and has 2+ children
                    if (parent[u] == -1 && children > 1)
                        ap[u] = true;

                    // 2. u is not root and low[v] >= disc[u]
                    if (parent[u] != -1 && low[v] >= disc[u])
                        ap[u] = true;

                } else if (v != parent[u]) {
                    // update low value (back edge case)
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // graph traversals
        // bfs(graph);
        // System.out.println();
        // dfs(graph, 0, new boolean[V]);

        // hash path exists ?
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

        // System.out.println(cycleDetect(graph));

        // System.out.println(bipartiteGraph(graph));

        // System.out.println(cycleDetectDirected(graph));

        // topSort(graph);

        // topSortBFS(graph);

        // int src = 5, dest = 1;
        // allPathSrcDest(graph, src, dest, "");

        // int src = 0;
        // dijkastra(graph, src);

        // ballmanFord(graph, 0);

        // primsAlgorithm(graph);

        // int n = 4;
        // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600
        // }, { 2, 3, 200 } };
        // int src = 0, dst = 3, k = 1;
        // System.out.println(cheapestFlight(n, flights, src, dst, k));

        // int cities[][] = {
        // { 0, 1, 2, 3, 4 },
        // { 1, 0, 5, 0, 7 },
        // { 2, 5, 0, 6, 0 },
        // { 3, 0, 6, 0, 0 },
        // { 4, 7, 0, 0, 0 }
        // };
        // System.out.println(connectCities(cities));

        // krushkal algo.
        // int V = 4;
        // ArrayList<Edge2> edges = new ArrayList<>();
        // creategraph(edges);
        // kruskalAlgo(edges, V);

        // kosarajuAlgo(graph, V);

        // tarjanBridge(graph, V);

        // arculation point
        Graph1 g = new Graph1(5);

        // Example graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.findArticulationPoints();
    }
}
