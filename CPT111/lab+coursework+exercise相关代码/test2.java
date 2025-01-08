public class test2 {

    public static boolean checkAllStr(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkAllStr("abababababa"));
        System.out.println(checkAllStr("abababab"));
        System.out.println(checkAllStr("abcdefg"));
        System.out.println(checkAllStr("abcdabcd"));
    }
}
