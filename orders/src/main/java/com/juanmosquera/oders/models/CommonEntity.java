package com.juanmosquera.oders.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
 


import java.io.Serializable;
import java.util.Date;

@Data

public class CommonEntity implements Serializable {

    @CreatedDate
    private Date createdDate;


    @LastModifiedDate
    private Date lastUpdateDate;
}
