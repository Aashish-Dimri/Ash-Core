package com.indusind.aem.platform.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;

@Model(adaptables = Resource.class)
public class MegaMenuModel {
  private static final Logger log = LoggerFactory.getLogger(MegaMenuModel.class);
  @SlingObject
  private ResourceResolver resourceResolver;
  
  @SlingObject
  private Resource  resource;
  
  @PostConstruct
  protected void init() {}
  ArrayList<String> title = new ArrayList<String>();
  int lvl;
  int l=1;
     public List<String> getPages() 
     {
        List<String> pageList = new ArrayList<>();

        if (resourceResolver != null) {
            String path = resource.getValueMap().get("path", String.class);
            lvl = resource.getValueMap().get("level", Integer.class);
            Resource pageResource = resourceResolver.getResource(path);
            Page currentPage = pageResource.adaptTo(Page.class);
            if (currentPage != null) {
                Iterator<Page> childPagesIterator = currentPage.listChildren();
                pageList.addAll(getTagsRecursively(childPagesIterator,l));
            } else {
                log.error("Failed to adapt page resource to Page class.");
            }
        } else {
            log.error("ResourceResolver is null. Initialization failed.");
        }
        return pageList;
    }

    private List<String> getTagsRecursively(Iterator<Page> childPagesIterator, int l) {
        List<String> tags = new ArrayList<>();
        while (childPagesIterator.hasNext()) {
            Page childPage = childPagesIterator.next();
            String navCheck = childPage.getProperties().get("hideInNavigation", String.class);
            String subCheck = childPage.getProperties().get("hideAllSubpage", String.class);
            String pageTitle = childPage.getTitle();
            log.info("AASHISH VALO"+navCheck + subCheck + pageTitle);
            String formattedTitle = "lvl"+l+pageTitle;
    
            if (l<=lvl) {
                if (navCheck.equals("true") && subCheck.equals("true")) continue;
                else if (navCheck.equals("true")) {
                    Iterator<Page> grandChildIterator = childPage.listChildren();
                    tags.addAll(getTagsRecursively(grandChildIterator,l+1));
                }
                else if (subCheck.equals("true")) { title.add(formattedTitle);} 
                else {
                    title.add(formattedTitle);
                    Iterator<Page> grandChildIterator = childPage.listChildren();
                    tags.addAll(getTagsRecursively(grandChildIterator,l+1));
                }
            }
        }
        return title;
    }    
} 