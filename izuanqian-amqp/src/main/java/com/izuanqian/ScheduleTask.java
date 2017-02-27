/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author sanlion
 */
@Component
public class ScheduleTask {

    @Autowired private Sender sender;

    // http://cron.qqe2.com/ 在线解析或生成cron规则
    @Scheduled(cron = "10-30 * * * * *")
    public void autoSendMessage() throws InterruptedException {
        sender.send();
    }

}
