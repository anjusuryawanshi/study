package list;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> mylist = new LinkedList<>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);

        System.out.println(mylist.get(0) + " " + mylist.get(1) + " " + mylist.get(2));
        System.out.println("Size = " + mylist.size());
        System.out.println(mylist.isEmpty());
        System.out.println(mylist.contains(1));
        System.out.println(mylist.contains(2));
        System.out.println(mylist.contains(3));
        System.out.println(mylist.contains(5));
        System.out.println("head = " + mylist.getHead());
        System.out.println("end = " + mylist.getEnd());
        //System.out.println(mylist.get(10));

        System.out.println("Removing 0th...");
        mylist.remove(0);
        System.out.println(mylist.get(0));
        System.out.println(mylist.get(1));
        System.out.println("size = " + mylist.size());

        System.out.println("Adding back...");
        mylist.add(1);
        System.out.println(mylist.get(0));
        System.out.println(mylist.get(1));
        System.out.println(mylist.get(2));

        System.out.println("Removing 1st...");
        mylist.remove(1);
        System.out.println(mylist.get(0));
        System.out.println(mylist.get(1));
        System.out.println("size = " + mylist.size());

        System.out.println("Adding back...");
        mylist.add(3);
        System.out.println(mylist.get(0));
        System.out.println(mylist.get(1));
        System.out.println(mylist.get(2));

        System.out.println("Removing 2nd...");
        mylist.remove(2);
        System.out.println(mylist.get(0));
        System.out.println(mylist.get(1));
        System.out.println("size = " + mylist.size());
    }
}
