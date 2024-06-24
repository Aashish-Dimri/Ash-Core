package com.indusind.aem.platform.core.schedulers;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "DemoConfig Scheduler Configurtions", description = "DemoConfig Scheduler Configurtions")

public @interface DemoConfig {
@AttributeDefinition(name = "Enabled", description = "Enable Scheduler", type = AttributeType.BOOLEAN)
boolean serviceEnabled() default true;

 @AttributeDefinition(name = "Scheduler name", description = "Scheduler name", type = AttributeType.STRING)
 public String schedulerName() default "OSGi R6 Annotation Scheduler Example";

 @AttributeDefinition(name = "Concurrent", description = "Schedule task concurrently", type = AttributeType.BOOLEAN)
 boolean schedulerConcurrent() default false;

 @AttributeDefinition(name = "Expression", description = "Cron-job expression. Default: run every hour.", type = AttributeType.STRING)
 String schedulerExpression() default "*/30 * * * * ?";
}