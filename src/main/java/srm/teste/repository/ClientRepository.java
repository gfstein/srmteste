package srm.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srm.teste.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
