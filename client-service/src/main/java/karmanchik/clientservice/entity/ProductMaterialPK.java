package karmanchik.clientservice.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ProductMaterialPK implements Serializable {
    private Integer productId;
    private Integer materialId;
}
