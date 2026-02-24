import java.util.Scanner;

public class ForBackUp5 {

    static int index = 0;
    static String[] productName = new String [100];
    static double[] productPrice = new double[100];
    static int[] productQuantity = new int[100];

    public static void menu() {

        Scanner input = new Scanner(System.in);
        int startMenu;

        while (true) {
            System.out.print("=====================================");
            System.out.print("\n        SHOPPING CART SYSTEM");
            System.out.print("\n=====================================");
            System.out.print("\n1. Add Product");
            System.out.print("\n2. View Card");
            System.out.print("\n3. Remove Product");
            System.out.print("\n4. Checkout");
            System.out.print("\n5. Exit");
            System.out.print("\nChoose option: ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    add();
                    break;

                case 2:
                    viewCartScreen();
                    break;

                case 3:
                    removeProduct();
                    break;

                case 4:
                    checkOut();
                    break;
        
                case 5:
                    System.out.print("\nThank you for using Shopping Cart System.");
                    System.out.print("\nProgram terminated.");
                    return;
                default:
                    System.out.print("\nInvalid Option!\n\n");
            }
        }
    }

    public static void pressEnterToContinue() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nPress Enter to continue...\n");
        input.nextLine();
    }

    public static void add() {

        Scanner input = new Scanner(System.in);
        String nameProduct;
        double priceProduct;
        int quantityProduct;

        System.out.print("\n=====================================");
        System.out.print("\n            ADD PRODUCT");
        System.out.print("\n=====================================");

        while (true) {
            System.out.print("\nEnter product name: ");
            nameProduct = input.nextLine();

            if (nameProduct.matches("[a-zA-Z ]+")) {
                productName[index] = nameProduct;
                break;
            } else {
                System.out.print("Invalid! Words Only...\n");
            }
        }

        while (true) {
            System.out.print("Enter product price (RM): ");

            if (input.hasNextDouble()) {
                priceProduct = input.nextDouble();

                if (priceProduct > 0) {
                    productPrice[index] = priceProduct;
                    break;
                } else {
                    System.out.print("Invalid! Value cannot be negative.\n\n");
                }

            } else {
                System.out.print("Invalid! Numbers Only...\n\n");
                input.next();
            }
        }

        while (true) {
            System.out.print("Enter quantity: ");

            if (input.hasNextInt()) {
                quantityProduct = input.nextInt();

                if (quantityProduct > 0) {
                    productQuantity[index] = quantityProduct;
                    break;
                } else {
                    System.out.print("Invalid! Value cannot be negative.\n\n");
                }
            } else {
                System.out.print("Invalid! Numbers Only...\n\n");
                input.next();
            }
        }

        index++;

        System.out.print("\nProduct successfully added to cart!\n");

        pressEnterToContinue();

    }

    public static double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    public static void viewCartScreen() {

        System.out.print("\n=====================================");
        System.out.print("\n              YOUR CART");
        System.out.print("\n=====================================\n");
        System.out.printf("%-4s %-12s %-8s %-6s %-10s\n",
                            "No", "Product", "Price", "Qty", "Subtotal");
        System.out.print("------------------------------------------------\n");

        for (int i = 0; i < index; i++) {
            double subTotal = calculateSubtotal(productPrice[i], productQuantity[i]);
            System.out.printf( "%-4s %-12s %-8.2f %-6s %-10.2f\n", 
                                i + 1 , productName[i], productPrice[i], productQuantity[i], subTotal);
        }

        System.out.print("------------------------------------------------\n\n");
        System.out.print("\nTotal Items: " + index);
        pressEnterToContinue();
    }

    public static void removeProduct() {

        Scanner input = new Scanner(System.in);
        int numDelete;

        System.out.print("\n=====================================");
        System.out.print("\n          REMOVE PRODUCT");
        System.out.print("\n=====================================\n");

        for (int i = 0; i < index; i++) {
            System.out.print("\n" + (i + 1) + ". " + productName[i]);
        }

        System.out.print("\n\nEnter product number to remove: ");
        numDelete = input.nextInt();

        deleteProduct(numDelete - 1);

        System.out.print("\nProduct removed successfully!\n");

        pressEnterToContinue();
    }

    public static void deleteProduct(int numDelete) {

        for (int i = numDelete; i < index - 1; i++) {
            productName[i] = productName[i + 1];
            productPrice[i] = productPrice[i + 1];
            productQuantity[i] = productQuantity[i + 1];
        }

        index--;
    }

    public static double calculateDiscount(double total) {
        if (total > 200) {
            return total * 0.1;
        } else {
            return 0;
        }
    }

    public static void checkOut() {

        double total = 0, discount, totalPayment;

        System.out.print("\n=====================================");
        System.out.print("\n              CHECKOUT");
        System.out.print("\n=====================================\n");

        for (int i = 0; i < index; i++) {
            double subTotal = calculateSubtotal(productPrice[i], productQuantity[i]);
            System.out.printf("%-17s  %-12s RM%-5.2f", 
                                        productName[i], "x"+productQuantity[i], subTotal
            );
            total += subTotal;
        }

        discount = calculateDiscount(total);
        totalPayment = total - discount;

        System.out.print("\n\n-------------------------------------");
        System.out.printf("\nSubtotal:                       RM%.2f", total);
        System.out.printf("\nDiscount:                       RM%.2f", discount);
        System.out.print("\n-------------------------------------");
        System.out.printf("\nTOTAL PAYMENT:                  RM%.2f", totalPayment);
        System.out.print("\n-------------------------------------");

        System.out.print("\n\nThank you for shopping!\n");
        pressEnterToContinue();
    }

    public static void main(String[] args) {
        menu();
    }
}