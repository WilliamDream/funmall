package com.funmall.commons.properties;

import com.funmall.commons.constants.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: WilliamDream
 * @Description:
 */

@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class AllProperties {

    private SwaggerProperties swaggerProperties = new SwaggerProperties();


}
