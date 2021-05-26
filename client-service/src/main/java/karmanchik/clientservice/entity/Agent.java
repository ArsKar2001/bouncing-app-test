package karmanchik.clientservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "AGENT")
@EqualsAndHashCode(callSuper = true)
public class Agent extends AbstractEntity {
    private String title;
    private String address;
    private String inn;
    private String kpp;
    private String directorName;
    private String phone;
    private String email;
    private String logo;
    private Integer priority;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "AGENTTYPEID")
    private AgentType type;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<AgentPriorityHistory> histories;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<ProductSale> sales;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Shop> shops;

    public Agent() {

    }

    public Integer getPercent() {
        int sumProductCount = sales.stream()
                .map(ProductSale::getProductCount)
                .mapToInt(Integer::intValue).sum();
        int sumCost = sales.stream()
                .map(sale -> sale.getProduct().getMinCostForAgent())
                .distinct()
                .mapToInt(BigDecimal::intValue).sum();
        int sum = sumProductCount * sumCost;
        return (sum >= 10_000 ?
                sum >= 50_000 ?
                        sum >= 150_000 ?
                                sum >= 500_000 ? 25
                                        : 20
                                : 10
                        : 5
                : 0);
    }

}
