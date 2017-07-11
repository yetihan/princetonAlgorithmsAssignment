//package sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by hanzhou on 17/7/10.
 */
public class Board {
    private int dimension;
    private int[][] blocks;
    private int hamming;
    private int manhattan;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks){
        this.dimension = blocks.length;
        this.blocks = new int[dimension][dimension];

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++)
                this.blocks[i][j] = blocks[i][j];
        }

        hamming = 0;
        manhattan = 0;

        int count = 1;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++){
                if(blocks[i][j] != count && blocks[i][j] != 0){
                    hamming ++;
                    int m = (blocks[i][j]-1)/(dimension);
                    int n = (blocks[i][j]-1)%(dimension);
                    manhattan += (Math.abs(m-i)+Math.abs(n-j));
                }
                count++;

            }
        }
    }


    private Board(int[][] blocks,int i1,int j1, int i2, int j2){
        this.dimension = blocks.length;
        this.blocks = new int[dimension][dimension];

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++)
                this.blocks[i][j] = blocks[i][j];
        }

        this.blocks[i1][j1] = this.blocks[i2][j2];
        this.blocks[i2][j2] = blocks[i1][j1];

        hamming = 0;
        manhattan = 0;

        int count = 1;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++){
                if(this.blocks[i][j] != count && this.blocks[i][j] != 0){
                    hamming ++;
                    int m = (this.blocks[i][j]-1)/(dimension);
                    int n = (this.blocks[i][j]-1)%(dimension);
                    manhattan += (Math.abs(m-i)+Math.abs(n-j));
                }
                count++;
            }
        }
    }


    // board dimension n
    public int dimension(){
        return dimension;
    }

    // number of blocks out of place
    public int hamming(){
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan(){
        return manhattan;
    }


    // is this board the goal board?
    public boolean isGoal(){
        int count = 1;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if(this.blocks[i][j] != count && this.blocks[i][j] != 0)
                    return false;
                count++;
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin(){
        Board twin;
        if (blocks[0][0] != 0 && blocks[0][1] != 0) {
            twin = new Board(blocks, 0, 0, 0, 1);
        } else if (blocks[0][0] != 0 && blocks[1][0] != 0) {
            twin = new Board(blocks, 0, 0, 1, 0);
        } else {
            twin = new Board(blocks, 0, 1, 1, 0);
        }
        return twin;
    }

    // does this board equal y?
    public boolean equals(Object y){
        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass())
            return false;
        Board that = (Board) y;
        if (that.dimension != this.dimension)
            return false;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (that.blocks[i][j] != this.blocks[i][j])
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        Queue<Board> neighbors = new Queue<Board>();
        int blankI = 0;
        int blankJ = 0;

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if(blocks[i][j] == 0){
                    blankI = i;
                    blankJ = j;
                }
            }
        }

        if(blankI > 0)
            neighbors.enqueue(new Board(this.blocks, blankI, blankJ, blankI-1, blankJ));
        if(blankJ > 0)
            neighbors.enqueue(new Board(this.blocks, blankI, blankJ, blankI, blankJ-1));
        if(blankI < dimension - 1)
            neighbors.enqueue(new Board(this.blocks, blankI, blankJ, blankI+1, blankJ));
        if(blankJ < dimension -1 )
            neighbors.enqueue(new Board(this.blocks, blankI, blankJ, blankI, blankJ+1));
        return neighbors;
    }

    // string representation of this board (in the output format specified below)
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }


    // unit tests (not graded)
    public static void main(String[] args){
        In in = new In(args[0]);
        int n = in.readInt();
        System.out.println("阶数:"+n);
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                blocks[i][j] = in.readInt();
                // StdOut.println(blocks[i][j]);
            }
        Board initial = new Board(blocks);

//        StdOut.println(initial);
//        StdOut.println("manhattan:"+initial.manhattan());
        StdOut.println("hamming:"+initial.hamming());
//        StdOut.println("");
//        StdOut.println("neighbors");
//        for (Board neighbor : initial.neighbors()) {
//            StdOut.println(neighbor);
//            StdOut.println("manhattan:" + neighbor.manhattan());
//        }
    }
}
