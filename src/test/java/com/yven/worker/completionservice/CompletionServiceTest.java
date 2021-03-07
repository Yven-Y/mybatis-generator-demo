package com.yven.worker.completionservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * {@link: https://www.cnblogs.com/huhx/p/baseusejavaCompletionService.html}
 *
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/25
 */
@Slf4j
public class CompletionServiceTest {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(5);

        CompletionService<String> completionService = new ExecutorCompletionService<String>(service);
        for (int i = 5; i > 0; i--) {
            completionService.submit(new ReturnAfterSleepCallable(i));
        }
        log.info("after submit");
        for (int i = 0; i < 5; i++) {
//            log.info("result: " + completionService.take().get()); // 这个方法是阻塞的
            log.info("result: " + completionService.poll()); // 这个方法是阻塞的
        }
        log.info("after get");
        service.shutdown();
    }

    private static class ReturnAfterSleepCallable implements Callable<String> {
        int sleep;

        public ReturnAfterSleepCallable(int sleep) {
            this.sleep = sleep;
        }

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(sleep);
            return System.currentTimeMillis() + ",sleep=" + String.valueOf(sleep);
        }
    }
}
