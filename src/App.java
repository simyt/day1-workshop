import java.io.Console;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//compiling: javac --source-path src -d bin src/*
//running compiled file: java -cp bin App (Do it inside bin folder)
//slide 12, packaging to jar: jar -c -v -f day01.jar -e App. (without going into the class file)
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart.");

        List<String> cartItems = new ArrayList<>();

        Console cons = System.console();
        String input = "";

        
        while (!input.equals("quit")) {
            input = cons.readLine();
            input = input.toLowerCase();

            if (input.equals("list")){

                if (cartItems.size()>0) {
                    for (int i = 0; i < cartItems.size(); i++){
                        System.out.println((i+1) + cartItems.get(i));
                    }
                } else {
                    System.out.println("Your cart is empty!");
                }
            }

            if (input.startsWith("add")) {
                input = input.replace(',',' '); //single quotation

                Scanner scan = new Scanner(input.substring(4));
                String stringVal = "";
                while (scan.hasNext()){
                    stringVal = scan.next();
                    cartItems.add(stringVal);

                }

            }

            if (input.startsWith("delete")) {
                Scanner scan = new Scanner(input.substring(6));

                int cartPosition = Integer.parseInt(scan.next());
                cartPosition = cartPosition - 1 ;

                if (cartPosition < cartItems.size()){
                    //delete items from cart
                    cartItems.remove(cartPosition);


                } else {
                    System.out.println("Incorrect item index");
                }
                
            }
        }
        System.out.println("Bye! See you again...");
    }
}
