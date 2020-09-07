package jdkclass;

import java.lang.reflect.ReflectPermission;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/2
 */
public class TestSecurityManager {

    public static void main(String[] args) {

        System.out.println(canAccessPrivateMethods());

    }

    /**
     * 默认的 SecurityManager
     * @return
     */
    private static boolean canAccessPrivateMethods() {
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (null != securityManager) {
                securityManager.checkPermission(new ReflectPermission("suppressAccessChecks"));
            }
        } catch (SecurityException e) {
            return false;
        }
        return true;
    }

}
