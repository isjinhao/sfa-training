package jishuneimu.basis.resolver;

import org.apache.ibatis.io.ResolverUtil;

import java.util.Set;

public class TestResolverUtil {

    public static void main(String[] args) {

        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<>();
        ResolverUtil.IsA isA = new ResolverUtil.IsA(Object.class);

//        ResolverUtil.IsA annotatedWith = new ResolverUtil.AnnotatedWith(Annotated.class);

        resolverUtil.find(isA, "jishuneimu");
        Set<Class<? extends Class<?>>> classes = resolverUtil.getClasses();

        for (Class<?> c : classes) {
            System.out.println(c);
        }

    }
}