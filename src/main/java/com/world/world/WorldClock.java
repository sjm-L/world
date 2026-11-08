package com.world.world;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * 세계의 게임 시간. 날짜 계산은 LocalDateTime에 맡긴다.
 * 현실에서 빌리는 것은 "몇 초마다 움직이는지"뿐이고, 날짜와 시각은 현실과 관계없다.
 */
public class WorldClock {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("uuuu년 MM월 dd일 HH:mm");
    private static final long FIRST_DAY = LocalDate.of(1, 1, 1).toEpochDay();
    private static final long LAST_DAY = LocalDate.of(9999, 12, 31).toEpochDay();

    private final int minutesPerTick;
    private LocalDateTime now;

    public WorldClock(LocalDateTime start, int minutesPerTick) {
        this.now = start;
        this.minutesPerTick = minutesPerTick;
    }

    public static LocalDateTime randomStart(Random random) {
        LocalDate date = LocalDate.ofEpochDay(random.nextLong(FIRST_DAY, LAST_DAY + 1));
        LocalTime time = LocalTime.of(random.nextInt(24), random.nextInt(60));
        return LocalDateTime.of(date, time);
    }

    public void tick() {
        now = now.plusMinutes(minutesPerTick);
    }

    @Override
    public String toString() {
        return now.format(FORMAT);
    }
}
