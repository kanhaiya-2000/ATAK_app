package atakplugin.UASTool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0019"}, mo1538e = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, mo1539f = "kotlin/NumbersKt", mo1541h = 1)
class aoy extends aox {
    /* renamed from: a */
    private static final BigInteger m2527a(BigInteger bigInteger, BigInteger bigInteger2) {
        bfq.m6567f(bigInteger, "$this$plus");
        BigInteger add = bigInteger.add(bigInteger2);
        bfq.m6554b(add, "this.add(other)");
        return add;
    }

    /* renamed from: b */
    private static final BigInteger m2530b(BigInteger bigInteger, BigInteger bigInteger2) {
        bfq.m6567f(bigInteger, "$this$minus");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        bfq.m6554b(subtract, "this.subtract(other)");
        return subtract;
    }

    /* renamed from: c */
    private static final BigInteger m2532c(BigInteger bigInteger, BigInteger bigInteger2) {
        bfq.m6567f(bigInteger, "$this$times");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        bfq.m6554b(multiply, "this.multiply(other)");
        return multiply;
    }

    /* renamed from: d */
    private static final BigInteger m2534d(BigInteger bigInteger, BigInteger bigInteger2) {
        bfq.m6567f(bigInteger, "$this$div");
        BigInteger divide = bigInteger.divide(bigInteger2);
        bfq.m6554b(divide, "this.divide(other)");
        return divide;
    }

    /* renamed from: e */
    private static final BigInteger m2536e(BigInteger bigInteger, BigInteger bigInteger2) {
        bfq.m6567f(bigInteger, "$this$rem");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        bfq.m6554b(remainder, "this.remainder(other)");
        return remainder;
    }

    /* renamed from: a */
    private static final BigInteger m2525a(BigInteger bigInteger) {
        bfq.m6567f(bigInteger, "$this$unaryMinus");
        BigInteger negate = bigInteger.negate();
        bfq.m6554b(negate, "this.negate()");
        return negate;
    }

    /* renamed from: b */
    private static final BigInteger m2528b(BigInteger bigInteger) {
        bfq.m6567f(bigInteger, "$this$inc");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        bfq.m6554b(add, "this.add(BigInteger.ONE)");
        return add;
    }

    /* renamed from: c */
    private static final BigInteger m2531c(BigInteger bigInteger) {
        bfq.m6567f(bigInteger, "$this$dec");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        bfq.m6554b(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    /* renamed from: d */
    private static final BigInteger m2533d(BigInteger bigInteger) {
        BigInteger not = bigInteger.not();
        bfq.m6554b(not, "this.not()");
        return not;
    }

    /* renamed from: f */
    private static final BigInteger m2537f(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger and = bigInteger.and(bigInteger2);
        bfq.m6554b(and, "this.and(other)");
        return and;
    }

    /* renamed from: g */
    private static final BigInteger m2538g(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger or = bigInteger.or(bigInteger2);
        bfq.m6554b(or, "this.or(other)");
        return or;
    }

    /* renamed from: h */
    private static final BigInteger m2539h(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger xor = bigInteger.xor(bigInteger2);
        bfq.m6554b(xor, "this.xor(other)");
        return xor;
    }

    /* renamed from: a */
    private static final BigInteger m2526a(BigInteger bigInteger, int i) {
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        bfq.m6554b(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    /* renamed from: b */
    private static final BigInteger m2529b(BigInteger bigInteger, int i) {
        BigInteger shiftRight = bigInteger.shiftRight(i);
        bfq.m6554b(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    /* renamed from: a */
    private static final BigInteger m2523a(int i) {
        BigInteger valueOf = BigInteger.valueOf((long) i);
        bfq.m6554b(valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    /* renamed from: a */
    private static final BigInteger m2524a(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        bfq.m6554b(valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }

    /* renamed from: e */
    private static final BigDecimal m2535e(BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    /* renamed from: a */
    static /* synthetic */ BigDecimal m2522a(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            bfq.m6554b(mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i, mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m2521a(BigInteger bigInteger, int i, MathContext mathContext) {
        return new BigDecimal(bigInteger, i, mathContext);
    }
}
