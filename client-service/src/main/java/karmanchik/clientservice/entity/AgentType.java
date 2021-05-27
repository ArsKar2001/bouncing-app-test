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
@Table(name = "AGENTTYPE")
@EqualsAndHashCode(callSuper = true)
public class AgentType extends AbstractEntity {
    private String title;
    private String image;

    @OneToMany(mappedBy = "type")
    private List<Agent> agents;

    public AgentType() {

    }

    @Override
    public String toString() {
        return title;
    }
}
