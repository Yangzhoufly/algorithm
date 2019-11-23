package 牛客初级._04树;

import java.util.HashMap;

/**
 *  Trie，又经常叫前缀树，字典树
 *  这里用 HashMap来保存该节点下有哪些边
 *  一定注意：
 *      字符信息保存在边中，也就是map中，经过的数量 path  和 以该串结尾的数量 保存在end 中
 */

public class _11前缀树 {


    public static class TrieNode {
        public int nodePath;  //有多少字符串经过该节点
        public int nodeEnd;   //有多少字符串以该节点结尾
        public HashMap<Character,TrieNode> edgeNext; //也可以这样设计，针对任何字符
        //public TrieNode []nexts;//这里假定只有26个小写字母组成

        public TrieNode() {
            nodePath=0;
            nodeEnd=0;
            edgeNext=new HashMap<Character,TrieNode>();
        }
    }
    public static class Trie{
        public TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word){
            if(word==null || word.length()==0){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = this.root;
            for(int i=0;i<chars.length;i++){
                if (!node.edgeNext.containsKey(chars[i])) {
                    node.edgeNext.put(chars[i],new TrieNode());
                } //没有就创建
                node=node.edgeNext.get(chars[i]); //走到下一步
                node.nodePath++;  //对应Path加1
            }
            node.nodeEnd++;//对应end加1
        }

        public int  search(String word){
            if(word==null || word.length()==0){
                return -1;
            }
            char[] chars = word.toCharArray();
            TrieNode node = this.root;
            for(int i=0;i<chars.length;i++){
                if (!node.edgeNext.containsKey(chars[i])) {
                    return 0;
                } //节点下没有这条边，所以没有这个字符串
                node=node.edgeNext.get(chars[i]); //走到下一步
            }
            return node.nodeEnd;//返回最后一条边的下一个节点对应的end
        }

        public int prefixNumber(String prefix){
            if(prefix==null || prefix.length()==0){
                return -1;
            }
            char[] chars = prefix.toCharArray();
            TrieNode node = this.root;
            for(int i=0;i<chars.length;i++){
                if (!node.edgeNext.containsKey(chars[i])) {
                    return 0;
                } //节点下没有这条边，所以没有这个字符串
                node=node.edgeNext.get(chars[i]); //走到下一步
            }
            return node.nodePath;//返回最后一条边的下一个节点对应的end
        }

        public void delete(String word){
            if(word==null || word.length()==0 ||search(word)<=0){
                System.out.println("异常返回");
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = this.root;
            for(int i=0;i<chars.length;i++){
                if (node.edgeNext.get(chars[i]).nodePath==1) {
                    node.edgeNext.remove(chars[i]);
                    return ;
                }//如果path，那么删除的这时候直接把这条路砍断
                //不然就走到下一步，把nodePath减一
                node=node.edgeNext.get(chars[i]);
                node.nodePath--;
            }
            node.nodeEnd--;
        }
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }
}
