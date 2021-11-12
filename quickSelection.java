/*given an array with all uique values find the kth smallest one */
//method 1 use minheap with size k
//method 2 implement quick sort

public class quickSelection {
    public static int findKthSmallest (int[] array, int k) {
        int left = 0;
        int right = array.length-1;
        int index = partition(array, left, right);
        int result = 0;
    //base case
    while(left <= right) {
        if (index == k-1) {
            result = array[index];
            break;
        
        }else if (index > k-1) {//find the kth from the left
            right = index-1;
            index = partition(array, left, right);

        }else{
            left = index+1;
            index = partition(array, left, right);
        }
    }
        return result;
    }
    private static int partition(int[] array, int left, int right) {
        //base case
        if (left == right) {
            return left;

        }
        int pivot = array[right]; //choose the last one as pivot
        int i = 0;
        int j = right-1;
        while(i <= j) {
            if (array[i] < pivot) {
                i++;
            }else{
                swap(array,i,j);
                j--;
            }
        }
        //put the pivot back
        swap(array,i,right);
        return j;
    }
    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
        
    public static void main(String[] args) {
        int[] array = new int[] {8,5,6,9,7,2,3};
        int result = findKthSmallest(array,7);
        System.out.println(result);
    }
    
}
