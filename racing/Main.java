package dev.racing;

import dev.racing.controller.RaceController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🐎 경마 게임에 오신 걸 환영합니다!");
        System.out.print("경주에 참가할 말의 수를 입력하세요: ");
        int horseCount = scanner.nextInt();

        RaceController controller = new RaceController(horseCount);
        controller.startRace();
    }
}