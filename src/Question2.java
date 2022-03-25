import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question2 {
    class Node {
        private int value;
        private Node next;

        public void setValue(int i) {
            this.value = i;
        }
        public int getValue() {
            return this.value;
        }

        public void setNext(Node i) {
            this.next = i;
        }
        public Node getNext() {
            return this.next;
        }
    }

    Node top;

    public void push(int i) {
        Node node = new Node();
        node.setValue(i);
        node.setNext(this.top);
        this.top = node;
    }

    public int pop() throws Exception {
        if(this.top == null) {
            throw new Exception("Stack is empty");
        }
        int i = this.top.getValue();
        this.top = this.top.getNext();
        return i;
    }

    public int max() throws Exception {
        List<Integer> stackValues = new ArrayList<Integer>();
        if(this.top == null) {
            throw new Exception("Stack is empty");
        }
        createList(stackValues, this.top);
        Collections.sort(stackValues);
        Collections.reverse(stackValues);
        return stackValues.get(0);
    }

    private List<Integer> createList(List<Integer> list, Node node) {
        list.add(node.getValue());
        if (node.getNext() == null ){
            return list;
        } else {
            createList(list, node.getNext());
        }
        return null;
    }
}
