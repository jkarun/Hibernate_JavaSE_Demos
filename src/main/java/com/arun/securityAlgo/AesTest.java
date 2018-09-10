package com.arun.securityAlgo;

public class AesTest {

	public static void main(String[] args) {
		final String secretKey = "@run";
	     
	    String originalString = "Arun prasath jk";
	    String encryptedString = AES.encrypt(originalString, secretKey) ;
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
	     
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	    
	}

}
