package com.indusind.aem.platform.core.jobs;

import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = JobConsumer.class,
        property = JobConsumer.PROPERTY_TOPICS + "=com/myproject/job"
)
public class MyProjectJobConsumer implements JobConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MyProjectJobConsumer.class);

    @Override
    public JobResult process(Job job) {
        LOG.info("Processing job: {}", job.getTopic());
        
        // Implement your job logic here
        
        return JobResult.OK;
    }
}

