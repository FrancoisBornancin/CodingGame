package org.shadowoftheknight.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BatmanTest {
    @Test
    void itShouldUpdateWhenTwoDownConsecutively(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "D";
        bomb.beforeDir = "D";

        Batman batman = new Batman();

        batman.actualY = 6;
        batman.maxY = 14;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(10, batman.actualY);
    }

    @Test
    void itShouldUpdateWhenDownFollowUp(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "D";
        bomb.beforeDir = "U";

        Batman batman = new Batman();

        batman.actualY = 2;
        batman.beforeOneY = 6;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(4, batman.actualY);
    }

    @Test
    void itShouldUpdateWhenTwoUpConsecutively(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "U";
        bomb.beforeDir = "U";

        Batman batman = new Batman();

        batman.actualY = 8;
        batman.beforeOneY = 10;
        batman.minY = 0;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(4, batman.actualY);
    }

    @Test
    void itShouldUpdateWhenUpFollowDown(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "U";
        bomb.beforeDir = "D";

        Batman batman = new Batman();

        batman.actualY = 8;
        batman.beforeOneY = 4;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(6, batman.actualY);
    }

    @Test
    void itShouldUpdateWhenTwoRightConsecutively(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "R";
        bomb.beforeDir = "R";

        Batman batman = new Batman();

        batman.actualX = 6;
        batman.maxX = 14;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(10, batman.actualX);
    }

    @Test
    void itShouldUpdateWhenRightFollowLeft(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "R";
        bomb.beforeDir = "L";

        Batman batman = new Batman();

        batman.actualX = 2;
        batman.beforeOneX = 6;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(4, batman.actualX);
    }

    @Test
    void itShouldUpdateWhenTwoLeftConsecutively(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "L";
        bomb.beforeDir = "L";

        Batman batman = new Batman();

        batman.actualX = 8;
        batman.minX = 0;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(4, batman.actualX);
    }

    @Test
    void itShouldUpdateWhenLeftFollowRight(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "L";
        bomb.beforeDir = "R";

        Batman batman = new Batman();

        batman.actualX = 8;
        batman.beforeOneX = 4;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(6, batman.actualX);
    }

    @Test
    void itShouldContinueToUpdateLeftDirection(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "L";
        bomb.beforeDir = "L";

        Batman batman = new Batman();

        batman.actualX = 8;
        batman.beforeOneX = 8;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(7, batman.actualX);
    }

    @Test
    void itShouldContinueToUpdateRightDirection(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "R";
        bomb.beforeDir = "R";

        Batman batman = new Batman();

        batman.actualX = 8;
        batman.beforeOneX = 8;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(9, batman.actualX);
    }

    @Test
    void itShouldContinueToUpdateUpDirection(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "U";
        bomb.beforeDir = "U";

        Batman batman = new Batman();

        batman.actualY = 8;
        batman.beforeOneY = 8;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(7, batman.actualY);
    }

    @Test
    void itShouldContinueToUpdateDownDirection(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "D";
        bomb.beforeDir = "D";

        Batman batman = new Batman();

        batman.actualY = 8;
        batman.beforeOneY = 8;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(9, batman.actualY);
    }

    @Test
    void positionXAndYShouldUpdateWhenXAndYDirection(){
        Bomb bomb = new Bomb();
        bomb.actualDir = "UL";
        bomb.beforeDir = "DR";

        Batman batman = new Batman();

        batman.actualX = 8;
        batman.beforeOneX = 4;

        batman.actualY = 8;
        batman.beforeOneY = 4;

        batman.updateCoordinates(bomb);

        Assertions.assertEquals(6, batman.actualX);
        Assertions.assertEquals(6, batman.actualY);
    }
}
