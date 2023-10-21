// 1, 2, 3으로 구성된 N자리수 수열 만들기
// 가장 작은 숫자 구하기
// 좋은 수열 구분하기(N자리수, N/2 자리수까지 비교할 것)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static String[] list = {"1", "2", "3"};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, "");
    }

//
    public static void dfs(int idx, String a) {
        if(idx == N){
            System.out.println(a);
            System.exit(0);
        }
        for (int i = 0; i <= 2; i++) {
            if (validation(a+list[i])) {
                dfs(idx + 1, a + list[i]);
            }
        }
    }

//  좋은 수열인지 판별하는 함수
    public static boolean validation(String st) {
        int length = st.length() / 2;
        for (int i=1; i <= length; i++){
            if (st.substring(st.length() - i).equals(st.substring(st.length() - 2 * i, st.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
