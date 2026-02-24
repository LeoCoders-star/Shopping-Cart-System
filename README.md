Shopping Cart System (Java Console Application)
A simple console-based shopping cart system written in Java. It allows users to add products, view cart, remove items, and checkout with discount calculation.

Features
Add Product – Input product name (letters only), price (positive double), and quantity (positive integer).
View Cart – Display all items with their price, quantity, and subtotal.
Remove Product – Remove an item from the cart by selecting its number.
Checkout – Calculate total, apply 10% discount if total > RM200, and show final payment.
Exit – Terminate the program.

Code Structure
Static arrays – productName, productPrice, productQuantity (maximum 100 items).
menu() – Main loop displaying options and calling corresponding methods.
add() – Handles adding a new product with input validation.
viewCartScreen() – Displays all items with subtotals.
removeProduct() – Prompts for item number and calls deleteProduct().
deleteProduct() – Shifts array elements to remove the selected item.
calculateSubtotal() – Returns price * quantity.
calculateDiscount() – Returns 10% of total if total > 200, else 0.
checkOut() – Calculates total, discount, and displays receipt.
pressEnterToContinue() – Utility to pause the screen.

Limitations
Fixed maximum of 100 products.
No persistent storage (data is lost when program exits).
Simple console interface (no GUI).
Discount only applies when total exceeds RM200.

License
This project is open source and available under the MIT License.
