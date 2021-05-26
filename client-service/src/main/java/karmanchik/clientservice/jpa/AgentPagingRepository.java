package karmanchik.clientservice.jpa;

import karmanchik.clientservice.entity.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AgentPagingRepository extends PagingAndSortingRepository<Agent, Integer> {
    List<Agent> findAll();
}
