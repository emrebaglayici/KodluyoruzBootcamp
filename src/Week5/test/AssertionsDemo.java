package Week5.test;

import Week5.Calculator;
import Week5.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("emre", "baglayici");


    @Test
    void standardAssertions() {
        assertEquals(2, Calculator.add(1, 1));
        assertEquals(4, Calculator.add(2, 2),
                "The optional failure messages is now the last parameter");

        assertTrue('a' < 'b', () -> "Assertion messages can lazily evaluated " +
                " to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("emre", person.getName()),
                () -> assertEquals("baglayici", person.getSurname()));
    }

    @Test
    void dependentAssertions() {
        assertAll(
                "properties",
                () -> {
                    String firstName = person.getName();
                    assertNotNull(firstName);

                    assertAll("firstName",
                            () -> assertTrue(firstName.startsWith("e")),
                            () -> assertTrue(firstName.endsWith("e")));

                },
                () -> {
                    String lastName = person.getSurname();
                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("b")),
                            () -> assertTrue(lastName.endsWith("i")));
                }
        );
    }

    @Test
    void exceptionTesting(){
        Exception exception=assertThrows(ArithmeticException.class,()->
                Calculator.divide(1,0));
        assertEquals("/ by zero",exception.getMessage());
    }

    @Test
    void timeOutNotExceeded(){
        assertTimeout(Duration.ofMinutes(2),()->{

        });
    }

    @Test
    void timeOutNotExceededWithResult(){
        String actualResult=assertTimeout(Duration.ofMinutes(2),()->{
            return "a result";
        });
        assertEquals("a result ",actualResult);
    }

    @Test
    void timeOutNotExceededWithMethod(){
        String actualGreetings=assertTimeout(Duration.ofMinutes(2),AssertionsDemo::greetings);
        assertEquals("Hello",actualGreetings);
    }

    @Test
    void timeOutExceeded(){
        assertTimeout(Duration.ofMillis(10),()->{
            Thread.sleep(100);
        });
    }

    @Test
    void timeOutExceededWithPreemptiveTermination(){
        assertTimeoutPreemptively(Duration.ofMillis(10),()->{
            new CountDownLatch(1).await();
        });
    }

    @Test
    void testOnlyOnCiServer(){
        assumeTrue("CI".equals(System.getenv("ENV")),
                ()-> "Aborting test:not on developer workstation");
    }

    @Test
    void testInAllEnvironments(){
        assumingThat("CI".equals(System.getenv("ENV")),
                ()->{
            assertEquals(2,Calculator.divide(4,2));
                });
    }

    public static String greetings(){
        return "Hello";
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        // ...
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    void notOnCiServer() {
        // ...
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void onlyOnStagingServer() {
        // ...
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void notOnDeveloperWorkstation() {
        // ...
    }

    @Test
    @EnabledIf("customCondition")
    void enabled(){}

    @Test
    @DisabledIf("customCondition")
    void disabled(){}

    boolean customCondition(){
        return true;
    }
}
