
package com.Mawe.ProjetoIntegrador.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Mawe.ProjetoIntegrador.DTO.UsuarioDTO;
import com.Mawe.ProjetoIntegrador.DTO.UsuarioLoginDTO;
import com.Mawe.ProjetoIntegrador.model.Categoria;
import com.Mawe.ProjetoIntegrador.model.Produto;
import com.Mawe.ProjetoIntegrador.model.Usuario;
import com.Mawe.ProjetoIntegrador.model.util.TipoUsuario;
import com.Mawe.ProjetoIntegrador.repository.CategoriaRepository;
import com.Mawe.ProjetoIntegrador.repository.ProdutoRepository;
import com.Mawe.ProjetoIntegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {

	/**
	 * Traz atributos da classe UsuarioRepository
	 */
	@Autowired
	private UsuarioRepository repository;
	
	/**
	 * Traz atributos da classe CategoriaRepository
	 */

	/**
	 * Traz atributos da classe ProdutoRepository
	 */
	

	/**
	 * Neste método, se um Usuario for existente, o retorno será vazio. 
	 Caso o contrário uma senha é codificada, criptografada e salva como um novo usuário
	 * 
	 * @nomeobjeto CadastrarUsuario()
	 * @param novoUuario
	 * @return
	 */
	public Optional<Object> CadastrarUsuario(Usuario novoUuario) {
		return repository.findByEmail(novoUuario.getEmail()).map(UsuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUuario.getSenha());
			novoUuario.setSenha(senhaCriptografada);
			return Optional.ofNullable(repository.save(novoUuario));
		});
	}
	
	/**
	 * Este método serve par alterar o usuario da classe UsuarioDTO
	 * 
	 * @nomeobjeto alterar()
	 * @param id
	 * @param novoUsuario
	 * @return
	 */
	public Optional<Usuario> alterar(Long id, UsuarioDTO novoUsuario) {
		return repository.findById(id).map(atualizarUsuario -> {
			atualizarUsuario.setNome(novoUsuario.getNome());
			atualizarUsuario.setSenha(novoUsuario.getSenha());
			return Optional.ofNullable(repository.save(atualizarUsuario));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	/**
	 * Este método é utilizado para logar um UsuarioLoginDTO
	 * 
	 * @nomeobjeto Logar()
	 * @param dadosLogin
	 * @return
	 */
	public Optional<?> Logar(UsuarioLoginDTO dadosLogin) {
		return repository.findByEmail(dadosLogin.getEmail()).map(UsuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(dadosLogin.getSenha(), UsuarioExistente.getSenha())) {
				String basic = dadosLogin.getEmail() + ":" + dadosLogin.getSenha();
				byte[] autorizacao = Base64.encodeBase64(basic.getBytes(Charset.forName("US-ASCII")));
				String autorizacaoHeader = "Basic " + new String(autorizacao);

				dadosLogin.setToken(autorizacaoHeader);
				dadosLogin.setId(UsuarioExistente.getId());
				dadosLogin.setNome(UsuarioExistente.getNome());
				dadosLogin.setSenha(UsuarioExistente.getSenha());
				dadosLogin.setTipoUsuario(UsuarioExistente.getTipoUsuario());

				return Optional.ofNullable(dadosLogin);
			} else {
				return Optional.empty();
			}

		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	
}
