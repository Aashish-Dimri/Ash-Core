package com.indusind.aem.platform.core.services;

import java.util.HashMap;
import java.util.Map;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=ReadWriteServiceImpl.class,immediate = true)
public class ReadWriteServiceImpl {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Reference
	private ResourceResolverFactory resolverFactory;
    @Activate
	public void doAReadOperation(ComponentContext ctx) throws org.apache.sling.api.resource.LoginException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ResourceResolverFactory.SUBSERVICE, "aashish");
		ResourceResolver resolver = null;
		try {
			resolver = resolverFactory.getServiceResourceResolver(param);
			log.info("user-ids " + resolver.getUserID());
			Resource res = resolver.getResource("/content/Indusind/jcr:content");
			ValueMap readMap = res.getValueMap();
			log.info("Read the value of jcr:primaryType "+readMap.get("jcr:primaryType", ""));
			ModifiableValueMap modMap = res.adaptTo(ModifiableValueMap.class);
			if (modMap != null) {
				modMap.put("value by systemUser (aashish)", true);
				resolver.commit();
				log.info("Successfully saved");
			}
		} catch (PersistenceException e) {
			log.error("LoginException", e);
		} finally {
			if (resolver != null && resolver.isLive()) {
				resolver.close();
			}
		}
	}

}