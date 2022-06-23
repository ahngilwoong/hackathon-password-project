package com.swuniv.security_tutle_project.util;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CipherAesUtils {

    private static String key = "abcdefghijklmnop";
    private static String target = "Java AES 암호화";
    private static final int max_len = 12;
    public static void main(String[] args)  {
        String str = encrypt(target.getBytes(), key.getBytes(), 15);
        str = Symbol(str);
        str = Caps(str);
        System.out.println(str);
    }

    public static String Symbol(String s)
    {
        StringBuilder Z = new StringBuilder("~!@#$%^&*-_");
        int Z_Num = (int) (Math.random() * 11); //DB에 rand함수 써서 나온 값을 저장해야됌
        StringBuilder str = new StringBuilder(s);
        str.deleteCharAt(1);
        char z = Z.charAt(Z_Num);//대문자 알파뱃 추가
        return str.toString()+z;
    }

    public static String Caps(String s)
    {
        StringBuilder CAPS = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUWXYZ");
        char text;
        StringBuilder str = new StringBuilder(s);
        try {


            for(int i=0; i<max_len; i++) {
                for(int j = 0; j<25; j++) {
                    if(s.charAt(i)==CAPS.charAt(j)) {
                        text = s.charAt(i);
                        str = str.delete(i,text);
                        text = Character.toUpperCase(text);
                        str = str.insert(i,text);
                        break;
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String Index is out of bounds");



        }
        return str.toString();

    }


    public static String encrypt(byte[] target, byte[] key, int num){
        SecretKeySpec keySpec = null;

        keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (NoSuchPaddingException e) {
            return null;
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        } catch (InvalidKeyException e) {
            return null;
        }

        try {
            Encoder encoder = Base64.getEncoder();
            String result = new String(encoder.encode(cipher.doFinal(target)));
            result = result.substring(0, num);
            result = result.toLowerCase();   //소문자로 변경
            return result;
        } catch (IllegalBlockSizeException e) {

        } catch (BadPaddingException e) {

        }
        return null;
    }

}
