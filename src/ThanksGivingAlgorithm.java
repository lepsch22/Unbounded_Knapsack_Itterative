import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

/**
 *This is a class to run the thanksgiving knapsack algorithm.
 * @author blepsch
 */
public class ThanksGivingAlgorithm {
    /**
     * A list of enjoyment values.
     */
    private double[] enjoy;
    /**
     * a list of weights
     */
    private int[] weight;
    /**
     * the capacity used in the algorithm
     */
    private int Cap;
    /**
     * The dynamic matrix to keep track of current maximum enjoyments
     */
    private double[][] WEC;
    /**
     * List of the foods used
     */
    String[] foodList;
    /**
     * Optimal enjoyment given parameters
     */
    private double optimalEnjoy;


    /**
     * The thanksgiving problem is a play on your usual knapsack problem. A knapsack problem is when you are given a list of items
     * athey consist of profits and weight. The knapsack algorithm find you the most optimal enjoyment given the list of objects
     * and given a total capacity. In this problem we are given an unlimited amount of items we can choose. Therefore this algorithm
     * is an unbounded knapsack problem.
     * @param inEnjoy is used for the list of enjoyments.
     * @param inWeight is used for a list of weights
     * @param c is the capacity
     * @param infoodList is the list of capacities
     *
     */
    public ThanksGivingAlgorithm(double[] inEnjoy, int[] inWeight, int c,String[] infoodList) {

        foodList = infoodList;
        enjoy = inEnjoy;
        weight = inWeight;
        Cap = c;
        int n = enjoy.length;
        WEC = new double[n+1][Cap + 1];
        String[][] numOfItems = new String[n+1][Cap+1];

        for (int i = 0; i < n+1; i++) {//We need to look at each row
            for (int j = 0; j < Cap + 1; j++) {//For each row we want to look at each col
                if(i == 0 || j==0){
                    WEC[i][j] = 0;
                    numOfItems[i][j] = "";
                }
                else if (weight[i-1] > j) {//If the weight of our current index is more than the current capacity go to the previous row and grab the value
                    WEC[i][j] = WEC[i - 1][j];
                    numOfItems[i][j] = numOfItems[i-1][j] ;

                } else if (weight[i-1] <= j) {
                    WEC[i][j] = Math.max(WEC[i - 1][j], WEC[i][j - weight[i-1]] + enjoy[i-1]);//This is the algorithmic part of knapsack. First we grab the previous col value and then comapare it to the new value
                    if(WEC[i][j - weight[i-1]] + enjoy[i-1] > WEC[i - 1][j]) {

                        numOfItems[i][j] = numOfItems[i][j-weight[i-1]]+Integer.toString(i);

                    }
                    else{
                        numOfItems[i][j] = numOfItems[i-1][j] ;
                    }
                }
                else {
                    WEC[i][j] = 0;//If there are no weights of capacity then just add 0+
                }
            }
        }
        //System.out.println(Arrays.deepToString(WEC).replace("], ", "]\n"));
        System.out.println("Optimal enjoyment value of " + WEC[n][Cap]);
        optimalEnjoy = WEC[n][Cap];
        //System.out.println(Arrays.deepToString(numOfItems).replace("], ", "]\n"));
        //System.out.println("Optimal Choices " + numOfItems[n][Cap]);
        int[] foodAmount = new int[n];
        for (char a:numOfItems[n][Cap].toCharArray()) {
            int foodIndex = Character.getNumericValue(a)-1;
            foodAmount[foodIndex] +=1;
        }
        String stringBuilder = "";
        for (int i = 0; i < foodAmount.length; i++) {
            stringBuilder += foodList[i]+": "+foodAmount[i]+", ";

        }
        stringBuilder += "\n";
        System.out.println(stringBuilder);
    }

    /**
     * A getter to grab the optimal enjoyment of the algorithm to use in out Junit tests.
     * @return optimal enjoyment
     */
    public double getOptimalEnjoy() {
        return optimalEnjoy;
    }
}


