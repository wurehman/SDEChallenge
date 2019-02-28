package com.paytm.challenge;

/**
 * Interface for calculating moving average. MovieAverage Interface provides methods to add and
 * get element from the underlying data structure.
 * MovieAverage Interface provides method to calculate the moving average of last N numbers.
 * @param <E> type of element.
 * @author Waqas ur Rehman
 */
public interface MovingAverage<E> {
    /**
     *  Add the element to the data structure being used
     * @param element element to be added
     */
    public void addElement(E element);

    /**
     * Get the element from the data structure being used
     * @param index position of the element
     * @return element at index position
     * @throws IndexOutOfBoundsException - if the index is out of range (index &lt; 0 || index &gt;= size())
     */
    public E getElement(int index);

    /**
     * Get the moving average of the last n elements
     * @param n number of elements
     * @return moving average of n elements
     */
    public double getMovingAverage(int n);
}
