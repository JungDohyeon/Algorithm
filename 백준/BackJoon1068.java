package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BackJoon1068 {
    static ArrayList<Integer>[] arrlist;
    static int rootNode;
    static int delNode;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arrlist = new ArrayList[n];
        for(int i = 0; i<arrlist.length; i++){
            arrlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == -1){
                rootNode = i;
            } else {
                arrlist[num].add(i);    // 부모노드 배열에 자식 노드 추가
            }
        }

        delNode = Integer.parseInt(br.readLine());

        if(delNode == rootNode){
            ans = 0;
        } else {
            DFS(rootNode);
        }
        System.out.println(ans);
    }

    public static void DFS(int a){
        if(a == delNode){
            return;
        }

        if(arrlist[a].size() == 0){
            ans++;
            return;
        } else if(arrlist[a].size() ==1) {  //  !! 자식이 1개 있지만 그 자식이 지워진 노드일 경우!!
            if(arrlist[a].get(0) == delNode){
                ans++;
                return;
            } else {
                DFS(arrlist[a].get(0));
            }
        } else {
            for(int i = 0; i<arrlist[a].size(); i++){
                DFS(arrlist[a].get(i));
            }
        }
    }
}