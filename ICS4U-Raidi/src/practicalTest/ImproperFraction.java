/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalTest;

/**
 *
 * @author 1dingrai
 */
public class ImproperFraction extends Fraction {

    public ImproperFraction(int numerator, int denominator) {
        super(numerator, denominator);

        if (denominator < 1) {
            numerator *= -1;
            denominator *= -1;
        }

        if (Math.abs(numerator) < Math.abs(denominator)) {
            denominator = (int) (Math.random() * numerator + 1);
            System.out.println("Invalid proper fraction.");
            System.out.println("A new denominator of " + denominator + " was generated.");
        }
        super.reduce();
    }

    public int toMixed() {

    }

}
