import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] check;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        check = new boolean[N+1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i=0; i < N+1 ;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i=2; i < parent.length; i++){
            System.out.println(parent[i]);
        }

    }

    public static void dfs(int idx){
        check[idx] = true;
        for(int i: list[idx]){
            if(!check[i]){
                parent[idx]=idx;
                dfs(i);
            }
        }

    }
}