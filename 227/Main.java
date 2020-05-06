public class Main {

    public static void main(String[] args) {
        char[] table = {
                'S', 'A', 'I', 'D',
                'P', 'A', 'L', 'S',
                'T', 'A', 'N', 'A',
                'I', 'A', 'S', 'S'
        };
        //Dictionary of valid words
        String[] dictionary = {
                "SAID",
                "PAID",
                "PALS",
                "TAN",
                "SLID",
                "TANAY",
                "SLIDS",
        };
        Boggle b = new Boggle(table, dictionary);
        System.out.println(b.findPossibleWords().toString());
        //Ideally should print [SAID, PAID, PALS, TAN, SLID]
    }
}
