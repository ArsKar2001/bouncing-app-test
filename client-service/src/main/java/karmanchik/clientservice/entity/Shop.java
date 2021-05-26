package karmanchik.clientservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "SHOP")
public class Shop extends AbstractEntity {
    private String title;
    private String address;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "AGENTID")
    private Agent agent;

    public Shop() {

    }
}
