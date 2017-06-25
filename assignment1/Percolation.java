import edu.princeton.cs.algs4.WeightedQuickUnionUF;


/**
 * Created by hanzhou on 17/6/18.
 */


public class Percolation {
    private boolean[] status;
    private int order;
    private int edgeLength;
    private int virtualTopSite;
    private int virtualBottomSite;
    private WeightedQuickUnionUF quick_union;
    private WeightedQuickUnionUF fullness;
    public Percolation(int n)               // create n-by-n grid, with all sites blocked
    {
        if(n <= 0) throw new java.lang.IllegalArgumentException();
        int num = n*n+2;
        virtualTopSite = 0;
        virtualBottomSite = num -1;
        edgeLength = n;
        quick_union = new WeightedQuickUnionUF(num);
        fullness = new WeightedQuickUnionUF(num-1);

        status = new boolean[num];


        for(int i=1; i <= num-2; i++ ){
            status[i] = false;
        }
        status[virtualTopSite] = true;
        status[virtualBottomSite] = true;


        //虚拟顶site,连通最上面一层所有site id[0]

        for(int i = 1; i<= edgeLength; i++){
            quick_union.union(virtualTopSite,i);
            fullness.union(virtualTopSite,i);
        }
    }

    public  void open(int row, int col)    // open site (row, col) if it is not open already
    {
        if (!isIndexLegel(row, col)) throw new java.lang.IndexOutOfBoundsException();
        if (isOpen(row, col)) return;
        else {
            if(row==edgeLength){quick_union.union(calOrder(row,col),virtualBottomSite);}
            int order1 = calOrder(row, col);
            status[order1] = true;

            if (isIndexLegel(row - 1, col) && isOpen(row - 1, col)) {
                quick_union.union(order1, order1 - this.edgeLength);
                fullness.union(order1, order1 - this.edgeLength);
            }
            if (isIndexLegel(row + 1, col) && isOpen(row + 1, col)) {
                quick_union.union(order1, order1 + this.edgeLength);
                fullness.union(order1, order1 + this.edgeLength);
            }
            if (isIndexLegel(row, col - 1) && isOpen(row, col - 1)) {
                quick_union.union(order1, order1 - 1);
                fullness.union(order1, order1 - 1);
            }
            if (isIndexLegel(row, col + 1) && isOpen(row, col + 1)) {
                quick_union.union(order1, order1 + 1);
                fullness.union(order1, order1 + 1);
            }
        }
    }


    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        if(!isIndexLegel(row,col)) throw new java.lang.IndexOutOfBoundsException();

        return status[calOrder(row,col)];
    }

    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        if(!isIndexLegel(row,col)) throw new java.lang.IndexOutOfBoundsException();
        order = calOrder(row, col);
        if(fullness.connected(0, order) && isOpen(row, col))
            return true;
        else
            return false;
    }

    public int numberOfOpenSites()       // number of open sites
    {
        int sum = 0;
        for (int i = 1; i <= edgeLength*edgeLength;i++){
            if(status[i]) sum++;}
        return sum;}

    public boolean percolates()              // does the system percolate?
    {
        if(edgeLength>1)
            return quick_union.connected(virtualTopSite,virtualBottomSite);
        else
            return isOpen(1,1);
    }

    private boolean isIndexLegel(int row, int col){
        if(row>=1 && row<=edgeLength && col>=1 && col<=edgeLength)
            return true;
        else
            return false;
    }

    private int calOrder(int row, int col){
        return (row-1)*edgeLength + col;
    }

    public static void main(String[] args)   // test client (optional)
    {
        Percolation percolation = new Percolation(6);
        percolation.open(1,6);//6
        percolation.open(2,6);//12
        percolation.open(3,6);//18
        percolation.open(4,6);//24
        percolation.open(5,6);//30
        percolation.open(6,6);//34

        percolation.open(5,2);
        percolation.open(6,2);
        percolation.isFull(5,2);


        System.out.println("18,24导电否:"+percolation.quick_union.connected(18,24));
        System.out.println("24,30导电否:"+percolation.quick_union.connected(24,30));
        System.out.println("30,37导电否:"+percolation.quick_union.connected(28,34));

        System.out.println("导电否:"+percolation.isFull(5,2));
        System.out.println("open_num:"+percolation.numberOfOpenSites());
    }
}

