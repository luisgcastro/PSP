package encriptar;

import java.util.Arrays;

import javax.crypto.Cipher;

import javax.crypto.SecretKey;

import javax.crypto.spec.SecretKeySpec;

import java.security.MessageDigest;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class Principal {
	
	public static void main(String[] args) {
		 
		String encriptado = Encriptar("linea 4 del fichero");
		
		System.out.println(encriptado);
		
		String desencriptado = Desencriptar(encriptado);
		
		System.out.println(desencriptado);
		
	}
		
	
	
	

	private static String Encriptar(String texto) {
		
		String secretKey = "demasiadossecretos2"; //llave para encriptar datos 
		
		String base64EncryptedString = "";
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			
			
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			
			Cipher cipher = Cipher.getInstance("DESede");
			
			cipher.init(cipher.ENCRYPT_MODE, key);
			
			
			byte[] plainTextBytes = texto.getBytes("utf-8");
			
			byte[] buf = cipher.doFinal(plainTextBytes);
			
			byte[] base64Bytes = Base64.encodeBase64(buf);
			
			base64EncryptedString = new String(base64Bytes);
			
		} catch (Exception ex) {
			
		}
		
		return base64EncryptedString;
		
	}
			
	
	private static String Desencriptar(String textoEncriptado) {
		// TODO Auto-generated method stub
	
		
		String secretKey = "demasiadossecretos2"; //llave para desencriptar datos
		
		String base64EncryptedString = "";
		
		try {
			
			byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			
			
			Cipher decipher = Cipher.getInstance("DESede");
			
			decipher.init(Cipher.DECRYPT_MODE, key);
			
			byte[] plainText = decipher.doFinal(message);
			
			base64EncryptedString = new String(plainText, "UTF-8");
			
		} catch (Exception ex) {
			
				
		}
		
		return base64EncryptedString;

			
		}
	
	
	

}
