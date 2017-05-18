package com.example.utils;

import java.security.MessageDigest;

public class MD5Util {
	
	private static String MD5_32_ENCODEING = "1";
	private static String MD5_16_ENCODEING = "0";
	
	/**
	 * MD5加密
	 * @param target
	 * @return
	 */
	public static String MD5Encoding(String target, String md5Encode){
		StringBuffer buf = new StringBuffer("");
		try {
		    //生成实现指定摘要算法的 MessageDigest 对象。
		    MessageDigest md = MessageDigest.getInstance("MD5"); 
		    //使用指定的字节数组更新摘要。
		    md.update(target.getBytes());
		    //通过执行诸如填充之类的最终操作完成哈希计算。
		    byte b[] = md.digest();
		    //生成具体的md5密码到buf数组
		    int i;
		    for (int offset = 0; offset < b.length; offset++) {
		     i = b[offset];
		     if (i < 0)
		      i += 256;
		     if (i < 16)
		      buf.append("0");
		     buf.append(Integer.toHexString(i));
		    }
		    System.out.println("32位: " + buf.toString());// 32位的加密
		    System.out.println("16位: " + buf.toString().substring(8, 24));// 16位的加密，其实就是32位加密后的截取
		   } 
		   catch (Exception e) {
		    e.printStackTrace();
		   }
		return buf.toString();
	}
	
	/**
	 * 16位
	 * @param target
	 * @return
	 */
	public static String  MD5Encode16(String target){
		return MD5Encoding(target, MD5_16_ENCODEING);
	}
	
	/**
	 * 32位
	 * @param target
	 * @return
	 */
	public static String  MD5Encode32(String target){
		return MD5Encoding(target, MD5_32_ENCODEING);
	}
	
}
