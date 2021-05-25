package unidac.unidac.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unidac.unidac.cafe.model.*;

import unidac.unidac.cafe.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	// Metodo de consulta
	@GetMapping(path = "/api/usuario/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
		return repository.findById(codigo) // se achar no repositorio pelo código
				.map(record -> ResponseEntity.ok().body(record)) // monta o corpo da requisição com o registro
				.orElse(ResponseEntity.notFound().build()); // se não retorna notFound e faz build
	}
	
	// Metodo para salvar no banco
	@PostMapping(path = "/api/usuario/salvar")
	public Usuario salver(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

}
