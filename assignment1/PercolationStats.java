//package fundamentals;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;



/**
 * Created by hanzhou on 17/6/18.
 */
public class PercolationStats {
    private double[] thresholds;

    public PercolationStats(int n, int trials)   // perform trials independent experiments on an n-by-n grid
    {
        if(n<1 || trials<1) throw new java.lang.IllegalArgumentException();
        thresholds = new double[trials];
        int open_row;
        int open_col;

        for(int i=0;i<trials;i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                open_row = StdRandom.uniform(1, n + 1);
                open_col = StdRandom.uniform(1, n + 1);
                if (percolation.isOpen(open_row, open_col)) continue;
                percolation.open(open_row, open_col);
            }
            thresholds[i] = (double)percolation.numberOfOpenSites()/(n*n);
        }
    }

    public double mean()                          // sample mean of percolation threshold
    {
        return StdStats.mean(thresholds);
    }
    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return mean() - (1.96 * stddev())/Math.sqrt(thresholds.length);
    }

    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return mean() + (1.96 * stddev())/Math.sqrt(thresholds.length);
    }

    public static void main(String[] args)        // test client (described below)
    {
//        mean                    = 0.5929934999999997
//        stddev                  = 0.00876990421552567
//        95% confidence interval = [0.5912745987737567, 0.5947124012262428]

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

//        int n = 200;
//        int trials = 100;

        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println("mean                     "+percolationStats.mean());
        System.out.println("stddev                   "+percolationStats.stddev());
        System.out.println("95% confidence interval ="+"["+ percolationStats.confidenceLo() + ","+percolationStats.confidenceHi()+"]");

    }
}
