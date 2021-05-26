package karmanchik.clientservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "PRODUCTSALE")
public class ProductSale extends AbstractEntity {
    private LocalDate saleDate;
    private Integer productCount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "PRODUCTID")
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "AGENTID")
    private Agent agent;

    public ProductSale() {

    }

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", productCount=" + productCount +
                '}';
    }
}
