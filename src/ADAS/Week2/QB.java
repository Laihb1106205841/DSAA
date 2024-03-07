package ADAS.Week2;

import java.util.*;

public class QB {
    static class Student implements Comparable<Student>{
        int index;
        int score;
        public Student(int index,int score){
            this.index=index;
            this.score=score;
        }
        @Override
        public int compareTo(Student o) {
            return o.score-score;// 如果o的分数大，将我自己排出来
        }
    }

    static class School implements Comparable<School>{
        int index;
        int score;
        public School(int index,int score){
            this.index=index;
            this.score=score;
        }
        @Override
        public int compareTo(School o){
            return score-o.score;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N_Student = scan.nextInt();
        int M_School = scan.nextInt();

        int[] Cap = new int[M_School];
        for(int i=0;i<M_School;i++){
            Cap[i] = scan.nextInt();
        }

        PriorityQueue<School>[] Student_evaluation_for_sch = new PriorityQueue[N_Student];
        for(int i=0;i<N_Student;i++){
            for(int j=0;j<M_School;j++){
                int score = scan.nextInt();
                if(score>0){
                    Student_evaluation_for_sch[i].add(new School(j,score));
                }
            }
        }

        // the student that university like
        PriorityQueue<Student>[] School_evaluation_for_stu = new PriorityQueue[M_School];
        for(int i=0;i<M_School;i++){
            for(int j=0;j<N_Student;j++){
                int score = scan.nextInt();
                if(score>0){
                    School_evaluation_for_stu[i].add(new Student(j,score));
                }
            }
        }

        // input success tested on 19:11

        // for free student
        ArrayList<Integer> free_Student = new ArrayList<>();
        for(int i=0;i<N_Student;i++){
            free_Student.add(i+1);
        }



    }
}
