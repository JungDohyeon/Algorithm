package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BackJoon1015 {
    public static class Pair{
        int index, val;
        Pair(int index, int val){
            this. index = index;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<size; i++){
            list.add(new Pair(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.val < p2.val){
                    return -1;
                } else if(p1.val > p2.val){
                    return 1;
                } else {
                    if(p1.index < p2.index){
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        int[] arr = new int[1001];
        for(int i = 0; i < size; i++){
            arr[list.get(i).index] = i;
        }

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
