package com.example.money.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.money.api.model.Pessoa;
import com.example.money.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizarPessoa(Long codigo, Pessoa pessoa){
		
		Pessoa pessoaSalva = buscarPorCodigo(codigo);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoa = buscarPorCodigo(codigo);
		
		pessoa.setAtivo(ativo);
		pessoaRepository.save(pessoa);
	}
	
	private Pessoa buscarPorCodigo(Long codigo) {
		Pessoa pessoa = !pessoaRepository.findById(codigo).isEmpty() 
				? pessoaRepository.findById(codigo).get() : null;
		
		if(pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa;
	}
}
