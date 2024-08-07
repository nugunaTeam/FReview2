package com.nuguna.freview.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

  @Bean
  public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setPoolSize(10);
    scheduler.setThreadNamePrefix("log-scheduler-");
    scheduler.initialize();
    return scheduler;
  }

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
    scheduledTaskRegistrar.setScheduler(threadPoolTaskScheduler());
  }
}
