public class HeapApp {
    public static void main(String[] args) {
        Heap<Integer> myHeap = new Heap<>();
        myHeap.add(1);
        myHeap.add(5);
        myHeap.add(4);
        myHeap.add(2);
        myHeap.add(6);

        System.out.println(myHeap);
        while (!myHeap.isEmpty()) {
            int max = myHeap.delete();
            System.out.println(max + " " + myHeap);
        }
    }
}
