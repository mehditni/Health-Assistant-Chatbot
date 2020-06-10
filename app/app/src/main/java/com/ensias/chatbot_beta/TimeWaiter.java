package com.ensias.chatbot;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeWaiter {

    private static int numberOfThread = 16;
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(numberOfThread);

    public static void addNext(Runnable run, long time, TimeUnit unit, DataType scheduler) {
        TimeWaiter.scheduler.schedule(run, time, unit);
    }
    public enum DataType {
        USER,
        BOT,
        APPLICATION;


    }
}
