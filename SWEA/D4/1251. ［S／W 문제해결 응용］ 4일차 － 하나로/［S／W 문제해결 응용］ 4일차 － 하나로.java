import java.util.*;
import java.io.*;

public class Solution {
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

    public static int N;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N];

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
                    long nx = X[i] - X[j];
                    long ny = Y[i] - Y[j];

                    double dist = Math.sqrt(nx * nx + ny * ny);
                    double weight = E * dist * dist;

                    edges.add(new Edge(i, j, weight));
                }
            }

            Collections.sort(edges);
            make();

            double ans = 0;
            int cnt = 0;

            for (Edge edge: edges) {
                if (find(edge.from) != find(edge.to)) {
                    union(edge.from, edge.to);
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

    private static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }


    private static int find(int x) {
        if (parents[x] == x)
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx != ny) {
            parents[ny] = nx;
        }
    }
}