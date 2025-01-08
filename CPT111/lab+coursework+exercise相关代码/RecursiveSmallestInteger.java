public class RecursiveSmallestInteger {
    public static int smallest(int[]array) {
        return smallest(array, 0);
    }

    private static int smallest(int[] array, int start){
        if(start == array.length - 1){
            return array[start];
        }
        int currentMin = smallest(array, start + 1);
        return Math.min(array[start], currentMin);
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 7, 9};
        System.out.println(smallest(array)); 
    }
}
