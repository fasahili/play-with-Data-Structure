package SingleLinkedList;

class CycleListNode {
    int value;
    CycleListNode next;

    CycleListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class CycleLinkedList {
    CycleListNode head;

    public boolean hasCycle() {
        if (head == null) return false;

        CycleListNode slow = head;
        CycleListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public CycleListNode findCycleStart() {
        if (head == null || !hasCycle()) return null;

        CycleListNode slow = head;
        CycleListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void addNode(int value) {
        if (head == null) {
            head = new CycleListNode(value);
        } else {
            CycleListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new CycleListNode(value);
        }
    }

    public static void main(String[] args) {
        CycleLinkedList list = new CycleLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);

        CycleListNode temp = list.head;
        while (temp != null && temp.value != 6) {
            temp = temp.next;
        }
        if (temp != null) {
            temp.next = list.head.next.next;
        }

        if (list.hasCycle()) {
            System.out.println("The list has a cycle.");

            CycleListNode cycleStart = list.findCycleStart();
            System.out.println("Cycle starts at node with value: " + cycleStart.value);
        } else {
            System.out.println("The list does not have a cycle.");
        }
    }
}
