//package fundamentals;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;


/**
 * Created by hanzhou on 17/6/24.
 *
 * Performance requirements.
 * Your randomized queue implementation must support each randomized queue operation
 * (besides creating an iterator) in constant amortized time. That is, any sequence
 * of m randomized queue operations (starting from an empty queue) should take at
 * most cm steps in the worst case, for some constant c. A randomized queue containing
 * n items must use at most 48n + 192 bytes of memory. Additionally, your iterator
 * implementation must support operations next() and hasNext() in constant worst-case time;
 * and construction in linear time; you may (and will need to) use a linear amount of
 * extra memory per iterator.
 * 为了常数时间 完成 出队 必须使用 数组实现,使用链表一定不是常数时间
 * 另外反正顺序没意义,出队的时候,把出队的位置用数组的最后一个元素代替,数组的size 就可以减一了.
 *
 * 在思考返回iterator,使用了泛型
 */

public class RandomizedQueue<Item> implements Iterable<Item>{
    private int N;
    private Object[] arr;
    private int capacity = 1;




    private class RandomIterator implements Iterator{
        Object[] randomArr = new Object[N];
        int k = 0;


        public RandomIterator(){
            int[] arrIndex = new int[N];
            for (int j = 0; j < N; j++) arrIndex[j] = j;
            StdRandom.shuffle(arrIndex);
            for (int i = 0; i < N; i++) randomArr[i] = arr[arrIndex[i]];
        }

        @Override
        public boolean hasNext() {
            return k < N;
        }

        @Override
        public Object next() {
            if(!hasNext()) throw new java.util.NoSuchElementException();
            return (Item) randomArr[k++];
        }

        @Override
        public void remove() {
            throw  new java.lang.UnsupportedOperationException();

        }
    }

    private void resize(int capacity){
        Object[] copy = new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    public RandomizedQueue() {
        arr = (Item[])new Object[capacity];
    }



    public boolean isEmpty()                 // is the queue empty?
    {
        return N == 0;
    }


    public int size()                        // return the number of items on the queue
    {
        return N;
    }

    public void enqueue(Item item)           // add the item
    {
        if(item == null) throw  new IllegalArgumentException();
        if(N == arr.length) resize(2*N);
        arr[N++] = item;
    }

    public Item dequeue()                    // remove and return a random item
    {
        if(N == 0) throw  new  java.util.NoSuchElementException();
        if(N > 8 && N == arr.length/4) resize(2*N);
        int i = StdRandom.uniform(N);
        Item item = (Item) arr[i];
        arr[i] = arr[--N];
        arr[N] = null;

        return item;
    }

    public Item sample()                     // return (but do not remove) a random item
    {
        if(N == 0) throw new java.util.NoSuchElementException();
        int i = StdRandom.uniform(N);
        return (Item) arr[i];

    }

    public Iterator<Item> iterator()          // return an independent iterator over items in random order
    {
// 这种实现只能返回 Object数据
//        int[] arrIndex = new int[N];
//        StdRandom.shuffle(arrIndex);
//        Object[] arrRandom = new Object[N];
//        for (int i = 0; i < N; i++) arrRandom[i] = arrIndex[i];
//        return arrRandom;
        return new RandomIterator();

    }

    public static void main(String[] args)   // unit testing (optional)
    {
        RandomizedQueue rq = new RandomizedQueue();

        System.out.println("dequeue:" + rq.dequeue());

        for(Iterator iter = rq.iterator();iter.hasNext();){
        System.out.println(iter.next());
    }


    }

}
