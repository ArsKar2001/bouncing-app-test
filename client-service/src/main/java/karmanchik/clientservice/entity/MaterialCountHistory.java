package karmanchik.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "MATERIALCOUNTHISTORY")
public class MaterialCountHistory extends AbstractEntity {
    private LocalDate changeDate;
    private double countValue;

    @ManyToOne
    @JoinColumn(name = "MATERIALTYPEID")
    private Material material;

    public MaterialCountHistory() {

    }
}
