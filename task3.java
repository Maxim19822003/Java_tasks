//Необходимо реализовать метод разворота связного списка (двухсвязного 
//или односвязного на выбор).
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    Node head;

    // Метод для добавления новой ноды в конец списка
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Метод для разворота списка
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Сохраняем ссылку на следующую ноду
            current.next = prev; // Разворачиваем ссылку на следующую ноду
            prev = current;      // Перемещаем prev на текущую ноду
            current = next;      // Перемещаем current на следующую ноду
        }

        head = prev; // Обновляем начало списка
    }

    // Метод для отображения списка
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);

        System.out.println("Исходный список:");
        list.display();  // Выведет: 5 10 15

        list.reverse();

        System.out.println("Развёрнутый список:");
        list.display();  // Выведет: 15 10 5
    }
}