import edu.princeton.cs.algs4.In;

/**
 * Created by hanzhou on 17/6/18.
 */
public class Test {
    public static void main(String[] args){
        In in = new In(args[0]);
        int[] arr = in.readAllInts();
        Percolation percolation=new Percolation(arr[0]);
        for(int i=1;i<arr.length;i+=2){
            percolation.open(arr[i],arr[i+1]);
            if(percolation.isFull(18,1)){
                System.out.println(percolation.numberOfOpenSites());
            }
        }
	System.out.println("isFull(19,1):"+percolation.isFull(19,1));
	System.out.println("isFull(18,2):"+percolation.isFull(18,2));
    }
}
