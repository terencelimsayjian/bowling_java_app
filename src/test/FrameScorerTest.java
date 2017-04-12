import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameScorerTest {
    @Test
    void testScoreOpenFrame() {
        Frame frame = new Frame();
        frame.roll(new Roll(6));
        frame.roll(new Roll(3));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(6));
        nextFrame.roll(new Roll(3));

        Frame followingFrame = new Frame();
        followingFrame.roll(new Roll(6));
        followingFrame.roll(new Roll(3));
        assertEquals(FrameScorer.scoreFrame(frame, nextFrame, followingFrame), 9);
    }

    @Test
    void testSpare() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(6));
        currentFrame.roll(new Roll(4));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(2));
        nextFrame.roll(new Roll(7));

        Frame followingFrame = new Frame();
        followingFrame.roll(new Roll(2));
        followingFrame.roll(new Roll(7));

        assertEquals(FrameScorer.scoreFrame(currentFrame, nextFrame, followingFrame), 12);
    }

    @Test
    void testSpareWithStrike() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(6));
        currentFrame.roll(new Roll(4));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(10));

        Frame followingFrame = new Frame();
        followingFrame.roll(new Roll(10));

        assertEquals(FrameScorer.scoreFrame(currentFrame, nextFrame, followingFrame), 20);
    }

    @Test
    void testStrikeWithOpenFrame() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(10));

        Frame nextFrame = new Frame();
        nextFrame.roll(new Roll(6));
        nextFrame.roll(new Roll(4));

        Frame followingFrame = new Frame();
        followingFrame.roll(new Roll(6));
        followingFrame.roll(new Roll(4));

        assertEquals(FrameScorer.scoreFrame(currentFrame, nextFrame, followingFrame), 20);
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

        assertEquals(FrameScorer.scoreFrame(currentFrame, nextFrame, followingFrame), 28);
    }

    @Test
    void testNinthFrameSpare() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(9));
        currentFrame.roll(new Roll(1));

        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(8));
        lastFrame.roll(new Roll(1));

        assertEquals(FrameScorer.scoreNinthFrame(currentFrame, lastFrame), 18);
    }

    @Test
    void testNinthFrameStrike() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(10));

        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(8));
        lastFrame.roll(new Roll(1));

        assertEquals(FrameScorer.scoreNinthFrame(currentFrame, lastFrame), 19);
    }

    @Test
    void testNinthFrameStrikeWithThreeLastFrameStrikes() {
        Frame currentFrame = new Frame();
        currentFrame.roll(new Roll(10));

        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));

        assertEquals(FrameScorer.scoreNinthFrame(currentFrame, lastFrame), 30);
    }

    @Test
    void testScoreLastOpenFrame() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(6));
        lastFrame.roll(new Roll(2));

        assertEquals(FrameScorer.scoreLastFrame(lastFrame), 8);
    }

    @Test
    void testScoreLastOpenFrameDifferentValues() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(5));
        lastFrame.roll(new Roll(4));

        assertEquals(FrameScorer.scoreLastFrame(lastFrame), 9);
    }

    @Test
    void testScoreLastFrameSpareOpen() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(5));
        lastFrame.roll(new Roll(5));
        lastFrame.roll(new Roll(6));

        assertEquals(FrameScorer.scoreLastFrame(lastFrame), 16);
    }

    @Test
    void testScoreLastFrameStrikeSpare() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(5));
        lastFrame.roll(new Roll(5));

        assertEquals(FrameScorer.scoreLastFrame(lastFrame), 20);
    }

    @Test
    void testScoreLastFrameTripleStrike() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));
        lastFrame.roll(new Roll(10));

        assertEquals(FrameScorer.scoreLastFrame(lastFrame), 30);
    }

}