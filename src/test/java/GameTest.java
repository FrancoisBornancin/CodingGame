import org.shadowoftheknight.episode1.Bomb;
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

        Bomb bomb = new Bomb(3, 7);

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player, bomb));
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

        Bomb bomb = new Bomb(24, 2);

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player, bomb));
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

        Bomb bomb = new Bomb(38, 38);

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player, bomb));
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

        Bomb bomb = new Bomb(0, 36);

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player, bomb));
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

        Bomb bomb = new Bomb(22, 22);

        Player player = new Player(useCodeGymValues, buildingWidth, buildingHeight, N, initialX, initialY, in);

        Assertions.assertEquals("YOU WIN", game.play(player, bomb));
    }
}
