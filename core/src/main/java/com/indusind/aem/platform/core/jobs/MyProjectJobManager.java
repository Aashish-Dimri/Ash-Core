package com.indusind.aem.platform.core.jobs;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class MyProjectJobManager {

    private static final Logger LOG = LoggerFactory.getLogger(MyProjectJobManager.class);
    private static final String JOB_TOPIC = "com/myproject/job";
    private static final String JOB_NAME = "myProjectJob";

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate() {
        ScheduleOptions options = scheduler.EXPR("0 0/1 * 1/1 * ? *"); // Run every minute
        options.name(JOB_NAME);
        options.canRunConcurrently(false);

        //scheduler.schedule(() -> triggerJob(), options);
        LOG.info("Job scheduled to run every minute");
    }

    @Deactivate
    protected void deactivate() {
        scheduler.unschedule(JOB_NAME);
        LOG.info("Job unscheduled");
    }

    private void triggerJob() {
        LOG.info("Triggering job execution");
        // Logic to trigger the job execution
    }
}
