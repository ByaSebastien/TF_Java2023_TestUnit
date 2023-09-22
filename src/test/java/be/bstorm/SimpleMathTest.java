package be.bstorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMathTest {

    private SimpleMath math;

    @BeforeEach
    void setUp(){
        math = new SimpleMath();
    }

    @AfterEach
    void tearDown(){
        math = null;
    }

    @Test
    void fivePlusFiveShouldEqualsTen(){

        //Arrange
        int a = 5;
        int b = 5;
        int expected = 10;

        //Action
        int actual = math.add(a,b);

        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void twoPlusFiveShouldEqualsSeven(){

        //Arrange
        int a = 2;
        int b = 5;
        int expected = 7;

        //Action
        int actual = math.add(a,b);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void maxValuePlusPositiveShouldThrowRuntimeException(){

        //Arrange
        int a = Integer.MAX_VALUE;
        int b = 5;

        //Action and Arrange
        assertThrows(RuntimeException.class,() -> math.add(a,b));
    }
}