package org.lyflexi.debug_thread.designParten.syncParten.guardedSuspension.rpcDubbo_OneToOne;

/**
 * @Author: ly
 * @Date: 2024/3/16 10:57
 */
public class TestRpc {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        Thread.sleep(1000);
        for (Integer id : Mailboxes.getIds()) {
            new Postman(id, "内容" + id).start();
        }
    }
}
