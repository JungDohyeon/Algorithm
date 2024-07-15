import java.io.*;
import java.util.*;

public class Main {

    static String ans = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String init ="";
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                int num = Integer.parseInt(st.nextToken());
                init += num;
            }
        }

        map.put(init, 0);
        System.out.println(bfs(init));
    }

    static int bfs(String init) {

        Queue<String> q = new LinkedList<>();
        q.add(init);
        while(!q.isEmpty()) {
            String cur = q.poll();
            
            int cnt = map.get(cur);
            int empty = cur.indexOf('0');
            
            int px = empty % 3;
            int py = empty / 3;

            if(cur.equals(ans)) {
                return cnt;
            }

            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) 
                    continue;

                int nPos = ny * 3 + nx;
                char tmp = cur.charAt(nPos);
                String next = cur.replace(tmp, 'c');
                next = next.replace('0', tmp);
                next = next.replace('c', '0');

                if(!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, cnt + 1);
                }
            }
        }
        
        return -1;
    }
}