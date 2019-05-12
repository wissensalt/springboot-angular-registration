package com.wissensalt.test.sar.model.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created on 2/27/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class ABaseAuditTrail extends BaseMasterDATA<Long> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4888747591156741211L;

    @CreatedBy
    @Column(name= "created_by", length=150)
    @Size(max = 150)
    protected String createdBy;

    @CreatedDate
    @Column(name = "created_on", nullable = false, updatable = false)
    protected Date createdOn;

    @LastModifiedBy
    @Column(name = "updated_by", length = 150)
    protected String modifiedBy;

    @LastModifiedDate
    @Column(name = "updated_on")
    protected Date modifiedOn;
}