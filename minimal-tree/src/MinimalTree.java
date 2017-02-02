import java.util.LinkedList;
import java.util.Queue;

public class MinimalTree {
  public static void main(String[] args) {
    int[] sortedArray = {1, 2, 3, 4, 5, 6};
    TreeNode output = createMinTree(sortedArray);
    printTree(output);
  }
  public static TreeNode createMinTree(int[] array) {
    return createMinTree(array, 0, array.length - 1);
  }

  public static TreeNode createMinTree(int[] array, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(array[mid]);
    n.left = createMinTree(array, start, mid-1);
    n.right = createMinTree(array, mid+1, end);
    return n;
  }

  public static void printTree(TreeNode n) {
    if (n == null) {
      return;
    }
    Queue q = new LinkedList<>();
    int levelNodes;
    q.add(n);
    while(!q.isEmpty()) {
      levelNodes = q.size();
      while (levelNodes > 0) {
        TreeNode r = (TreeNode) q.remove();
        System.out.print(" " + r.data);
        if (r.left != null) {
          q.add(r.left);
        }
        if (r.right != null) {
          q.add(r.right);
        }
        levelNodes--;
      }
      System.out.println();
    }

  }
  public static class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data) {
      this.left = null;
      this.right = null;
      this.data = data;
    }
  }

}

