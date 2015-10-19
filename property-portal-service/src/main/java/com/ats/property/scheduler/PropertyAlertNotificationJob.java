package com.ats.property.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * The PropertyAlertNotificationJob.
 *
 * @author anbarasan.s
 */
public class PropertyAlertNotificationJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        PropertyAlertNotificationTask.prepareAndSendMail();
    }
}
