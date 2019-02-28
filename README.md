# PaytmLabs SDE Challenge Solution - Waqas ur Rehman

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

## Coding Solution

``` MovingAverage``` interface is provided with methods to add an element, get an element at specific index and get moving average of last N elements.

``` SimpleMovingAverage``` class implements the interface and provides the implementation using LinkedList.

### Assumptions

1. The data added to the list stays in the list and can only be accessed but not removed.
2. The value of N is provided by the caller at the time of calling the method and not during the initializtion of data structure. So the user has flexibility of getting the moving average for different values of N.
3. Only provide the method to get the moving average of last N numbers and not the moving averages for the entire list over N.
4. Since the main goal seems to be getting the moving average so the most frequent opertations are insert and get averages.
### Solution Explanation

Based on the above assumption, LinkedList seems to be the best candidate for both time and space complexity. So LinkedList is being used as the data structure for carrying out the required operations. Inserts will be fast as the time complexity is O(1). Accessing the element will be O(n). In order to improve the performance of calculating moving average we are inserting element at the front of list. This will enusre that we only need to access first N elements to calculate the moving average. So the time complexity will be O(N), N being the number of elements for which average is required and not the size of list.    

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.
