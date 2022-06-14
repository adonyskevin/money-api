package com.example.money.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.money.api.model.Categoria;
import com.example.money.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Optional<Categoria> buscarPorCodigo(@PathVariable Long codigo) {
		return categoriaRepository.findById(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{codigo}").buildAndExpand(categoriaSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(categoriaSalva);
	}
}
