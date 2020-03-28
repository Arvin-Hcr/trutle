package com.hcr.turtle.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 其他工具类
 */
public class OtherUtil {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(Object str) {
        if (str == null || str.equals("") || str.equals("null")) {
            return true;
        }
        return false;
    }


    /**
     * 生成六位随机数
     *
     * @return
     */
    public static String getNum() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    /**随机生成用户名
     * @return
     */
    public static String getUname(){
        String randomcode = "";
        for(int i=0;i<6;i++)
        {
            //52个字母与6个大小写字母间的符号；范围为91~96
            int value = (int)(Math.random()*58+65);
            while(value>=91 && value<=96)
                value = (int)(Math.random()*58+65);
            randomcode = randomcode + (char)value;

        }
        return randomcode;
    }

    /**
     * md5加密
     *
     * @param pwd
     * @return
     */
    private static char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F'};

    public final static String MD5(String pwd) {
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) { //i = 0
                byte byte0 = md[i];//95
                str[k++] = md5String[byte0 >>> 4 & 0xf];//5 
                str[k++] = md5String[byte0 & 0xf];// F
            }
            //返回经过加密后的字符串
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取现在时间
     * @return返回字符串格式yyyyMMddHHmmss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMHH");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    /**
     * 由年月日时分秒+3位随机数
     * 生成编号
     * @return
     */
    public static String GetCnum(){
        String t = getStringDate();
        int x=(int)(Math.random()*900)+100;
        String serial = t + x;
        return serial;
    }

    public static void main(String[] args) {
        System.out.println(GetCnum());
    }

}
