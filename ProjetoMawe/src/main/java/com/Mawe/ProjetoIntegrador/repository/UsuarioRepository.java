
package com.Mawe.ProjetoIntegrador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mawe.ProjetoIntegrador.model.Usuario;
import com.Mawe.ProjetoIntegrador.model.util.TipoUsuario;

/**
 * Estabelecer comunicação com dados (MySQL)
 * 
 * Última atualização: julho de 2021
 * 
 * @author desenvolvedores Mawé
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	/**
	 * Pesquisar os parâmetros dos atributos, que contenha os caracteres informados
	 * na aplicação
	 * 
	 * @Método findByAllNomeContaining localiza os dados solicitados na tabela
	 * @param descricao
	 * @return atributos do Usuario Model, onde os caracteres correspondem com os parametros
	 *         do atributo nome
	 */
	List<Usuario>findAllByNomeContaining(String nome);
	
	/**
	 * Pesquisar os parâmetros dos atributos, que contenha os caracteres informados
	 * na aplicação
	 * 
	 * @Método findByAllEmailContaining localiza os dados solicitados na tabela
	 * @param descricao
	 * @return atributos do Usuario Model, onde os caracteres correspondem com os parametros
	 *         do atributo email
	 */
	List<Usuario>findAllByEmailContaining(String email);
	Optional<Usuario>findById(Long id);
	Optional<Usuario>findByEmail(String email);
	List<Usuario>findByTipoUsuario(TipoUsuario tipoUsuario);

}
