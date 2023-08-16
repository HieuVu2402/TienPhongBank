/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;


/**
 *
 * @author Admin
 */
public class EBank {
    private Locale locale;
    public ResourceBundle bundle = null;

    public EBank() {
        this.locale = new Locale("en");
        String baseName = "language/Language";
        bundle = ResourceBundle.getBundle(baseName, this.locale);
    }

    public void setLocate(Locale locale) {
        this.locale = locale;
        String baseName = "language/Language";
        bundle = ResourceBundle.getBundle(baseName, this.locale);
    }

    /**
     * Check the account number.
     *
     * @param(acount)
     * @return String
     */
    public String checkAccountNumber(String account) {
        // Check account number must be a number and must have 10 digits
        if (!account.matches("[0-9]{10}")) {
            return bundle.getString("errorAcount");
        }
        return account;//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Check the password string.
     *
     * @param (password)
     * @return String
     */
    public String checkPasswordString(String password) {
        // Password must be between 8 and 31 characters and must be alphanumeric
        // where: 
        // (?=.*[0-9]) Check password has at least 1 digit
        // (?=.*[a-zA-Z]) Check password has at least 1 character in alphabet
        // \\w{8,31} Check format string must be  between 8 and 31 characters and contains digits and character uppercase and lowercase 
        if (!password.matches("(?=.*[0-9])(?=.*[a-zA-Z])\\w{8,31}")) {
            return bundle.getString("errorPassword");
        }
        return password;
    }


    /**
     * Generate a random captcha code.
     *
     * @return String
     */
    public String generateCaptcha() {
        Random random = new Random();
        int captchaLength = 5;
        StringBuilder characters = new StringBuilder("");
        StringBuilder captcha = new StringBuilder("");
        // Loop to append digits at the end of characters 
        for (char i = '0'; i <= '9'; i++) {
            characters.append(i);
        }
        // Loop to append abphabet lowercase at the end of String characters
        for (char i = 'a'; i <= 'z'; i++) {
            characters.append(i);
        }
        // Loop to append abphabet uppercase at the end of String characters 
        for (char i = 'A'; i <= 'Z'; i++) {
            characters.append(i);
        }
        // Loop to get random captcha with the length is 5
        for (int i = 0; i < captchaLength; i++) {
            char character = characters.charAt(random.nextInt(characters.length()));
            captcha.append(character);
        }
        return captcha.toString();
    }

    /**
     * Check the captcha
     *
     * @param(captchaInput,captchaGenerate)
     * @return String
     */
    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        // check captcha input is not empty or captchaGenerate contains captchaInput 
        if (captchaInput.isEmpty() || !captchaGenerate.contains(captchaInput)) {
            return bundle.getString("errorCaptcha");
        }
        return captchaInput;
    }
}
