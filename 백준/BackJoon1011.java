package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        StringTokenizer st = new StringTokenizer(t, " ");
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());
        for(int i = 0; i<testCase; i++){
            String path = br.readLine();
            st = new StringTokenizer(path, " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int distance = dest - start;
            int sqrtDist = (int)Math.sqrt(distance);
            if(distance == sqrtDist * sqrtDist){
                sb.append(2*sqrtDist - 1).append("\n") ;
            } else if (distance <= sqrtDist*sqrtDist + sqrtDist ){
                sb.append(2*sqrtDist).append("\n") ;
            } else {
                sb.append(2*sqrtDist + 1).append("\n") ;
            }
        }
        System.out.println(sb);
    }
}
