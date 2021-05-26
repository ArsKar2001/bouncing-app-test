package karmanchik.clientservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "AGENTTYPE")
@EqualsAndHashCode(callSuper = true)
public class AgentType extends AbstractEntity {
    private String title;
    private String image;

    @JsonBackReference
    @OneToMany(mappedBy = "type")
    private List<Agent> agents;

    public AgentType() {

    }

    @Override
    public String toString() {
        return "AgentType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
