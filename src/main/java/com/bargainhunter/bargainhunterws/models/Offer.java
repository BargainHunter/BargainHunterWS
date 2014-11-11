package com.bargainhunter.bargainhunterws.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Johnny on 11/11/14.
 */
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private String title;
    private String description;
    private double price;
    private Date startDate;
    private Date expDate;



}
