package com.indusind.aem.platform.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.commons.Externalizer;
import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class)
public class AppModel {

    private final Logger logger = LoggerFactory.getLogger(AppModel.class);

    @ValueMapValue
    private String link;

    @SlingObject
    ResourceResolver resourceResolver;

    @OSGiService
    Externalizer externalizer;

    private String publishLink;
    private String authorLink;
    private String mydomainLink;

    @PostConstruct
    protected void init() {
        publishLink = externalizer.publishLink(resourceResolver, link);
        authorLink = externalizer.authorLink(resourceResolver, link);
        mydomainLink = externalizer.externalLink(resourceResolver, "mydomain", link);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPublishLink() {
        return publishLink;
    }

    public void setPublishLink(String publishLink) {
        this.publishLink = publishLink;
    }

    public String getAuthorLink() {
        return authorLink;
    }

    public void setAuthorLink(String authorLink) {
        this.authorLink = authorLink;
    }

    public String getMydomainLink() {
        return mydomainLink;
    }

    public void setMydomainLink(String mydomainLink) {
        this.mydomainLink = mydomainLink;
    }

}