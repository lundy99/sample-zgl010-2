package com.mhi.zgl010.domains;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Table;
// import javax.persistence.Id;
import lombok.Data;

@Data
// @Entity
// @Table(name="ext::ytorderadd")
public class Ytorderadd {
    public Ytorderadd(String mandt, String ybukrs, String ybeln, String yreasoncd, String yreasons) {
        setMandt(mandt);
        setYbukrs(ybukrs);
        setYbeln(ybeln);
        setYreasoncd(yreasoncd);
        setYreasons(yreasons);
    }

    // @Id
	// @Column(name ="mandt", nullable = false)
    private String mandt;

    // @Id
	// @Column(name ="ybukrs", nullable = false)
    private String ybukrs;

    // @Id
	// @Column(name ="ybeln", nullable = false)
    private String ybeln;

    // @Column(name ="yreasoncd")
    private String yreasoncd;

    // @Column(name ="yreasons")
     private String yreasons;

}
