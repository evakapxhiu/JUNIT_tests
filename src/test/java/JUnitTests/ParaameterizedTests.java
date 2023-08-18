package JUnitTests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParaameterizedTests {
    @ParameterizedTest(name="Run : {index} -  value : {arguments}")
    @ValueSource(ints={1,5,6})
    void intValues(int param){
        System.out.println("param = " + param);
    }

    @ParameterizedTest(name="Run : {index} : Value : {arguments}")
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    @ValueSource(strings={"first","second","third"})
    void stringValues(String params){
        System.out.println("params = " + params);
    }

    @ParameterizedTest
    @CsvSource(value={"steve,rogers","eva,eva","today,tomorrow"})
    void stringString(String param1,String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value={"Eva,34,true","Eva,4,false","Me,44,false"})
    void stringIntBoolean(String param1,int param2,boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value={"eva eva,'eva,eva'","winter winter,"+ "'me,me'"})
    void stringWithComa(String param1,String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers","steve?steve"},delimiter = '?')
    void stringDelimiter(String param1,String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files={"src/test/resources/params/shoppinglist.csv","src/test/resources/params/shoppinglist2.csv"},numLinesToSkip = 1)
    void fileSource(String name,double price,int qty,String unit,String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty +
                ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/params/shoppinglist3.csv",numLinesToSkip = 1,delimiterString = "__")
    void fileSourceWithDelimeter(String name,double price,int qty,String unit,String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty +
                ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource(String param1){
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString (){
        //processing done here
        return Arrays.asList("cherries","mango","strawberry");
    }

    @ParameterizedTest
    @MethodSource(value = "streamOfValues")
    void methodSource2(String param1){
        System.out.println("param1 = " + param1);
    }
    Stream<String> streamOfValues(){
        return Stream.of("carrot","apple","mango");
    }

    @ParameterizedTest
    @MethodSource(value = "listOfArg")
    void methodSourceWithListOfArg(String param1,double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    List<Arguments> listOfArg(){
        return  Arrays.asList(arguments("carrot",3.0), arguments("cherries",4.5));
    }

    @ParameterizedTest
    @MethodSource(value = "JUnitTests.ParamProvider#streamOfArg")
    void methodSourceWithStream(String param,double param1){
        System.out.println("param = " + param + ", param1 = " + param1);
    }

}
