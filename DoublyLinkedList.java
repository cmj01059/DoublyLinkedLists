public class DoublyLinkedList<T extends Comparable<T>> {
    
    private NodeType<T> head;
    private int length;

    public DoublyLinkedList() {
        head = null;
        length = 0;
    }

    public void insertItem(T item) throws NullPointerException {
        if (item != null) {
            if (head == null) {
                head = new NodeType<T>();
                head.info = item;
            } else {
                boolean isFound = false;
                NodeType<T> temp = head;
                while (!isFound && temp != null) {
                    if (item.compareTo(temp.info) < 0) {
                        NodeType<T> insert = new NodeType<>();
                        insert.info = item;
                        insert.next = temp;
                        insert.back = temp.back;
                        insert.back.next = insert;
                        insert.next.back = insert;
                        isFound = true;
                        length++;
                    } else if (item.compareTo(temp.next.info) > 0) {
                        temp = temp.next;
                    } else if (item.compareTo(temp.next.info) == 0) {
                        System.out.println("Cannot insert duplicate item");
                        isFound = true;
                    }
                }
            }
        } else {
            throw new NullPointerException("Item is null");
        }
    }

    public void deleteItem(T item) throws NullPointerException {
        if (item != null) {
            if (length == 0) {
                System.out.println("Cannot delete from empty list");
            } else if (head.info.compareTo(item) == 0) {
                head = head.next;
                head.back = null;
                length--;
            } else {
                boolean isFound = false;
                NodeType<T> temp = head;
                while (!isFound && temp != null) {
                     if (item.compareTo(temp.info) == 0) {
                        temp.back.next = temp.next;
                        temp.next.back = temp.back;
                        length--;
                        isFound = true;
                    } else if (item.compareTo(temp.next.info) > 0) {
                        temp = temp.next;
                    }
                }
                if (!isFound) {
                    System.out.println("Item not found");
                }
            }
        } else {
            throw new NullPointerException("Item is null");
        }
    }

    public int length() {
        return length;
    }

    public void print() {
        NodeType<T> temp = head;
        System.out.print("List: [");
        for(int count = 0; count < length; count++) {
            if (count == length - 1) {
                System.out.println(temp.info + "]");
            } else {
                System.out.print(temp.info + ", ");
            }
            temp = temp.next;
        }
    }

    public void printReverse() {
        NodeType<T> temp = head;
        for(int count = 0; count < length; count++) {
            temp = temp.next;
        }
        System.out.print("List: [");
        for(int count = 0; count < length; count++) {
            if (count == length - 1) {
                System.out.println(temp.info + "]");
            } else {
                System.out.print(temp.info + ", ");
            }
            temp = temp.back;
        }
    }

    public void deleteSubsection(T start, T end) {
        NodeType<T> temp = head;
        while(start.compareTo(temp.info) > 0) {
            temp = temp.next;
        }
        while(start.compareTo(temp.info) <= 0 && end.compareTo(temp.info) >= 0) {
            temp = temp.next;
            deleteItem(temp.back.info);
        }
    }

    public void reverseList() {
        if (head != null && head.info != null) {
            NodeType<T> temp = head;
            do {
                temp = temp.next;
                head.next = head.back;
                head.back = temp;
                head = temp;
            } while (head.back != null);
        }
    }

    public void swapAlternate() {
        if (head != null && head.next != null) {
            NodeType<T> temp1 = head;
            NodeType<T> temp2 = head.next;
            NodeType<T> temp;
            while(temp1 != null && temp2 != null) {
                temp = temp1;
                temp1.next = temp2.next;
                temp1.back = temp2.back;
                temp2.next = temp.next;
                temp2.back = temp.back;
                temp1 = temp1.next.next;
                temp2 = temp2.next.next;
            }
        }
    }
    
}
