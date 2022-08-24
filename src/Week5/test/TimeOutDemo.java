package Week5.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeOutDemo {
    @BeforeEach
    @Timeout(5)
    void setUp(){
        // fails if execution time exceeds 5 seconds
    }

    @Test
    @Timeout(value = 100,unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100MilliSeconds(){
        // fails if execution time exceeds 100 milliseconds
    }
}
