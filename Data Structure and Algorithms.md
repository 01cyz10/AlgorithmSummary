## Data Structure and Algorithms



#### Stack

LIFO =  Last-in First-out

```java
        Stack<String>  stack = new Stack<String>();

        System.out.println(stack.empty()); // T

        stack.push("Audi");
        stack.push("BMW");
        stack.push("Benz");
        stack.push("Toyota");
        stack.push("Ford");
        stack.push("Volvo");

        stack.pop(); // remove 'Volvo'

        System.out.println(stack.empty()); // F
        System.out.println(stack.peek()); // return object at Top of stack
        System.out.println(stack.search("Benz")); // return the index of object in stack
        System.out.println(stack);
```

Stack use case

1. undo/redo feature in text editors
2. moving back/forward through browser history
3. backtracking algorithms (maze, file, directories)
4. calling function (call stack)

#### Queue

FIFO = First-in First-out

Collection > Queue > LinkedList

```java
    Queue<String>  queue = new LinkedList<String>();

        System.out.println(queue.isEmpty()); // T

        queue.offer("Audi");
        queue.offer("BMW");
        queue.offer("Benz");
        queue.offer("Mazda");

        System.out.println(queue);

        System.out.println(queue.size()); // 4

        System.out.println(queue.contains("Audi")); // T

        System.out.println(queue.peek()); // return first object in queue

        queue.poll(); // dequeue first object

        System.out.println(queue);
```

​    Queue use case

    1. Keyboard Buffer (letters should appear in the order they're pressed)
    1. Printer Queue
    1. Used in LinkedList, PriorityQueues, Breath-First search

##### Priority Queue

```Java
    Queue<Double> queue = new PriorityQueue<Double>(Collections.reverseOrder());

        queue.offer(3.0);
        queue.offer(2.0);
        queue.offer(2.5);
        queue.offer(4.0);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
```

#### Linked List

Singly Linked List

[data | address] -> [data | address] -> [data | address]

Doubly Linked List

[address | data | address] <-> [address | data | address] <-> [address | data | address]

Advantages

1. Dynamic Date Structure (allocated needed memory while running)
2. Insertion and Deletion of Node is easy
3. No/Low memory waste

Disadvantage

1. Greater memory useage (additional usage)
2. No random access of element (no index[i])
3. Accessing/Searching elements is more time consuming 

Use case

1. implement Stack/Queues
2. GPS navigation
3. music playlist

```java
        LinkedList<String> linkedList_1 = new LinkedList<String>();
        LinkedList<String> linkedList_2 = new LinkedList<String>();

        linkedList_1.push("A");
        linkedList_1.push("B");
        linkedList_1.push("C");
        linkedList_1.push("D");
        linkedList_1.push("F");

        System.out.println(linkedList_1); // [F, D, C, B, A]
        linkedList_1.pop(); // remove F
        System.out.println(linkedList_1); // [D, C, B, A]

        linkedList_2.offer("A");
        linkedList_2.offer("B");
        linkedList_2.offer("C");
        linkedList_2.offer("D");
        linkedList_2.offer("F");

        System.out.println(linkedList_2); // [A, B, C, D, F]
        linkedList_2.poll(); // remove A

        linkedList_2.add(4, "E");
        linkedList_2.remove("E");
        System.out.println(linkedList_2); // [B, C, D, F]

        System.out.println(linkedList_2.peekFirst()); // B
        System.out.println(linkedList_2.peekLast()); // F
        linkedList_2.addFirst("0");
        linkedList_2.addLast("G");

```

#### Dynamic Array

Growth factor usually between 1.5 to 2.0, differnet by language

Advantages

1. Random acces of element
2. Good localoty of refence and data cache utilization
3. Easy to insert/delete at the end

Disadvantage

1. Waste more memory
2. Shifting elements is time consuming
3. Expanding/Shrinking the array is time consuming

```java
    DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");

        System.out.println(dynamicArray); // [A, B, C, null, null, null, null, null, null, null]

        dynamicArray.insert(0, "X"); // insert X
        dynamicArray.delete("A"); // delete A

        System.out.println(dynamicArray); // [X, B, C, null, null, null, null, null, null, null]
        System.out.println("Size: " + dynamicArray.size); // Size: 3
        System.out.println("Capacity: " + dynamicArray.capacity); // Capacity: 10
        System.out.println("Empty: " + dynamicArray.isEmpty()); // Empty: false
        System.out.println("Search: " + dynamicArray.search("C")); // Search: 2
```

```Java
public class DynamicArray {

    int size;
    int capacity = 10;
    Object[] array;

    public DynamicArray() {
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data) {
        if (size >= capacity) {
            grow();
        }
        array[size] = data;
        size++;
    }

    public void insert(int index, Object data) {
        if (size >= capacity) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        size++;
    }

    public void delete(Object data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data ) {
                for (int j = 0; j < (size - i - 1); j++ ){
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size --;
                if (size <= (int)(capacity/3)) {
                    shrink();
                }
                break;
            }
        }
    }

    public int search(Object data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        int newCapacity = (int)(capacity * 2);
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    private void shrink() {
        int newCapacity = (int)(capacity / 2);
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < capacity; i++ ) {
            string += array[i] + ", ";
        }
        if (string != "") {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        }
        else {
            string = "[]";
        }
        return string;
    }
}
```

#### Big O Notation

Big O notation is a mathematical notation used in computer science and mathematics to describe the efficiency or complexity of an algorithm. It provides an upper bound on the asymptotic growth rate of a function, indicating how the runtime or space requirements of an algorithm increase with the size of the input.

![BigONotation](/Users/cyz/Desktop/BigONotation.jpg)

#### Liner Search

Linear search is a simple search algorithm used to find a specific element within a collection. It works by sequentially checking each element in the collection until a match is found or the entire collection has been searched.

```java
    private static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
```

#### Binary Search

Binary search is a widely used search algorithm that efficiently finds the position of a target value within a **sorted** array or list. It works by repeatedly dividing the search space in half until the target value is found or determined to be absent.

```java
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
```

#### Interpolation search

Interpolation search is a search algorithm that improves upon **Binary search** by leveraging the assumption of **uniformly distributed** elements in a sorted array. It predicts the probable location of the target value based on the values of the first and last elements in the array.

```Java
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
```

#### Bubble Sort (O(n^2))

Bubble sort is a simple comparison-based sorting algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The algorithm continues iterating through the list until the entire list is sorted. Perform good for small data, bad for large data.

```java
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
```

#### Selection Sort (O(n^2))

Selection sort is comparison-based sorting algorithm. It sorts an array by repeatedly finding the minimum element from the unsorted part of the array and placing it at the beginning of the sorted part.

```java
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
```

#### Insertion Sort (O(n^2))

Insertion sort is a simple comparison-based sorting algorithm that builds the final sorted array one element at a time. It iterates through the input array and, in each iteration, selects an element and inserts it into its correct position in the already sorted portion of the array.

```java
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
```

#### Recursion

Recursion is a programming concept in which a function calls itself during its execution.

```java
    public static int power(int base, int exponent) {

        if (exponent < 1) return 1;
        return base * power(base, exponent - 1);
    }

    private static int factorial(int num) {

        if (num < 1) return 1;
        return num * factorial(num - 1);

    }
```

#### MergeSort (O(n log n))

Recursively divide array in 2, sort, re-combine;

```java
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
```

```java
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
```

#### QuickSort

Move smaller elements to left of a pivot, recursively divide array in 2 partitions;

runtime complexity = Best case O(n log(n)) / Average case O(n log(n)) / Worst case O(n^2) if alredy sorted

```java
		quickSort(array, 0, array.length - 1);    

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
```

#### Hash Table

Key.hashCode() % 10 capacity = index; formular to caluculate index

```java
        Hashtable<Integer, String> table = new Hashtable<Integer, String>(10);

        table.put(100, "Spongebob");
        table.put(123, "Patrick");
        table.put(321, "Sandy");
        table.put(555, "SquidWard");
        table.put(777, "Gary");
```

#### Undirected Graph

<img src="https://i0.wp.com/pediaa.com/wp-content/uploads/2019/01/Difference-Between-Directed-and-Undirected-Graph_Figure-2.png?resize=550%2C400" alt="img" style="zoom:50%;" />

	##### Adjacency Matrix

<img src="/Users/cyz/Desktop/Adjacency Matrix.png" alt="Adjacency Matrix" style="zoom:50%;" />

runtimr complexity to check edge: O(1)

space complexity: O(v^2)

```java
    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1,2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();

        System.out.println(graph.checkEdge(0,0));
    }
```

```java
public class Node {

    char data;

    Node(char data) {
        this.data = data;
    }
}
```

```java
import java.util.ArrayList;

public class Graph {

    ArrayList<Node> nodes;

    int[][] matrix;

    Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        if (matrix[src][dst] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void print() {
        System.out.print("  ");
        for (Node node : nodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++ ) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++ ) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

```

```java
  A B C D E 
A 0 1 0 0 0 
B 0 0 1 0 0 
C 0 0 0 1 1 
D 0 0 0 0 0 
E 1 0 1 0 0 
```

#### Directed Graph

<img src="https://i0.wp.com/pediaa.com/wp-content/uploads/2019/01/Difference-Between-Directed-and-Undirected-Graph_Figure-1.png?resize=550%2C360" alt="img" style="zoom:50%;" />

	##### Adjacency List

<img src="/Users/cyz/Desktop/Adjacency List.png" alt="Adjacency List" style="zoom: 33%;" />

runtime complexity to check an edge; O(v);

space complexity: O(v + e);

```java
    public static void main(String[] args) {

        Graph graph = new Graph();
        
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1,2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();
    }
```

```java
public class Node {

    char data;

    Node(char data) {
        this.data = data;
    }
}
```

```java
public class Graph {
    ArrayList<LinkedList<Node>> alist;

    Graph() {
        alist = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        alist.add(currentList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node> currentList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);
        currentList.add(dstNode);
    }

    public Boolean checkEdge(int src, int dst) {
        LinkedList<Node> currentList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);

        for (Node node : currentList) {
            if (node == dstNode) {
                 return true;
            }
        }
        return false;
    }

    public void print() {
        for (LinkedList<Node> currentList : alist) {
            for (Node node : currentList) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
```

```java
A -> B -> 
B -> C -> 
C -> D -> E -> 
D -> 
E -> A -> C -> 
```

*Notice: the below two method (DFS & BFS) need to added to above class.*

#### Depth First Search

DFS = Traverse a graph branch by branch, Utilizes a Stack, Better if destination is on average far from the start, Children are visited before sibling.

```java

		public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[matrix.length];
        dFSHelper(src, visited);
    }

    private void dFSHelper(int src, boolean[] visited) {
        if (visited[src]) {
            return;
        }
        else {
            visited[src] = true;
            System.out.println(nodes.get(src).data + " = visited");
        }

        for (int i = 0; i < matrix[src].length; i++) {
            if (matrix[src][i] == 1) {
                dFSHelper(i, visited);
            }
        }
        return;
    }
```

#### Breadth First Search

BFS = Traverse a graph level by level, Utilizes a Queue, Better if destinaiton is on average close to start, Silbing are visited before children.

```java
    public void breadthFirstSearch(int src) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while(queue.size() != 0) {
            src = queue.poll();

            System.out.println(nodes.get(src).data + " = visited");

            for (int i = 0; i < matrix[src].length; i++) {
                if (matrix[src][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
```

#### Tree

Binary Tree

Binary Search Tree

```java
public class BinarySearchTree {

    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node); // node for entire tree
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node); //
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    public boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        }
        else if (root.data == data) {
            return true;
        }
        else if (root.data > data) {
            return searchHelper(root.left, data);
        }
        else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {

        if (search(data)) {
            removeHelper(root, data);
        }
        else {
            System.out.println(data + " Not Be Found");
        }
    }

    private Node removeHelper(Node root, int data) {

        if (root == null) {
            return root;
        }
        else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        }
        else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        }
        else {
            // node found
            if (root.left == null && root.right == null) {
                root = null;
            }
            else if (root.right != null) {
                // find a successdor tp replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else {
                // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) {
        // find the least value below the right child of this root node
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        // find the least value below the left child of this root node
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}

```

```java
public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
```

Traversal Tree

<img src="https://www.freecodecamp.org/news/content/images/size/w1600/2022/02/ex-binary-search-tree.png" alt="img" style="zoom:50%;" />

In-order: left -> root -> right (e.g. D B E A F C G)

Post-order: left -> right -> root (e.g. D E B F G C A)

Pre-order: root -> left -> right (e.g. A B D E C F G)

#### Appendix

https://www.runoob.com/w3cnote/ten-sorting-algorithm.html

https://www.freecodecamp.org/news/binary-search-tree-traversal-inorder-preorder-post-order-for-bst/