package Week5.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mysql.cj.util.StringUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EmptyStackException;
import java.util.Stack;

@DisplayName("A stack")
public class TestingAStackDemo {
    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew(){
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew{
        @BeforeEach
        void createNewStack(){
            stack=new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("Throws EmptyStackException when popped")
        void throwsExceptionWhenPopped(){
            assertThrows(EmptyStackException.class,stack::pop);
        }

        @Test
        @DisplayName("Throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class,stack::peek);
        }

        @Nested
        @DisplayName("After pushing an element")
        class AfterPushing{
            String anElement=" an element";

            @BeforeEach
            void pushElement(){
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnsElementWhenPopped(){
                assertEquals(anElement,stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked(){
                assertEquals(anElement,stack.peek());
                assertTrue(stack.isEmpty());
            }
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"raceCaor","radar","able was I ere I saw elba"})
    void palindromes(String candidate){
//        assertTrue(StringUtils.isisPalindrome(candidate));
    }


}
