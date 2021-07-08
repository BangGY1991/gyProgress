package com.example.leetode.com.nowcoder.offer.chapter5;/**
 * @program: gyProgress
 * @description: 字典树（前缀树）的实现
 * @author: GuoYu
 * @create: 2021-07-08 11:15
 **/

/**
 * @program: gyProgress
 *
 * @description: 字典树（前缀树）的实现
 *
 * @author: GuoYu
 *
 * @create: 2021-07-08 11:15
 **/
public class Chapter5_24 {
    public class TrieNode
    {
        public int path;
        public int end;
        public TrieNode[] map;
        public  TrieNode()
        {
            path=0;
            end=0;
            map=new TrieNode[26];
        }
    }
    public class Trie{
        private TrieNode root;
        public Trie()
        {
            root =new TrieNode();
        }
        public void insert(String word)
        {
            if (word==null)
            {
                return;
            }
            char[] chs=word.toCharArray();
            TrieNode node=root;
            node.path++;
            int index=0;
            for (int i = 0; i < chs.length; i++) {
                index=chs[i]-'a';
                if (node.map[index]==null)
                {
                    node.map[index]=new TrieNode();
                }
                node=node.map[index];
                node.path++;
            }
            node.end++;
        }
        public void delete(String word)
        {
            if(search(word))
            {
                char[] chs=word.toCharArray();
                TrieNode node=root;
                node.path++;
                int index=0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.map[index].path--==1)
                    {
                        node.map[index]=null;
                        return;

                    }
                    node=node.map[index];

                }
                node.end--;
            }
        }
        public boolean search(String word)
        {
            if (word==null)
            {
                return false;
            }
            char[] chs=word.toCharArray();
            TrieNode node=root;
            int index=0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    return false;

                }
                node=node.map[index];
            }
            return node.end!=0;
        }
        public int prefixNumber(String pre)
        {
            if (pre==null)
            {
                return 0;
            }
            char[] chs=pre.toCharArray();
            TrieNode node=root;
            int index=0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    return 0;

                }
                node=node.map[index];
            }
            return node.path;
        }
    }
}
