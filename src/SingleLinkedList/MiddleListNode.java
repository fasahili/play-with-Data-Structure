package SingleLinkedList;

class MiddleListNode {
    int value;
    MiddleListNode next;

    MiddleListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class MiddleLinkedList {
    MiddleListNode head;


    public MiddleListNode findMiddle() {
        if (head == null) return null;

        MiddleListNode slow = head;
        MiddleListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public void addNode(int value) {
        if (head == null) {
            head = new MiddleListNode(value);
        } else {
            MiddleListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new MiddleListNode(value);
        }
    }

    public static void main(String[] args) {
        MiddleLinkedList list = new MiddleLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        MiddleListNode middleNode = list.findMiddle();
        System.out.println("Middle Element: " + (middleNode != null ? middleNode.value : "List is empty"));

        list.addNode(6);
        middleNode = list.findMiddle();
        System.out.println("Middle Element after adding 6: " + (middleNode != null ? middleNode.value : "List is empty"));
    }
}
