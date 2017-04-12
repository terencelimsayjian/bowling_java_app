import java.util.ArrayList;

public class Frame {
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
            return "[[X][ ]]";
        } else if (isSpare()) {
            return "[[" + getRoll(0) +  "][/]]";
        } else {
            return "[[" + getRoll(0) +  "][" + getRoll(1) + "]]";
        }
    }

    private int getRoll(int i) {
        return rolls.get(i).getPinFall();
    }

}
