package com.mhi.zgl010.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.mhi.zgl010.domains.Ytorderadd;

@Repository
public class YtorderaddRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

   //Find all customers, thanks Java 8, you can create a custom RowMapper like this :
    public List<Ytorderadd> findAll() {

        List<Ytorderadd> result = jdbcTemplate.query(
                "SELECT mandt, ybukrs, ybeln, yreasoncd,yreasons FROM \"ext::ytorderadd\"",
                (rs, rowNum) -> new Ytorderadd(rs.getString("mandt"),
                        rs.getString("ybukrs"), rs.getString("ybeln"), 
                        rs.getString("yreasoncd"), rs.getString("yreasons"))
        );

        return result;

    }

}
