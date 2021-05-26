package karmanchik.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "MATERIAL")
public class Material extends AbstractEntity {
    private String title;
    private Integer countInPack;
    private String unit;
    private Double countInStock;
    private Double minCount;
    private String description;
    private BigDecimal cost;
    private String image;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<MaterialCountHistory> histories;

    @ManyToOne
    @JoinColumn(name = "MATERIALTYPEID")
    private MaterialType type;

    public Material() {

    }
}
