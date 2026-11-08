package com.world.world;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * 서버가 켜질 때 시계를 만들고, Quartz에 "5초마다 시계 작업을 실행"하도록 등록한다.
 */
@Configuration
public class WorldClockConfig {

    private static final int SECONDS_PER_TICK = 5;
    private static final int MINUTES_PER_TICK = 10;

    @Bean
    public WorldClock worldClock() {
        return new WorldClock(WorldClock.randomStart(new Random()), MINUTES_PER_TICK);
    }

    @Bean
    public JobDetail worldClockJobDetail() {
        return JobBuilder.newJob(WorldClockJob.class)
                .withIdentity("worldClockJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger worldClockTrigger(JobDetail worldClockJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(worldClockJobDetail)
                .withIdentity("worldClockTrigger")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(SECONDS_PER_TICK))
                .build();
    }
}
