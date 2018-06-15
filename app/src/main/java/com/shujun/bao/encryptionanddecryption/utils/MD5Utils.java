package com.shujun.bao.encryptionanddecryption.utils;

import android.support.annotation.NonNull;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * MD5加密算法
 *
 * MD5全称是Message-digest Algorithm5（信息摘要算法），用于确保信息传输完整的一致。MD5用的是散列函数（Hash函数），
 * 其典型应用是对一段信息产生信息摘要，从而事先数字签名，登录口令的认证，为文档生成“数字指纹”等。MD5算法的基本思想是
 * 以512位分组来处理输入的信息，且每一分组又被划分位16个32分组，经过一系列的处理后算法输出由4个32位分组组成，将这4个
 * 32位分组级联后将生产一个128位的散列值
 * <href= "https://developer.android.google.cn/reference/java/security/MessageDigest">Android官网文档</href>
 *
 *
 */
public class MD5Utils {
    private static final String TAG = "MD5Utils";

    /**
     *
     * md5加密字符串
     * @param text 需要加密的字符串
     * @return 加密之后的字符串
     */
    public static String encode(String text){

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
           // byte[] result = messageDigest.digest(text.getBytes());
            byte[] result = messageDigest.digest(text.getBytes("utf-8"));

            return byteToHashHexLower(result);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1){
            e1.printStackTrace();
        }

        return null;
    }

    /**
     *
     * 获取摘要之后，进行hash计算
     * @param digestByte 摘要字节
     * @return 返回小写字符串
     */
    @NonNull
    private static String byteToHashHexLower(byte[] digestByte) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digestByte){
            int number=b&0xff;
            String hex=Integer.toHexString(number);
            if(hex.length()==1){
                stringBuilder.append("0").append(hex);
            }else {
                stringBuilder.append(hex);
            }
        }
        return stringBuilder.toString();
    }


}
