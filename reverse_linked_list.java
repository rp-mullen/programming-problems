// problem: given a linked list, write a method that returns the same list, reversed.

public class reverse_linked_list {
  public static void main(String[] args) {

    LinkedList L = new LinkedList();

    for (int i = 0; i < 10; i++) {
      L.addNode(new Node(i));
    }

    L.print();
    
    // main algorithm
    L.reverse();

    L.print();
  }
}

// implemented node
class Node {
  int data;
  Node next;

  public Node(int n) {
    data = n;
    next = null;
  }
}

// implemented linked list
class LinkedList {
  Node head;

  public LinkedList() {
    head = null;
  }
  public LinkedList(Node N) {
    head = N;
  }

  public void addNode(Node N) {
    if (head == null) {
      head = N;
    }
    else {
      Node tmp = head;
      while (tmp.next != null) {
        tmp = tmp.next;
      }
      tmp.next = N;
    }
  }

  public void print() {
    Node tmp = head;
    while (tmp.next != null) {
      System.out.print(tmp.data + ", ");
      tmp = tmp.next;
    }
    System.out.print(tmp.data + "\n");
  }

  
  public void reverse() {
    Node current = head;
    Node prev = null;
    Node next = null;
    while (current != null) {
      // store next
      next = current.next;

      // reverse current node's pointer
      current.next = prev;

      // move pointers one position ahead
      prev = current;
      current = next;
    }
    head = prev;
  }

}
