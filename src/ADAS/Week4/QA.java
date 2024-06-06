package ADAS.Week4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class QA {

    // The basic Java idea is from: https://zhuanlan.zhihu.com/p/311942904
    static class LFU{
        int capacity;
        int minFreq; // The element that operates least frequently in LFU
        int time;
        static int LIFE;

        // KV KF FK TK KT
        HashMap<Integer, Integer> keyToVal; // 用哈希表把所有的key跟我们的存储值进行建立, KV
        HashMap<Integer, Integer> keyToFreq;// 用表建立key跟频率的映射, KF
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys; // freq 到 key 列表的映射，FK
        HashMap<Integer,Integer> timeToKey; // 用表建立时间戳到key的映射，TK
        HashMap<Integer,Integer> keyToTime; // 用表建立key到时间戳的映射，KT

        public LFU (int capacity, int T){
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            timeToKey = new HashMap<>();
            keyToTime = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 0;
            this.time = 0;
            LIFE = T;
        }

        public int get(int key){
            lifeCycle();

            if (!keyToVal.containsKey(key)) {
                time++;
                return -1;
            }
            // 增加 key 对应的 freq
            increaseFreq(key);

            // 更新 key 对应的 time
            int that_time = keyToTime.remove(key);
            timeToKey.remove(that_time);
            keyToTime.put(key, time);
            timeToKey.put(time, key);

            time++;
            return keyToVal.get(key);
        }

        public void put(int key, int val){
            if (this.capacity <= 0) {
                return;}
            lifeCycle();

            /* 若 key 已存在，修改对应的 val 即可 */
            if (keyToVal.containsKey(key)) {//not inc
                keyToVal.put(key, val);
                // key 对应的 freq 加1
                increaseFreq(key);

                // 更新 key 对应的 time
                int that_time = keyToTime.get(key);
                keyToTime.remove(key);
                timeToKey.remove(that_time);
                keyToTime.put(key,time);
                timeToKey.put(time, key);

                time++;
                return;
            }

            // key is not exist, need to add it to cache
            // if the cap is full, remove Min Freq Key
            if (this.capacity <= keyToVal.size()) {
                removeMinFreqKey();
            }

            // Insert it to cache
            keyToVal.put(key, val); // KV
            keyToFreq.put(key, 1);  // KF
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>()); // FK
            freqToKeys.get(1).add(key);
            // 插入新 key 后最小的 freq 肯定是 1
            this.minFreq = 1;

            timeToKey.put(time,key);// TK
            keyToTime.put(key,time);// KT
            time++;
        }

        private void removeMinFreqKey() {
            // freq 最小的 key 列表
            LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
            // 其中最先被插入的那个 key 就是该被淘汰的 key
            // LinkedHashSet 是一个双向链表 + 哈希表的结构，
            // 保证先被插入的 key 会被先淘汰
            // 注意：这里我们选择 iterator 而不是 get(0)
            // 因为 get(0) 返回的仅仅是链表中的第一个元素，
            // 并没有真正移除该元素
            int deletedKey = keyList.iterator().next();

            /* 更新 FK 表 */
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                freqToKeys.remove(this.minFreq);
                // 问：这里需要更新 minFreq 的值吗？
                // 答：No need, since we will refresh minFreq later
            }
            if(!keyList.isEmpty()){
                freqToKeys.remove(this.minFreq);
                freqToKeys.put(this.minFreq,keyList);
            }
            /* 更新 KV 表 */
            keyToVal.remove(deletedKey);
            /* 更新 KF 表 */
            keyToFreq.remove(deletedKey);
            int time = keyToTime.remove(deletedKey);// TK
            timeToKey.remove(time);//KT
        }

        private void increaseFreq(int key) {
            int freq = keyToFreq.get(key);
            /* 更新 KF 表 */
            keyToFreq.put(key, freq + 1);
            /* 更新 FK 表 */
            // 将 key 从 freq 对应的列表中删除
            freqToKeys.get(freq).remove(key);
            // 将 key 加入 freq + 1 对应的列表中
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);

            // 如果 freq 对应的列表空了，移除这个 freq
            if (freqToKeys.get(freq).isEmpty()) {// not inc
                freqToKeys.remove(freq);
                // 如果这个 freq 恰好是 minFreq，更新 minFreq
                if (freq == this.minFreq) {
                    this.minFreq++;
                }
            }
        }

        // In addition, each operation will cost 1 time unit. Before each operation,
        // you need to check if any key in the cache has not been used for more than
        //T time units. You must evict them all before each operation.
        private void lifeCycle(){

            if (!timeToKey.containsKey(time - LIFE -1)) {
                return;
            }
            int key = timeToKey.remove(time - LIFE -1); // 1
//            System.out.println("Remove: "+key);
            keyToTime.remove(key); // 2

            // 更新 KF 表
            // 移除 key
            int freq = keyToFreq.remove(key); // 3
            keyToVal.remove(key); //4

            // min Freq! 5
            // 之前的错误来自于此
            LinkedHashSet<Integer> keyList = freqToKeys.get(freq);
            keyList.remove(key);
            freqToKeys.remove(freq);
            if(keyList.isEmpty()){
                // 要更新我们的minFreq了
                if(freq == this.minFreq){
                    int min = Integer.MAX_VALUE;
                    for(int new_key: keyToFreq.keySet()){
                        if(keyToFreq.get(new_key) < min){
                            min = keyToFreq.get(new_key);
                        }
                    }
                    minFreq = min;
                }
                // 还没有想到更好的算法去实现
            }else {
                freqToKeys.put(freq , keyList);// not inc
            }
        }

        // output all the values of all keys that end up in the cache,
        // in the order of update time (starting from the most recently updated item).
        // If there is nothing in the cache, output "empty".
        private void printCache(){
            int m =0;
            for(int i = time; i>0; i--){
                if (timeToKey.containsKey(i)) {
                    m += 1;
                    int key = timeToKey.get(i);
                    System.out.print(keyToVal.get(key) + " ");
                }
            }
            if(m == 0){
                System.out.println("empty");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int capacity = scan.nextInt();

        int M = scan.nextInt();
        int T = scan.nextInt();

        LFU cache = new LFU(capacity,T);
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
