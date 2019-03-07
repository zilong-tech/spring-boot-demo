package com.demo.config;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Description:
 * <p>
 * Create on 2019/03/07
 *
 * @author zouyongsheng
 */
public class PasswordUtil {

    public static void main(String[] args) {

        //盐值用的用的是对用户名的加密（测试用的"lisi"）
        ByteSource credentialsSalt01 = ByteSource.Util.bytes("admin");
        Object salt = null;//盐值
        Object credential = "123456";//密码
        String hashAlgorithmName = "MD5";//加密方式
        //1024指的是加密的次数
        Object simpleHash = new SimpleHash(hashAlgorithmName, credential,
                credentialsSalt01, 1024);
        System.out.println("加密后的值----->" + simpleHash);
    }
}
