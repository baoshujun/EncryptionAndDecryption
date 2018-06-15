package com.shujun.bao.encryptionanddecryption;

import com.shujun.bao.encryptionanddecryption.utils.EncodeByCommonsCodec;

import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CommonsCodecUnitTest {
    private  EncodeByCommonsCodec encodeByCommonsCodec = new EncodeByCommonsCodec();
    private  String textStr = "加解密测试字符串";


    @Test
    public void testEncodeAndDecode() throws Exception {
        System.out.println("==============MD5================");
        System.out.println("before====MD5:" + textStr + " after MD5:" + encodeByCommonsCodec.md5Encode(textStr));


        System.out.println("==============sha1Hex================");
        System.out.println("before====sha1Hex:" + textStr + " after sha1Hex:" + encodeByCommonsCodec.sha1Hex(textStr));

        System.out.println("==============base64================");
        String base64String = encodeByCommonsCodec.base64EncodeAsString(textStr);
        System.out.println("before====base64:" + textStr + " after base64:" + base64String);
        System.out.println("==============base64Decode================");
        System.out.println("before====base64Decode:" + base64String + " after base64Decode:" + encodeByCommonsCodec.base64DeEncodeAsString(base64String));

        System.out.println("==============urlEncode================");
        String urlEncodeString = encodeByCommonsCodec.urlEncodec(textStr);
        System.out.println("before====urlEncode:" + textStr + " after urlEncode:" + urlEncodeString);
        System.out.println("==============urlDecode================");
        System.out.println("before====urlDecode:" + urlEncodeString + " after urlDecode:" + encodeByCommonsCodec.urlDecodec(urlEncodeString));


    }


}