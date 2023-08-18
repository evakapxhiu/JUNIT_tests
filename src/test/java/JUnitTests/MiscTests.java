package JUnitTests;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTests {
    @Test
    @Timeout(5)
    void timeout() throws InterruptedException{
        System.out.println("Test ran fast");
        Thread.sleep(6000);
    }
    @MyAnnotations
    void annotadeTests()throws InterruptedException{
        System.out.println("This is the custom annotated method!");
//        Thread.sleep(3000);
    }
    @Test
    @Timeout(90)
    @DisplayName("Method")
    @Tag("theTag")
    void annotadeTests2(){
        System.out.println("This is the  annotated method!");
    }
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest    {
        @BeforeAll
        void beforeAll(){
            System.out.println("Before all!");
        }
        @Test
        void nestedTest(){
            System.out.println("Nested testsss");
        }
    }
}
