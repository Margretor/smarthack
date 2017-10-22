package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordHandler {

    public static String randomString(int size) {
        Random r = new Random();
        String result = "";
        for ( int i = 0; i < size; ++i ) {
            result += Constants.alfabet.charAt(r.nextInt(Constants.lungimeAlfabet));
        }
        return result;
    }

    public static byte[] encrypt(String passw) {
        try {
            byte[] buffer = passw.getBytes();
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-512");
            md.update(buffer);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = Constants.hexArray[v >>> 4];
            hexChars[j * 2 + 1] = Constants.hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String generate() {
        return bytesToHex(encrypt(randomString(Constants.passwSize)));
    }

    public static String encryptPass(String password) {
        return bytesToHex(encrypt(password));
    }

    public static boolean compare(String clean, String crypted) {
        String encrypted = bytesToHex(encrypt(clean));
        return encrypted.equals(crypted);
    }

}