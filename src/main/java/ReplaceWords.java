import java.util.*;

public class ReplaceWords {

    //using Trie
    private TrieNode root;
    class TrieNode{
        Map<Character, TrieNode> children=new HashMap<>();
        String word;
        boolean isEndOfWord;
    }

    public ReplaceWords(){
        root = new TrieNode();
    }

    public void insertIntoTrie(List<String> dictionary){
       for(String r: dictionary){
            TrieNode cur = root;
            for(Character c: r.toCharArray()){
                // System.out.println(c);
                if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
                System.out.println(cur.children.keySet());
                cur = cur.children.get(c);
                cur.word = r;
            }
            cur.isEndOfWord = true;
        }
    }

    public String searchWord(String successor){
        TrieNode cur = root;
        for(Character c: successor.toCharArray()){
            boolean exists = cur.children.containsKey(c);
            if(!exists) return successor;
            cur = cur.children.get(c);
            if(exists && cur.isEndOfWord) return cur.word;
        }
        return "";
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        //insert into Trie;
        insertIntoTrie(dictionary);


        StringBuilder sb = new StringBuilder();
        for(String successor: sentence.split("\\s+")){
            sb.append(searchWord(successor)+" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
//        ReplaceWords r = new ReplaceWords();
//        r.replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);

    }



}
