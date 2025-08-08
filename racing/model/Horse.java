package dev.racing2.model;

import dev.racing2.movelogic.MoveLogic;
import dev.racing2.settings.RaceSettings;

public class Horse extends Thread {
    private final int number;
    private int distance;
    private boolean finished;
    private final MoveLogic moveLogic;
    private final RaceResult raceResult;

    public Horse(int number, MoveLogic moveLogic, RaceResult raceResult) {
        this.number = number;
        this.moveLogic = moveLogic;
        this.raceResult = raceResult;
    }

    @Override
    public void run() {
        while (!finished) {
            distance += moveLogic.move();
            if (distance >= RaceSettings.TRACK_LENGTH) {
                distance = RaceSettings.TRACK_LENGTH;
                finished = true;
                raceResult.recordFinish(number + "번 말");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isFinished() {
        return finished;
    }
}
