package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ObjectArray {
    private Object[] array;

    // Constructor
    public ObjectArray(int size) {
        array = new Object[size];
    }

    // Method to populate the array
    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + array.length + " elements: ");

        String input = scanner.nextLine();
        String[] elements = input.split("\\s*,\\s*"); // Split input by commas, trimming spaces

        for (int i = 0; i < array.length; i++) {
            array[i] = elements[i];
        }
    }

    // Method to display elements in reverse order
    public void displayReverseOrder() {
        System.out.print("Reverse Order: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + (i == 0 ? "" : ", "));
        }
        System.out.println();
    }

    // Method to display numeric elements in ascending order
    public void displayAscendingOrder() {
        ArrayList<NumberStringPair> pairs = new ArrayList<>();

        for (Object element : array) {
            String str = element.toString();
            try {
                int number = Integer.parseInt(str.split("\\s+")[0]);
                String text = str.substring(str.indexOf(' ') + 1);
                pairs.add(new NumberStringPair(number, text));
            } catch (NumberFormatException e) {
                // Ignore non-numeric elements
            }
        }

        Collections.sort(pairs, Comparator.comparingInt(pair -> pair.number));

        System.out.print("Ascending Order: ");
        for (int i = 0; i < pairs.size(); i++) {
            System.out.print(pairs.get(i) + (i == pairs.size() - 1 ? "" : ", "));
        }
        System.out.println();
    }

    // Static nested class to hold number and string pair
    private static class NumberStringPair {
        int number;
        String text;

        public NumberStringPair(int number, String text) {
            this.number = number;
            this.text = text;
        }

        @Override
        public String toString() {
            return number + " " + text;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the size of the array
        System.out.print("Enter Size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Create an instance of ObjectArray
        ObjectArray objArray = new ObjectArray(size);

        // Populate the array
        objArray.populateArray();

        // Display in reverse order
        objArray.displayReverseOrder();

        // Display numeric elements in ascending order
        objArray.displayAscendingOrder();
    }
}