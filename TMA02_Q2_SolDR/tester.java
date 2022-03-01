public class tester{


    public static void main(String[] args) {
        Thesaurus th = new Thesaurus();

        th.populate();
        th.addSynonym("happy", "good");
        th.print();
        th.addSynonym("think", "ponder");
        th.addSynonym("must", "need to");
        th.addSynonym("think", "thunk");
        th.print();
        th.replaceWord("happy", "this man is very happy because he has a car.");
        th.crossReference();
        th.print();
    }
}