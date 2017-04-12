import java.util.ArrayList;

public class Game {
    private ArrayList<Frame> frames = new ArrayList<Frame>(10);
    private int currentFrameIndex = 0;
    private int totalPinFall;
    private boolean gamePlaying = true;

    public Game() {
        for (int i = 0; i < 9; i++) {
            frames.add(new Frame());
        }
        frames.add(new LastFrame());
    }

    public void roll(int pins) {
        stopGameIfEndOfLastFrame();

        if (gamePlaying) {
            incrementTotalPinFall(pins);
            incrementCurrentFrameIfCurrentFrameComplete();
            rollInCurrentFrame(pins);
        }
    }

    public boolean isGamePlaying() {
        return gamePlaying;
    }

    private void stopGameIfEndOfLastFrame() {
        if (frames.get(9).frameComplete) {
            gamePlaying = false;
        }
    }

    private void incrementTotalPinFall(int pins) {
        totalPinFall += pins;
    }

    private void incrementCurrentFrameIfCurrentFrameComplete() {
        if (frames.get(currentFrameIndex).frameComplete) {
            currentFrameIndex += 1;
        }
    }

    private void rollInCurrentFrame(int pins) {
        frames.get(currentFrameIndex).roll(new Roll(pins));
    }

    public int score() {
        int totalScore = 0;
        Frame ninthFrame = frames.get(8);
        LastFrame lastFrame = (LastFrame) frames.get(9);

        totalScore += scoreFirstEightFrames();
        totalScore += FrameScorer.scoreNinthFrame(ninthFrame, lastFrame);
        totalScore += FrameScorer.scoreLastFrame(lastFrame);

        System.out.println(toString());
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }

    private int scoreFirstEightFrames() {
        int score = 0;

        for (int i = 0; i < 8; i++) {
            Frame currentFrame = frames.get(i);
            Frame nextFrame = frames.get(i + 1);
            Frame followingFrame = frames.get(i + 2);

            score += FrameScorer.scoreFrame(currentFrame, nextFrame, followingFrame);
        }
        return score;
    }

    public int getTotalPinFall() {
        return totalPinFall;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

    public String toString() {
        return frames.toString();
    }
}
