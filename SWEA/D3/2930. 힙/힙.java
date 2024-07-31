
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution
{
    static PriorityQueue<Integer> pq;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb.append("#").append(tc).append(" ");
            pq = new PriorityQueue<>(Comparator.reverseOrder());

            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int op = Integer.parseInt(st.nextToken());

                switch(op) {
                    case 1:
                        int n = Integer.parseInt(st.nextToken());
                        pq.add(n);
                        break;

                    case 2:
                        if(pq.isEmpty())
                            sb.append(-1);
                        else
                            sb.append(pq.poll());
                        sb.append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
