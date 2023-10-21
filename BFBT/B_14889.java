// DFS, 백트래킹, 브루트포스, 비트마스킹
// N값 입력 => 팀 나누기 => 능력치 더하기 => 최소값 구하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] player;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        player = new int[N][N];
        check = new boolean[N];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0 ; str.hasMoreTokens();j++) {
                player[i][j]= Integer.parseInt(str.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);


    }

    // dfs로 팀 나누기
    public static void dfs(int idx, int a) {

        if(idx == N/2) {
            score();
            return;
        }

        for(int i = a ; i < N ; i++) {
            check[i]=true;
            dfs(idx+1, i+1);
            check[i]=false;
        }
    }

    // start팀, link팀 나눠서 능력치 더하기
    public static void score() {
        int start = 0;
        int link = 0;
        for(int i = 0 ; i < N-1 ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                if(check[i]==true && check[j]==true) {
                    start += player[i][j];
                    start += player[j][i];
                }
                else if(check[i]==false && check[j]==false) {
                    link += player[i][j];
                    link += player[j][i];
                }

            }
        }

        int ans = Math.abs(start - link);

        if(ans == 0) {
            System.out.println(ans);
            System.exit(0);
        }

        min=Math.min(min,ans);
    }


}
