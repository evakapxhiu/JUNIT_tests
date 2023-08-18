package JUnitTests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {
    //Run the code 5 times
    @RepeatedTest(5)
    void firstRepeatMethod(){
        System.out.println("We repeat this test");
    }
    @RepeatedTest(value = 3,name = "Running repetiton : {currentRepetition}."+ " Total is : {totalRepetitions]")
    void secondMethod(){
        System.out.println("We are repating a new method");
    }
    @RepeatedTest(3)
    void thirdTest(RepetitionInfo repInfo){
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repInfo.getCurrentRepetition()==3, () ->
            System.out.println("This code run only for rep. 3"));
    }
}
