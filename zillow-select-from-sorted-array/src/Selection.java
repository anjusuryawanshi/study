/**
 * Created by mystique on 10/13/16.
 */
public class Selection {

    public static void main(String[] args) {
        String[] arr = {"apple", "null", "null", "ball","cat","null","null","null","dog"};
        String input = "apple";
        getIndex(arr, input, 0, 8);
        //System.out.println("index = " + index);
    }

    public static void getIndex(String[] arr, String input, int start, int end) {
        int mid = (start+end)/2;
        if (arr[mid].equals(input)) {
            System.out.println(mid);
        }
        else {
            for (int i = mid; i >= start; i--) {
                if (!arr[i].equals("null")) {
                    if(arr[i].equals(input)) {
                        System.out.println(i);
                        return;
                    }
                    else {
                        if (arr[i].compareTo(input) < 0) {
                            break;
                        }
                        else {
                            getIndex(arr, input, 0, i);
                        }
                    }
                }
            }
            getIndex(arr, input, mid+1, end);
        }

    }
}
