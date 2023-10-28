import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, ans;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(br.readLine());
//      순열 만들기
        for(int i=0; i<T; i++){
            N = Integer.parseInt(st.nextToken());
            ans = 0;
            for(int j=1; j < N+1; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int k=1; k < N; k++){
                if(!check[k]){
                    check[k] = true;
                    int cycle = arr[k];
                    while(true){
                        if(check[cycle]) {
                            ans++;
                            break;
                        }
                        check[cycle] = true;
                        cycle = arr[cycle];

                    }

                }

            }
            System.out.println(ans);
        }

    }

}
