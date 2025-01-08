public class maxproduct2 {
    public static int maxProduct(int[] arr){
        if(arr.length==0||arr.length==1) return 0;
        if(arr.length==2) return arr[0]*arr[1];
        int product=0;
        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1;j<arr.length;j++){
                product=Math.max(product,arr[i]*arr[j]);
            }
            
        }
        return product;

    }
}