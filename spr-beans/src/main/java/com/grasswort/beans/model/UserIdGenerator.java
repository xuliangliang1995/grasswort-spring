package com.grasswort.beans.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/5
 */
public class UserIdGenerator implements IdGenerator {

    private final AtomicLong atomicLong = new AtomicLong();
    /**
     * 生成 ID
     *
     * @return
     */
    @Override
    public Long generateId() {
        return atomicLong.incrementAndGet();
    }
}
