public class maxproduct {
    public static int maxProduct(int[] arr){
        int max1=0;
        int max2=0;
        int min1=0;
        int min2=0;
        if(arr.length==0||arr.length==1) return 0;
        if(arr.length==2) return arr[0]*arr[1];
        else{
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    if (arr[i] > max1) {
                        max2 = max1;
                        max1 = arr[i];
                    }
                    else if (arr[i] > max2) {
                        max2 = arr[i];
                    }
                }


                if (arr[i] < 0) {
                    if (arr[i] < min1) {
                        min2 = min1;
                        min1 = arr[i];
                    }
                    else if (arr[i] < min2) {
                        min2 = arr[i];
                    }
                }
            }
            return Math.max(max1 * max2, min1 * min2);
        }

    }

    
    }