package com.mhi.zgl010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

// import com.mhi.zx0000.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.cfenv.jdbc.CfJdbcEnv;

@SpringBootApplication
@ComponentScan({"com.sap.cloud.sdk", "com.mhi"})
@ServletComponentScan({"com.sap.cloud.sdk", "com.mhi"})
public class Application extends SpringBootServletInitializer
{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure( final SpringApplicationBuilder application )
    {
        return application.sources(Application.class);
    }

    public static void main( final String[] args )
    {
         CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
        logger.info("CfJdbcEnv:" + cfJdbcEnv.toString());

        //         // スキャンされているbeanを出力する
        logger.info("START:スキャンされているbeanを出力する");
        // AnnotationConfigApplicationContext     applicationContext =
        //   new AnnotationConfigApplicationContext(Application.class);

        // for (String beanName : applicationContext.getBeanDefinitionNames()) {
        //     logger.info(beanName);
        // }
        // applicationContext.close();
        //  logger.info("END:スキャンされているbeanを出力する");

        SpringApplication.run(Application.class, args);
    }
}
