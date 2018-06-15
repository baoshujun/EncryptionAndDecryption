package com.shujun.bao.encryptionanddecryption.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;

/**
 *
 * commons-codec是Apache开源组织提供的用于摘要运算、编码的包。在该包中包含一些通用的编码解码算法.主要分为四类加密：
 * BinaryEncoders、DigestEncoders、LanguageEncoders、NetworkEncoders。
 * <href= "http://commons.apache.org/proper/commons-codec/">官网</href>
 *
 *
 */
public class EncodeByCommonsCodec {
    /**
     *
     * 1.MD5  不可逆算法
     * @param textStr 加密前的字符串
     * @return 加密之后的字符串
     */
    public String md5Encode(String textStr) {
        return DigestUtils.md5Hex(textStr);

    }

    /**
     *
     * 1.SHA1  不可逆算法
     * @param textStr 加密前的字符串
     * @return 加密之后的字符串
     */
    public String sha1Hex(String textStr) {
        return DigestUtils.sha1Hex(textStr);
    }

    /**
     *
     * 常规加密解密算法：
     * 1.BASE64 加密算法 可逆算法
     * @param textStr 加密之前的字符串
     * @return 加密之后的字符串
     */
    public String base64EncodeAsString(String textStr) {
        byte[] data = textStr.getBytes();
        Base64 base64 = new Base64();
        return base64.encodeAsString(data);
    }


    /**
     *
     * 常规加密解密算法：
     * 2.BASE64 解密算法
     * @param textStr 解密之前的字符串
     * @return 解密之后的字符串
     */
    public String base64DeEncodeAsString(String textStr) {
        byte[] data = textStr.getBytes();
        Base64 base64 = new Base64();
        byte[] bytes = base64.decodeBase64(data);
        return new  String(bytes);
    }

    /**
     * 常规加密解密算法：
     * 3.URLEncode 对中文字符串才有效果，英文及数字没有变化
     * @param queryString 加密之前的字符串
     * @return 加密之后的字符串
     * @throws Exception
     */
    public String urlEncodec(String queryString) throws Exception {
        URLCodec codec = new URLCodec();
        return codec.encode(queryString, "UTF-8");
    }


    /**
     * 常规加密解密算法：
     * 4.URLDecode
     * @param queryString 解密之的字符串
     * @return 解密之后的字符串
     * @throws Exception
     */
    public String urlDecodec(String queryString) throws Exception {
        URLCodec codec = new URLCodec();
        return codec.decode(queryString, "UTF-8");
    }
}
