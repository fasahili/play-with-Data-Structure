package SingleLinkedList;

class FindThirdListNode {
    int value;
    FindThirdListNode next;

    FindThirdListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class FindThirdLinkedList {
    FindThirdListNode head;

    public void addNode(int value) {
        if (head == null) {
            head = new FindThirdListNode(value);
        } else {
            FindThirdListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new FindThirdListNode(value);
        }
    }

    public FindThirdListNode findThirdFromEnd() {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        FindThirdListNode first = head;
        FindThirdListNode second = head;
        FindThirdListNode third = head;

        for (int i = 0; i < 3; i++) {
            if (third != null) {
                third = third.next;
            }
        }

        while (third != null) {
            first = first.next;
            second = second.next;
            third = third.next;
        }

        return first;
    }

    public static void main(String[] args) {
        FindThirdLinkedList list = new FindThirdLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        FindThirdListNode thirdFromEnd = list.findThirdFromEnd();
        if (thirdFromEnd != null) {
            System.out.println("The third node from the end has the value: " + thirdFromEnd.value);
        } else {
            System.out.println("There are less than three nodes in the list.");
        }
    }
}