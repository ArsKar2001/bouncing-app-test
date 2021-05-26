package karmanchik.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "PRODUCTMATERIAL")
public class ProductMaterial {

    @EmbeddedId
    private ProductMaterialPK productMaterialPK;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCTID")
    private Product product;
    @ManyToOne
    @MapsId("materialId")
    @JoinColumn(name = "MATERIALID")
    private Material material;

    private Double count;

    public ProductMaterial() {

    }
}
