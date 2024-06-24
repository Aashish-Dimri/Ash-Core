package com.indusind.aem.platform.core.listeners;
import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service = EventHandler.class,
           immediate = true,
           property = {
                   EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
                   EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
                   EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/REMOVED",
                   EventConstants.EVENT_FILTER +"=(path=/content/Indusind/us/*)"
           })
public class PropertyEventHandlerOSGI implements EventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(PropertyEventHandlerOSGI.class);
    @Reference
    ResourceResolverFactory resourceResolverFactory;
    public void handleEvent(final Event event) {
        LOG.info("\n Resource event: {} at: {}", event.getTopic(), event.getProperty(SlingConstants.PROPERTY_PATH));
        try {
            for(String prop : event.getPropertyNames()){
                LOG.info("\n Property : {} , Value : {} ", prop,event.getProperty(prop));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}