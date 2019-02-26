package com.mask.core.io;

import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class TemplateFactory {

   final static Logger LOGGER = LoggerFactory.getLogger(TemplateFactory.class);

    public Template getTemplate(String name) {
        Template template = null;
        try {
            Configuration configuration = new Configuration(new Version("2.3.23"));
            configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
            template = configuration.getTemplate(name);
        }catch (TemplateNotFoundException e) {
            LOGGER.error("Load Template ERROR : ", e);
        }catch (IOException e) {
            LOGGER.error("Load Template ERROR : ", e);
        }
        return template;
    }

    public void showTemplate(Map<String, Object> map, String name) {
        try {
            Template template = this.getTemplate(name);
            template.process(map, new PrintWriter(System.out));
        }catch (TemplateException e) {
            LOGGER.error("Show Template ERROR : " + e);
        }catch (IOException e) {
            LOGGER.error("Show Template ERROR : " + e);
        }
    }
}
