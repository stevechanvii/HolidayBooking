/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author stevechanvii
 */
public class HashString {

    public String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = password;

        // Change this to UTF-16 if needed
        md.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));

        return hex;
    }

}
