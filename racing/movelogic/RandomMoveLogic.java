package dev.racing.movelogic;

import java.util.Random;

public class RandomMoveLogic implements MoveLogic {
    private final Random random = new Random();

    @Override
    public int move() {
        return random.nextInt(2);  // 0 또는 1
    }
}
