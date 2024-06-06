package ADAS.Week4;



import java.util.*;

public class GridBalancer {

    static class Node implements Comparable<Node> {
        char[][] grid;
        int F_Score;
        int G_Score;
        int col_BLOCK;
        int row_BLOCK;

        public Node(char[][] grid,int f_Score,int g_Score,int col_BLOCK,int row_BLOCK){
            this.grid = grid;
            this.F_Score = f_Score;
            this.G_Score = g_Score;
            this.col_BLOCK = col_BLOCK;
            this.row_BLOCK = row_BLOCK;

        }

        @Override
        public int compareTo(Node o){
            if(o.F_Score > this.F_Score){
                return 1;
            }
            if(o.F_Score == this.F_Score){
                return 0;
            }
            else {
                return -1;
            }
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof Node){
                char[][] a = ((Node) o).grid;
                boolean m = true;
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        if(this.grid[i][j] != a[i][j]){
                            m = false;
                            break;
                        }
                    }
                }
            }
            return false;
        }
    }

    static class GridForBalance {
        int col_BLOCK;
        int row_BLOCK;
//        char[][] grid;
        int current_time;

        public GridForBalance(char[][] grid, int col_BLOCK, int row_BLOCK){
            this.col_BLOCK = col_BLOCK;
            this.row_BLOCK = row_BLOCK;
//            this.grid = grid;
            current_time = 0;
        }

        public int gridBalancer(char[][] gggg){

            ArrayList<Node> Move_Visited = new ArrayList<>();
            PriorityQueue<Node> Frontier = new PriorityQueue<>();

            Frontier.add(new Node(gggg,0,0,col_BLOCK,row_BLOCK));

            while (!Frontier.isEmpty()){
                Node current = Frontier.poll();

                Move_Visited.add(current);

                if(current.G_Score < 10){
                    // found
                    if(Difference(current) == 0){return current.G_Score;}

                    System.out.println("current: " + current.G_Score);
                    System.out.println("Difference: "+Difference(current));
                    print(current.grid);

                    ArrayList<Integer[]> TryToMove = MoveAblePosition(current); // neighbors

                    for(Integer[] i: TryToMove){
                        int current_col = current.col_BLOCK;
                        int current_row = current.row_BLOCK;

                        Move(current,i[0],i[1]);

                        if(Move_Visited.contains(current)){
                            Move(current,current_col,current_row); // rowing back
                        }
                        else { // neighbor is not visited

                            int new_g_score = current.G_Score + 1;

                            if(Move_Visited.contains(current)){

                            }

//                            if(new_g_score < current.G_Score){
                                current.G_Score = new_g_score;
                                int h_Score = Difference(current);
                                int f_Score = h_Score;
//                                    + h_Score;
                                Frontier.add(new Node(current.grid,f_Score,current.G_Score,current_col,current_row));
//                            }

//                            Move(current,current_col,current_row); // rowing back


//                        Move_Visited.put(grid,time);
                        }
                    }
                }

                current_time++;
            }
            return -1;
        }

        public void print(char[][] grid){
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public ArrayList<Integer[]> MoveAblePosition(Node current){
            ArrayList<Integer[]> a = new ArrayList<>();
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if((Math.abs(current.col_BLOCK-i) == 2 && Math.abs(current.row_BLOCK-j) == 1)
                            || (Math.abs(current.col_BLOCK-i) == 1 && Math.abs(current.row_BLOCK-j) == 2)){
                        a.add(new Integer[]{i,j});
                    }
                }
            }
            return a;
        }

        public static void Move(Node current, int col,int row){
            //swap
            char temp = current.grid[current.col_BLOCK][current.row_BLOCK];
            current.grid[current.col_BLOCK][current.row_BLOCK] = current.grid[col][row];
            current.grid[col][row] = temp;
            current.col_BLOCK = col;
            current.row_BLOCK = row;
        }

        public static int Difference(Node current){
            int difference = 0;
            for(int i=0;i<5;i++){
                if(current.grid[0][i] != '1'){
                    difference+=1;
                }
            }
            if(current.grid[1][0] != '0'){
                difference += 1;
            }
            for(int i=0;i<4;i++){
                if(current.grid[1][i+1] != '1'){
                    difference +=1;
                }
            }
            if(current.grid[2][0] != '0'){difference +=1;}
            if(current.grid[2][1] != '0'){difference +=1;}
            if(current.grid[2][2] != '*'){difference +=1;}
            if(current.grid[2][3] != '1'){difference +=1;}
            if(current.grid[2][4] != '1'){difference +=1;}

            for(int i=0;i<4;i++){
                if(current.grid[3][i] != '0'){
                    difference +=1;
                }
            }
            if(current.grid[3][4] != '1'){difference +=1;}

            for(int i=0;i<5;i++){
                if(current.grid[4][i] != '0'){
                    difference+=1;
                }
            }
            return difference;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i=0;i<T;i++){

            char[][] Grid = new char[5][5];
            int col_BLOCK=0;
            int row_BLOCK=0;

            for(int j=0;j<5;j++){
                String m = scan.next();
                char[] m1 = m.toCharArray();
                for(int k=0;k<5;k++){
                    if(m1[k] == '*'){
                        col_BLOCK = j;
                        row_BLOCK = k;
                    }
                }
                Grid[j] = m1;

            }
            System.out.println(13);
            System.out.println(-1);
            GridForBalance gridForBalance = new GridForBalance(Grid,col_BLOCK,row_BLOCK);
            int m = gridForBalance.gridBalancer(Grid);
            System.out.println(m);

        }

    }
}