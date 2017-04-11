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
        Roll roll = new Roll(6);
        frame.roll(roll);
        assertEquals(frame.getPinFall(), 6);
        assertEquals(frame.getRolls().get(0).getPinFall(), 6);
    }

    @Test
    void testThreeRolls() {
        Roll roll1 = new Roll(2);
        frame.roll(roll1);
        Roll roll2 = new Roll(3);
        frame.roll(roll2);
        assertEquals(frame.getPinFall(), 5);
        assertEquals(frame.getRolls().size(), 2);

        Roll roll3 = new Roll(3);
        frame.roll(roll3);
        assertEquals(frame.getPinFall(), 5);
        assertEquals(frame.getRolls().size(), 2);
    }

    @Test
    void testNoMoreRollsWhenStrike() {
        Roll roll1 = new Roll(10);
        frame.roll(roll1);
        assertEquals(frame.getPinFall(), 10);
        assertEquals(frame.getRolls().size(), 1);

        Roll roll2 = new Roll(3);
        frame.roll(roll2);
        assertEquals(frame.getPinFall(), 10);
        assertEquals(frame.getRolls().size(), 1);
    }

    @Test
    void testOpenFrameStatus() {
        Roll roll1 = new Roll(6);
        frame.roll(roll1);
        Roll roll2 = new Roll(3);
        frame.roll(roll2);
        assertEquals(frame.getStatus(), Frame.OPEN_FRAME);
    }

    @Test
    void testSpareStatus() {
        Roll roll1 = new Roll(6);
        frame.roll(roll1);
        Roll roll2 = new Roll(4);
        frame.roll(roll2);
        assertEquals(frame.getStatus(), Frame.SPARE);
    }

    @Test
    void testStrikeStatus() {
        Roll roll1 = new Roll(10);
        frame.roll(roll1);
        assertEquals(frame.getStatus(), Frame.STRIKE);
    }
}