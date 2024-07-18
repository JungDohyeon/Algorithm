
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[][] map;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        flag = false;
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();

            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(map[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == 81) {
            flag = true;
            return;
        }

        int x = depth / 9;
        int y = depth % 9;

        if (map[x][y] != 0) {
            dfs(depth + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if(!check(x, y, i))
                    continue;

                map[x][y] = i;
                dfs(depth + 1);
                if (flag)
                    return;
                map[x][y] = 0;
            }
        }
    }

    private static boolean check(int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == n || map[i][y] == n)
                return false;
        }

        int nx = x / 3 * 3;
        int ny = y / 3 * 3;

        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if(map[i][j] == n)
                    return false;
            }
        }

        return true;
    }
}