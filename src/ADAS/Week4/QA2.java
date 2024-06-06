package ADAS.Week4;

import java.util.*;

public class QA2 {
    static class Var{
        int key;
        int value;
        int freq;
        int lastTime;

        public Var(int key,int value, int time){
            this.key = key;
            this.value = value;
            freq = 0;
            lastTime = time;
        }
        public void AddFreq(){
            freq++;
        }
        public void UpdateTime(int time){
            lastTime = time;
        }
    }
    static class LFU{
        int capacity;
        int time;
        static int LIFE;
        HashMap <Integer, Var> keyToVar;
        HashMap<Integer,LinkedHashSet<Integer>> freqToKey;

        public LFU(int capacity,int T){
            this.capacity = capacity;
            LIFE = T;
            keyToVar = new HashMap<>();
            time = 0;
            freqToKey = new HashMap<>();
        }

        public int get(int key){
            lifeCycle();

            if (!keyToVar.containsKey(key)) {
                return -1;
            }

            Var gets = keyToVar.remove(key);

            int freq = gets.freq;
            // 将 key 从 freq 对应的列表中删除
            freqToKey.get(freq).remove(key);

            freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKey.get(freq + 1).add(key);
            // 如果 freq 对应的列表空了，移除这个 freq
            if (freqToKey.get(freq).isEmpty()) {
                freqToKey.remove(freq);
                // 如果这个 freq 恰好是 minFreq，更新 minFreq

            }

            gets.AddFreq();
            gets.UpdateTime(time);
            keyToVar.put(key, gets);

            time++;
            return gets.value;
        }

        // not done
        public void printCache(){}

        // not done
        public void put(int key, int val){
            if(!keyToVar.containsKey(key)){
                if(keyToVar.size() == capacity){

                }
                Var newVar = new Var(key,val,time);
                keyToVar.put(key,newVar);
//                freqToKey.add(key);
            }

        }
        public void lifeCycle(){}

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = scan.nextInt();
        int M = scan.nextInt();
        int T = scan.nextInt();
        int[][] M_Ins = new int[M][3];

        for(int i=0;i<M; i++){
            M_Ins[i][0] = scan.nextInt();

            if( M_Ins[i][0] == 1){
                M_Ins[i][1] = scan.nextInt();
                M_Ins[i][2] = 0;
            }
            else {
                M_Ins[i][1] = scan.nextInt();
                M_Ins[i][2] = scan.nextInt();
            }
        }

        LFU cache = new LFU(capacity,T);

        for(int i=0; i<M; i++){
            if(M_Ins[i][0] == 1){
                int val = cache.get(M_Ins[i][1]);
                System.out.println(val);
            }
            if(M_Ins[i][0] == 2){
                cache.put(M_Ins[i][1],M_Ins[i][2]);
            }
        }
        cache.printCache();
    }
}
