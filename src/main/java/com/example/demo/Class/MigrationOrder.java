package com.example.demo.Class;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.List;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="migration_order")
public class MigrationOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    public Integer ORDER_ID;

    @Column(name = "USER_ID")
    public String USER_ID;

    @Column(name = "USER_GROUP")
    public String USER_GROUP;
    @Column(name = "COID")
    public String COID ;
    @Column(name = "OFFER_INIT")
    public String OFFER_INIT;
    @Column(name = "OFFER_TARGET")
    public String OFFER_TARGET;
    @Column(name = "DUEDATE")
    public String DUEDATE;
    @Column(name = "DATE_START")
    public String DATE_START;
    @Column(name = "DATE_END")
    public String DATE_END;
    @Column(name = "MIG_COMMENT")
    public String MIG_COMMENT;
    @Column(name = "CUSTCODE")
    public String CUSTCODE;
    @Column(name = "CUSTID")
    public String CUSTID;
    @Column(name = "COCODE")
    public String COCODE;
    @Column(name = "OFFER_INIT_DES")
    public String OFFER_INIT_DES;
    @Column(name = "OFFER_TARGET_DES")
    public String OFFER_TARGET_DES;
    @Column(name = "remarque")
    public String remarque;
    @Column(name = "task")
    public String task;
    @Column(name = "status")
    public Integer status;
    @Column(name = "MSISDN")
    public String MSISDN;
    @Column(name = "OLD_COID")
    public String OLD_COID ;
    @Column(name = "OLD_COCODE")
    public String OLD_COCODE;
    @Column(name = "dateend")
    public String dateEnd;
    @Column(name = "datestart")
    public String dateStart;
    @Column(name = "migcomment")
    public String migComment;
    @Column(name = "offerinit")
    public String offerinit;
    @Column(name = "offerinitdes")
    public String offerinitdes;
    @Column(name = "offertarget")
    public String offertarget;
    @Column(name = "offertargetdes")
    public String offertargetdes;
    @Column(name = "usergroup")
    public String userGroup;
    @Column(name = "userid")
    public String userId;
}
