import java.util.List;

public class IsPartionable {
    // Exercise #11.3
    public static boolean isPartitionable(List<Integer> list) {
        int totalSum = 0;
        for (int num : list) {
            totalSum += num;
        }

        if(list.isEmpty()) return true;
        
        if (totalSum % 2 != 0||list.size()==1) {
            return false;
        }

        int sumleft=0;
        for (int i= 0; i < list.size()-1; i++) {
            sumleft+=list.get(i);
            if (sumleft == totalSum/2) {
                return true; 
            }
            
        }
        return false;
        
    }

}
