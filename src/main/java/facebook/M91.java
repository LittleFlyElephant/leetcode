package facebook;

public class M91 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] f = new int[len];
        f[0] = 1;
        for (int i=1; i<len; i++) {
            // special case: 0
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '0' || s.charAt(i-1) >= '3') return 0;
                if (i == 1) f[i] = 1;
                else f[i] = f[i-2];
                continue;
            }
            boolean b = false;
            if (s.charAt(i-1) == '1') {
                b = true;
            } else if (s.charAt(i) <= '6' && s.charAt(i-1) == '2') {
                b = true;
            }
            if (b) {
                if (i == 1) f[i] = 2;
                else {
                    f[i] = f[i-1] + f[i-2];
                }
            } else {
                f[i] = f[i-1];
            }
        }
        return f[len-1];
    }
}
