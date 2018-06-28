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
public class FractionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProperFraction f1 = new ProperFraction(5, 10);
        ProperFraction f2 = new ProperFraction(3, 4);
        Fraction f3 = new Fraction(1, 2);
        Fraction f4 = new Fraction(3, 8);
        ProperFraction f5 = new ProperFraction(10, 2);

        assert (f1.size() == 0.5);

        assert (f2.larger(f1).equals(f2));
        assert (f3.larger(f1).equals(f3));

        assert (f2.times(f3).equals(f4));

        f1.reduce();
        f1.invert();

    }

}
