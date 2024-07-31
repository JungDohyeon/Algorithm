
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {

    static int T, N, M, ans;
    static HashSet<String> set;
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            set = new HashSet<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(st.nextToken());
            }

            ans = 0;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if(set.contains(st.nextToken()))
                    ans++;
            }
            
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}