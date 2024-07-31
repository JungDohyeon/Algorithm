import java.util.*;
import java.io.*;

public class Solution {
    static class DisjointSet {
        int[] parent;

        DisjointSet(int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;

            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int nx = find(x);
            int ny = find(y);

            if (nx != ny) {
                parent[ny] = nx;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            long[] X = new long[N];
            long[] Y = new long[N];

            String[] xInput = br.readLine().split(" ");
            String[] yInput = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                X[i] = Long.parseLong(xInput[i]);
                Y[i] = Long.parseLong(yInput[i]);
            }

            double E = Double.parseDouble(br.readLine());

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dx = X[i] - X[j];
                    long dy = Y[i] - Y[j];

                    double dist = Math.sqrt(dx * dx + dy * dy);
                    double weight = E * dist * dist;

                    edges.add(new Edge(i, j, weight));
                }
            }

            Collections.sort(edges);

            DisjointSet set = new DisjointSet(N);

            double ans = 0;
            int cnt = 0;

            for (Edge edge: edges) {
                if (set.find(edge.from) != set.find(edge.to)) {
                    set.union(edge.from, edge.to);
                    ans += edge.weight;

                    cnt++;

                    if (cnt == N - 1)
                        break;
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(ans)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}