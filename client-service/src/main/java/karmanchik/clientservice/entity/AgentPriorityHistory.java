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
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "AGENTPRIORITYHISTORY")
@EqualsAndHashCode(callSuper = true)
public class AgentPriorityHistory extends AbstractEntity {
    private LocalDate changeDate;
    private Integer priorityValue;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "AGENTID")
    private Agent agent;

    public AgentPriorityHistory() {

    }

    @Override
    public String toString() {
        return "AgentPriorityHistory{" +
                "id=" + id +
                ", changeDate=" + changeDate +
                ", priorityValue=" + priorityValue +
                '}';
    }
}
