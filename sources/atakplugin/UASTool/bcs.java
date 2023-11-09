package atakplugin.UASTool;

import java.lang.annotation.Annotation;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, mo1538e = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
public final class bcs {
    /* renamed from: a */
    public static /* synthetic */ void m6379a(bji bji) {
    }

    @anx(mo1516a = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", mo1517b = @C0081api(mo1552a = "(this as Any).javaClass", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: e */
    public static /* synthetic */ void m6384e(bji bji) {
    }

    /* renamed from: b */
    public static final <T> Class<T> m6381b(bji<T> bji) {
        bfq.m6567f(bji, "$this$java");
        Class<?> a = ((bfa) bji).mo2350a();
        if (a != null) {
            return a;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* renamed from: c */
    public static final <T> Class<T> m6382c(bji<T> bji) {
        bfq.m6567f(bji, "$this$javaPrimitiveType");
        Class<?> a = ((bfa) bji).mo2350a();
        if (!a.isPrimitive()) {
            String name = a.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            return Integer.TYPE;
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            return Float.TYPE;
                        }
                        break;
                    case -515992664:
                        if (name.equals("java.lang.Short")) {
                            return Short.TYPE;
                        }
                        break;
                    case 155276373:
                        if (name.equals("java.lang.Character")) {
                            return Character.TYPE;
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            return Boolean.TYPE;
                        }
                        break;
                    case 398507100:
                        if (name.equals("java.lang.Byte")) {
                            return Byte.TYPE;
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            return Long.TYPE;
                        }
                        break;
                    case 399092968:
                        if (name.equals("java.lang.Void")) {
                            return Void.TYPE;
                        }
                        break;
                    case 761287205:
                        if (name.equals("java.lang.Double")) {
                            return Double.TYPE;
                        }
                        break;
                }
            }
            return null;
        } else if (a != null) {
            return a;
        } else {
            throw new apx("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    /* renamed from: d */
    public static final <T> Class<T> m6383d(bji<T> bji) {
        bfq.m6567f(bji, "$this$javaObjectType");
        Class a = ((bfa) bji).mo2350a();
        if (a.isPrimitive()) {
            String name = a.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            a = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            a = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            a = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            a = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            a = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            a = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            a = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            a = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            a = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (a != null) {
                return a;
            }
            throw new apx("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (a != null) {
            return a;
        } else {
            throw new apx("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    /* renamed from: a */
    public static final <T> bji<T> m6376a(Class<T> cls) {
        bfq.m6567f(cls, "$this$kotlin");
        return bgp.m6715b(cls);
    }

    /* renamed from: a */
    public static final <T> Class<T> m6378a(T t) {
        bfq.m6567f(t, "$this$javaClass");
        Class<?> cls = t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* renamed from: f */
    public static final <T> Class<bji<T>> m6385f(bji<T> bji) {
        bfq.m6567f(bji, "$this$javaClass");
        Class<?> cls = bji.getClass();
        if (cls != null) {
            return cls;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }

    /* renamed from: a */
    public static final /* synthetic */ <T> boolean m6380a(Object[] objArr) {
        bfq.m6567f(objArr, "$this$isArrayOf");
        bfq.m6539a(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    /* renamed from: a */
    public static final <T extends Annotation> bji<? extends T> m6377a(T t) {
        bfq.m6567f(t, "$this$annotationClass");
        Class<? extends Annotation> annotationType = t.annotationType();
        bfq.m6554b(annotationType, "(this as java.lang.annot…otation).annotationType()");
        bji<? extends T> a = m6376a(annotationType);
        if (a != null) {
            return a;
        }
        throw new apx("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
