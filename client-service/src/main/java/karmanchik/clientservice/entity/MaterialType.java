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
@Table(name = "MATERIALTYPE")
@EqualsAndHashCode(callSuper = true)
public class MaterialType extends AbstractEntity {
    private String title;
    private Double defectedPercent;

    @OneToMany(mappedBy = "type")
    private List<Material> materials;

    public MaterialType() {

    }
}
