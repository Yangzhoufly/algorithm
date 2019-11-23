package 牛客初级._05哈希;


import java.util.HashMap;
import java.util.HashSet;

/**
 *【题目】 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * getRandom()：等概率随机返回结构中的任何一个key。
 * delete(key)：将原本在结构中的某个key移除。
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
 *
 * 【思路】
 * 问题1，一个hashset就可以解决
 * 问题2，等概率随机返回，比较困难，需要设计两个hashmap,
 * 问题3，
 */

public class _01RandomPool结构 {
    public static class RandomPool<T>{
        HashMap<T,Integer> keyIndexMap;
        HashMap<Integer,T> indexKeyMap;

        public RandomPool() {
            this.keyIndexMap = new HashMap<T, Integer>();
            this.indexKeyMap = new HashMap<Integer, T>();
        }

        public void insert(T key){
            if(key==null){
                return ;
            }
            if(keyIndexMap.containsKey(key)){
                System.out.println("containsKey-----"+key);
                return;
            }
            keyIndexMap.put(key,keyIndexMap.size());
            indexKeyMap.put(indexKeyMap.size(),key);
        }

        public T getRandom(){
            if(indexKeyMap.size()==0){
                return null ;
            }
            return indexKeyMap.get((int)(Math.random()*indexKeyMap.size()));
        }

        public T delete(T key){
            if(key==null || keyIndexMap.size()==0){
                return null;
            }

            Integer index = keyIndexMap.get(key);
            T lastKey = indexKeyMap.get(indexKeyMap.size() - 1);

            keyIndexMap.remove(key);
            keyIndexMap.replace(lastKey,index);

            indexKeyMap.replace(index,lastKey);
            indexKeyMap.remove(indexKeyMap.size()-1);
            return key;
        }
    }

    public static void main(String[] args) {
        RandomPool<String> pool = new RandomPool<>();
        pool.insert("A");
        pool.insert("B");
        pool.insert("C");
        pool.insert("C");

        System.out.println(pool.getRandom());
        System.out.println(pool.delete("A"));

    }



}
