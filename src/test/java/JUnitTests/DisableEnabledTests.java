package JUnitTests;

import listeners.Listeners;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
@ExtendWith(Listeners.class)
public class DisableEnabledTests {
    @Test
    @Disabled(value = "Disabled for demoo")
    void firstTest(){
        System.out.println("This is the first method!");
    }
    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "we disable this...")
    void secondTest(){
        System.out.println("This is the 2nd method");
    }
    @Test
//    @DisabledIfSystemProperty()
    void thirdTest(){
        System.out.println("This is the 3rd method");
    }
    @Test
    @DisabledIf(value = "provider",disabledReason = "Disabled......")
    void fourthMethod(){
        System.out.println("This is the fourth method");
    }
    @Test
    void fifthMethod(){
        System.out.println("This is the 5th method");
    }
    boolean  provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }

}
