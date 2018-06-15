package cn.yh.st.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 32位加密
 * 
 * @author duyu
 * 
 */
public class MD5 {
	/***
	 * MD5加密 生成32位md5码
	 * 
	 * @param
	 * @return 返回32位md5码
	 */
	public static String md5Encode(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}


	}
	
	/**
	 * MD5
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(data);
		return md5.digest();
	}

	public String md5Encode_1(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			try {
				byte[] hashedBytes = md.digest(s.getBytes("UTF-8"));
				return this.convertByteArrayToHexString(hashedBytes);
			} catch (UnsupportedEncodingException e) {
				System.err.println("I'm sorry, but unsupported encoding");
				return "FAILED";
			}
		} catch (NoSuchAlgorithmException e) {
			System.err
					.println("I'm sorry, but MD5 is not a valid message digest algorithm");
			return "FAILED";
		}
	}

	private String convertByteArrayToHexString(byte[] hashedBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < hashedBytes.length; i++) {
			stringBuffer.append(Integer.toString(
					(hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}

	/**
	 * 测试主函数
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		if(md5Encode("123123").equalsIgnoreCase("9cc2253af4a2fe1a62ab842beaf7cdbe")){
			
		}
	}
}
