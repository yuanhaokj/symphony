package org.b3log.symphony.spring.config;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeMarkerConfig {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Value("${mvcPath}")
    private String mvcPath;


    @PostConstruct
    public void setConfigure() throws Exception {
        configuration.setSharedVariable("mvcPath", mvcPath);
    }

}
