package com.example.Aplicacao_Recycle.repository;

import com.example.Aplicacao_Recycle.model.AgendamentoModel;
import com.example.Aplicacao_Recycle.model.EmpresaModel;
import com.example.Aplicacao_Recycle.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, UUID> {

	@Query(value =  "select * from agendamento where loja_cnpj = ?1 AND usuario_cpf = ?2", nativeQuery = true)
	EmpresaModel loginEmpresa(String cnpj, String senha);

	@Query(value = "select * from agendamento where nome_loja = ?1 ORDER BY RAND(cnpj) ", nativeQuery = true)
	List<EmpresaModel> buscarPorNome(String nome, String cnpj);

	@Query(value = "select count(cnpj) from loja", nativeQuery = true)
	public EmpresaModel LojasCadastrados (String cnpj);
}
