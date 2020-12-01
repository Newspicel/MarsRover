package de.newspicel.greenfoot;

import de.newspicel.greenfoot.enums.Preposition;

public class LessonRoverMethods {

    public void helix(BetterRover betterRover) {
        while (!betterRover.markExist()) {
            if (!betterRover.hillExist(Preposition.FRONT)) {
                betterRover.drive();
            } else {
                betterRover.rotate(Preposition.RIGHT);
            }
        }
    }

}
