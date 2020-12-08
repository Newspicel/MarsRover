package de.newspicel.greenfoot;

import de.newspicel.greenfoot.enums.Preposition;
import de.newspicel.greenfoot.enums.Time;

import java.util.Random;

public class LessonRoverMethods {

    Random random = new Random();


    public void helix(BetterRover betterRover) {
        while (!betterRover.markExist()) {
            if (!betterRover.hillExist(Preposition.FRONT)) {
                betterRover.drive();
            } else {
                betterRover.rotate(Preposition.RIGHT);
            }
        }
    }

    public void printSelfInformation(BetterRover rover) {
        System.out.printf("[ROVER] My Name is: %s and in drive in World: %s and my Radio frequency is: %s%n", rover.getName(), rover.getPlanet().getName(), rover.getRadioFrequency().name());
    }

    public int getTemperature(Time time) {
        if (time.equals(Time.DAY)) {
            return random.nextInt(20 - (-70)) + (-70);
        } else {
            return random.nextInt(-70 - (-120)) + (-120);
        }
    }

}
