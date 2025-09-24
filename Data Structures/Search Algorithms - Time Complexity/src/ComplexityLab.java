import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Class to analyze time complexity of sorting algorithms.
 */
public class ComplexityLab {

    public static void main(String[] args) {
        int numOfElements = 5000;
        // Create 4 Arrays of size 5000 and 4 Lists
        int []arr1 = new int[numOfElements];
        int []arr2 = new int[numOfElements];
        int []arr3 = new int[numOfElements];
        int []arr4 = new int[numOfElements];
        LinkedList<Integer> linked1 = new LinkedList<>();
        LinkedList<Integer> linked2 = new LinkedList<>();
        LinkedList<Integer> linked3 = new LinkedList<>();
        LinkedList<Integer> linked4 = new LinkedList<>();

        // Put a random value between 1 - 100000 into each array and list
        for (int i = 0; i < numOfElements; i++){
            int random = (int) (Math.random() * 100001);
            arr1[i] = random;
            arr2[i] = random;
            arr3[i] = random;
            arr4[i] = random;
            linked1.add(random);
            linked2.add(random);
            linked3.add(random);
            linked4.add(random);
        }
        // Print out top of table
        System.out.println("Sort Type     Data Struct     Operations     Run Time(ms)     " + numOfElements + " Elements");
        System.out.println("----------------------------------------------------------");
        
        // Initialize variables for finding amount of Operations and Run Time (ms)
        long start;
        long operations;
        long end;
        long elapsedTime;

        // Quick sort for Array
        start = System.currentTimeMillis();
        operations = quickSortArray(arr1, 0, arr1.length-1, 0);
        end = System.currentTimeMillis();
        elapsedTime = end - start; // Finds runtime
        System.out.printf("Quick         Array           %d         %d", operations, elapsedTime);

        // Quick sort for List
        start = System.currentTimeMillis();
        operations = quickSortList(linked1);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nQuick         List            %d          %d", operations, elapsedTime);

        // Merge sort for Array
        start = System.currentTimeMillis();
        operations = mergeSortArray(arr2);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nMerge         Array           %d          %d", operations, elapsedTime);

        // Merge sort for List
        start = System.currentTimeMillis();
        operations = mergeSortList(linked2);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nMerge         List            %d          %d", operations, elapsedTime);

        // Insertion sort for Array
        start = System.currentTimeMillis();
        operations = insertionSortArray(arr3);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nInsertion     Array           %d        %d", operations, elapsedTime);

        // Insertion sort for List
        start = System.currentTimeMillis();
        operations = insertionSortList(linked3);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nInsertion     List            %d        %d", operations, elapsedTime);

        // Selection sort for Array
        start = System.currentTimeMillis();
        operations = selectionSortArray(arr4);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nSelection     Array           %d       %d", operations, elapsedTime);

        // Selection sort for List
        start = System.currentTimeMillis();
        operations = selectionSortList(linked4);
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.printf("\nSelection     List            %d       %d", operations, elapsedTime);
    }

    /**
     * Sorts an array using the quicksort algorithm.
     *
     * @param arr        The array to be sorted.
     * @param low        The index of the first element in the array.
     * @param high       The index of the last element in the array.
     * @param operations The number of operations performed during the sort.
     * @return The total number of operations performed during the sort.
     */
    public static long quickSortArray(int[] arr, int low, int high, long operations) {
        if (low < high) {
            PartitionResult result = partition(arr, low, high, operations);
            operations = quickSortArray(arr, low, result.pi - 1, result.operations);
            operations = quickSortArray(arr, result.pi + 1, high, operations);
        }
        return operations;
    }

    /**
     * Partitions the array for the quicksort algorithm.
     *
     * @param arr        The array to be partitioned.
     * @param low        The index of the first element in the array.
     * @param high       The index of the last element in the array.
     * @param operations The number of operations performed during the partition.
     * @return The partition index and the total number of operations performed during the partition.
     */
    private static PartitionResult partition(int[] arr, int low, int high, long operations) {
        operations +=2;
        int pivotIndex = ThreadLocalRandom.current().nextInt(low, high + 1);
        int pivot = arr[pivotIndex];

        int temp = arr[high];
        arr[high] = pivot;
        arr[pivotIndex] = temp;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            operations++;
            if (arr[j] < pivot) {
                i++;
                operations++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return new PartitionResult(i + 1, operations);
    }

    /**
     * Sorts a linked list using the quicksort algorithm.
     *
     * @param list       The linked list to be sorted.
     * @return The total number of operations performed during the sort.
     */
    public static long quickSortList(LinkedList<Integer> list) {
        long operations = 0;
        if (list.size() <= 1) {
            return 0; // Already sorted or empty list
        }

        int pivotIndex = ThreadLocalRandom.current().nextInt(list.size());
        int pivot = list.remove(pivotIndex);

        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for (Integer element : list) {
            operations++; // Counting comparison operation
            if (element < pivot) {
                left.add(element);
            } else if (element == pivot) {
                equal.add(element);
            } else {
                right.add(element);
            }
        }

        operations += (quickSortList(left)); // Counting recursive call operation
        operations += (quickSortList(right)); // Counting recursive call operation

        list.clear(); // This operation is not counted
        list.addAll(left); // This operation is not counted
        list.addAll(equal); // This operation is not counted
        list.add(pivot); // This operation is not counted
        list.addAll(right); // This operation is not counted

        return operations;
    }

    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param array The array to be sorted.
     * @return The total number of operations performed during the sort.
     */
    public static long mergeSortArray(int[] array) {
        if (array.length <= 1) {
            return 0;
        }

        int mid = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(array, mid, array.length);

        long leftOperations = mergeSortArray(leftHalf);
        long rightOperations = mergeSortArray(rightHalf);
        long mergeOperations = mergeArrays(array, leftHalf, rightHalf);

        return leftOperations + rightOperations + mergeOperations;
    }

    /**
     * Merges two arrays for the merge sort algorithm.
     *
     * @param array     The array to be sorted.
     * @param leftHalf  The left half of the array.
     * @param rightHalf The right half of the array.
     * @return The total number of operations performed during the merge.
     */
    private static long mergeArrays(int[] array, int[] leftHalf, int[] rightHalf) {
        long operations = 0;
        int i = 0, j = 0, k = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            operations++;
            if (leftHalf[i] <= rightHalf[j]) {
                array[k++] = leftHalf[i++];
            } else {
                array[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            array[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            array[k++] = rightHalf[j++];
        }

        return operations;
    }

    /**
     * Sorts a linked list using the merge sort algorithm.
     *
     * @param list The linked list to be sorted.
     * @return The total number of operations performed during the sort.
     */
    public static long mergeSortList(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return 0;
        }

        int mid = list.size() / 2;
        LinkedList<Integer> leftHalf = new LinkedList<>(list.stream().limit(mid).collect(Collectors.toList()));
        LinkedList<Integer> rightHalf = new LinkedList<>(list.stream().skip(mid).collect(Collectors.toList()));

        long leftOperations = mergeSortList(leftHalf);
        long rightOperations = mergeSortList(rightHalf);

        list.clear();
        long mergeOperations = mergeListsTail(list, leftHalf, rightHalf);

        return leftOperations + rightOperations + mergeOperations;
    }

    /**
     * Merges two linked lists for the merge sort algorithm.
     *
     * @param list      The destination linked list.
     * @param leftHalf  The left half of the list.
     * @param rightHalf The right half of the list.
     * @return The total number of operations performed during the merge.
     */
    private static long mergeListsTail(LinkedList<Integer> list, LinkedList<Integer> leftHalf, LinkedList<Integer> rightHalf) {
        long operations = 0;
        while (!leftHalf.isEmpty() && !rightHalf.isEmpty()) {
            operations++;
            if (leftHalf.peek() <= rightHalf.peek()) {
                list.add(leftHalf.poll());
            } else {
                list.add(rightHalf.poll());
            }
        }

        list.addAll(leftHalf);
        list.addAll(rightHalf);

        return operations;
    }

    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long insertionSortArray(int[] arr) {
        long comparisons = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            comparisons++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                comparisons++;
            }
            arr[j + 1] = key;
        }
        return comparisons;
    }

    /**
     * Sorts a linked list using the insertion sort algorithm.
     *
     * @param list The linked list to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long insertionSortList(LinkedList<Integer> list) {
        long comparisons = 0;
        int n = list.size();
        if (n <= 1) {
            return 0; // Already sorted or empty list
        }

        // Create a new sorted list
        LinkedList<Integer> sortedList = new LinkedList<>();

        // Iterate over the original list
        for (Integer current : list) {
            // Find the correct position to insert the current element in the sorted list
            ListIterator<Integer> sortedIterator = sortedList.listIterator();
            int index = 0;
            while (sortedIterator.hasNext()) {
                int sortedValue = sortedIterator.next();
                comparisons++;
                if (sortedValue > current) {
                    // Insert the current element into the sorted list
                    sortedList.add(index, current);
                    break;
                }
                index++;
            }

            if (!sortedIterator.hasNext()) {
                // If the current element is the largest, add it to the end
                sortedList.addLast(current);
            }
        }

        // Update the original list with the sorted copy
        list.clear();
        list.addAll(sortedList);

        return comparisons;
    }

    /**
     * Sorts an array using the selection sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long selectionSortArray(int[] arr) {
        long comparisons = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return comparisons;
    }

    /**
     * Sorts a linked list using the selection sort algorithm.
     *
     * @param list The linked list to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long selectionSortList(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        long cost = 0;
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            ListIterator<Integer> curr = list.listIterator(i);
            int minIndex = i;
            int minVal = curr.next();

            while (curr.hasNext()) {
                cost++;
                int tempVal = curr.next();
                if (tempVal < minVal) {
                    minIndex = curr.previousIndex();
                    minVal = tempVal;
                }
            }

            if (minIndex != i) {
                int temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
                cost++;
            }
        }
        return cost;
    }


    /**
     * Represents the result of partitioning an array for quick sort.
     */
    static class PartitionResult {
        int pi;
        long operations;

        /**
         * Constructs a PartitionResult object.
         *
         * @param pi         The partition index.
         * @param operations The total number of operations performed during partitioning.
         */
        PartitionResult(int pi, long operations) {
            this.pi = pi;
            this.operations = operations;
        }
    }
}

