package com.smcodinglab.xkcd.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "xkcd")
public class XKCDProperties {

    private String url;

}
