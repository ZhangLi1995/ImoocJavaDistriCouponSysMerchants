package com.imooc.passbook.merchants.security;

/**
 * <h1>用 ThreadLocal 去单独存储每一个线程携带的 Token 信息</h1>
 * ThreadLocal：用于保存当前的线程的一些少量的数据
 * Created by Zhangli.
 */
public class AccessContext {

    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
