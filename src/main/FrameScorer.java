public abstract class FrameScorer {

    public static int scoreFrame(Frame currentFrame, Frame nextFrame, Frame followingFrame) {
        if (currentFrame.isOpenFrame()) {
            return currentFrame.getPinFall();
        } else if (currentFrame.isSpare()) {
            return currentFrame.getPinFall() + getFirstRoll(nextFrame);
        } else if (currentFrame.isStrike() && !nextFrame.isStrike()) {
            return currentFrame.getPinFall() + getFirstTwoRolls(nextFrame);
        } else {
            return currentFrame.getPinFall() + nextFrame.getPinFall() + getFirstRoll(followingFrame);
        }
    }

    public static int scoreNinthFrame(Frame ninthFrame, LastFrame lastFrame) {
        if (ninthFrame.isSpare()) {
            return ninthFrame.getPinFall() + getFirstRoll(lastFrame);
        } else if (ninthFrame.isStrike()) {
            return ninthFrame.getPinFall() + getFirstTwoRolls(lastFrame);
        }
        return ninthFrame.getPinFall();
    }

    private static int getFirstRoll(Frame frame) {
        return frame.getRolls().get(0).getPinFall();
    }

    private static int getFirstTwoRolls(Frame frame) {
        return getFirstRoll(frame) + frame.getRolls().get(1).getPinFall();
    }

    public static int scoreLastFrame(LastFrame lastFrame) {
        return lastFrame.getPinFall();
    }

}
