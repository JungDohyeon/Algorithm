import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] truthPeople;
    static int[] parentNode;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());

        if (truthNum == 0) {
            System.out.println(M);
        } else {
            truthPeople = new int[truthNum];

            for (int i = 0; i < truthNum; i++) {
                truthPeople[i] = Integer.parseInt(st.nextToken());
            }

            parentNode = new int[N + 1];
            party = new ArrayList[M];
            for (int i = 0; i < M; i++) {
                party[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine());

                int partyAttendee = Integer.parseInt(st.nextToken());
                for(int j = 0; j < partyAttendee; j++) {
                    party[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            for (int i = 0; i <= N; i++) {
                parentNode[i] = i;
            }

            for (int i = 0; i < M; i++) {
                int partyFirst = party[i].get(0);

                for (int j = 1; j < party[i].size(); j++) {
                    union(partyFirst, party[i].get(j));
                }
            }

            int answer = 0;
            for (int i = 0; i < M; i++) {
                int firstMan = party[i].get(0);
                boolean flag = true;
                
                for (int j = 0; j < truthNum; j++) {
                    if (find(firstMan) == find(truthPeople[j])) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    private static void union(int a, int b) {
        int setA = find(a);
        int setB = find(b);

        if (setA != setB) {
            parentNode[setB] = setA;
        }
    }

    private static int find(int n) {
        if (parentNode[n] == n) {
            return n;
        } else {
            return find(parentNode[n]);
        }
    }
}
