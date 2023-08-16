/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validator {

    private static Scanner in = new Scanner(System.in);

    /**
     * Get an integer in the range [min, max]
     *
     * @param (min, max)
     */
    public static int getInt(int min, int max) {
        // Loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                // result is only valid in range [min, max]
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please enter an integer number in the range[" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
}
