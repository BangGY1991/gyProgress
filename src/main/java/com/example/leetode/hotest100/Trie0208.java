package com.example.leetode.hotest100;

public class Trie0208 {
    private Trie0208[] children;
    private boolean isEnd;

    public Trie0208() {
        children = new Trie0208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie0208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie0208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie0208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie0208 searchPrefix(String prefix) {
        Trie0208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }


}
