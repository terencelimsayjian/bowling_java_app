public class Main {


    public static void main(String[] args) {
        System.out.println("Random Bowler");
        randomBowler();

        System.out.println("Average Bowler");
        averageBowler();

        System.out.println("Good Bowler");
        goodBowler();
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

    private static void averageBowler() {
        Game game = new Game();

        while (game.isGamePlaying()) {

            int firstRoll = (int) (Math.random() * 5 + 6);
            game.roll(firstRoll);

            if (firstRoll != 10) {
                int secondRoll = (int) (Math.random() * (10 - firstRoll) + 1);
                game.roll(secondRoll);
            }

        }

        game.score();
    }

    private static void goodBowler() {
        Game game = new Game();

        while (game.isGamePlaying()) {

            int firstRoll = (int) (Math.random() * 3 + 8);
            game.roll(firstRoll);

            if (firstRoll != 10) {
                int secondRoll = (int) (Math.random() * (10 - firstRoll) + 1);
                game.roll(secondRoll);
            }

        }

        game.score();
    }

}
