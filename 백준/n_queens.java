package 백준;

public class n_queens {
    static boolean[] flag_col = new boolean[8];     // 각 행에 퀸 배치가 되었는지 체크
    static boolean[] flag_cross_a = new boolean[15];    // / 방향 대각 체크
    static boolean[] flag_cross_b = new boolean[15];    // \ 방향 대각 체크
    static int[] position = new int[8];
    static int count;

    // 8 Queen print
    static void printQueen() {
        count++;
        System.out.println("case : " + count);
        for(int i = 0; i<8; i++) {
            System.out.print(position[i] + " ");
        }
        System.out.println("\n");
    }

    // 배치 가능한 퀸 조합 배열 설정
    static void QueenSet(int i){
        for(int j = 0; j<8; j++) {
            // 양 대각 및 행에 같은 행에 퀸이 없다면 배치
            if(!flag_col[j] && !flag_cross_a[i+j] && !flag_cross_b[i-j+7]){
                position[i] = j;
                if(i == 7) {
                    printQueen();
                } else {
                    // i 열 j 행에 배치 -> 퀸이 이동 가능한 곳 모두 true 로 설정
                    flag_col[j] = flag_cross_a[i+j] = flag_cross_b[i-j+7] = true;
                    QueenSet(i+1);  // 다음 열 배치 (재귀 호출)
                    // 모두 배치 완료 시 false 배열로 다시 초기화 실행
                    flag_col[j] = flag_cross_a[i+j] = flag_cross_b[i-j+7] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        count = 0;
        QueenSet(0); // 0번 열부터 퀸 배치 시작
        System.out.println("8 Queen set: " + count);
    }
}
