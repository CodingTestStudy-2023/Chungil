import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

//      순열 만들기
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            ans = 0;
            int arr[] = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j < arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            boolean check[] = new boolean[N+1];
            for(int k=1; k <= N; k++){
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
