import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameScorerTest {
    @Test
    void testScoreOpenFrame() {
        Frame frame = new Frame();
        frame.roll(new Roll(6));
        frame.roll(new Roll(3));
        assertEquals(FrameScorer.score(frame), 9);
    }

    @Test
    void testSpare() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(6));
        currentFrame.roll(new Roll(4));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(2));
        nextFrame.roll(new Roll(7));

        assertEquals(FrameScorer.scoreClosedFrame(currentFrame, nextFrame), 12);
    }

    @Test
    void testSpareWithStrike() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(6));
        currentFrame.roll(new Roll(4));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(10));

        assertEquals(FrameScorer.scoreClosedFrame(currentFrame, nextFrame), 20);
    }

    @Test
    void testStrikeWithOpenFrame() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(10));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(6));
        nextFrame.roll(new Roll(4));

        assertEquals(FrameScorer.scoreClosedFrame(currentFrame, nextFrame), 20);
    }

    @Test
    void testStrikeWithStrikeAndOpenFrame() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(10));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(10));

        Frame followingFrame = new Frame();
        followingFrame.roll(new Roll(8));
        followingFrame.roll(new Roll(2));

        assertEquals(FrameScorer.scoreTwoConsecutiveStrikes(currentFrame, nextFrame, followingFrame), 28);
    }
}