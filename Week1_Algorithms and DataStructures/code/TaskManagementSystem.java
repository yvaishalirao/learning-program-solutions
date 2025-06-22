public class TaskManagementSystem {

    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String toString() {
            return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class TaskList {
        Node head;

        public void addTask(Task t) {
            Node newNode = new Node(t);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            System.out.println(" Task added: " + t.taskName);
        }

        public Task searchTask(int id) {
            Node temp = head;
            while (temp != null) {
                if (temp.task.taskId == id) {
                    return temp.task;
                }
                temp = temp.next;
            }
            return null;
        }

        public void displayTasks() {
            Node temp = head;
            if (temp == null) {
                System.out.println(" No tasks available.");
                return;
            }
            while (temp != null) {
                System.out.println(temp.task);
                temp = temp.next;
            }
        }

        public void deleteTask(int id) {
            if (head == null) {
                System.out.println(" Task list is empty.");
                return;
            }

            if (head.task.taskId == id) {
                head = head.next;
                System.out.println(" Task deleted.");
                return;
            }

            Node prev = head;
            Node curr = head.next;

            while (curr != null) {
                if (curr.task.taskId == id) {
                    prev.next = curr.next;
                    System.out.println(" Task deleted.");
                    return;
                }
                prev = curr;
                curr = curr.next;
            }

            System.out.println(" Task not found.");
        }
    }

    public static void main(String[] args) {
        TaskList list = new TaskList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Develop Backend", "In Progress"));
        list.addTask(new Task(3, "Test Application", "Pending"));

        System.out.println("\n All Tasks:");
        list.displayTasks();

        System.out.println("\n Searching Task ID 2:");
        Task found = list.searchTask(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\n Deleting Task ID 1:");
        list.deleteTask(1);

        System.out.println("\nUpdated Task List:");
        list.displayTasks();
    }
}
