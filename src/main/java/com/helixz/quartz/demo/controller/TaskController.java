package com.helixz.quartz.demo.controller;

import com.helixz.quartz.demo.enitiy.SchedulerJobInfo;
import com.helixz.quartz.demo.service.SchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wit
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Autowired
    private SchedulerService schedulerService;


    @GetMapping("/start")
    public void startAllTask() {
        schedulerService.startAllSchedulers();
        log.info("start...");
    }

    @GetMapping("/update")
    public void update() {
        SchedulerJobInfo jobInfo = new SchedulerJobInfo();
        jobInfo.setJobName("Sample Cron");
        jobInfo.setCronJob(true);
        jobInfo.setCronExpression("*/10 * * * * ?");
        schedulerService.updateScheduleJob(jobInfo);
        log.info("update...");
    }

    @GetMapping("/pause")
    public void pause() {
        SchedulerJobInfo jobInfo = new SchedulerJobInfo();
        jobInfo.setJobName("Sample Cron");
        jobInfo.setJobGroup("Test_Cron");
        schedulerService.pauseJob(jobInfo);
        log.info("pause...");
    }

    @GetMapping("/resume")
    public void resume() {
        SchedulerJobInfo jobInfo = new SchedulerJobInfo();
        jobInfo.setJobName("Sample Cron");
        jobInfo.setJobGroup("Test_Cron");
        schedulerService.resumeJob(jobInfo);
        log.info("resume...");
    }

    @GetMapping("/delete")
    public void delete() {
        SchedulerJobInfo jobInfo = new SchedulerJobInfo();
        jobInfo.setJobName("Sample Cron");
        jobInfo.setJobGroup("Test_Cron");
        schedulerService.deleteJob(jobInfo);
        log.info("delete...");
    }
}
