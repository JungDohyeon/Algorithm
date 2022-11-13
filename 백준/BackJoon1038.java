package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BackJoon1038 {
    static ArrayList<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        // 10 이하인 경우 그냥 그대로 반환
        if(num <= 10){
            System.out.println(num);
        }
        // 9876543210 -> 1022번째 값이기 때문에 이보다 크다면 범위 이탈
        else if (num > 1022){
            System.out.println(-1);
        } else {
            for(int i = 0; i<10; i++){
                insertVal(i, 1);
            }
            Collections.sort(list);     // list내부 오름차순 정렬
            System.out.println(list.get(num));  // num 인덱스에 해당하는 값 반환
        }
    }

    public static void insertVal(long num, int length){
        if(length > 10){
            return;
        }
        list.add(num);
        for(int i = 0; i<num%10; i++){
            insertVal((num*10) + i, length + 1);
        }
    }
}
