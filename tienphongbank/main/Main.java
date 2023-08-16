package main;


import java.util.HashMap;
import model.EBank;
import java.util.Locale;
import manager.EBankManager;
import validate.Validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Main {

    public final static Locale VI = new Locale("vi");
    public final static Locale EN = new Locale("en");

    public final static HashMap<String, String> INFORMATION_ACCOUNTS = new HashMap<>();
    // Information accounts
    static {
        INFORMATION_ACCOUNTS.put("1234567890", "123456ab");
        INFORMATION_ACCOUNTS.put("0337607098", "Phuong1009");
        INFORMATION_ACCOUNTS.put("0362407489", "anhpt1807");
    }

    public static void main(String[] args) {
        EBank eBank;
        EBankManager eBankManager = new EBankManager();
        while (true) {
            eBank = new EBank();
            // Step 1: Get choice options from Login Program
            showLoginProgam();
            int choice = Validator.getInt(1, 3);
            switch (choice) {
                case 1:
                    // Step 2: If the user selects 1: Switch the interface language to Vietnamese
                    eBankManager.switchLanguage(eBank, VI);
                    // Login: Allows the user to input the account number, password and captcha from the keyboard.
                    eBankManager.Login(eBank);
                    break;

                case 2:
                    // Step 3: If the user selects 2: Keep the English interface
                    // Login: Allows the user to input the account number, password and captcha from the keyboard.
                    eBankManager.Login(eBank);
                    break;

                case 3:
                    // Step 4: If the user selects 3. Exit Login Program
                    return;
            }
        }
    }

    /**
     * Login Program
     */
    private static void showLoginProgam() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }
}
