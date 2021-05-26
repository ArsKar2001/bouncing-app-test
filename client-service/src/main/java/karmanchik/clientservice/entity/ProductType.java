package karmanchik.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "PRODUCTTYPE")
@EqualsAndHashCode(callSuper = true)
public class ProductType extends AbstractEntity {
    private String title;
    private Double defectedPercent;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;

    public ProductType() {

    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", defectedPercent=" + defectedPercent +
                '}';
    }
}
