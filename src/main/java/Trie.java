import java.util.HashMap;
import java.util.Map;

class Trie {
    public TrieNode root;
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfTheWord;
    }

    /** Initialize your data structure here. */
    public Trie() {
        root =  new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        //apple
        //cur = empty Trie
        TrieNode cur = root;
        for(Character c: word.toCharArray()){
            if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isEndOfTheWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //apple
        TrieNode cur = root;
        for(Character c: word.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.isEndOfTheWord;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(Character c: prefix.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie x = new Trie();
        x.insert("akhila");
        System.out.println(x.search("akhila"));
        System.out.println(x.search("akhi"));
        System.out.println(x.startsWith("akhi"));
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */