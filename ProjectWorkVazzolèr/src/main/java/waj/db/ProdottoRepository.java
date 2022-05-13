package waj.db;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import waj.model.Prodotto;

@Repository
public interface ProdottoRepository extends CrudRepository<Prodotto, Integer>{
	
	List<Prodotto> findProdottiByPrezzoAndTipoProdotto(Double prezzo, String tipoProdotto);
}
