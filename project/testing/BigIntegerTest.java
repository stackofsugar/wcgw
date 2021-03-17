import java.math.BigInteger;

class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigint = Big("45662188484865165846516");
        System.out.println(bigint);
    }

    static BigInteger Big(String value) {
        return new BigInteger(value);
    }
}
