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

            System.out.print("\nChoose option: ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    add();
                    break;
        
                default:
                    break;
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

    public static void main(String[] args) {
        menu();
    }
}