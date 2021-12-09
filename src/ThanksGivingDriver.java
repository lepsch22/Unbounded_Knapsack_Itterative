import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Driver for the Thanksgiving class. In here we create the userinput for the algorithm. The way it works is that the user will be
 * asked their stomach capacity, then a food item, its optimal enjoyment and wetght. The user wil continue entering food until
 * they are satisfied. The capacity must be a whole number.
 */
public class ThanksGivingDriver {
    public static void main(String[] args) {
        //Create arrays that wll be used for inputs.
        ArrayList<String> userInFood = new ArrayList<>();
        ArrayList<Double> userInEnjoy = new ArrayList<>();
        ArrayList<Integer> userInWeight = new ArrayList<>();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your stomach capacity(must be an int): ");
        int cap = myObj.nextInt();
        myObj.nextLine();

        Boolean flag = false;
        while(!flag) {

            System.out.println("Enter a food item, type quit when you are finished.");
            String foodItem = myObj.nextLine();
            userInFood.add(foodItem);
            if(foodItem.equals("quit")){
                flag = true;
            }
            else {

                System.out.println("Enjoyment level of " + foodItem + ": ");
                double foodEnjoy = myObj.nextDouble();
                myObj.nextLine();
                userInEnjoy.add(foodEnjoy);


                System.out.println("Weight level of(needs to be integer) " + foodItem + ": ");
                int foodWeight = myObj.nextInt();
                myObj.nextLine();
                userInWeight.add(foodWeight);
            }
        }
        //Organize the user inputs into the acceptable input for the function
        userInFood.remove(userInFood.size()-1);
        String[] userFood = new String[userInFood.size()];
        double[] userEnjoy = new double[userInFood.size()];
        int[] userWeight = new int[userInFood.size()];
        System.out.println(userInFood);
        for (int i = 0; i < userInFood.size(); i++) {
            userFood[i] = userInFood.get(i);
            userEnjoy[i] = userInEnjoy.get(i);
            userWeight[i] = userInWeight.get(i);
        }
        ThanksGivingAlgorithm userTest = new ThanksGivingAlgorithm(userEnjoy,userWeight,cap,userFood);
        System.out.println(userInFood);
        System.out.println(userInWeight);
        System.out.println(userInEnjoy);
    }

}
