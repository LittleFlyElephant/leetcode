package facebook;

public class E680 {
    boolean valid(char[] arr, int l, int r, int left) {
        if (l>=r) return true;
        if (arr[l] == arr[r]) return valid(arr, l+1, r-1, left);
        if (left == 0) return false;
        return valid(arr, l+1, r, left-1) || valid(arr, l, r-1, left-1);
    }
    public boolean validPalindrome(String s) {
        return valid(s.toCharArray(), 0, s.length()-1, 1);
    }
}
