package com.mhi.zgl010.flamework;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Profile("cloud")
public class Configration extends AbstractCloudConfig {
    @Bean 
    public DataSource dataSource() {
        Logger logger = LoggerFactory.getLogger(Configration.class);
        
        CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
        String url = "";
        String user = "";
        String password = "";
        String driver = "";  

        if (cfJdbcEnv != null) {
            CfCredentials hanaCredentials = cfJdbcEnv.findCredentialsByTag("hana");
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

   
	// @Bean 
	// public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
	// 	return new JdbcTemplate(dataSource);
    // }
    
    // @Bean
	// @Primary
	// @Profile("cloud")
	// public DataSourceProperties dataSourceProperties() {
	// 	CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
	// 	DataSourceProperties properties = new DataSourceProperties();
	// 	CfCredentials hanaCredentials = cfJdbcEnv.findCredentialsByTag("hana");

	// 	if (hanaCredentials != null) {

	// 		String uri = hanaCredentials.getUri("hana");
	// 		properties.setUrl(uri);
	// 		properties.setUsername(hanaCredentials.getUsername());
	// 		properties.setPassword(hanaCredentials.getPassword());
	// 	}

	// 	return properties;
	// }
}