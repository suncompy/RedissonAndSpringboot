package org.spring.springboot.redis2.entity;
import org.hibernate.annotations.GenericGenerator;  
  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
  
/** 
 * 测试类实体 
 * Created by LiaoKe on 2017/5/22. 
 */  
@Entity  
public class TestEntity {  
    @Id  
    @GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")  
    private String id;  
    private Integer num;  
  
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
  
    public Integer getNum() {  
        return num;  
    }  
  
    public void setNum(Integer num) {  
        this.num = num;  
    }  
}  
