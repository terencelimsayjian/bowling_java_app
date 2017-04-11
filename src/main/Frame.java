import java.util.ArrayList;

public class Frame {
    public static final int INCOMPLETE = 0;
    public static final int OPEN_FRAME = 1;
    public static final int SPARE = 2;
    public static final int STRIKE = 3;

    private int pinFall;
    private ArrayList<Roll> rolls = new ArrayList<Roll>();
    private int status = Frame.INCOMPLETE;

    public void roll(Roll roll) {
        if (status == Frame.INCOMPLETE) {
            rolls.add(roll);
            addRollToPinFall(roll);
            setStatus();
        }
    }

    private void addRollToPinFall(Roll roll) {
        pinFall += roll.getPinFall();
    }

    private void setStatus() {
        if (rolls.size() == 2 && pinFall <= 9) {
            status = Frame.OPEN_FRAME;
        } else if (rolls.size() == 2 && pinFall == 10) {
            status = Frame.SPARE;
        } else if (rolls.size() == 1 && pinFall == 10) {
            status = Frame.STRIKE;
        }
    }

    public int getPinFall() {
        return pinFall;
    }

    public ArrayList<Roll> getRolls() {
        return rolls;
    }

    public int getStatus() {
        return status;
    }

    // lastFrame extends Frame
    // has three rolls if last Frame

}
