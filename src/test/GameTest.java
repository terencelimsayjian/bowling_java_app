import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testNumberOfFrames() {
        assertEquals(game.getFrames().size(), 10);
    }

    @Test
    void rollOneOpenFrame() {
        game.roll(6);
        game.roll(3);
        assertEquals(game.getFrames().get(0).getPinFall(), 9);
        assertEquals(game.getTotalPinFall(), 9);
    }

    @Test
    void rollTwoOpenFrames() {
        game.roll(6);
        game.roll(3);
        assertEquals(game.getFrames().get(0).getPinFall(), 9);
        game.roll(5);
        game.roll(1);
        assertEquals(game.getFrames().get(1).getPinFall(), 6);
        assertEquals(game.getTotalPinFall(), 15);
    }

    @Test
    void rollNineOpenFramesAndTestLastFrame() {
        for (int i = 0; i < 18; i++) {
            game.roll(4);
        }
        for (int i = 0; i < 9; i++) {
            assertEquals(game.getFrames().get(i).getPinFall(), 8);
        }

        game.roll(6);
        game.roll(3);
        assertEquals(game.getFrames().get(9).getPinFall(), 9);
        assertEquals(game.getTotalPinFall(), 81);
    }

    @Test
    void gameStopsAfterLastFrameIsRolled() {
        for (int i = 0; i < 18; i++) {
            game.roll(5);
        }

        game.roll(10);
        game.roll(3);
        game.roll(7);
        assertEquals(game.getTotalPinFall(), 110);
        game.roll(10);
        game.roll(3);
        assertEquals(game.getTotalPinFall(), 110);

    }
}