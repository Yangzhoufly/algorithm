package 牛客初级._05哈希;

import java.util.HashMap;
import java.util.List;

public class _02并查集 {
    public static class Node{
        //whatever
    }

    public static class UnionFindSet{
        public HashMap<Node,Node> fatherMap; //key son ;value -> father
        public HashMap<Node,Integer> sizeMap;


        public UnionFindSet(List<Node> nodes) {
            this.fatherMap = new HashMap<Node, Node>();
            this.sizeMap = new  HashMap<Node, Integer>();
            makeSets(nodes);
        }

        //根据传入的数据初始化并查集
        private void makeSets(List<Node> nodes){
            this.fatherMap.clear();
            this.sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node node){
            Node father=fatherMap.get(node);
            if(father!=node){
                 father = findHead(father);
            }
            fatherMap.put(node,father); //将一路查找的节点的父亲节点修改为并查集的代表节点
            return father;
        }

        public boolean isSameSet(Node a ,Node b){
            return findHead(a) == findHead(b);
        }

        public void union (Node a , Node b){
            if(a==null || b==null){
                return ;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);

            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize <= bSetSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSetSize+bSetSize);
                } else {
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSetSize + bSetSize);
                }


            }

        }
    }

    public static void main(String[] args) {

    }


}
