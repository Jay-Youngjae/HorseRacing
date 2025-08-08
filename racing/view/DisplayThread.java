package dev.racing2.view;

import dev.racing2.model.Horse;
import java.util.Comparator;
import java.util.List;

public class DisplayThread extends Thread {
    private final List<Horse> horses;

    public DisplayThread(List<Horse> horses) {
        this.horses = horses;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            UIPrinter.clearConsole();
            System.out.println("📢 현재 경주 상황:");

            horses.stream()
                .sorted(Comparator.comparingInt(Horse::getNumber))
                .forEach(h -> System.out.printf("%2d번 말: %s%n", h.getNumber(), UIPrinter.buildTrack(h.getDistance())));

            System.out.println("\n(트랙 출력 중... 최종 순위는 도착 후 출력됩니다)");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}