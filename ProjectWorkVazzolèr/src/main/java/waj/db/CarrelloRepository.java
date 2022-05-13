package waj.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import waj.model.Carrello;

@Repository
public interface CarrelloRepository extends CrudRepository<Carrello, Integer>{
	
	Carrello findByCodProdottoAndCodUtente(Integer codProdotto, Integer codUtente);
	
	List<Carrello> findByCodUtente(Integer codUtente);
}
