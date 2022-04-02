package wolf.com.github.myjava;

import org.junit.jupiter.api.Test;
import wolf.com.github.myjava.common.AESUtils;
import wolf.com.github.myjava.common.Base64Utils;

public class AESTester {

    static String key;

    static {
        try {
            key = "3HBhJdf1e989mQYGW3Sdiw==";
            //key = "ZyZXJEyouSqVUcBqhjNh515fLeni09z90EW/i9WuOXc=";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void encrypt() throws Exception {
        long begin = System.currentTimeMillis();
        // 加密
        // encryptFile();
        // 解密
        decryptFile();
        //test();
        long end = System.currentTimeMillis();
        System.err.println("耗时：" + (end-begin) + "ms");
    }

    static void decryptFile() throws Exception {
        String sourceFilePath = "/Users/huangjiang/Downloads/common-2.encrypt";
        String destFilePath = "common-128";
        AESUtils.decryptFile(key, sourceFilePath, destFilePath);
    }

    static void encryptFile() throws Exception {
        String sourceFilePath = "common-2.zip";
        String destFilePath = "/Users/huangjiang/Downloads/common-2.encrypt";
        AESUtils.encryptFile(key, sourceFilePath, destFilePath);
    }

    static void test() throws Exception {
        String source = "这是一行测试DES加密/解密的文字，你看完也等于没看，是不是啊？！";
        System.err.println("原文:\t" + source);
        byte[] inputData = source.getBytes();
        inputData = AESUtils.encrypt(inputData, key);
        System.err.println("加密后:\t" + Base64Utils.encode(inputData));
        byte[] outputData = AESUtils.decrypt(inputData, key);
        String outputStr = new String(outputData);
        System.err.println("解密后:\t" + outputStr);
    }

}

