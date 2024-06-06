package ADAS.Week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QB {

    // 城市
    static class City implements Comparable<City>{
        int cost;
        int index;
        int isRoot;
        ArrayList<Integer> priority;

        public City (int cost, int index) {
            this.cost = cost;
            this.index = index;// is City or not
            this.isRoot = 0;
            priority = new ArrayList<>();
        }
        public City (int cost, int index, int isRoot) {
            this.cost = cost;
            this.index = index;// is City or not
            this.isRoot = isRoot;
            priority = new ArrayList<>();
        }
        public void AddPriority(int CityIndex){
            priority.add(CityIndex);
        }

        @Override
        public int compareTo(City o) {
            if(o.isRoot == 1){return -1;}
            if(isRoot == 1){return 1;}
            if(priority.contains(o.index)){// 你在我后面
                return 1;
            }
            if(o.priority.contains(index)){
                return -1;
            }
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int node1 = scanner.nextInt();

        int[] costs = new int[n];

        for(int i=0;i<n;i++){
            costs[i] = scanner.nextInt();
        }
        ArrayList<City> acn = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(i == node1-1){
                acn.add(new City(costs[i], i,1));
            }
            else {
                acn.add(new City(costs[i], i));
            }

        }

        for(int i=0;i<n-1;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            acn.get(x-1).AddPriority(y-1);
        }

        Collections.sort(acn);
//        PriorityQueue<City> pq = new PriorityQueue<>(acn);

        int time =n;
        int cost =0;
        for (City city: acn){
//            city
            cost += time * city.cost;
//            System.out.println(city.index + 1 + " " + city.cost + " "+time);
            time--;
        }
        System.out.println(cost);
    }
}
