package com.indusind.aem.platform.core.listeners;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service = EventListener.class, immediate = true)
public class PropertyEventListenerJCR implements EventListener {
    private static final Logger log = LoggerFactory.getLogger(PropertyEventListenerJCR.class);

    @Reference
    private SlingRepository repository;
    private Session session;

    @Activate
    protected void activate() throws Exception {
        session = repository.loginService("testUser", null);
        session.getWorkspace().getObservationManager().addEventListener(this,
                Event.NODE_REMOVED | Event.NODE_ADDED | Event.PROPERTY_REMOVED | Event.PROPERTY_ADDED,
                "/content/Indusind/us",
                true,
                null,
                null,
                false);
    }

    @Override
    public void onEvent(EventIterator events) {
        try {
            while (events.hasNext()) {
                Event event = events.nextEvent();
                log.info(" AASHISH Event Type: {}, Node Identifier: {}, Path: {}",
                        event.getType(),
                        event.getIdentifier(),
                        event.getPath());
            }
        } catch (RepositoryException e) {
            log.error("Exception occurred", e);
        }
    }
}
