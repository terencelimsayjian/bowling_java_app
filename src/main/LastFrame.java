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
        int firstRoll = getRoll(0);
        int secondRoll = getRoll(1);
        String roll1String = "[" + firstRoll + "]";
        String roll2String = "[" + secondRoll + "]";
        String roll3String = "[ ]";

        if (firstRoll == 10) {
            roll1String = "[X]";
        }

        if (firstRoll + secondRoll == 10 && firstRoll < 10) {
            roll2String = "[/]";
        } else if (firstRoll == 10 && secondRoll == 10) {
            roll2String = "[X]";
        }

        if (rolls.size() == 3) {
            int thirdRoll = getRoll(2);
            roll3String = "[" + thirdRoll + "]";
            if (thirdRoll == 10) {
                roll3String = "[X]";
            }

        }

        return "[" + roll1String + roll2String + roll3String + "]";
    }

    private int getRoll(int i) {
        return rolls.get(i).getPinFall();
    }

}
