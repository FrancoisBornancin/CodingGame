import org.shadowoftheknight.episode1.Game;
import org.shadowoftheknight.episode1.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class GameTest {

    @Test
    void lotOfJumps(){
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        boolean useCodeGymValues = false;
        int buildingWidth = 4;
        int buildingHeight = 8;
        int N = 40;
        int initialX = 2;
        int initialY = 3;

        game.bombX = 3;
        game.bombY = 7;

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player));
    }

    @Test
    void lessOfJumps(){
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        boolean useCodeGymValues = false;
        int buildingWidth = 25;
        int buildingHeight = 33;
        int N = 49;
        int initialX = 2;
        int initialY = 29;

        game.bombX = 24;
        game.bombY = 2;

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player));
    }

    @Test
    void evenLessOfJumps(){
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        boolean useCodeGymValues = false;
        int buildingWidth = 40;
        int buildingHeight = 60;
        int N = 32;
        int initialX = 6;
        int initialY = 6;

        game.bombX = 38;
        game.bombY = 38;

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player));
    }

    @Test
    void tower(){
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        boolean useCodeGymValues = false;
        int buildingWidth = 1;
        int buildingHeight = 80;
        int N = 6;
        int initialX = 0;
        int initialY = 1;

        game.bombX = 0;
        game.bombY = 36;

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player));
    }

    @Test
    void goodCut(){
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        boolean useCodeGymValues = false;
        int buildingWidth = 50;
        int buildingHeight = 50;
        int N = 6;
        int initialX = 0;
        int initialY = 0;

        game.bombX = 22;
        game.bombY = 22;

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player));
    }
}
