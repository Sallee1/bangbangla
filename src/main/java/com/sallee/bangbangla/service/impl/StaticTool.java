package com.sallee.bangbangla.service.impl;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

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
    StringBuilder hashResultStr = new StringBuilder();
    for (byte b : hashedResult) {
      String tmpStr = Integer.toHexString(b & 0xff);
      if(tmpStr.length() == 1)
        tmpStr = "0"+tmpStr;
      hashResultStr.append(tmpStr);
    }
    return hashResultStr.toString();
  }

  public static String getSalt(){
    return StaticTool.getSalt(8);
  }

  public static String getSalt(int length){
    String CharMapper = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder salt = new StringBuilder();
    SecureRandom random;
    try {
      random = SecureRandom.getInstance("SHA1PRNG");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < length; i++){
      int nextVal = Math.abs(random.nextInt()) % 62;
      salt.append(CharMapper.charAt(nextVal));
    }
    return salt.toString();
  }

  public static String date2String(Date date)
  {
    String res = String.format("%tF%n",date);
    return res;
  }

  public static String list2Json(List<String> list)
  {
    
  }
}
