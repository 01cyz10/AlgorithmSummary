import java.util.*;

public class Main {

    public static void main(String[] args) {

//        int[] array = {5,8,3,9,6,2,7,1,4};
//        Graph graph = new Graph(5);
//
//        graph.addNode(new Node('A'));
//        graph.addNode(new Node('B'));
//        graph.addNode(new Node('C'));
//        graph.addNode(new Node('D'));
//        graph.addNode(new Node('E'));
//
//        graph.addEdge(0, 1);
//        graph.addEdge(1,2);
//        graph.addEdge(1,4);
//
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 4);
//
//        graph.addEdge(4, 0);
//        graph.addEdge(4, 2);
//
//        graph.print();
//
//        graph.breadthFirstSearch(0);

        // init a binary search tree & add data node

//        BinarySearchTree tree = new BinarySearchTree();
//
//        tree.insert(new Node(5));
//        tree.insert(new Node(1));
//        tree.insert(new Node(9));
//        tree.insert(new Node(2));
//        tree.insert(new Node(7));
//        tree.insert(new Node(3));
//        tree.insert(new Node(6));
//        tree.insert(new Node(4));
//        tree.insert(new Node(8));
//
//        tree.display();

    }

    private static void quickSort(int[] array, int start, int end) {

        if (end <= start) return; // base case

        int pivot = partition(array, start, end);

        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    private static void mergeSort(int[] array) {

        int length = array.length;
        if (length <= 1) return; // base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; // left array
        int j = 0; // right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; // indices

        // check the condition for merging

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static int power(int base, int exponent) {

        if (exponent < 1) return 1;
        return base * power(base, exponent - 1);
    }

    private static int factorial(int num) {

        if (num < 1) return 1;
        return num * factorial(num - 1);

    }

    private static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int interpolationSearch(int[] array, int value) {

        int high = array.length - 1;
        int low = 0;

        while(value >= array[low] && value <= array[high] && low <= high) {

            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);

            System.out.println("Probe: " + probe);

            if (array[probe] == value) {
                return probe;
            } else if (array[probe] < value) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }
        return  -1;
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = array[middle];

            System.out.println("Middle: " + value);

            if (value < target) low = middle + 1;

            else if (value > target) high = middle - 1;
            else return middle; // target found
        }
        return -1; // target not found
    }

    private static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}