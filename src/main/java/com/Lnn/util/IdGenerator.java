package com.Lnn.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGenerator {
    // 时间戳的位数
    private static final int TIMESTAMP_BITS = 41;
    // 机器 ID 的位数
    private static final int WORKER_ID_BITS = 10;
    // 序列号的位数
    private static final int SEQUENCE_BITS = 12;

    // 时间戳偏移量
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    // 机器 ID 偏移量
    private static final long WORKER_ID_LEFT_SHIFT = SEQUENCE_BITS;

    // 最大序列号
    private static final long MAX_SEQUENCE = (1 << SEQUENCE_BITS) - 1;

    @Value("${generator.worker-id}")
    // 机器 ID
    private long workerId;

    // 上次生成 ID 的时间戳
    private long lastTimestamp = -1L;
    // 当前序列号
    private long sequence = 0L;

    // 用于存储最大时间戳以处理时间回拨
    private long maxTimestamp = -1L;

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        // 如果发生时间回拨
        if (timestamp < lastTimestamp) {
            timestamp = maxTimestamp; // 使用最大时间戳
        }

        // 如果当前时间戳等于上一次生成 ID 的时间戳，则序列号加1
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE; // 序列号递增
            if (sequence == 0) {
                // 序列号溢出，等待下一个毫秒
                timestamp = waitNextMillis(lastTimestamp);
            }
        } else {
            // 当前时间戳不等于上一次生成 ID 的时间戳，序列号重置为0
            sequence = 0L;
        }

        // 更新最大时间戳
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        lastTimestamp = timestamp;

        // 组合成 ID
        return ((timestamp << TIMESTAMP_LEFT_SHIFT) |
                (workerId << WORKER_ID_LEFT_SHIFT) |
                sequence);
    }

    private long waitNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
