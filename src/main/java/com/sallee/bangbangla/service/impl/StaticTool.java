package com.sallee.bangbangla.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StaticTool {
  public static String getSHA256(String str) {
    MessageDigest sha256;
    try {
      sha256 = MessageDigest.getInstance("sha256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    byte[] hashedResult;
    hashedResult = sha256.digest(str.getBytes(StandardCharsets.UTF_8));
    String hashResultStr = "";
    for (byte b : hashedResult) {
      String tmpStr = Integer.toHexString(b & 0xff);
      if(tmpStr.length() == 1)
        tmpStr = "0"+tmpStr;
      hashResultStr += tmpStr;
    }
    return hashResultStr;
  }

  public static String getSalt(){
    return StaticTool.getSalt(8);
  }

  public static String getSalt(int length){
    String CharMapper = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String salt = "";
    SecureRandom random;
    try {
      random = SecureRandom.getInstance("SHA1PRNG");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < length; i++){
      int nextVal = Math.abs(random.nextInt()) % 62;
      salt+=CharMapper.charAt(nextVal);
    }
    return salt;
  }

}
