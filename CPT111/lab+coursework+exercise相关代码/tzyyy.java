import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tzyyy {
    public static List<String> intersectList1(List<String> list1, List<String> list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    for (String item : list1){
        if (map.containsKey(item)) {
            map.put(item, map.get(item) + 1);
        } else {
            map.put(item, 1);
        }
    }
    for (String item : list2){
        if (map.containsKey(item) && map.get(item) > 0){
            result.add(item);
            map.put(item, map.get(item) - 1);
        }
    }
    return result;
    }

    public static void main(String[] args) {
            List<String> list1 = Arrays.asList("a", "b", "a", "c");
            List<String> list2 = Arrays.asList("b", "d", "a", "b", "b","a");
            List<String> output = intersectList1(list1, list2);
                
            Collections.sort(output);
            System.out.println(output);
        }   
}
