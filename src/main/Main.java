public class Main {


    public static void main(String[] args) {
        System.out.println("Random Bowler");
        randomBowler();
    }

    private static void randomBowler() {
        Game game = new Game();

        while (game.isGamePlaying()) {

            int firstRoll = (int) (Math.random() * 10 + 1);
            game.roll(firstRoll);

            if (firstRoll != 10) {
                int secondRoll = (int) (Math.random() * (10 - firstRoll) + 1);
                game.roll(secondRoll);
            }

        }

        game.score();
    }

}
