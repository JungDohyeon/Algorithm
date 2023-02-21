package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14891 {
    static LinkedList[] rotate;
    static int sum;

    static boolean first = true;
    static boolean second = true;
    static boolean third = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init linkedlist
        rotate = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            rotate[i] = new LinkedList<Integer>();
        }

        sum = 0;

        // 톱니바퀴 입력
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++)
                rotate[i].add(str.charAt(j) - '0');
        }

        // 톱니, 방향 입력
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            rotate(n-1, dir);
        }

        getSum();
        System.out.println(sum);
    }

    // n - 회전 바퀴 번째, rot - 방향
    public static void rotate(int n, int rot) {
        checkRot(); // 톱니 바퀴 겹치는 구간 체크

        switch (n) {
            case 0:
                if (rot == 1) {
                    rotate[0].addFirst(rotate[0].pollLast());
                    if (first) {
                        rotate[1].addLast(rotate[1].pollFirst());
                        if (second) {
                            rotate[2].addFirst(rotate[2].pollLast());
                            if (third) {
                                rotate[3].addLast(rotate[3].pollFirst());
                            }
                        }
                    }
                } else {
                    rotate[0].addLast(rotate[0].pollFirst());
                    if (first) {
                        rotate[1].addFirst(rotate[1].pollLast());
                        if (second) {
                            rotate[2].addLast(rotate[2].pollFirst());
                            if (third) {
                                rotate[3].addFirst(rotate[3].pollLast());
                            }
                        }
                    }
                }
                break;
            case 1:
                if (rot == 1) {
                    rotate[1].addFirst(rotate[1].pollLast());
                    if (first) {
                        rotate[0].addLast(rotate[0].pollFirst());
                    }

                    if (second) {
                        rotate[2].addLast(rotate[2].pollFirst());
                        if (third) {
                            rotate[3].addFirst(rotate[3].pollLast());
                        }
                    }
                } else {
                    rotate[1].addLast(rotate[1].pollFirst());
                    if (first) {
                        rotate[0].addFirst(rotate[0].pollLast());
                    }

                    if (second) {
                        rotate[2].addFirst(rotate[2].pollLast());
                        if (third) {
                            rotate[3].addLast(rotate[3].pollFirst());
                        }
                    }
                }
                break;
            case 2:
                if (rot == 1) {
                    rotate[2].addFirst(rotate[2].pollLast());
                    if (third) {
                        rotate[3].addLast(rotate[3].pollFirst());
                    }

                    if (second) {
                        rotate[1].addLast(rotate[1].pollFirst());
                        if (first) {
                            rotate[0].addFirst(rotate[0].pollLast());
                        }
                    }
                } else {
                    rotate[2].addLast(rotate[2].pollFirst());
                    if (third) {
                        rotate[3].addFirst(rotate[3].pollLast());
                    }

                    if (second) {
                        rotate[1].addFirst(rotate[1].pollLast());
                        if (first) {
                            rotate[0].addLast(rotate[0].pollFirst());
                        }
                    }
                }
                break;
            default:
                if (rot == 1) {
                    rotate[3].addFirst(rotate[3].pollLast());
                    if (third) {
                        rotate[2].addLast(rotate[2].pollFirst());
                        if (second) {
                            rotate[1].addFirst(rotate[1].pollLast());
                            if (first) {
                                rotate[0].addLast(rotate[0].pollFirst());
                            }
                        }
                    }
                } else {
                    rotate[3].addLast(rotate[3].pollFirst());
                    if (third) {
                        rotate[2].addFirst(rotate[2].pollLast());
                        if (second) {
                            rotate[1].addLast(rotate[1].pollFirst());
                            if (first) {
                                rotate[0].addFirst(rotate[0].pollLast());
                            }
                        }
                    }
                }
                break;
        }

        first = true;
        second = true;
        third = true;
    }

    // 극이 겹치는지 안겹치는지 확인
    public static void checkRot() {
        if (rotate[0].get(2).equals(rotate[1].get(6)))
            first = false;
        if (rotate[1].get(2).equals(rotate[2].get(6)))
            second = false;
        if (rotate[2].get(2).equals(rotate[3].get(6)))
            third = false;
    }

    // 12시 방향 S/N 판단 후 더하기
    public static void getSum() {
        for (int i = 0; i < 4; i++) {
            if (rotate[i].get(0).equals(1)) {
                sum += (int)Math.pow(2, i);
            }
        }
    }
}
