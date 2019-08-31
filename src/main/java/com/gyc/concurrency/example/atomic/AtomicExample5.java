package com.gyc.concurrency.example.atomic;

import com.gyc.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Description:
 * Author: gyc
 * Version: 1.0
 * Create Date Time: 2019/5/17 10:25
 * Update Date Time:
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");
    @Getter
    public volatile int count = 100;
    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(example5,100,120)){
            log.info("update success 1, {}",example5.getCount());
        }
        if (updater.compareAndSet(example5,100,120)){
            log.info("update success 2, {}",example5.getCount());
        }else {
            log.info("update failed, {}",example5.getCount());
        }

    }
}
