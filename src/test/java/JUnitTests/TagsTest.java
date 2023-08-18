package JUnitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TagsTest {
    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before all test");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("------This is the before each test");

    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after all test");

    }

    @AfterEach
    void afterEach(){
        System.out.println("------This is the after each test");

    }
    @Test
    @Tag("sanity")
    void firstTest(){
        System.out.println("This is the first test");
    }
    @Test
    @Tag("sanity")
    @Tag("acceptance")
    void secondTest(){
        System.out.println("The second test!");
    }
    @Test
    @Tag("acceptance")
    void thirdTest(){
        System.out.println("Third test-----");
    }
    @Tag("acceptance")
    @ParameterizedTest(name="Run : {index} -  value : {arguments}")
    @ValueSource(ints={1,5,6})
    void intValues(int param) {
        System.out.println("param = " + param);

    }
}
