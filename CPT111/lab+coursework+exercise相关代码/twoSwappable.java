public class twoSwappable {
    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        return new String(charArray);
    }

public static boolean twoSwappable(String s1, String s2) {
    if (s1.length() != 5 || s2.length() != 5) {
        return false;
    }

    // 检查偶数索引字符是否相同
    for (int i = 0; i < s1.length(); i += 2) {
        int j =0;
        if (!s1.equals(s2)) {
            s1=swap(s1,j,j+2);
            if (!s1.equals(s2)){
                s1=swap(s1,j,j+2);

            }
        }
    }


    // 检查奇数索引字符是否相同
    for (int i = 1; i < s1.length(); i += 2) {
        if (!s1.equals(s2)) {
            s1=swap(s1,i,i+2);
            if (!s1.equals(s2)) return false;
        }
    }


    return true;
}
        public static void main(String[] args) {
            System.out.println(twoSwappable("abcde", "cdabe"));
            System.out.println(twoSwappable("abcde", "edcba"));
            System.out.println(twoSwappable("abcde", "daceb"));
        }
    }