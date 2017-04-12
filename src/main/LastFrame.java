public class LastFrame extends Frame {

    @Override
    public void setFrameCompleteStatus() {
        if (isOpenFrame()) {
            frameComplete = true;
        } else if (rolls.size() == 3) {
            frameComplete = true;
        }
    }

    public String toString() {
        String roll1String = firstRollToString();
        String roll2String = secondRollToString();
        String roll3String = thirdRollToString();

        return OPEN_FRAME + roll1String + roll2String + roll3String + CLOSE_FRAME;
    }

    private String firstRollToString() {
        int firstRollPinFall = getRollPinFall(0);
        String roll1String = getStringForOpenRolls(0);

        if (firstRollPinFall == 10) {
            roll1String = STRIKE_STRING;
        }
        return roll1String;
    }

    private String secondRollToString() {
        String roll2String = getStringForOpenRolls(1);

        if (firstTwoRollsIsSpare()) {
            roll2String = SPARE_STRING;
        } else if (firstTwoRollsAreStrikes()) {
            roll2String = STRIKE_STRING;
        }
        return roll2String;
    }

    private boolean firstTwoRollsAreStrikes() {
        int firstRollPinFall = getRollPinFall(0);
        int secondRollPinFall = getRollPinFall(1);
        return firstRollPinFall == 10 && secondRollPinFall == 10;
    }

    private boolean firstTwoRollsIsSpare() {
        int firstRollPinFall = getRollPinFall(0);
        int secondRollPinFall = getRollPinFall(1);

        return firstRollPinFall + secondRollPinFall == 10 && firstRollPinFall < 10;
    }

    private String thirdRollToString() {
        String roll3String = EMPTY_ROLL;

        if (rolls.size() == 3) {
            int thirdRollPinFall = getRollPinFall(2);
            roll3String = getStringForOpenRolls(2);
            if (thirdRollPinFall == 10) {
                roll3String = STRIKE_STRING;
            }

        }
        return roll3String;
    }

    private int getRollPinFall(int i) {
        return rolls.get(i).getPinFall();
    }

}
