package com.wisedevlife.whytalkuser.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "WhyTalk Message API",
                version = "v1.0",
                description = "Message Service, Chat Room Service",
                contact = @Contact(
                        name = "WiseDeveloperLife Inc.",
                        url = "https://github.com/Wise-Developer-Life"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class OpenApiConfiguration {
}
