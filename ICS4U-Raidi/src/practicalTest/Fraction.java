package practicalTest;

/**
 *
 * @author 1dingrai
 */
public class Fraction implements FractionInterface {

    protected int num;
    protected int den;

    public Fraction(int numerator, int denominator) {
        num = numerator;
        den = denominator;
    }

    public Fraction() {
        num = (int) (Math.random() * 100) + 1;
        den = (int) (Math.random() * 100) + 1;

    }

    @Override
    public double size() {

        return (double) num / (double) den;
    }

    @Override
    public Fraction larger(Fraction f) {
        double sizeF = f.size();
        double sizeThis = this.size();

        if (sizeF == sizeThis || sizeF < sizeThis) {
            return this;
        }

        f.reduce();
        return f;

    }

    @Override
    public Fraction larger(Fraction f, Fraction g) {

    }

    @Override
    public Fraction times(Fraction f) {
        int numF = f.num;
        int denF = f.den;

        int numTotal = numF * num;
        int denTotal = denF * den;

//        System.out.println("Num total = " + numTotal);
//        System.out.println("Den total = " + denTotal);
        Fraction newF = new Fraction(numTotal, denTotal);

        newF.reduce();
        return newF;
    }

    @Override
    public Fraction times(Fraction f, Fraction g) {

    }

    @Override
    public void reduce() {
        int smaller;
        if (num > den) {
            smaller = den;
        } else {
            smaller = num;
        }

        for (int i = smaller; i > 0; i--) {
            if (num % i == 0 && den % i == 0) {
                num /= i;
                den /= i;
            }
        }
        this.toString();
    }

    @Override
    public String toString() {
        String s = " ";
        s += num + "\n";
        s += "---" + "\n";
        s += " " + den;

        System.out.println(s);
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public void invert() {
        int temp = num;

        num = den;
        den = temp;

        this.reduce();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        if (this.num != other.num) {
            return false;
        }
        if (this.den != other.den) {
            return false;
        }
        return true;
    }

}
