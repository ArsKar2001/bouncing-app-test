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
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Integer getAverageSaleCount() {
        return (int) sales.stream()
                .map(sale -> sale.getSaleDate().getYear())
                .distinct()
                .mapToInt(year -> sales.stream()
                        .filter(sale -> sale.getSaleDate().getYear() == year)
                        .mapToInt(ProductSale::getProductCount).sum()).average()
                .orElse(0);
    }

    public Integer getPercent() {
        int sum = sales.stream()
                .mapToInt(value -> value.getProduct().getMinCostForAgent().intValue() * value.getProductCount())
                .sum();
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
