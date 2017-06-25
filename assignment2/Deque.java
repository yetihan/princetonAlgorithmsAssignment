//package fundamentals;

import java.util.Iterator;

/**
 * Created by hanzhou on 17/6/24.
 */

/**
 * todo list 只有一个元素为 first 的时候，removelast报错 fixed
 */

public class Deque<Item> implements Iterable<Item>{
    private Node first = null;
    private Node last = null;
    private int  N = 0;

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    private class dequeIterator implements Iterator<Item>  {
        private Node currentNode = first;

        public boolean hasNext() {
            return currentNode != null;
        }


        public Item next() {
            if(!hasNext()) throw  new java.util.NoSuchElementException();
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        /**
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public Deque()                           // construct an empty deque
    {}

    public boolean isEmpty()                 // is the deque empty?
    {
        return N == 0;
    }

    public int size()                        // return the number of items on the deque
    {
        return N;
    }
    public void addFirst(Item item)          // add the item to the front
    {
        if(item == null) throw  new java.lang.IllegalArgumentException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;

        if(oldFirst != null)oldFirst.prev = first;

        if(N == 0) last = first;
        if(N == 1) {
            first.next = last;
            last.prev = first;
        }
        N++;

    }


    public void addLast(Item item)           // add the item to the end
    {
        if(item == null) throw  new java.lang.IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;

        if(oldLast != null)oldLast.next = last; // 一直没写

        if(N == 0) first = last;
        if(N == 1) {
            first.next = last;
            last.prev = first;
        }
        N++;
    }

    public Item removeFirst()                // remove and return the item from the front
    {
        if(N==0) {
            throw new java.util.NoSuchElementException();
        }

        Node oldFirst = first;
        first = oldFirst.next;
        if(first != null)first.prev = null;
        N--;
        if(N == 1) first = last;
        if(N == 0) last = null;
        return oldFirst.item;
    }

    public Item removeLast()                 // remove and return the item from the end
    {

        if(N==0)
            throw new java.util.NoSuchElementException();
        Node oldLast = last;
        last = oldLast.prev;
        if(last != null)last.next = null;
        N--;
        if(N == 1) last = first;
        if(N == 0) first = null;
        return oldLast.item;
    }

    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new dequeIterator();
    }

    public static void main(String[] args)   // unit testing (optional)
    {
        Deque deque = new Deque();
        deque.addFirst(1);
        System.out.println("size:" + deque.size());
        deque.addLast(2);
        System.out.println("size:" + deque.size());
        deque.removeFirst();
        System.out.println("size:" + deque.size());
        deque.removeLast();
        System.out.println("size:" + deque.size());

        for (Iterator a = deque.iterator();a.hasNext();) {
            System.out.println(a.next());
        }
    }
}
