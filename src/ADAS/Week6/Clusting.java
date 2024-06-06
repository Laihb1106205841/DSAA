package ADAS.Week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class PointS {
    double x;
    double y;
    int clusterId;
    public PointS(double x, double y, int clusterId){
        this.x = x;
        this.y = y;
        this.clusterId = clusterId;
    }
    // 计算两点之间的距离
    public double distance(PointS other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof PointS){
            PointS p = (PointS) o;
            if(p.x==x && p.y==y){
                return true;
            }
            return false;
        }
        return false;
    }
}

class EdgeS implements Comparable<EdgeS>{
    PointS p1;
    PointS p2;
    double length;
    public EdgeS(PointS p1, PointS p2){
        this.p1 = p1;
        this.p2 = p2;
        length = p1.distance(p2);
    }

    @Override
    public int compareTo(EdgeS o) {
        double d = length - o.length;
        if(d < 0){return -1;}
        if(d > 0){return 1;}
        else {return 0;}
//        return length-o.length<0 ? -1 : (length-o.length>0 ? 1 : 0);
    }
}

class Cluster{
    ArrayList<PointS> points;
    int index;
    public Cluster(PointS pointS, int index){
        points = new ArrayList<>();
        pointS.clusterId = index;
        points.add(pointS);
        this.index = index;
    }
    public boolean findPoint(PointS pointS){
        return points.contains(pointS);
    }
    public void addPoint(PointS pointS){
        points.add(pointS);
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Cluster){
            return ((Cluster) o).index == index;
        }
        return false;
    }
    public void merge(Cluster cluster){
        points.addAll(cluster.points);
        for(PointS pointS :points){
            pointS.clusterId = index;
        }
    }
}


public class Clusting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        PointS[] points = new PointS[n];

        double[][] coordinate = new double[n][2];
        for(int i=0;i<n;i++){
            coordinate[i][0] = scan.nextDouble();
            coordinate[i][1] = scan.nextDouble();
            PointS p = new PointS(coordinate[i][0],coordinate[i][1],i);
            points[i] = p;
        }
        PriorityQueue<EdgeS> edges = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(i != j){
                    EdgeS e = new EdgeS(points[i],points[j]);
                    edges.add(e);
                }
            }
        }// edges 里存放了所有的边

        HashMap<Integer,Cluster> clusters = new HashMap<>();

        for(int i=0; i<n; i++){
            Cluster cluster = new Cluster(points[i],i);
            clusters.put(i,cluster);
        }// 初始化我们的集群

        while (clusters.size() > k){
            EdgeS e = edges.poll();
            Cluster c1 = clusters.get(e.p1.clusterId);
            Cluster c2 = clusters.get(e.p2.clusterId);
            if(c1 == c2){

            }else{
                clusters.remove(c1.index);
                clusters.remove(c2.index);
                c1.merge(c2);
                clusters.put(c1.index,c1);
            }
        }
        // 现在我们已经找到了k个簇
        // 然后要找到一个跨边
        while (!edges.isEmpty()){
            EdgeS e = edges.poll();
            Cluster c1 = clusters.get(e.p1.clusterId);
            Cluster c2 = clusters.get(e.p2.clusterId);
            if(c1 != c2){
                System.out.printf("%.2f%n",e.length);
                break;
            }
        }

    }
}
