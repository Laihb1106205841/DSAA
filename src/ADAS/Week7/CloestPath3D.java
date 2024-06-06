package ADAS.Week7;

import java.util.Scanner;

class Point{
    int x;
    int y;
    int z;
    Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow(this.x-p.x, 2) + Math.pow(this.y-p.y, 2) + Math.pow(this.z-p.z, 2));
    }
}

class Edge implements Comparable<Edge>{
    Point p1;
    Point p2;
    double distance;
    public Edge(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        this.distance = p1.distance(p2);
    }

    @Override
    public int compareTo(Edge o) {
        double d = distance - o.distance;
        if(d < 0){return -1;}
        if(d > 0){return 1;}
        else {return 0;}
//        return length-o.length<0 ? -1 : (length-o.length>0 ? 1 : 0);
    }
}

public class CloestPath3D {
    public static float invSqrt(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f37642f - (i >> 1);
        x = Float.intBitsToFloat(i);
        x = x * (1.5f - xhalf * x * x);
        return 1 / x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] coordinate = new int[N][3];

        int X_Max = 0;
        int Y_Max = 0;
        int Z_Max = 0;
        for(int i=0; i<N; i++){
            // x y z
            coordinate[i][0] = scan.nextInt();
            coordinate[i][1] = scan.nextInt();
            coordinate[i][2] = scan.nextInt();

            if(coordinate[i][0] > X_Max){X_Max = coordinate[i][0];}
            if(coordinate[i][1] > Y_Max){Y_Max = coordinate[i][1];}
            if(coordinate[i][2] > Z_Max){Z_Max = coordinate[i][2];}

        }

        X_Max = X_Max / 4;
        Y_Max = Y_Max / 4;
        Z_Max = Z_Max / 4;

        double fmax = Double.MAX_VALUE;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(i != j){
                    if(coordinate[i][0]-coordinate[j][0] < X_Max && coordinate[i][1]-coordinate[j][1] < Y_Max && coordinate[i][2]-coordinate[j][2] < Z_Max){
//                        Edge e = new Edge(points[i],points[j]);
                        double distance = Math.sqrt(Math.pow(coordinate[i][0]-coordinate[j][0],2) + Math.pow(coordinate[i][1]-coordinate[j][1],2) + Math.pow(coordinate[i][2]-coordinate[j][2],2));
                        if(distance < fmax){
                            fmax = distance;
                        }
                    }
                }
            }
        }// edges 里存放了所有的边

        System.out.printf("%.2f%n",fmax);

    }
}
