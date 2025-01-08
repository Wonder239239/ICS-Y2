import java.util.Arrays;
import java.util.List;

public class RecursiveReplaceOddWithZero {
    public static void replaceOddZero(List<Integer> list){
        replaceOddZeroHelper(list, 0);
    }

    public static void replaceOddZeroHelper(List<Integer> list, int start){
        if(start >= list.size()||start<0){
            return;
        }
        else{
            if(list.get(start)%2==1){
                list.set(start, 0);
            }
            start+=1;
            replaceOddZeroHelper(list, start);
        }
    }

    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3,4,5);
        replaceOddZero(list);
        System.out.println(list);
    }
}