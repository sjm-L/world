package com.world.world;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class WorldClockTest {

    @Test
    void 틱_한_번이면_10분이_흐른다() {
        WorldClock clock = new WorldClock(LocalDateTime.of(1500, 4, 1, 6, 0), 10);

        clock.tick();

        assertThat(clock.toString()).isEqualTo("1500년 04월 01일 06:10");
    }

    @Test
    void 윤년_2월_마지막_날_다음은_3월_1일이다() {
        WorldClock clock = new WorldClock(LocalDateTime.of(2024, 2, 29, 23, 50), 10);

        clock.tick();

        assertThat(clock.toString()).isEqualTo("2024년 03월 01일 00:00");
    }

    @Test
    void 랜덤_시작_시각은_1년부터_9999년_사이다() {
        Random random = new Random(1);

        for (int i = 0; i < 1000; i++) {
            assertThat(WorldClock.randomStart(random).getYear()).isBetween(1, 9999);
        }
    }
}
