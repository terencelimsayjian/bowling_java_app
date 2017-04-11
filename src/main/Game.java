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

    public void roll (int pins) {
        stopGameIfEndOfLastFrame();

        if (gamePlaying) {
            incrementTotalPinFall(pins);
            incrementCurrentFrameIfCurrentFrameComplete();
            rollInCurrentFrame(pins);
        }
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
        return 0;
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
