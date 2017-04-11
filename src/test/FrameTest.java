import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {
    Frame frame;

    @BeforeEach
    void setUp() {
        frame = new Frame();
    }

    @Test
    void testRoll() {
        frame.roll(new Roll(6));
        assertEquals(frame.getPinFall(), 6);
        assertEquals(frame.getRolls().get(0).getPinFall(), 6);
    }

    @Test
    void testThreeRolls() {
        frame.roll(new Roll(2));
        frame.roll(new Roll(3));
        assertEquals(frame.getPinFall(), 5);
        assertEquals(frame.getRolls().size(), 2);

        frame.roll(new Roll(3));
        assertEquals(frame.getPinFall(), 5);
        assertEquals(frame.getRolls().size(), 2);
    }


    @Test
    void testOpenFrameStatus() {
        frame.roll(new Roll(6));
        frame.roll(new Roll(3));
        assertEquals(frame.isOpenFrame(), true);
        assertEquals(frame.isSpare(), false);
        assertEquals(frame.isStrike(), false);
    }

    @Test
    void testSpareStatus() {
        frame.roll(new Roll(6));
        frame.roll(new Roll(4));
        assertEquals(frame.isSpare(), true);
        assertEquals(frame.isOpenFrame(), false);
        assertEquals(frame.isStrike(), false);
    }

    @Test
    void testStrikeStatus() {
        frame.roll(new Roll(10));
        assertEquals(frame.isStrike(), true);
        assertEquals(frame.isSpare(), false);
        assertEquals(frame.isOpenFrame(), false);
    }
}