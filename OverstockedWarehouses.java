import java.util.Scanner;

public class OverstockedWarehouses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter number of warehouses and product types
        System.out.print("Enter the number of warehouses (rows): ");
        int r = sc.nextInt(); // number of rows (warehouses)

        System.out.print("Enter the number of product types (columns): ");
        int c = sc.nextInt(); // number of columns (product types)

        // Creating a 2D array to store the stock values
        int[][] stock = new int[r][c];

        // Asking the user to enter stock values row by row
        System.out.println("Enter the stock values row by row (space-separated):");
        for (int i = 0; i < r; i++) {
            System.out.print("Warehouse " + (i + 1) + ": ");
            for (int j = 0; j < c; j++) {
                stock[i][j] = sc.nextInt();
            }
        }

        int overstockedCount = 0; // Counter for overstocked warehouses

        // Loop through each warehouse
        for (int i = 0; i < r; i++) {
            int highStockItems = 0; // Count of items >= 100 in current warehouse

            // Check each product type in the warehouse
            for (int j = 0; j < c; j++) {
                if (stock[i][j] >= 100) {
                    highStockItems++;
                }
            }

            // If there are 3 or more items with stock >= 100 → it's overstocked
            if (highStockItems >= 3) {
                overstockedCount++;
            }
        }

        // Output the result: number of overstocked warehouses
        System.out.println("Number of overstocked warehouses: " + overstockedCount);
    }
}
