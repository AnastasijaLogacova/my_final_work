package lu.lv.finalWork.ui;



import lu.lv.finalWork.model.ProductInputData;
import lu.lv.finalWork.service.ProductService;

import java.util.Scanner;

public class ConsulUi {
    private ProductService productService = new ProductService();
    private int UserChoice;

    public void run() {

        Scanner scanner = new Scanner(System.in);

        int userChoice;
        while (true) {

            printMenu();

            userChoice = scanner.nextInt();

            if (userChoice == 1) {
                ProductInputData productInputData = new ProductInputData();

                              productService.save(productInputData);
            } else if (userChoice ==2){
                productService.findAll();
            }

            if (userChoice == 0) {
                break;
            }

        }
    }

    private void printMenu() {
        System.out.println("\n\n ===Product Accounting Application ===");
        System.out.println("Choose one option: \n");
        System.out.println("save product - 1");
        System.out.println("list all products - 2");

        System.out.println(" exit application - 0");
        System.out.println("please enter the choice");
    }


}
