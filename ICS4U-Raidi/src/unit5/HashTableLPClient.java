package unit5;

/**
 *
 * @author 1dingrai
 */
public class HashTableLPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HasthTableLP table = new HasthTableLP();
        Student s1 = new Student("Raidi", "Ding");
        s1.setStudentNumber(6);

        //CASE 1: TABLE IS EMPTY
        assert table.capacity() == 53;
        assert table.isEmpty();
        assert table.size() == 0;
        assert (!table.contains(s1));
        assert (!table.containsKey(4));

        //CASE 2: FILL THE TABLE WITHOUT OVERLOADING
        Student s2 = new Student("Raidi", "Ding");
        for (int i = 0; i < (table.capacity() * 0.75) - 1; i++) {

            s2.setStudentNumber(6 + i);

            table.put(s2.getStudentNumber(), s2);

            assert table.capacity() == 53;
            assert (!table.isEmpty());
            assert table.size() == i + 1;
        }

        //CASE 3: OVERLOAD THE TABLE
        Student s3 = new Student("Rai", "Ding");
        s3.setStudentNumber(8);
        table.put(s3.getStudentNumber(), s3);

        Student s4 = new Student("Rai2", "Ding2");
        s4.setStudentNumber(8124124);
        table.put(s4.getStudentNumber(), s4);

        assert table.capacity() == 163;
        assert (!table.isEmpty());
        assert table.size() == 41;
        assert (table.contains(s3));
        assert (table.containsKey(8));

        //CASE 5: EMPTY THE TABLE WITH MAKEEMPTY
        assert table.size() == 41;
        table.makeEmpty();

        assert table.capacity() == 163;
        assert table.size() == 0;
        assert (!table.contains(s3));
        assert (!table.containsKey(4));

    }

}
