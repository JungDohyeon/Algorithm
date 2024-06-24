import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final class SwapNumber {
        int num;
        int cnt;

        public SwapNumber(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static boolean[][] visited;
    static int N, K;
    static int result = -1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[1000001][K + 1];
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<SwapNumber> q = new LinkedList<>();
        q.add(new SwapNumber(N, 0));
        visited[N][0] = true;
        
        while(!q.isEmpty()) {
            SwapNumber tmp = q.poll();
            
            // 최댓값 갱신
            if (tmp.cnt == K) {
                result = Math.max(result, tmp.num);
                continue;
            }
            
            int numLen = String.valueOf(tmp.num).length();
            
            for(int i = 0; i < numLen - 1; i++) {
                for (int j = i + 1; j < numLen; j++) {
                    int nextNum = swap(tmp.num, i, j);
                    
                    if (nextNum != -1 && !visited[nextNum][tmp.cnt + 1]) {
                        q.add(new SwapNumber(nextNum, tmp.cnt + 1));
                        visited[nextNum][tmp.cnt + 1] = true;
                    }
                }
            }
        }
    }

    private static int swap(int num, int i, int j) {
        char[] arr = String.valueOf(num).toCharArray();

        if (i == 0 && arr[j] == '0') {
            return -1;  // 맨 앞자리가 0이면 불가
        } else {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            return Integer.parseInt(new String(arr));
        }
    }
}

