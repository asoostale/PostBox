package com.postbox.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {


    private String createdBy;
    private String lastModifiedBy;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;



}
