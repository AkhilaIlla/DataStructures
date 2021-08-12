import java.util.ArrayList;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        A a = new A();
        List<List<String>> re =  a.groupAnagrams(strs);
        System.out.println(re);
    }
}

class A {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if(strs.length==1) result.add(Arrays.asList(strs[0]));

        for(int i=0; i< strs.length; i++){
            String str = strs[i];

            //sort the string
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String s = new String(charArr);

            //check if map has the string
            List<String> vals;
            if(map.containsKey(s)){
                vals = map.get(s);
            }else{
                vals = new ArrayList<>();
                map.put(s, vals);
            }
            vals.add(str);
        }

        for(Map.Entry<String, List<String>> m: map.entrySet()){
            result.add(m.getValue());
        }
        return result;

    }
}
