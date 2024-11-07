package bibliotecas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptaciones {
	public static String encriptarConSHA256(String contrasena) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(contrasena.getBytes("UTF-8"));
			
			// Conversión a hexadecimal
			StringBuilder hexString = new StringBuilder();

			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException ex) {
			throw new RuntimeException(ex);
		}
	}

}
