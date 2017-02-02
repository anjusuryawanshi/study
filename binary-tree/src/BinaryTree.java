public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent;
        while(true) {
            parent = current;
            if (data < current.data) {
                current  = current.left;
                if (current == null) {
                    parent.left = newNode;
                    newNode.parent = parent;
                    return;
                }
            }
            else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    newNode.parent = parent;
                    return;
                }
            }
        }
    }

    public void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public TreeNode find(int data) {
        TreeNode current = root;
        while ( current != null) {
            if (data == current.data) {
                System.out.println("found");
                return current;
            }
            else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public boolean delete(int data) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while (current.data != data) {
            parent = current;
            if(current.data > data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }
        if (current.left == null && current.right == null) {
            if(current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if(isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        else {
            TreeNode successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode deleteNode) {
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode current = deleteNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    int inOrderSuccessor(int data) {
      TreeNode n = find(data);
      if (n == null) {
        return -1;
      }
      if (n.right != null) {
        return leftMostChild(n.right);
      } else {
        TreeNode q = n;
        TreeNode x = q.parent;
        while(x != null && x.left != q) {
          q = x;
          x = x.parent;
        }
        if (x == null) {
          return -1;
        }
        return x.data;
      }
    }

    private int leftMostChild(TreeNode n) {
      if (n == null) {
        return -1;
      }
      while (n.left != null) {
        n = n.left;
      }
      return n.data;
    }

    public int getHeight(TreeNode root) {
      if (root == null) {
        return -1;
      }
      return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
      if (root == null) {
        return true;
      }
      int heightDiff = getHeight(root.left) - getHeight(root.right);
      return Math.abs(heightDiff) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(2);
        binaryTree.insert(5);
        binaryTree.insert(4);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(1);
        System.out.println("root = " + binaryTree.root.data);
        binaryTree.printInorder(binaryTree.root);
        System.out.println();
        binaryTree.printPreOrder(binaryTree.root);
        System.out.println();
        binaryTree.printPostOrder(binaryTree.root);
        System.out.println();
        //binaryTree.find(10);
        //binaryTree.find(9);
        binaryTree.delete(4);
        binaryTree.printInorder(binaryTree.root);
        int successor = binaryTree.inOrderSuccessor(0);
        System.out.println("inorder successor = " + successor);
        System.out.println("Height of the tree = " + binaryTree.getHeight(binaryTree.root));
        System.out.println("isBalanced = " + binaryTree.isBalanced(binaryTree.root));
    }
}
