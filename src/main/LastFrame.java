public class LastFrame extends Frame {

    @Override
    public void setFrameCompleteStatus() {
        if (isOpenFrame()) {
            frameComplete = true;
        } else if (rolls.size() == 3) {
            frameComplete = true;
        }
    }

}
