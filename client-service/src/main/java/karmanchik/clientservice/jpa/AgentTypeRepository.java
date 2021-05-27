package karmanchik.clientservice.jpa;

import karmanchik.clientservice.entity.AgentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AgentTypeRepository extends JpaRepository<AgentType, Integer> {
}
