/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasurgical.sasurgical;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 *
 * @author Sothie
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("/media/**")
                .addResourceLocations("/resources/media/")
                .setCachePeriod(60 * 60 * 24)
                .resourceChain(true);
        
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/")
                .setCachePeriod(60 * 60 * 24)
                .resourceChain(true);
        
        registry.addResourceHandler("/tpl/**")
                .addResourceLocations("/resources/tpl/")
                .setCachePeriod(60 * 60 * 24)
                .resourceChain(true);
        
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/")
                .setCachePeriod(60 * 60 * 24)
                .resourceChain(true);
        
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/resources/fonts/")
                .setCachePeriod(60 * 60 * 24)
                .resourceChain(true);
    }
}
