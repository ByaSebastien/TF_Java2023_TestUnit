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

        //Examples
//        assertNotEquals();
//        assertNull();
//        assertNotNull();
//        assertTrue();
//        assertFalse();
//        assertThrows();
//        assertDoesNotThrow();
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

    @Test
    void tenDividedByTwoShouldEqualsFive(){
        assertEquals(5,math.division(10,2));
    }

    @Test
    void tenDividedByFourShouldEqualsTwo(){
        assertEquals(2,math.division(10,4));
    }

    @Test
    void dividedByZeroShouldThrowArithmeticException(){
        DividedByZeroException actualException = assertThrows(DividedByZeroException.class, () -> math.division(10, 0));
        assertEquals(actualException.getMessage(),"Cannot divide by zero");
    }
}