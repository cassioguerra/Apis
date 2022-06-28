package com.example.Aplicacao_Recycle.repository;

import com.example.Aplicacao_Recycle.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, String> {
	@Query(value =  "select * from loja where cnpj = ?1 AND senha_loja = ?2", nativeQuery = true)
	EmpresaModel loginLoja(String cnpj, String senha);

	@Query(value = "select * from loja where nome_loja = ?1 ORDER BY RAND(cnpj) ", nativeQuery = true)
	List<EmpresaModel> buscarPorNome(String nome, String cnpj);
}
