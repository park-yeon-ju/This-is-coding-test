import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        //2개 이상이어야 함
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();

            result += sum;

            queue.add(sum);
        }

        System.out.println(result);

    }
}
