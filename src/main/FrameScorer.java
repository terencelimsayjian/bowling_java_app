public abstract class FrameScorer {

    // how to implement the last frame

    // if frame is either strike or spare, cannot
    public static int score(Frame frame) {
        return frame.getPinFall();
    }

    // if both frames are strikes, cannot
    // if currentFrame is strike, this algo is sufficient for 9th frame;
    public static int scoreClosedFrame(Frame currentFrame, Frame nextFrame) {
        if (currentFrame.isSpare()) {
            return currentFrame.getPinFall() + nextFrame.getRolls().get(0).getPinFall();
        } else if (currentFrame.isStrike()) {
            return currentFrame.getPinFall() + nextFrame.getPinFall();
        }
        return currentFrame.getPinFall();
    }

    public static int scoreTwoConsecutiveStrikes(Frame currentFrame, Frame nextFrame, Frame followingFrame) {
        return currentFrame.getPinFall() + nextFrame.getPinFall() + followingFrame.getRolls().get(0).getPinFall();
    }


}
