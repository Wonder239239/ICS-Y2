import java.util.Arrays;
import java.util.List;

public class MaxStretch {
    // Exercise #11.1
    public static int maxStretch(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        
        int maxStretch = 1;
        
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size()-1; j >i; j--) {
                if(list.get(i)==list.get(j)){
                    if(j-i+1>=maxStretch) maxStretch=j-i+1;
                } 
            }
        }
        
        return maxStretch;
    }

    public static void main(String[] args) {
        // Create test cases
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = Arrays.asList(1, 3, 2, 1, 5, 6, 1);
        List<Integer> list3 = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> list4 = Arrays.asList(8,5,1,2,5,3,4,5, 10);
        List<Integer> list5 = Arrays.asList();

        // Print results
        System.out.println("Max stretch of list1: " + MaxStretch.maxStretch(list1));  
        System.out.println("Max stretch of list2: " + MaxStretch.maxStretch(list2));  
        System.out.println("Max stretch of list3: " + MaxStretch.maxStretch(list3));  
        System.out.println("Max stretch of list4: " + MaxStretch.maxStretch(list4)); 
        System.out.println("Max stretch of list5: " + MaxStretch.maxStretch(list5));  
    }

}
