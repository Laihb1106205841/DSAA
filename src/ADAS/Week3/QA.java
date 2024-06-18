package ADAS.Week3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QA {

static class Job {
    int ddl;
    int punishment;

    public Job(int ddl, int punishment) {
        this.punishment = punishment;
        this.ddl = ddl;
    }
}

    static class DdlComparator implements Comparator<Job> {
        @Override
        public int compare(Job job1, Job job2) {
            return Integer.compare(job1.ddl, job2.ddl);
        }
    }

    static class PunishmentComparator implements Comparator<Job> {
        @Override
        public int compare(Job job1, Job job2) {
            return Integer.compare(job1.punishment, job2.punishment);
        }
    }

    public static int calculateMinimumPunishment( int N, int[] deadlines, int[] punishments) {
        int punishment = 0;
        PriorityQueue<Job> jobs = new PriorityQueue<>(new DdlComparator()); // ddl engine
        PriorityQueue<Job> job_finishes = new PriorityQueue<>(new PunishmentComparator()); // punishment engine

        for(int i=0;i<N;i++){
            Job job = new Job(deadlines[i], punishments[i]);
            jobs.add(job);
        }

        int day = 0;

        for(int i =0;i < N;i++){
            Job J = jobs.remove();

            // ddl ok
            if(J.ddl > day){
                // done, so add another queue
                job_finishes.add(new Job(J.ddl,J.punishment));
                day++;
            }
            // ddl has conflict, you can't finish on time, we sacrifice
            else {

                Job previous_job = job_finishes.remove();

                if(previous_job.punishment < J.punishment){
                    // then I will do J rather than previous
                    job_finishes.add(new Job(J.ddl,J.punishment));
                    // 我们还会见面吗？
                    punishment += previous_job.punishment;

                }else {
                    // do previous rather than J
                    job_finishes.add(previous_job);
                    punishment += J.punishment;
                }
            }
        }

        return punishment;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] deadlines = new int[N];
        int[] punishments = new int[N];

        for(int i=0;i<N;i++){
            deadlines[i] = scan.nextInt();
        }
        for(int i=0; i<N; i++){
            punishments[i] = scan.nextInt();
        }
        int money = calculateMinimumPunishment(N,deadlines,punishments);
        System.out.println(money);
    }
}
