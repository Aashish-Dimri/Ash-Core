package com.indusind.aem.platform.core.models;

public class ModelData {
    private String url;
    private String title;
    private String description;
    private String tags;
    private String image;
    private String summary;
    private String lmod;
    
    // Constructors
    public ModelData() {
        // Default constructor
    }
    
    public ModelData(String url, String title,String description,String tags,String image,String summary,String lmod)
    //, String description
    //, List<String> tags, String image, String summary) 
    {
        this.url = url;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.image = image;
        this.summary = summary;
        this.lmod=lmod;
    }
    
    // Getters and Setters
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
     
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getTags() {
        return tags;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }
     
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLmod() {
        return lmod;
    }
    
    public void setLmod(String lmod) {
        this.lmod = lmod;
    }
}