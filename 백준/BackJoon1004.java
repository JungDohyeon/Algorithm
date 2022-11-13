package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1004 {
    static int startX, startY, destX, destY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a, " ");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++) {
            int ans = 0;
            String path = br.readLine();
            st = new StringTokenizer(path, " ");
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            String counter = br.readLine();
            st = new StringTokenizer(counter, " ");
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                String size = br.readLine();
                st = new StringTokenizer(size, " ");
                int circleX = Integer.parseInt(st.nextToken());
                int circleY = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());
                if (checkStart(circleX, circleY, radius) != checkDest(circleX, circleY, radius)) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static boolean checkStart(int x, int y, int r){
        boolean check = false;
        if(Math.pow(x-startX,2) + Math.pow(y-startY,2) < Math.pow(r,2)){
            check = true;
        }
        return check;
    }

    static boolean checkDest(int x, int y, int r){
        boolean check = false;
        if(Math.pow(x-destX,2) + Math.pow(y-destY,2) < Math.pow(r,2)){
            check = true;
        }
        return check;
    }
}
