import java.io.*;
import java.util.*;
import java.util.Scanner;

interface paymentMethod{
    public void makePayment();
}


class payUsingCOD implements paymentMethod{
         public void makePayment()
         {
             System.out.println("Payment using Cash on Delivery selected.\n");
         }

}

class payUsingDebitCard implements paymentMethod{
         public void makePayment()
         {
             System.out.println("Payment using Debit Card selected.\n");
         }

}

class payUsingCreditCard implements paymentMethod{
         public void makePayment()
         {
             System.out.println("Payment using Credit Card selected.\n");
         }

}

class payUsingNetBanking implements paymentMethod{
         public void makePayment()
         {
             System.out.println("Payment using Net Banking selected.\n");
         }

}

class shoppingCart
{
    paymentMethod myPayment;
    int noOfItems;
    Vector items = new Vector(); 

    public void addItemsInCart(shoppingCart sC){
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter Item name: ");
        String str  = input.nextLine();
        sC.items.add(str);
        sC.noOfItems = sC.items.size();
    }
    public int getNoOfItems(shoppingCart sC){
           return sC.noOfItems;
    }

    public void getItemsInCart(shoppingCart sC){
        Enumeration e = sC.items.elements();
        System.out.println("\nItems in cart are: "); 
        while (e.hasMoreElements()) {         
           System.out.println(e.nextElement());
        }           
    }
 
    public void setPaymentMethod(shoppingCart sC)                    /// changing the payment method at runtime
    {
        System.out.println("\nEnter your choice for payment: \n");
        System.out.println("1. Pay using Cash on Delivery \n");
        System.out.println("2. Pay using Debit Card \n");
        System.out.println("3. Pay using Credit Card \n");
        System.out.println("4. Pay using Net Banking \n");
        Scanner sc = new Scanner(System.in); 
        int choice = sc.nextInt();
        
        switch(choice){
             case 1:
                sC.myPayment = new payUsingCOD();
                break;
             case 2:
                sC.myPayment = new payUsingDebitCard();
                break;
             case 3:
                sC.myPayment = new payUsingCreditCard();
                break;
             case 4:
                sC.myPayment = new payUsingNetBanking();
                break;
             default:
                System.out.println("Please select a valid option");   
         }

    }

    public void makeMyPayment(shoppingCart sC)
    {
        sC.myPayment.makePayment();
    }


}







public class strategyPattern {
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("This is a Strategy Pattern \n");
       
        shoppingCart cart = new shoppingCart();
        cart.addItemsInCart(cart);
        int items = cart.getNoOfItems(cart);
        System.out.println("\nNo of Items in cart are: "+items);
        cart.getItemsInCart(cart);
        cart.setPaymentMethod(cart);
        cart.makeMyPayment(cart);
    } 
    
}
