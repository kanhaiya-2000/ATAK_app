package atakplugin.UASTool;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000bH\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000eH\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000fH\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0010H\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\u0011\u001a\u00020\u0001*\u00020\u0001H\n¨\u0006\u0012"}, mo1538e = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "mod", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, mo1539f = "kotlin/NumbersKt", mo1541h = 1)
class aox {
    /* renamed from: a */
    private static final BigDecimal m2513a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        bfq.m6567f(bigDecimal, "$this$plus");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        bfq.m6554b(add, "this.add(other)");
        return add;
    }

    /* renamed from: b */
    private static final BigDecimal m2515b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        bfq.m6567f(bigDecimal, "$this$minus");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        bfq.m6554b(subtract, "this.subtract(other)");
        return subtract;
    }

    /* renamed from: c */
    private static final BigDecimal m2517c(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        bfq.m6567f(bigDecimal, "$this$times");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        bfq.m6554b(multiply, "this.multiply(other)");
        return multiply;
    }

    /* renamed from: d */
    private static final BigDecimal m2518d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        bfq.m6567f(bigDecimal, "$this$div");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        bfq.m6554b(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @anx(mo1516a = "Use rem(other) instead", mo1517b = @C0081api(mo1552a = "rem(other)", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: e */
    private static final BigDecimal m2519e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        bfq.m6567f(bigDecimal, "$this$mod");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        bfq.m6554b(remainder, "this.remainder(other)");
        return remainder;
    }

    /* renamed from: f */
    private static final BigDecimal m2520f(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        bfq.m6567f(bigDecimal, "$this$rem");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        bfq.m6554b(remainder, "this.remainder(other)");
        return remainder;
    }

    /* renamed from: a */
    private static final BigDecimal m2512a(BigDecimal bigDecimal) {
        bfq.m6567f(bigDecimal, "$this$unaryMinus");
        BigDecimal negate = bigDecimal.negate();
        bfq.m6554b(negate, "this.negate()");
        return negate;
    }

    /* renamed from: b */
    private static final BigDecimal m2514b(BigDecimal bigDecimal) {
        bfq.m6567f(bigDecimal, "$this$inc");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        bfq.m6554b(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    /* renamed from: c */
    private static final BigDecimal m2516c(BigDecimal bigDecimal) {
        bfq.m6567f(bigDecimal, "$this$dec");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        bfq.m6554b(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    /* renamed from: a */
    private static final BigDecimal m2508a(int i) {
        BigDecimal valueOf = BigDecimal.valueOf((long) i);
        bfq.m6554b(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    /* renamed from: a */
    private static final BigDecimal m2509a(int i, MathContext mathContext) {
        return new BigDecimal(i, mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m2510a(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        bfq.m6554b(valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    /* renamed from: a */
    private static final BigDecimal m2511a(long j, MathContext mathContext) {
        return new BigDecimal(j, mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m2506a(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    /* renamed from: a */
    private static final BigDecimal m2507a(float f, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m2504a(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    /* renamed from: a */
    private static final BigDecimal m2505a(double d, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
