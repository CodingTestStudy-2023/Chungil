import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Max(arr, n, m);
        System.out.println(ans);
    }

//  브루트 포스

    static int Max(int[] arr, int n, int m){
        int ans = 0;

        for (int i = 0; i < n -2; i++){

            for (int j = i+1; j < n-1; j++) {

                for (int k = j+1; k < n; k++){
                    int a = arr[i] + arr[j] + arr[k];

                    if ( m == a) {
                        return a;
                    }

                    if (ans < a && a < m) {
                        ans = a;
                    }
                }
            }
        }

        return ans;
    }
}
