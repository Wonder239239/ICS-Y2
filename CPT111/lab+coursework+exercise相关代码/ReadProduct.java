import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadProduct {
    private int ProductID;
    private String ProductName;
    private double ProductPrice;
    private int ProductQuantity;
    public ReadProduct(int ProductID, String ProductName, double ProductPrice, int ProductQuantity) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
    }
    public int getProductID() {
        return ProductID;
    }
    public String getProductName() {
        return ProductName;
    }
    public double getProductPrice() {
        return ProductPrice;
    }
    public int getProductQuantity() {
        return ProductQuantity;
    }

@Override
    public String toString() {
        return "ProductID: " + ProductID + ", Name: " + ProductName +
                ", Price: " + ProductPrice + ", Quantity: " + ProductQuantity;
    }


    public static void main(String[] args) {
        double totalPrice = 0;
        List<ReadProduct> readProducts = new ArrayList<ReadProduct>();
        File file = new File("src/products.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split(", ");
                int productID = Integer.parseInt(parts[0].split(": ")[1]);
                String productName = parts[1].split(": ")[1];
                double productPrice = Double.parseDouble(parts[2].split(": ")[1]);
                int productQuantity = Integer.parseInt(parts[3].split(": ")[1]);
                totalPrice += productPrice * productQuantity;
                ReadProduct readProduct = new ReadProduct(productID, productName, productPrice, productQuantity);
                readProducts.add(readProduct);
            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        for (ReadProduct readProduct : readProducts) {
            System.out.println(readProduct);
        }
        System.out.println( "Total Inventory Value: $"+totalPrice);
    }

}
