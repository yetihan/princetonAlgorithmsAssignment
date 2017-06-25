import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);

        RandomizedQueue rq = new RandomizedQueue();

        for (String s : StdIn.readAllStrings() ) {
            rq.enqueue(s);   
        }
        

        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }

    }
}
