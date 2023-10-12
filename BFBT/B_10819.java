import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;

public class Main {
    static Boolean[] check = new Boolean[8];
    static int[] arr = new int[8];
    static int[] a=new int[8];
    static int n, ans;

    static void dfs(int idx) {
        if (idx >= n) {
            int tans=0;
            for(int i=1;i<n;i++){
                tans += Math.abs(a[arr[i]]-a[arr[i-1]]);
            }
            ans=Math.max(ans,tans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                arr[idx]=i;
                dfs(idx + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = 0;
        for (int i = 0; i < n; i++) {
            check[i] = false;
            arr[i] = 0;
        }
        String[] inputs=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(inputs[i]);
        }
        dfs(0);
        bw.write(ans + "");
        br.close();
        bw.flush();
        bw.close();

    }


}
