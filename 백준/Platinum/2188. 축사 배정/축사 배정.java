import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 이분매칭 P4
public class Main {
    static int N, M;
    static int[] shed;
    static int[][] shedPointer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        shed = new int[M];
        shedPointer = new int[N][];
        visited = new boolean[M];

        for (int i = 0; i < M; i++) {
            shed[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shedPointer[i] = new int[Integer.parseInt(st.nextToken())];

            for (int j = 0; j < shedPointer[i].length; j++) {
                shedPointer[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
        
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            visited = new boolean[M];
            if (setCowShed(i)) {
                count++;
            }
        }
        
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
    
    private static boolean setCowShed(int cowNum) {
        for (int i = 0; i < shedPointer[cowNum].length; i++) {
            int shedIdx = shedPointer[cowNum][i];
            
            if (visited[shedIdx]) {
                continue;
            }
            
            visited[shedIdx] = true;

            if (shed[shedIdx] == -1 || setCowShed(shed[shedIdx])) {
                shed[shedIdx] = cowNum;
                return true;
            }
        }
        
        return false;
    }
}
