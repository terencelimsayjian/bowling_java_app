public class Roll {
    private int pinFall;

    public Roll(int pinFall) {
        this.pinFall = pinFall;
    }

    public int getPinFall() {
        return pinFall;
    }

    public String toString() {
        return pinFall + " pins hit.";
    }

}
