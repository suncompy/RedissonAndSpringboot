package org.spring.springboot.redis2;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
  
/** 
 * Created by LiaoKe on 2017/5/22. 
 */  
@Configuration  
public class BeanConfig {  
  
    @Bean  
    public DistributedLockFactoryBean distributeLockTemplate(){  
        DistributedLockFactoryBean d  = new DistributedLockFactoryBean();  
        d.setMode("SINGLE");  
        return d;  
    }  
}  