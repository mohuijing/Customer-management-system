package com.youchuang.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: mohuijing
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login/login");
    }

    /**
     * 图片路径配置
     * @param registry
     */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      /*和页面有关的图片放在项目的img目录下
      意思就是,前端浏览器访问路径带有/file/**就转到对应磁盘下读取图片,
      类似前端访问tomcat webapp下file文件夹中文件
      测试就会自动去找D盘中的file目录中文件*/
      registry.addResourceHandler("/img/**").addResourceLocations("file:D://project/");
    }
}

