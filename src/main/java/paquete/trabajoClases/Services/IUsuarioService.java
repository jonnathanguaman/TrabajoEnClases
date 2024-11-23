package paquete.trabajoClases.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import paquete.trabajoClases.model.Usuario;

@Service
public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);
}
