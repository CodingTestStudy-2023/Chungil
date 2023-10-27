// BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] check;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {

            String s = br.readLine();

            for(int j=0; j<M; j++) {

                map[i][j] = s.charAt(j) - '0';

            }
        }

        check = new boolean[N][M];
        check[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y){
//      BFS에 사용할 큐를 생성
        Queue<int[]> q = new LinkedList<>();
//      큐에 BFS 노드 번호 입력
        q.add(new int[] {x,y});

//      큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

//          큐에서 꺼낸 노드와 연결된 노드들 체크
            for(int i=0; i< 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (check[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                check[nextX][nextY] = true;
            }
        }

    }
}
