package JUnitTests;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTests {

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
    void firstTest(){
        System.out.println("This is the first test");
    }
    @Test
    void secondTest(){
        System.out.println("The second test!");
    }
}
