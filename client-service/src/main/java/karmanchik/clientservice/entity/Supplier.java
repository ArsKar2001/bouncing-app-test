package karmanchik.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "SUPPLIER")
public class Supplier extends AbstractEntity {
    private String title;
    private String inn;
    private LocalDate startDate;
    private Integer qualityRating;
    private String supplierType;

    public Supplier() {

    }
}
