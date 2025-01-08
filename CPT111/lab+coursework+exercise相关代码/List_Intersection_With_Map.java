import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_Intersection_With_Map {
    public static List<String> intersectList(List<String> list1, List<String> list2) {
        
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        // Complete the function
        if (list1.isEmpty() || list2.isEmpty()) {
            result.add("");
            return result;
        } 
        
        for(String a:list1){
            if(map.containsKey(a)){
                int value = map.get(a);
                value+=1;
                map.put(a, value);
            }
            if(!map.containsKey(a)){
                map.put(a,1);
            }
        }

        for(String a:list2){
            if(map.containsKey(a)){
                int value = map.get(a);
                value+=1;
                map.put(a, value);
            }
            if(!map.containsKey(a)){
                map.put(a,1);
            }
        }
        
        for(String b:map.keySet()){
            if(map.get(b)>=2&&list1.contains(b)&&list2.contains(b)){
                result.add(b);
            }
        }
            
        return result;
    }


    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "a", "c");
        List<String> list2 = Arrays.asList("b", "d", "a", "b", "b");
        List<String> output = intersectList(list1, list2);
            
        Collections.sort(output);
        System.out.println(output);
    }   

}
