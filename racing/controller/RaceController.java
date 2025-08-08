package dev.racing2.controller;

import dev.racing2.model.*;
import dev.racing2.view.*;
import dev.racing2.movelogic.*;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final List<Horse> horses = new ArrayList<>();
    private final RaceResult raceResult = new RaceResult();
    private final int horseCount;

    public RaceController(int horseCount) {
        this.horseCount = horseCount;
        MoveLogic logic = new RandomMoveLogic();
        for (int i = 1; i <= horseCount; i++) {
            horses.add(new Horse(i, logic, raceResult));
        }
    }

    public void startRace() throws InterruptedException {
        DisplayThread display = new DisplayThread(horses);
        display.start();

        for (Horse h : horses) h.start();

        while (true) {
            if (raceResult != null && horses.stream().allMatch(Horse::isFinished)) {
                break;
            }
            Thread.sleep(1000);
        }

        display.interrupt();
        display.join();

        System.out.println("\n🏁 최종 순위 발표!");
        raceResult.printRanking();
    }
}
