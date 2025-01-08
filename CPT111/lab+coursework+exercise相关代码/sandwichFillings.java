public class sandwichFillings {
    public static String sandwichFillings(String input){
        if(input.length()==0||input.length()<=5) return "none";
        char[] arr= input.toCharArray();
        int index1=-1;
        int index2=-1;
        int i=0;
        int k=arr.length-5;
        String s="";
        while(i<=arr.length-5){
            if(arr[i]=='b'&&arr[i+1]=='r'&&arr[i+2]=='e'&&arr[i+3]=='a'&&arr[i+4]=='d'){
                index1=i;
                break;
            }
            i++;
        }
        while(k>=0){
            if(arr[k]=='b'&&arr[k+1]=='r'&&arr[k+2]=='e'&&arr[k+3]=='a'&&arr[k+4]=='d'){
                index2 =k;
                break;
            }
            k--;
        }

        if(index1 != -1 && index2 != -1 && index2 != index1){
            for(int j=index1+5;j<index2;j++) s+=arr[j];
            if(s.equals("")) return "none";
            else return s;
        }
        else return "none";
        }
    
}
