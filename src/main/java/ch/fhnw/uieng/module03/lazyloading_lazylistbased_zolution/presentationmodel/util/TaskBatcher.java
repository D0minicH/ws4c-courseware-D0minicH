package ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.util;

import java.time.Duration;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

/**
 * @author Dieter Holz
 */
public class TaskBatcher {
    private final Duration delay;
    private Timer timer;

    public TaskBatcher(Duration delay){
        this.delay = delay;
    }

    public void batch(Runnable toDo) {
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(toDo);
                timer.cancel();
            }
        };

        timer.schedule(task, delay.toMillis());
    }
}
