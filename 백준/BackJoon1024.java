package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1024 {
    static long X, Y, Z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        X=Long.parseLong(st.nextToken());
        Y=Long.parseLong(st.nextToken());
        Z=100*Y/X;

        if(Z>=99) {
            System.out.println(-1);
        }else {
            // BinarySearch 활용
            long low=0;
            long high=1000000000;
            long mid=0;
            while(low<=high) {
                mid=(low+high)/2;
                if(Z<100*(Y+mid)/(X+mid)){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }
            System.out.println(low);
        }
    }
}