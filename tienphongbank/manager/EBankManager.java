/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import static main.Main.INFORMATION_ACCOUNTS;
import model.EBank;

/**
 *
 * @author Admin
 */
public class EBankManager {

    private Scanner in = new Scanner(System.in);

    /**
     * Switch the interface language
     *
     * @param(eBank, locale)
     */
    public void switchLanguage(EBank eBank, Locale locale) {
        eBank.setLocate(locale);
    }

    /**
     * Allows the user to input the account number, password and captcha from the keyboard.
     * 
     * @param(eBank)
     */
    public void Login(EBank eBank) {
        // step 1: Input the account number
        String accountNumber = inputAccount(eBank);
        // step 2: Input the password
        String password = inputPassword(eBank);
        // step 3: Check acount and password is valid or not
        boolean resultAfterCheck = checkAccountAndPasswordValid(eBank, accountNumber, password);
        // Implement generate captcha and input captcha if 
        if (resultAfterCheck == true) {
            // step 4: Generate a random captcha code. If account and password is valid
            String captchaGenerate = eBank.generateCaptcha();
            // step 5: Input captcha
            String captchaInput = inputCaptcha(eBank, captchaGenerate);
            // Check the captcha
            String checkCaptcha = eBank.checkCaptcha(captchaInput, captchaGenerate);
            // If checkCaptcha equals captchaInput user entered, then return 
            if (checkCaptcha.equals(captchaInput)) {
                // If checkCaptcha equals checkCaptcha user entered, then return 
                System.out.println(eBank.bundle.getString("success") + "\n");
            } else {
                System.out.println(eBank.bundle.getString("errorCaptcha"));
                System.out.println(eBank.bundle.getString("fail") + "\n");
            }
        }
    }


    /**
     *Input the account number
     * 
     * @param(eBank)
     * @return String
     */
    public String inputAccount(EBank eBank) {
        // Loop until user input correct
        while (true) {
            try {
                System.out.print(eBank.bundle.getString("account"));
                String account = in.nextLine().trim();
                // Check the account number.
                String checkAccount = eBank.checkAccountNumber(account);
                // If checkAccount equals account user entered
                if (checkAccount.equals(account)) {
                    return account;
                }
                System.out.println(checkAccount);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Input the password
     * 
     * @param(eBank)
     * @return String
     */
    public String inputPassword(EBank eBank) {
        // Loop until user input correct
        while (true) {
            try {
                System.out.print(eBank.bundle.getString("password"));
                String password = in.nextLine().trim();
                // Check the password string.
                String checkPassword = eBank.checkPasswordString(password);
                // If checkPassword equals password user entered
                if (checkPassword.equals(password)) {
                    return password;
                }
                System.out.println(checkPassword);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Check acount and password valid
     * 
     * @param(eBank,accountNumber,password)
     * @return boolean
     */
    public boolean checkAccountAndPasswordValid(EBank eBank, String accountNumber, String password) {
        // Loop to access all information accounts
        for (String key : INFORMATION_ACCOUNTS.keySet()) {
            // Check if account number is exist or not
            if (accountNumber.equals(key)) {
                // Check password is correct or not
                if (password.equals(INFORMATION_ACCOUNTS.get(key))) {
                    return true;
                } else {
                    System.out.println(eBank.bundle.getString("passwordIncorrect") + "\n");
                    return false;
                }
            }
        }
        System.out.println(eBank.bundle.getString("accountDoesNotExist") + "\n");
        return false;
    }
    
    /**
     * Input captcha
     * 
     * @param(eBank,captchaGenerate)
     * @return String
     */
    public String inputCaptcha(EBank eBank, String captchaGenerate) {
        System.out.println(eBank.bundle.getString("captcha") + captchaGenerate);
        System.out.print(eBank.bundle.getString("enterCaptcha"));
        return in.nextLine().trim();
    }
}
