package com.indusind.aem.platform.core.services;
import org.osgi.service.component.annotations.Component;
@Component(service = DemoMicroService.class)
public class DemoMicroService {
    public String getGreeting(String name) { return "Hello, " + name + "!";}
}