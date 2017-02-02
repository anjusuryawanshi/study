/**
 * Created by mystique on 11/21/16.
 * A magic index in an array A[1,2,...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of <b>distinct</b> integers, write a method to find a magic index, if one exists,
 * in array A.
 */
public class MagicIndex {
    //Use binary search
    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length-1);
    }
    public int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == mid) {
            return mid;
        } else if(array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        MagicIndex magicIndex = new MagicIndex();
        int[] array = { -1, 0, 1, 2, 4, 10};
        int index = magicIndex.magicFast(array);
        System.out.println("Magic index = " + index);
    }
}

