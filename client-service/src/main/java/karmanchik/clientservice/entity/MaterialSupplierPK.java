package karmanchik.clientservice.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class MaterialSupplierPK implements Serializable {
    private Integer materialId;
    private Integer supplierId;

}
