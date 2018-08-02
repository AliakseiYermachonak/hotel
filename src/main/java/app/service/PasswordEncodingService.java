package app.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class for encrypting the users password.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class PasswordEncodingService {

    /**
     * Encrypts the password and returns hash as a String.
     * @param key String real line
     * @return String encrypted
     */
    public String encrypt(String key){
        if (key == null)
            return "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (md != null)
            return new String(md.digest());
        else
            return "";
    }

}
