package com.mhi.zgl010.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import com.mhi.zgl010.domains.Ytorderadd;

@Repository
public class YtorderaddRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(YtorderaddRepository.class);

   //Find all customers, thanks Java 8, you can create a custom RowMapper like this :
    public List<Ytorderadd> findAll() {
        logger.info(jdbcTemplate.toString());
        RowMapper<Ytorderadd> rowMapper = new BeanPropertyRowMapper<Ytorderadd>(Ytorderadd.class);
        List<Ytorderadd> result = jdbcTemplate.query(
                "SELECT mandt, ybukrs, ybeln, yreasoncd,yreasons FROM \"ext::ytorderadd\"",
                rowMapper
        );

        return result;

    }
    
    public int insertData(Ytorderadd row) {

        String sqlText  = "INSERT INTO \"ext::ytorderadd\" ("	
            + "MANDT"
            + ",YBUKRS"
            + ",YBELN"
            + ",YREASONCD"
            + ",YREASONS"
            + ") "
            + "VALUES (?,?,?,?,?)";

        int result = jdbcTemplate.update(sqlText, 
            row.getMandt()
            ,row.getYbukrs()
            ,row.getYbeln()
            ,row.getYreasoncd()
            ,row.getYreasons());
       
        return result;

    }

    public int updataData(Ytorderadd row) {

        String sqlText  = "UPDATE \"ext::ytorderadd\" SET"	
            + "  YBELN = ?"
            + "  ,YREASONCD = ?"
            + "  ,YREASONS = ?"
            + " WHERE  "
            + "  MANDT = ?"
            + "  AND YBUKRS = ?";

        int result = jdbcTemplate.update(sqlText
            ,row.getYbeln()
            ,row.getYreasoncd()
            ,row.getYreasons() 
            ,row.getMandt()
            ,row.getYbukrs());
       
        return result;

    }
}
