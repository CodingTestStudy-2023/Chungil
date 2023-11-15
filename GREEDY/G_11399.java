import java.io.IOException;
import java.util.*;

public class G_11399 {
//    static int N;
//    static int[] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        arr = new int[N];
//        int sum = 0;
//        int ans = 0;
//        for(int i=0; i < N; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//
//        for(int j=0; j< arr.length; j++){
//            sum += arr[j];
//            ans += sum;
//        }
//
////        System.out.println(Arrays.toString(arr));
//        System.out.println(ans);
//    }

    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int ans = 0;
        for(int i=0; i < N; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        for(int j=0; j< N; j++){
            sum += list.get(j);
            ans += sum;
        }

//        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }
}
