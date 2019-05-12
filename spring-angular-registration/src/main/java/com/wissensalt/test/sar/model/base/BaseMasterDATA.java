package com.wissensalt.test.sar.model.base;

/**
 * Created on 2/27/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 */
@Getter
@Setter
@MappedSuperclass
public class BaseMasterDATA<KEY extends Serializable> implements ISingleKeyDATA<KEY>, Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -81861420500108351L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private KEY id;

    @Column(name = "code", length = 50, unique = true, nullable = false)
    @NotNull(message = "Code Field of Entity is Required")
    @Size(max = 50)
    private String code;

    @Size(max = 50)
    @NotNull(message = "Name Field of Entity is Required")
    @Column(name = "name", length = 50)
    private String name;

    @Column(name= "status", nullable = false)
    protected Boolean status;

    @Size(max = 256)
    @Column(name= "remarks", length=256)
    protected String remarks;

    @Override
    public KEY getId() {
        return id;
    }
}