import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_13305 {
    static int n;
    static long ans, min;
    static long[] dst, prc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//      도시의 수
        n = Integer.parseInt(br.readLine());

        dst = new long[n-1];
        prc = new long[n];

//      도시간 거리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i < n-1; i++){

            dst[i] = Long.parseLong(st.nextToken());
        }

//      주유소 금액
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i < n; i++){
            prc[i] = Long.parseLong(st.nextToken());
        }

        ans = 0;
        min = prc[0];

        for(int i=0; i < n - 1; i++){

            if(prc[i] < min){
                min = prc[i];
            }

            ans += (min * dst[i]);
        }

        System.out.println(ans);
    }

}
