package com.mhi.zgl010.flamework;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Profile("cloud")
public class CloudDatabaseConfig extends AbstractCloudConfig {

    Logger logger = LoggerFactory.getLogger(CloudDatabaseConfig.class);
    
    // @Bean
    // @Profile("cloud")
    // public CfJdbcEnv cfJdbcEnv() {
    //     return new CfJdbcEnv();
    // }
    @Bean 
    @Profile("cloud")
    public DataSource dataSource() {
        
        
        CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
        String url = "";
        String user = "";
        String password = "";
        String driver = "";  

        if (cfJdbcEnv != null) {
            CfCredentials hanaCredentials = cfJdbcEnv.findCredentialsByTag("hana");
            logger.info(hanaCredentials.toString());
            
            url = hanaCredentials.getUri("hana");
			user = hanaCredentials.getUsername();
            password = hanaCredentials.getPassword();
            driver = hanaCredentials.getString("driver");

            logger.info("hana.url/CfJdbcEnv:" + url);
            logger.info("hana.user/CfJdbcEnv:"+ user);
            logger.info("hana.password/CfJdbcEnv:"+ password);
            logger.info("hana.driver:"+ driver);
		}
        
        DataSource ds = DataSourceBuilder.create()
            .type(HikariDataSource.class)
            .driverClassName(driver)
            .url(url)
            .username(user)
            .password(password)
            .build();	

        logger.info("ds:"+ds.toString());
                
        return ds;
	}

}