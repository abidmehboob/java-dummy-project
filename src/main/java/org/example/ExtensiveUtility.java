package org.example;

import java.util.*;
import java.time.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;

/**
 * An extensive utility class providing a wide range of helper methods for various operations.
 * This class includes methods for string manipulation, mathematical calculations,
 * data structure operations, cryptography, and more.
 */
public class ExtensiveUtility {
    
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final String ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final ConcurrentHashMap<String, Object> CACHE = new ConcurrentHashMap<>();
    
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private ExtensiveUtility() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Generates a random string of specified length using alphanumeric characters.
     *
     * @param length the desired length of the random string
     * @return a random alphanumeric string
     * @throws IllegalArgumentException if length is negative
     */
    public static String generateRandomString(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative");
        }
        
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHA_NUMERIC.charAt(RANDOM.nextInt(ALPHA_NUMERIC.length())));
        }
        return sb.toString();
    }

    /**
     * Calculates the factorial of a number using BigInteger for large numbers.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Performs matrix multiplication of two 2D arrays.
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return resulting matrix after multiplication
     * @throws IllegalArgumentException if matrices cannot be multiplied
     */
    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1 == null || matrix2 == null || matrix1.length == 0 || matrix2.length == 0 ||
            matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");
        }

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    /**
     * Computes the MD5 hash of a string.
     *
     * @param input the string to hash
     * @return MD5 hash as hexadecimal string
     * @throws RuntimeException if MD5 algorithm is not available
     */
    public static String calculateMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    /**
     * Implements the Levenshtein distance algorithm to calculate the edit distance between two strings.
     *
     * @param str1 first string
     * @param str2 second string
     * @return the Levenshtein distance between the strings
     */
    public static int calculateLevenshteinDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1)
                    );
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    /**
     * Implements the Fisher-Yates shuffle algorithm to randomly permute a list.
     *
     * @param list the list to shuffle
     * @param <T> the type of elements in the list
     */
    public static <T> void shuffleList(List<T> list) {
        int size = list.size();
        for (int i = size - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    /**
     * Implements binary search algorithm for sorted arrays.
     *
     * @param array sorted array to search in
     * @param target value to find
     * @return index of target if found, -1 otherwise
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Validates an email address using regex pattern matching.
     *
     * @param email the email address to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Generates all permutations of a string.
     *
     * @param str the input string
     * @return set of all possible permutations
     */
    public static Set<String> generatePermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            return permutations;
        }
        
        generatePermutationsHelper("", str, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, Set<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsHelper(
                    prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1, n),
                    permutations
                );
            }
        }
    }

    /**
     * Implements the quicksort algorithm for sorting arrays.
     *
     * @param array the array to sort
     */
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Calculates the nth Fibonacci number using dynamic programming.
     *
     * @param n the position in Fibonacci sequence
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static BigInteger calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative numbers");
        }

        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        return fib[n];
    }

    /**
     * Implements a simple LRU (Least Recently Used) cache.
     */
    public static class LRUCache<K, V> {
        private final int capacity;
        private final LinkedHashMap<K, V> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > capacity;
                }
            };
        }

        public V get(K key) {
            return cache.get(key);
        }

        public void put(K key, V value) {
            cache.put(key, value);
        }
    }

    /**
     * Calculates prime factors of a number.
     *
     * @param n the number to factorize
     * @return list of prime factors
     * @throws IllegalArgumentException if n is less than 2
     */
    public static List<Long> calculatePrimeFactors(long n) {
        if (n < 2) {
            throw new IllegalArgumentException("Number must be greater than 1");
        }

        List<Long> factors = new ArrayList<>();
        long remaining = n;

        for (long i = 2; i * i <= remaining; i++) {
            while (remaining % i == 0) {
                factors.add(i);
                remaining /= i;
            }
        }

        if (remaining > 1) {
            factors.add(remaining);
        }

        return factors;
    }

    /**
     * Implements the Knuth-Morris-Pratt string matching algorithm.
     *
     * @param text the text to search in
     * @param pattern the pattern to search for
     * @return list of starting indices where pattern matches
     */
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        if (text == null || pattern == null || pattern.length() > text.length()) {
            return matches;
        }

        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                matches.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return matches;
    }

    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    /**
     * Implements depth-first search algorithm for a graph represented as adjacency list.
     *
     * @param graph the adjacency list representation of the graph
     * @param start the starting vertex
     * @return list of vertices in DFS order
     */
    public static List<Integer> depthFirstSearch(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        dfsHelper(graph, start, seen, visited);
        return visited;
    }

    private static void dfsHelper(Map<Integer, List<Integer>> graph, int vertex, 
                                Set<Integer> seen, List<Integer> visited) {
        seen.add(vertex);
        visited.add(vertex);

        List<Integer> neighbors = graph.getOrDefault(vertex, Collections.emptyList());
        for (int neighbor : neighbors) {
            if (!seen.contains(neighbor)) {
                dfsHelper(graph, neighbor, seen, visited);
            }
        }
    }

    /**
     * Implements breadth-first search algorithm for a graph represented as adjacency list.
     *
     * @param graph the adjacency list representation of the graph
     * @param start the starting vertex
     * @return list of vertices in BFS order
     */
    public static List<Integer> breadthFirstSearch(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            visited.add(vertex);

            List<Integer> neighbors = graph.getOrDefault(vertex, Collections.emptyList());
            for (int neighbor : neighbors) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visited;
    }

    /**
     * Implements the union-find data structure with path compression and union by rank.
     */
    public static class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                if (rank[rootX] == rank[rootY]) {
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    /**
     * Implements a min heap data structure.
     */
    public static class MinHeap<T extends Comparable<T>> {
        private final List<T> heap;

        public MinHeap() {
            this.heap = new ArrayList<>();
        }

        public void add(T element) {
            heap.add(element);
            siftUp(heap.size() - 1);
        }

        public T poll() {
            if (heap.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }

            T result = heap.get(0);
            T lastElement = heap.remove(heap.size() - 1);

            if (!heap.isEmpty()) {
                heap.set(0, lastElement);
                siftDown(0);
            }

            return result;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap.get(parentIndex).compareTo(heap.get(index)) <= 0) {
                    break;
                }
                swap(index, parentIndex);
                index = parentIndex;
            }
        }

        private void siftDown(int index) {
            int size = heap.size();
            while (true) {
                int smallest = index;
                int leftChild = 2 * index + 1;
                int rightChild = 2 * index + 2;

                if (leftChild < size && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                    smallest = leftChild;
                }
                if (rightChild < size && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                    smallest = rightChild;
                }

                if (smallest == index) {
                    break;
                }

                swap(index, smallest);
                index = smallest;
            }
        }

        private void swap(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int size() {
            return heap.size();
        }
    }

    /**
     * Calculates the greatest common divisor of two numbers using Euclidean algorithm.
     *
     * @param a first number
     * @param b second number
     * @return greatest common divisor
     */
    public static long calculateGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /**
     * Calculates the least common multiple of two numbers.
     *
     * @param a first number
     * @param b second number
     * @return least common multiple
     */
    public static long calculateLCM(long a, long b) {
        return Math.abs(a * (b / calculateGCD(a, b)));
    }

    /**
     * Implements the Rabin-Karp string matching algorithm.
     *
     * @param text the text to search in
     * @param pattern the pattern to search for
     * @return list of starting indices where pattern matches
     */
    public static List<Integer> rabinKarpSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        if (text == null || pattern == null || pattern.length() > text.length()) {
            return matches;
        }

        final int prime = 101;
        final int d = 256;
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // Calculate h = pow(d, M-1) % prime
        for (i = 0; i < m - 1; i++) {
            h = (h * d) % prime;
        }

        // Calculate initial hash values
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % prime;
            t = (d * t + text.charAt(i)) % prime;
        }

        // Find matches
        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    matches.add(i);
                }
            }

            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                if (t < 0) {
                    t = (t + prime);
                }
            }
        }

        return matches;
    }

    /**
     * Implements the merge sort algorithm.
     *
     * @param array array to sort
     * @param <T> type of elements that extend Comparable
     * @return sorted array
     */
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> array) {
        if (array.size() <= 1) {
            return new ArrayList<>(array);
        }

        int mid = array.size() / 2;
        List<T> left = mergeSort(array.subList(0, mid));
        List<T> right = mergeSort(array.subList(mid, array.size()));

        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }

    /**
     * Generates all combinations of k elements from n elements.
     *
     * @param n total number of elements
     * @param k size of each combination
     * @return list of all possible combinations
     */
    public static List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 0 || k > n) {
            return result;
        }

        generateCombinationsHelper(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(int n, int k, int start, 
                                                List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinationsHelper(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Implements Dijkstra's shortest path algorithm.
     *
     * @param graph weighted graph represented as adjacency map
     * @param start starting vertex
     * @return map of vertices to their shortest distance from start
     */
    public static Map<Integer, Integer> dijkstraShortestPath(
            Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();

        // Initialize distances
        pq.offer(new int[]{start, 0});
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int distance = current[1];

            if (visited.contains(vertex)) {
                continue;
            }
            visited.add(vertex);

            Map<Integer, Integer> neighbors = graph.getOrDefault(vertex, new HashMap<>());
            for (Map.Entry<Integer, Integer> neighbor : neighbors.entrySet()) {
                int nextVertex = neighbor.getKey();
                int weight = neighbor.getValue();

                if (!visited.contains(nextVertex)) {
                    int newDistance = distance + weight;
                    if (newDistance < distances.getOrDefault(nextVertex, Integer.MAX_VALUE)) {
                        distances.put(nextVertex, newDistance);
                        pq.offer(new int[]{nextVertex, newDistance});
                    }
                }
            }
        }

        return distances;
    }
}
