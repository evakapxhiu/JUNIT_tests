package JUnitTests;

import listeners.Listeners;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(Listeners.class)
public class AssertionsTest {

    @Test
    void assertEqualsTest(){
        assertEquals("firstString","secondString");
    }
    @Test
    void assertEqualsListTest(){
        List<String> expectedvAlues= Arrays.asList("first","second","third");
        List<String> actualValues=Arrays.asList("first","second","third");
        assertEquals(expectedvAlues,actualValues);
    }
    @Test
    void assertArrayEquals(){
        int [] expValues={1,2,3};
        int [] actual={1,2,3};
        Assertions.assertArrayEquals(expValues,actual);
    }
    @Test
    void assertTrue(){
        assertFalse(false);
//        Assertions.assertTrue(false,"This boolean condition did not evaluate to true");
    }
    @Test
    void assertThrowsTest(){
        assertThrows(NullPointerException.class,null);
    }
    @Test
    void assertAll(){
      Assertions.assertAll(
                ()->assertEquals("firstString","secondString"),
                ()->assertThrows(NullPointerException.class,null),
                ()->Assertions.assertTrue(false,"This boolean condition did not evaluate to true"));
    }

    @Test
    void assertForMapTest(){
        Map<String,Integer> map=new HashMap<>();
        map.put("first",1);
        map.put("second",2);

        assertThat(map,Matchers.hasKey("second"));
        assertThat(map,Matchers.hasValue(2));
    }
    @Test
    void assertForLists(){
        List<String> list=Arrays.asList("first","second","third");
        assertThat(list,Matchers.hasItem("third"));
    }


}
