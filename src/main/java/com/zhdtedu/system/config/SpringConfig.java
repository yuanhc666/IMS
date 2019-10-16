package com.zhdtedu.system.config;

import com.zhdtedu.util.PageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.zhdtedu.riverchiefs.*","com.zhdtedu.system.*","com.zhdtedu.util"}) //配置扫描包
public class SpringConfig {
    @Bean
    public PageModel pageModel(){
        return new PageModel();
    }
}
