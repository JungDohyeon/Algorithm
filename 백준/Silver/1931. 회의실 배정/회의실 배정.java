
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (end == o.end) {
                return start - o.start;
            }

            return end - o.end;
        }
    }

    static int N;
    static Room[] rooms;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        rooms = new Room[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(start, end);
        }

        Arrays.sort(rooms);

        int cnt = 0;
        int timer = 0;

        for (int i = 0; i< N; i++) {
            if (timer <= rooms[i].start) {
                cnt++;
                timer = rooms[i].end;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
