package br.com.lucianazuza.agropopshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucianazuza.agropopshop.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	/*Correção by Xico: Essa busca retorna apenas com o nome exato do produto. Coloquei a nota correspondente!*/
    List<Produto> findByNome(String nome);
}
