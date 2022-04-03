// priblem: write a program that recursively generates a binary tree of fixed depth N, then prints the tree to the terminal with a stylized, branching structure.
public class prettyBinaryTreeGenerator {
  // driver code
  public static void main(String[] args) {
    int N = 5;
    prettyBinaryTreeGenerator T = new prettyBinaryTreeGenerator(N);
    T.print();
  }

  Node root;
  int depth;

  public prettyBinaryTreeGenerator(int depth) {
    this.root = generateTree(depth);
  }

  // Recursively generate a binary tree of fixed depth
  private static Node generateTree(int depth) {
    if (depth < 0) return null;
    Node currentNode = new Node(depth);
    if (depth > 0) {
      currentNode.left = generateTree(depth-1);
      currentNode.right = generateTree(depth-1);
    }
    return currentNode;
  }

  public Node getRoot() {
    return root;
  }

  // Recursively traces through the tree node values, adds padding and symbolic pointers
  public void traverse(Node n, String padding, String pointer, StringBuilder sb) {
    if (n != null) {
      sb.append(padding);
      sb.append(pointer);
      sb.append(n.data);
      sb.append("\n");

      StringBuilder paddingBuilder = new StringBuilder(padding);
      paddingBuilder.append("| ");

      String paddingBoth = paddingBuilder.toString();
      String pointerRight = "└──";
      String pointerLeft = (n.right != null) ? "├──" : "└──";

      traverse(n.left, paddingBoth, pointerLeft, sb);
      traverse(n.right, paddingBoth, pointerRight, sb);
    }
  }

  // Prints the output of the Traverse method
  public void print() {
    StringBuilder sb = new StringBuilder();
    traverse(root, "", "", sb);
    System.out.println(sb.toString());
  }

}

// Binary tree Node
class Node {
  int data;
  Node left;
  Node right;

  Node(int i) {
    data = i;
  }

}
