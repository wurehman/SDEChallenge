package com.paytm.challenge;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * Implementation of MovingAverage Interface. SimpleMovingAverage uses LinkedList to store the data. The
 * data is of type Number. It provides method to add element to the list and retrieve the element at a specific index.
 * @author Waqas ur Rehman
 * @param <E> the type of element stored in the list. Element must be of type Number
 */
public class SimpleMovingAverage<E extends Number> implements MovingAverage<E> {

    private LinkedList<E> data;

    public SimpleMovingAverage() {
        this.data = new LinkedList<E>();
    }

    /**
     * Add the element to the start of the list.
     * @param element element to be added
     */
    @Override
    public void addElement(E element) {
        if (element != null) {
            //Add to the front of list. This will help to calculate avarage
            data.addFirst(element);
        }
    }

    /**
     * Get the element at index postion. This does not remove the element from the list.
     * @param index position of the element
     * @return element at index position
     * @throws IndexOutOfBoundsException - if the index is out of range (index &lt; 0 || index &gt;= size())
     */
    @Override
    public E getElement(int index) {
        return data.get(index);
    }

    /**
     * Get the size of list
     * @return size of list
     */
    public int getSize() {

        return data.size();
    }

    /**
     * Calculate the Average of last n numbers.
     * @param n Number of elements for which to calculate the average
     * @return Average of n elements
     */
    @Override
    public double getMovingAverage(int n) {
        if (n <=0 || data.size()==0) return 0;
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < n && i < data.size(); i++) {
            sum = sum.add(new BigDecimal(data.get(i).toString()));
        }
        return sum.divide(new BigDecimal(n), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
