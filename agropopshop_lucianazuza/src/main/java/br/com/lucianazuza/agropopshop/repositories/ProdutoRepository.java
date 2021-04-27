package br.com.lucianazuza.agropopshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucianazuza.agropopshop.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
