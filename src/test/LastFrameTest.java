import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastFrameTest {
    Frame lastFrame;

    @BeforeEach
    void setUp() {
        lastFrame = new LastFrame();
    }

    @Test
    void testRoll() {
        Roll roll = new Roll(6);
        lastFrame.roll(roll);
        assertEquals(lastFrame.getPinFall(), 6);
        assertEquals(lastFrame.getRolls().size(), 1);
    }

    @Test
    void testOpenFrame() {
        lastFrame.roll(new Roll(7));
        lastFrame.roll(new Roll(2));
        lastFrame.roll(new Roll(6));
        assertEquals(lastFrame.getPinFall(), 9);
        assertEquals(lastFrame.getRolls().size(), 2);
    }

    @Test
    void testThreeStrikes() {
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));
        assertEquals(lastFrame.getPinFall(), 30);
        assertEquals(lastFrame.getRolls().size(), 3);
    }

    @Test
    void testStrikeAndOpenFrame() {
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(7));
        lastFrame.roll(new Roll(1));
        lastFrame.roll(new Roll(8));
        assertEquals(lastFrame.getPinFall(), 18);
        assertEquals(lastFrame.getRolls().size(), 3);
    }



//    @Test
//    void testSpareAndStrike() {
//        lastFrame.roll(new Roll(6));
//        lastFrame.roll(new Roll(4));
//        lastFrame.roll(new Roll(10));
//        assertEquals(lastFrame.getPinFall(), 20);
//        assertEquals(lastFrame.getRolls().size(), 3);
//    }
//
//    @Test
//    void testSpareAndNonStrike() {
//        lastFrame.roll(new Roll(6));
//        lastFrame.roll(new Roll(4));
//        lastFrame.roll(new Roll(6));
//        assertEquals(lastFrame.getPinFall(), 16);
//        assertEquals(lastFrame.getRolls().size(), 3);
//    }
}