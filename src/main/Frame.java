import java.util.ArrayList;

public class Frame {
    protected static final String STRIKE_STRING = "[X]";
    protected static final String SPARE_STRING = "[/]";
    protected static final String OPEN_FRAME = "[";
    protected static final String CLOSE_FRAME = "]";
    protected static final String EMPTY_ROLL = OPEN_FRAME + " " + CLOSE_FRAME;

    protected int pinFall;
    protected ArrayList<Roll> rolls = new ArrayList<Roll>();
    protected boolean frameComplete = false;

    public void roll(Roll roll) {
        if (!frameComplete) {
            rolls.add(roll);
            addRollToPinFall(roll);
            setFrameCompleteStatus();
        }
    }

    private void addRollToPinFall(Roll roll) {
        pinFall += roll.getPinFall();
    }

    protected void setFrameCompleteStatus() {
        if (isOpenFrame()) {
            frameComplete = true;
        } else if (isSpare()) {
            frameComplete = true;
        } else if (isStrike()) {
            frameComplete = true;
        }
    }

    public boolean isOpenFrame() {
        return rolls.size() == 2 && pinFall <= 9;
    }

    public final boolean isStrike() {
        return rolls.size() == 1 && pinFall == 10;
    }

    public final boolean isSpare() {
        return rolls.size() == 2 && pinFall == 10;
    }

    public int getPinFall() {
        return pinFall;
    }

    public ArrayList<Roll> getRolls() {
        return rolls;
    }

    public String toString() {
        if (isStrike()) {
            return OPEN_FRAME + STRIKE_STRING + EMPTY_ROLL + CLOSE_FRAME;
        } else if (isSpare()) {
            return OPEN_FRAME + getStringForOpenRolls(0) + SPARE_STRING + CLOSE_FRAME;
        } else {
            return OPEN_FRAME + getStringForOpenRolls(0) + getStringForOpenRolls(1) + CLOSE_FRAME;
        }
    }

    protected String getStringForOpenRolls(int i) {
        return OPEN_FRAME + rolls.get(i).getPinFall() + CLOSE_FRAME;
    }

}
