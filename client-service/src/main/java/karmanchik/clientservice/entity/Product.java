package karmanchik.clientservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "PRODUCT")
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {
    private String title;
    private String articleNumber;
    private String description;
    private String image;
    private Integer productionPersonCount;
    private Integer productionWorkshopNumber;
    private BigDecimal minCostForAgent;

    @ManyToOne
    @JoinColumn(name = "PRODUCTTYPEID")
    private ProductType productType;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCostHistory> histories;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSale> productSales;

    public Product() {

    }
}
