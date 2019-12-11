package com.lishuang.shopping.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class Scheduling {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //一小时
    private static final long ONE_HOURS = 60 * 60 * 1000;
    //一天
    private static final long ONE_DAY = 60 * 60 * 1000 *24;
    //5秒
    private static final long FIVE_SECONDS = 5000;
    @Scheduled(fixedRate = FIVE_SECONDS)
    public void scheduledTask() {
        System.out.print(dateFormat.format(new Date()));
    }
    @Scheduled(fixedRate = ONE_DAY)
    public void scheduledTask1() {
        System.out.print("我是一个每间隔一天执行一次的调度任务");
    }
    @Scheduled(fixedDelay  = ONE_HOURS)
    public void scheduledTask2() {
        System.out.print("我是一个每间隔一天执行一次的调度任务");
    }
}
