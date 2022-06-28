package com.example.Aplicacao_Recycle.repository;

import com.example.Aplicacao_Recycle.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String>{
	@Query(value =  "select * from usuario where cpf = ?1 AND senha_usuario = ?2", nativeQuery = true)
	public UsuarioModel findByLoginAndSenha(String cpf, String senha);

	@Query(value = "select count(cpf) from usuario", nativeQuery = true)
	public UsuarioModel UsuarioCadastrados (String cpf);

	@Query(value =  "select * from usuario where email_usuario = ?1 AND  cpf = ?2", nativeQuery = true)
	public UsuarioModel EsqueceuSenha(String email, String cpf);

	@Query(value =  "select * from usuario where resposta_usuario = ?1 ", nativeQuery = true)
	public UsuarioModel RespostaChave(String resposta);

}
