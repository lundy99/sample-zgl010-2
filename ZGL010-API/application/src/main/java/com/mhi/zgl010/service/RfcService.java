package com.mhi.zgl010.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoTable;


@Service
@Transactional
public class RfcService {
    private static final Logger logger = LoggerFactory.getLogger(RfcService.class);


    public String getName() {
        String username = "";   

        try {


            //Destinationを経由してRFC接続を開始                                        
            final JCoDestination destinationJco = JCoDestinationManager.getDestination("S4H100");
            logger.info("RFC:Get Destination:"+ destinationJco.toString());
            
            JCoRepository repo = destinationJco.getRepository();
            logger.info("RFC:Get Repository:"+ repo.toString());
            
            //実行するFunction（SAP-API）を設定
            JCoFunction stfcConnection = repo.getFunction("USER_NAME_GET");
            logger.info("RFC:Get Function:"+ stfcConnection.toString());

            //Inputパラメータを作成
            // JCoParameterList imports = stfcConnection.getImportParameterList();
            // imports.setValue("REQUTEXT", "SAP BTP Connectivity runs with JCo");
            // JCoStructure importStructure = stfcConnection.getImportParameterList().getStructure("ORDERS");
            // for (JCoField field : importStructure) {
            //     field.setValue(imput.getValue(field.getName()));
            // }           
            //RFCを実行
            stfcConnection.execute(destinationJco);
            
            //実行結果を取得
            JCoParameterList exports = stfcConnection.getExportParameterList();
            username = exports.getString("USER_NAME");
            // JCoStructure exportStructure = stfcConnection.getExportParameterList().getStructure("RETURN");
            // JCoTable exportTable = stfcConnection.getExportParameterList().getTable("RETURN");
            // for (int i = 0; i < exportTable.getNumRows(); i++) {
            //     exportTable.setRow(i);
            //     for (JCoField field : exportStructure) {
            //         System.out.println(field.getName() + ":\t" + exportTable.getString());
            //     }
            // }
            logger.info("RFC:Execute");

        } catch (JCoException e) {
            
            logger.error("errorRFC:", e);
        }
        
        return username;
    }

    public String getRFC() {
        String username = "";   

        try {


            //Destinationを経由してRFC接続を開始                                        
            final JCoDestination destinationJco = JCoDestinationManager.getDestination("S4H100");
            logger.info("RFC:Get Destination:"+ destinationJco.toString());
            
            JCoRepository repo = destinationJco.getRepository();
            logger.info("RFC:Get Repository:"+ repo.toString());
            
            //実行するFunction（SAP-API）を設定
            JCoFunction stfcConnection = repo.getFunction("YF_UPD_ORDER1");
            logger.info("RFC:Get Function:"+ stfcConnection.toString());

            //Inputパラメータを作成
            // JCoParameterList imports = stfcConnection.getImportParameterList();
            // for (JCoField field : imports) {
            //     logger.info(field.getName()+field.getString());
            // } 
            // imports.setValue("REQUTEXT", "SAP BTP Connectivity runs with JCo");
            JCoTable importTable = stfcConnection.getImportParameterList().getTable("ORDERS");
            importTable.clear();
            importTable.insertRow(0);
            logger.info("log1:"+importTable.toString());
            JCoFieldIterator fields = importTable.getFieldIterator();
            logger.info("log2:"+fields.toString());
            while (fields.hasNextField()) {
                JCoField field = fields.nextField();
                logger.info("log3:"+field.getName() +":" +field.getTypeAsString());
                // field.setValue("test");
                // logger.info(field.toString());
            }
                      
            //RFCを実行
            stfcConnection.execute(destinationJco);
            
            //実行結果を取得
            JCoParameterList exports = stfcConnection.getExportParameterList();
            JCoTable exportTable = stfcConnection.getExportParameterList().getTable("RETURN");
            for (int i = 0; i < exportTable.getNumRows(); i++) {
                exportTable.setRow(i);
                fields = exportTable.getFieldIterator();
                logger.info("log4:"+fields.toString());
                while (fields.hasNextField()) {
                    JCoField field = fields.nextField();
                    logger.info("log4:"+field.getName() +":" +field.getValue());
                }
                
            }
            logger.info("RFC:Execute");

        } catch (JCoException e) {
            
            logger.error("errorRFC:", e);
        }
        
        return username;
    }

}
