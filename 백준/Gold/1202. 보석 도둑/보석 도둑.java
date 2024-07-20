
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Item implements Comparable<Item> {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            if(this.weight == o.weight)
                return o.value - this.value;

            return this.weight - o.weight;
        }
    }

    static int N, K;
    static Item[] items;
    static int[] bags;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new Item[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            items[i] = new Item(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(items);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;

        for (int i = 0, j = 0; i < K; i++) {
            while(j < N) {
                if (bags[i] < items[j].weight)
                    break;

                pq.add(items[j++].value);
            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}