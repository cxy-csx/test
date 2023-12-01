package com.csx.cxy;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws NoSuchAlgorithmException {

////        // RSA算法
////
//        // 生成公私钥对
//        KeyPair pair = SecureUtil.generateKeyPair("RSA");
//        PrivateKey privateKey = pair.getPrivate();
//        PublicKey publicKey = pair.getPublic();
//        // 获得私钥
//        String privateKeyStr = bytesToBase64(privateKey.getEncoded());
//        System.out.println("私钥：" + privateKeyStr);
//        // 获得公钥
//        String publicKeyStr = bytesToBase64(publicKey.getEncoded());
//        System.out.println("公钥：" + publicKeyStr);
////
////
//        RSA rsa = new RSA(privateKeyStr, publicKeyStr);
//        System.out.println(rsa);
////
////        // 公钥加密，私钥解密
//        String json = "123456";
//        byte[] encryptByte = rsa.encrypt(StrUtil.bytes(json, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
//        String encryptText = bytesToBase64(encryptByte);
//        System.out.println("公钥加密：" + encryptText);
//
////        byte[] decrypt = rsa.decrypt(base64ToBytes(encryptText), KeyType.PrivateKey);
////        System.out.println("私钥解密：" + new String(decrypt,StandardCharsets.UTF_8));
////
////      // 私钥加密，公钥解密
//        byte[] signByte = rsa.encrypt(StrUtil.bytes("123456", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
//        String sign = bytesToBase64(signByte);
//        System.out.println("私钥签名：" + sign);
//        byte[] textByte = rsa.decrypt(base64ToBytes(sign), KeyType.PublicKey);
//        String s = new String(textByte, StandardCharsets.UTF_8);
//        System.out.println("公钥解密：" + s);
////
////        // 用自己的私钥解密获取明文数据
////        byte[] origin = rsa.decrypt(base64ToBytes(s), KeyType.PrivateKey);
////        System.out.println(new String(origin, StandardCharsets.UTF_8));


        TestData testData = new TestData();
        testData.setMchtNo("15018701212");
        String now = DateUtil.now();
        System.out.println(now);
        // 这里实际上应该根据appId去查找对应的APP_SECRET 但是目前好像都是固定的只有一组APP_ID APP_SECRET
        String waitSignStr = now + "3LW1BK4M2cuyjQa3taeNOqwkyfjw1kpK" + JSONObject.toJSONString(testData);
        MessageDigest messageDigest;
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(waitSignStr.getBytes());
        String sign = new String(Base64.getEncoder().encode(messageDigest.digest()), StandardCharsets.UTF_8);
        System.out.println(sign);


    }


    /**
     * 字节数组转Base64编码
     * @param bytes 字节数组
     * @return Base64编码
     */
    private static String bytesToBase64(byte[] bytes) {
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    /**
     * Base64编码转字节数组
     * @param base64Str Base64编码
     * @return 字节数组
     */
    private static byte[] base64ToBytes(String base64Str) {
        byte[] bytes = base64Str.getBytes(StandardCharsets.UTF_8);
        return Base64.getDecoder().decode(bytes);
    }

}
