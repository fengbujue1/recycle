package com.zhouyunji.util;

import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class TokenUtil {
    private static KeyPairGenerator  keyPairGenerator;

    static {
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static KeyPair keyPair = keyPairGenerator.generateKeyPair();
    private static RSAPrivateKey rsaprivateKey = (RSAPrivateKey) keyPair.getPrivate();
    private static RSAPublicKey rsapublicKey = (RSAPublicKey) keyPair.getPublic();
    private static PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaprivateKey.getEncoded());
    private static KeyFactory keyFactory;
    private static X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsapublicKey.getEncoded());
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static Cipher cipher1;
    private static Cipher cipher2;
    //Cipher.ENCRYPT_MODE, 用于将 Cipher 初始化为加密模式的常量。

    static {
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            publicKey= keyFactory.generatePublic(x509EncodedKeySpec);
            privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            cipher1 = Cipher.getInstance("RSA");
            cipher1.init(Cipher.ENCRYPT_MODE, privateKey);
            cipher2 = Cipher.getInstance("RSA");
            cipher2.init(Cipher.DECRYPT_MODE, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TokenUtil()  {
    }

    /**
     * 解析token获取用户openId
     *
     * @return
     */
    public static String analysisToken(String token) throws Exception {
        System.out.println("token:  " + token);
        byte[] decode = Base64Utils.decodeFromString(token);
        return new String(cipher2.doFinal(decode));
    }

    public static String getToken(String openid) throws Exception {
        System.out.println(openid);
        byte[] result = cipher1.doFinal(openid.getBytes());
        String token = Base64Utils.encodeToString(result);
        System.out.println("token:  " + token);
        return token;
    }
}
