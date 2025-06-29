public class OrderSorting {

    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String toString() {
            return "OrderID: " + orderId + ", Name: " + customerName + ", Price: $" + totalPrice;
        }
    }

    public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    // Swap
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] arr, String msg) {
        System.out.println("\n" + msg);
        for (Order o : arr) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 100.0),
            new Order(3, "Charlie", 400.0),
            new Order(4, "David", 50.0),
            new Order(5, "Eva", 300.0)
        };

        // Clone array for different sorts
        Order[] orders2 = orders1.clone();

        bubbleSort(orders1);
        printOrders(orders1, "Orders after Bubble Sort (by price):");

        quickSort(orders2, 0, orders2.length - 1);
        printOrders(orders2, "Orders after Quick Sort (by price):");
    }
}
