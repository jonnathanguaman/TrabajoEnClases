package paquete.trabajoClases.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import paquete.trabajoClases.Services.IUsuarioService;
import paquete.trabajoClases.model.Usuario;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario show(@PathVariable Long id){
		return usuarioService.findById(id);
	}
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioModificar = usuarioService.findById(id);

		usuarioModificar.setNombre(usuario.getNombre());
		usuarioModificar.setEmail(usuario.getEmail());
		usuarioModificar.setEstado(usuario.getEstado());

		return usuarioService.save(usuarioModificar);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
