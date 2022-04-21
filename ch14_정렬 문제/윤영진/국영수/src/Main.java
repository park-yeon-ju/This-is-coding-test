import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Student implements Comparable<Student>{

        String name;
        int lang;
        int eng;
        int math;

        public Student(String name, int lang, int eng, int math) {
            this.name = name;
            this.lang = lang;
            this.eng = eng;
            this.math = math;
        }


        @Override
        public int compareTo(Student o) {
            if (this.lang == o.lang && this.eng == o.eng && this.math == o.math)
                return this.name.compareTo(o.name);
            if(this.lang == o.lang && this.eng == o.eng)
                return o.math - this.math;
            if(this.lang == o.lang) {
                return this.eng - o.eng;
            }
            return o.lang - this.lang;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Student tmp = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            students.add(tmp);

        }

        Collections.sort(students);
        for (Student student : students) {

            System.out.println(student.name);

        }


    }
}
