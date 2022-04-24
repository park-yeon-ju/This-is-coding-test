import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> houseList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            houseList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(houseList);

        //인덱스가 0부터 시작하므로 n-1
        System.out.println(houseList.get((n - 1) / 2));

        br.close();
    }

}
