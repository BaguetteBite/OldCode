/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

/**
 *
 * @author 1dingrai
 */
public class BirdsRecord implements BirdsInterface {

    /*Birds: 
    Osprey, 6 characters - Pandion haliaetus, 17 chars
    griffon vulture, 15 characters - Gyps fulvus, 11 chars
    barn owl,8 characters - Tyto alba, 9 chars
    chicken, 7 characters - Gallus gallus domesticus, 24 chars
    Adelie penguin, 14 characters - Pygoscelis adeliae, 18 chars
    little gull, 11 characters - Hydrocoloeus minutus, 20 chars
    goldcrest, 9 characters - Regulus regulus, 15 chars
    shoebill, 8 characters - Balaeniceps rex, 15 chars
     */
    public static final int FILE_RECORD_SIZE = 97;
    public static final int COMMON_RECORD_SIZE = 15;
    public static final int SCIENTIFIC_RECORD_SIZE = 24;

    int id;
    String commonName;
    String scientificName;
    double populationInMillions;
    int wingspan;
    int maxLifespan;
    boolean birdOfPrey;

    //Char is Y for if the bird exists in America, N if not.
    char inAmerica;

    

    public BirdsRecord(String commonName, String scientificName, double populationinMillions,
             int wingspan, int maxLifespan, boolean birdOfPrey, char inAmerica) {
        this();
        this.setCommonName(commonName);
        this.setScientificName(scientificName);
        this.populationInMillions = populationinMillions;
        this.wingspan = wingspan;
        this.maxLifespan = maxLifespan;
        this.birdOfPrey = birdOfPrey;
        this.inAmerica = inAmerica;
        id = -1;
    }

    public BirdsRecord() {
        this.id = -1;
    }

    BirdsRecord(String string, String string0, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getInAmerica() {
        return inAmerica;
    }

    public void setInAmerica(char inAmerica) {
        this.inAmerica = inAmerica;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        StringBuilder temp = new StringBuilder();
        
        if (commonName != null) {
            temp.append(commonName.trim());
        } else {
            temp.append("TBD");
        }
        
        temp.setLength(COMMON_RECORD_SIZE);
        this.commonName = temp.toString();
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
         StringBuilder temp = new StringBuilder();
        
        if (scientificName != null) {
            temp.append(scientificName.trim());
        } else {
            temp.append("TBD");
        }
        
        temp.setLength(SCIENTIFIC_RECORD_SIZE);
        this.scientificName = temp.toString();
    }

    public double getPopulationInMillions() {
        return populationInMillions;
    }

    public void setPopulationInMillions(double populationInMillions) {
        this.populationInMillions = populationInMillions;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getLongestLifespan() {
        return maxLifespan;
    }

    public void setLongestLifespan(int longestLifespan) {
        this.maxLifespan = longestLifespan;
    }

    public boolean isBirdOfPrey() {
        return birdOfPrey;
    }

    public void setBirdOfPrey(boolean birdOfPrey) {
        this.birdOfPrey = birdOfPrey;
    }

    public void writeBirds(BirdsRecord b, RandomAccessFile birdsFile) throws IOException
    {
        birdsFile.writeChars(b.getCommonName());
        birdsFile.writeChars(b.getScientificName());
        birdsFile.writeDouble(b.getPopulationInMillions());
        birdsFile.writeInt(b.getWingspan());
        birdsFile.writeInt(b.getLongestLifespan());
        birdsFile.writeBoolean(b.isBirdOfPrey());
        birdsFile.writeChar(b.getInAmerica());
    }
    
    public boolean isValid() {
        return true;
    }
    
    @Override
    public String toString() {
        String s = "\n ---------- \n";

        s += "Common name: " + commonName + "\n";
        s += "Scientific name: " + scientificName + "\n";
        s += "Population in millions: " + populationInMillions + "\n";
        s += "Max wingspan: " + wingspan + "\n";
        s += "Max lifespan: " + maxLifespan + "\n";
        s += "Bird of prey: " + birdOfPrey + "\n";
        s += "In America? " + inAmerica + "\n";

        return s;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final BirdsRecord other = (BirdsRecord) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.populationInMillions) != Double.doubleToLongBits(other.populationInMillions)) {
            return false;
        }
        if (this.wingspan != other.wingspan) {
            return false;
        }
        if (this.maxLifespan != other.maxLifespan) {
            return false;
        }
        if (this.birdOfPrey != other.birdOfPrey) {
            return false;
        }
        if (this.inAmerica != other.inAmerica) {
            return false;
        }
        if (!Objects.equals(this.commonName, other.commonName)) {
            return false;
        }
        if (!Objects.equals(this.scientificName, other.scientificName)) {
            return false;
        }
        return true;
    }
    
}
