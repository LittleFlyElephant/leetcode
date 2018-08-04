package facebook;

public class E461 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
