package com.self.org.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Evan Savage <savage.evan@gmail.com>
 * 
 * Utility methods for string manipulation.
 */
public class StringUtils {
    private static String HEX_DIGITS = "0123456789abcdef";
    
    /**
     * @return  hex string representing byteData, two characters per byte
     */
    public static String toHexString(byte[] byteData) {    
        StringBuffer sb = new StringBuffer();
        for (byte b : byteData) {
            sb.append(HEX_DIGITS.charAt((b & 0xf0) >>> 4));
            sb.append(HEX_DIGITS.charAt(b & 0xf));
        }
        return sb.toString();
    }
    
    /**
     * 
     * @param str  string to hash
     * @param algorithm  hash algorithm to use on the string
     * @return  hex-encoded hash of the given string using the given algorithm
     * @throws NoSuchAlgorithmException  if the hash algorithm is not provided
     */
    public static String toHexHash(String str, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            return toHexString(byteData);
        } catch (NoSuchAlgorithmException e) {
            // NOTE: we rethrow this unchecked so callers don't have to handle
            // NoSuchAlgorithmException.
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 
     * @param str  original string
     * @return  string encoded in UTF-8
     * @throws UnsupportedEncodingException  never
     */
    public static String toUTF8(String str) {
        try {
            return new String(str.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // NOTE: this should never happen, as UTF-8 is a recognized valid
            // encoding.
            throw new RuntimeException(e);
        }
    }
    
    /**
     * "Linkifies" a string, converting occurrences of linkText to links:
     * 
     * <a href="${linkUrl }">${linkText }</a>
     * 
     * These links are identified as Pair<String, String> objects, with the first element
     * set to "link".  Text spans have their first element set to "span".
     * 
     * @param text  string to linkify
     * @param linkText  text of links
     * @param linkUrl  href URL of links
     * @return  sequence of Pair<String, String> objects denoting raw text or link segments
     *          within the original string
     */
    public static List<Pair<String, String>> linkify(String text, String linkText, String linkUrl) {
        List<Pair<String, String>> tokens = new ArrayList<Pair<String, String>>();
        int start = 0;
        int end = text.indexOf(linkText);
        while (end != -1) {
            if (start != end) {
                tokens.add(Pair.of("span", text.substring(start, end)));
            }
            tokens.add(Pair.of("link", linkText));
            start = end + linkText.length();
            end = text.indexOf(linkText, start);
        }
        if (start < text.length()) {
            tokens.add(Pair.of("span", text.substring(start)));
        }
        return tokens;
    }
}
