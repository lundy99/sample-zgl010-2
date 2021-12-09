package com.mhi.zgl010.service;


// import java.net.URI;
// import java.net.URISyntaxException;
import java.util.List;

// import javax.naming.Context;
// import javax.naming.InitialContext;
// import javax.naming.NamingException;
// import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import io.pivotal.cfenv.core.CfCredentials;
// import io.pivotal.cfenv.jdbc.CfJdbcEnv;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.cloud.config.java.AbstractCloudConfig;
import com.mhi.zgl010.repository.YtorderaddRepository;
import com.mhi.zgl010.domains.Ytorderadd;
import org.springframework.boot.cloud.CloudFoundryVcapEnvironmentPostProcessor;


@Service
@Transactional
public class PutOrdersService {
    private static final Logger logger = LoggerFactory.getLogger(RfcService.class);

    @Autowired
    private YtorderaddRepository repos;
   
    public List<Ytorderadd> getAll() {

        // access HANA Cloud by JDBC
        logger.info("access HANA Cloud by JDBC");
        List<Ytorderadd> data = repos.findAll();
        logger.info(data.toString());
        return data;

    }
    public int putYtorderadd(Ytorderadd data) {

        // access HANA Cloud by JDBC
        logger.info("access HANA Cloud by JDBC");
        int result  = repos.insertData(data);
        return result;

    }
}
