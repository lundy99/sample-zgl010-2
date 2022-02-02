package com.mhi.zgl010.service;


// import java.net.URI;
// import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

// import javax.naming.Context;
// import javax.naming.InitialContext;
// import javax.naming.NamingException;
// import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
public class OrdersService {
    private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

    @Autowired
    private YtorderaddRepository repos;
   
    public List<Ytorderadd> getAll() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        logger.info("requestUrl:" + url);

        // access HANA Cloud by JDBC
        logger.info("access HANA Cloud by JDBC");
        List<Ytorderadd> data = repos.findAll();
        logger.info(data.toString());
        return data;

    }
    public int putYtorderadd(Ytorderadd data) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        logger.info("requestUrl:" + url);

        // access HANA Cloud by JDBC
        logger.info("access HANA Cloud by JDBC");
        int result  = repos.insertData(data);
        return result;

    }
    public int postYtorderadd(Ytorderadd data) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        logger.info("requestUrl:" + url);

        // access HANA Cloud by JDBC
        logger.info("access HANA Cloud by JDBC");
        int result  = repos.updataData(data);
        return result;

    }
}
