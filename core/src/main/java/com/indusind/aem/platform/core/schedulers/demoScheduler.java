package com.indusind.aem.platform.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service= Runnable.class, immediate = true)
@Designate(ocd=DemoConfig.class)

public class demoScheduler  implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate(final DemoConfig config) {
        logger.error(" demoScheduler activate method called");
        addScheduler(config);
    }

    public void addScheduler(DemoConfig config) {
        if (config.serviceEnabled()) {
            ScheduleOptions options = scheduler.EXPR(config.schedulerExpression());
            options.name(config.schedulerName());
            options.canRunConcurrently(config.schedulerConcurrent());
            scheduler.schedule(this, options);
            //ScheduleOptions opt = scheduler.NOW(3,10);
            //scheduler.schedule(this, opt);
            logger.error("Scheduler added successfully name='{}'", config.schedulerName());
        } else {
            logger.error("SimpleScheduledTask disabled");
        }
    }

    @Deactivate
    protected void deactivate(DemoConfig config) {
        scheduler.unschedule(config.schedulerName());
        logger.error("demoScheduler removed successfully >>>>>>>   ");
    }

    @Override
    public void run() {
        logger.error("demoScheduler run >>>>>>>>>>>");
    }
}