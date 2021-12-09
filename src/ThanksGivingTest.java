
import org.junit.jupiter.api.*;

import java.util.ArrayList;

/**
 *This is a class to test the algorithm against test cases given by the instructors.
 * The optimal enjoyment values of the algorithm came from the test cases.
 * @author blepsch
 */
class ThanksGivingTest {

    /**
     * These are all Junit the test cases.
     */
    @Test
    void thanksGivingTests() {
        ArrayList<Double> optimalEnjoymentAnswers = new ArrayList<Double>();
        optimalEnjoymentAnswers.add(30.0);
        optimalEnjoymentAnswers.add(64.0);
        optimalEnjoymentAnswers.add(18.0);
        optimalEnjoymentAnswers.add(19.0);
        optimalEnjoymentAnswers.add(0.0);

        double[] testEnjoy1 = new double[]{4, 2, 5, 10, 3, 5, 17};
        int[] testWeight1 = new int[]{3, 2, 4, 10, 2, 7, 12};
        String[] objects1 = new String[]{"Turkey", "Pie", "Potatoes", "Gravy", "Stuffing", "Cranberries", "Casserole"};
        ThanksGivingAlgorithm test1 = new ThanksGivingAlgorithm(testEnjoy1, testWeight1, 20, objects1);
        Assertions.assertEquals(optimalEnjoymentAnswers.get(0), test1.getOptimalEnjoy());

        double[] testEnjoy2 = new double[]{4, 2, 5, 1, 3, 14, 24};
        int[] testWeight2 = new int[]{3, 2, 4, 1, 2, 10, 15};
        ThanksGivingAlgorithm test2 = new ThanksGivingAlgorithm(testEnjoy2, testWeight2, 41, objects1);
        Assertions.assertEquals(optimalEnjoymentAnswers.get(1), test2.getOptimalEnjoy());

        double[] testEnjoy3 = new double[]{5, 12, 1, 5, 1, 2, 3};
        int[] testWeight3 = new int[]{3, 4, 1, 2, 1, 2, 3};
        ThanksGivingAlgorithm test3 = new ThanksGivingAlgorithm(testEnjoy3, testWeight3, 7, objects1);
        Assertions.assertEquals(optimalEnjoymentAnswers.get(2), test3.getOptimalEnjoy());

        double[] testEnjoy4 = new double[]{6, 9, 0.5, 4, 1, 2, 3};
        int[] testWeight4 = new int[]{3, 4, 1, 2, 1, 2, 3};
        ThanksGivingAlgorithm test4 = new ThanksGivingAlgorithm(testEnjoy4, testWeight4, 9, objects1);
        Assertions.assertEquals(optimalEnjoymentAnswers.get(3), test4.getOptimalEnjoy());

        double[] testEnjoy5 = new double[]{7, 8, 9, 10, 11, 12, 13};
        int[] testWeight5 = new int[]{6, 7, 8, 9, 10, 11, 12};
        ThanksGivingAlgorithm test5 = new ThanksGivingAlgorithm(testEnjoy5, testWeight5, 5, objects1);
        Assertions.assertEquals(optimalEnjoymentAnswers.get(4), test5.getOptimalEnjoy());
        System.out.println("ALL TESTS PASSED!\n");


    }
}

