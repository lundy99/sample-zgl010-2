package com.mhi.zgl010.service;


import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationNotFoundException;
import com.sap.cloud.sdk.s4hana.connectivity.exception.RequestExecutionException;
import com.sap.cloud.sdk.s4hana.connectivity.exception.RequestSerializationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.cloud.config.java.AbstractCloudConfig;
import com.mhi.zgl010.repository.YtorderaddRepository;
import com.mhi.zgl010.domains.Ytorderadd;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;


@Service
@Transactional
public class PutOrdersService {
    private static final Logger logger = LoggerFactory.getLogger(PutOrdersService.class);

    @Autowired
    private YtorderaddRepository repos;
    
    public void init() {

        // access HANA Cloud by JDBC
        List<Ytorderadd> data = repos.findAll();
        logger.info(data.toString());

    }

    public String getName() throws RequestSerializationException, DestinationNotFoundException, DestinationAccessException, RequestExecutionException {
        // access the RFC Destination "JCoDemoSystem"
        String username = "";

        try {
            final JCoDestination destinationJco = JCoDestinationManager.getDestination("S4H100");
            logger.info("RFC:Get Destination:"+ destinationJco.toString());
            
            // make an invocation of STFC_CONNECTION in the backend;

            JCoRepository repo = destinationJco.getRepository();
            logger.info("RFC:Get Repository:"+ repo.toString());

            JCoFunction stfcConnection = repo.getFunction("USER_NAME_GET");
            logger.info("RFC:Get Function:"+ stfcConnection.toString());

            // JCoParameterList imports = stfcConnection.getImportParameterList();
            // imports.setValue("REQUTEXT", "SAP BTP Connectivity runs with JCo");

            stfcConnection.execute(destinationJco);
            JCoParameterList exports = stfcConnection.getExportParameterList();

            username = exports.getString("USER_NAME");
            logger.info("RFC:Execute");

        } catch (JCoException e) {
            
            logger.error("errorRFC:", e);
        }
        
        return username;
    }

}
