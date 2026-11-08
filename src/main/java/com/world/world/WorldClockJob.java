package com.world.world;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Quartz가 실행 시점마다 부르는 작업. 시계를 한 칸 움직이고 시각을 로그로 남긴다.
 */
public class WorldClockJob extends QuartzJobBean {

    private static final Logger log = LoggerFactory.getLogger(WorldClockJob.class);

    private final WorldClock clock;

    public WorldClockJob(WorldClock clock) {
        this.clock = clock;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        clock.tick();
        log.info("[{}]", clock);
    }
}
