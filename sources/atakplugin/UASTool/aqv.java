package atakplugin.UASTool;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B$\u0012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004R\u001f\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005ø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, mo1538e = {"Lkotlin/UseExperimental;", "", "markerClass", "", "Lkotlin/reflect/KClass;", "()[Ljava/lang/Class;", "kotlin-stdlib"})
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@arc(mo1692a = aqy.SOURCE)
@ard(mo1693a = {aqz.CLASS, aqz.PROPERTY, aqz.LOCAL_VARIABLE, aqz.VALUE_PARAMETER, aqz.CONSTRUCTOR, aqz.FUNCTION, aqz.PROPERTY_GETTER, aqz.PROPERTY_SETTER, aqz.EXPRESSION, aqz.FILE, aqz.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
public @interface aqv {
    /* renamed from: a */
    Class<? extends Annotation>[] mo1689a();
}
