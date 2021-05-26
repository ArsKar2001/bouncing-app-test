package karmanchik.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "MATERIALSUPPLIER")
public class MaterialSupplier {

    @EmbeddedId
    private MaterialSupplierPK materialSupplierPK;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("materialId")
    @JoinColumn(name = "MATERIALID")
    private Material material;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("supplierId")
    @JoinColumn(name = "SUPPLIERID")
    private Supplier supplier;

    public MaterialSupplier() {

    }
}
