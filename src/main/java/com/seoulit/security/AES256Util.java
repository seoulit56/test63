package com.seoulit.security;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AES256Util {
	private final String iv;
	private final Key keySpec;

    Encoder encoder = Base64.getEncoder();
    Decoder decoder = Base64.getDecoder();
    
   
	/**
	 * 16자리의 키값을 입력하여 객체를 생성한다.
	 * 
	 * @param key
	 *            암/복호화를 위한 키값
	 * @throws UnsupportedEncodingException
	 *             키값의 길이가 16이하일 경우 발생
	 */
	final static String key = "1234567890!@#$%^";

	public AES256Util() throws UnsupportedEncodingException {
		this.iv = key.substring(0, 16);
		final byte[] keyBytes = new byte[16];
		final byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		final SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		this.keySpec = keySpec;
	}

	public String encrypt(final String str) {
        try {
		    final Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		    final byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
		    final String enStr = new String(encoder.encode(encrypted));
            return enStr;
        } catch(Exception e){
            throw new EncryptorsException(e.getMessage());
        }
	}


	public String decrypt(final String str) {
        try {
		    final Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		    final byte[] byteStr = decoder.decode(str.getBytes());
            return new String(c.doFinal(byteStr), "UTF-8");
        } catch(Exception e){
            throw new EncryptorsException(e.getMessage());
        }
	}    
}