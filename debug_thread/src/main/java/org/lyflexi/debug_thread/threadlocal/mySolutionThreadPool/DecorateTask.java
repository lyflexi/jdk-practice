package org.lyflexi.debug_thread.threadlocal.mySolutionThreadPool;

import java.util.concurrent.Callable;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/7/27 12:12
 */
public class DecorateTask implements Callable<String>{
    private final String taskValue;
    private final ThreadLocal<String> contextHolder;

    public DecorateTask(String taskValue, ThreadLocal<String> contextHolder) {
        this.taskValue = taskValue;
        this.contextHolder = contextHolder;
    }

    @Override
    public String call() throws Exception {
        // 在任务执行前，将任务的值设置到ThreadLocal中
        contextHolder.set(taskValue);

        // 模拟任务执行
        String taskResult = "Task executed with value: " + contextHolder.get();

        // 任务执行后，可以清理ThreadLocal的值，如果需要的话
        contextHolder.remove();

        return taskResult;
    }
}
