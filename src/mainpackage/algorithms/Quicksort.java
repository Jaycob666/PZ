package mainpackage.algorithms;

public class Quicksort {
    /**
    * Returns an int array with sorted values. 
    *
    * This method uses Quicksort algorithm.
    * 
    * @param  arr  an int array
    * @return      sorted int array
    */
    public static int[] sort(int[] arr) {
        try {
           return sort(arr, 0, arr.length - 1);
        } catch(ArrayIndexOutOfBoundsException e) {
           return arr;
        }
    }
    
    private static int[] sort(int[] arr, int left, int right) {
        int i, j, pivot, temp;
 
        i = left;
        j = right;
        pivot = arr[(left + right) / 2];
        do {
            while (arr[i] < pivot)
                i++;
            while (pivot < arr[j])
                j--;
            if (i<=j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        
        if (left < j)
            sort(arr, left, j);
        if (i < right)
            sort(arr, i, right);
        
        return arr;
    }
}
