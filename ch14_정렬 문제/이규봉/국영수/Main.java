import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            studentList.add(new Student(name, kor, eng, math));
        }

        studentList.stream().sorted().forEach(o -> System.out.println(o.name));

        in.close();
    }

    static class Student implements Comparable<Student> {
        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

       //1. 국어 점수가 감소하는 순서로
       //2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
       //3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
       //4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
        @Override
        public int compareTo(Student o) {
            if (this.kor != o.kor) {
                return o.kor - this.kor;
            } else {
                if (this.eng != o.eng) {
                    return this.eng - o.eng;
                } else {
                    if (this.math != o.math) {
                        return o.math - this.math;
                    } else {
                        return this.name.compareTo(o.name);
                    }
                }
            }
        }
    }
}
