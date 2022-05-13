package waj.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waj.model.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer>{
	
	List<Utente> findByNome(String nome);
	
	List<Utente> findByPassword(String password);
	
	Utente findByUsernameAndPassword(String username, String password);
	
	
}
