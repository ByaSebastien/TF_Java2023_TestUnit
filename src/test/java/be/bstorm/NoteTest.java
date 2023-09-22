package be.bstorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    private Note note;

    @BeforeEach
    void setUp() {
        note = new Note();
    }

    @AfterEach
    void tearDown() {
        note = null;
    }

    @Test
    void negativeNumberShouldThrowIllegalArgumentException(){
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,() -> note.getLetterNote(-1));
        assertEquals("Year result must be between 0 and 100",actualException.getMessage());
    }
    @Test
    void numberUpToOneHundredNumberShouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,() -> note.getLetterNote(101));
    }
    @Test
    void zeroShouldReturnF(){
        assertEquals('F',note.getLetterNote(0));
    }
    @Test
    void fortyNineShouldReturnF(){
        assertEquals('F',note.getLetterNote(49));
    }
    @Test
    void fiftyShouldReturnE(){
        assertEquals('E',note.getLetterNote(50));
    }
    @Test
    void fiftyNineShouldReturnE(){
        assertEquals('E',note.getLetterNote(59));
    }
    @Test
    void sixtyShouldReturnD(){
        assertEquals('D',note.getLetterNote(60));
    }
    @Test
    void sixtyNineShouldReturnD(){
        assertEquals('D',note.getLetterNote(69));
    }
    @Test
    void seventyShouldReturnC(){
        assertEquals('C',note.getLetterNote(70));
    }
    @Test
    void seventyNineShouldReturnC(){
        assertEquals('C',note.getLetterNote(79));
    }
    @Test
    void eightyShouldReturnB(){
        assertEquals('B',note.getLetterNote(80));
    }
    @Test
    void eightyNineShouldReturnB(){
        assertEquals('B',note.getLetterNote(89));
    }
    @Test
    void ninetyShouldReturnA(){
        assertEquals('A',note.getLetterNote(90));
    }
    @Test
    void oneHundredShouldReturnA(){
        assertEquals('A',note.getLetterNote(100));
    }
}