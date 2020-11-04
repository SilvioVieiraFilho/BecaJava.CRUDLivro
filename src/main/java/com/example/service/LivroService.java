package com.example.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;


import com.example.model.Livro;
import com.example.repository.LivroRepository;

@Service
public class LivroService {

	private final LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public void inicial(Scanner leitor) {
		salvar(leitor);
	}

	public void exclusao(Scanner leitor) {
		excluir(leitor);
	}

	public void upadate(Scanner leitor) {
		upar(leitor);
	}

	public void consulte(Scanner leitor) {
		consultar(leitor);
	}

	private void salvar(Scanner leitor) {
		System.out.println("Nome do Livro");

		String nome = leitor.next();
		Livro livro = new Livro();
		System.out.println("Escreva O numero de paginas");
		int npaginas = leitor.nextInt();

		livro.setNome(nome);
		livro.setnpaginas(npaginas);

		livroRepository.save(livro);

		System.out.println("Salvo");
	}

	private void excluir(Scanner leitor) {
		System.out.println("Nome do id");

		long id = leitor.nextLong();
		Livro clube = new Livro();

		clube.setId(id);

		livroRepository.delete(clube);

		System.out.println(" Livro Excluido" + "Nº" + id);

	}

	private void upar(Scanner leitor) {

		Livro livro = new Livro();

		System.out.println("Escreva O id");

		livro.setId(leitor.nextLong());

		livroRepository.findById(leitor.nextLong());

		System.out.println("Nome do Livro");

		String nome = leitor.next();
		System.out.println("Escreva O numero de paginas");
		int npaginas = leitor.nextInt();

		livro.setNome(nome);
		livro.setnpaginas(npaginas);

		livroRepository.save(livro);

		System.out.println("update");
	}

	public void consultar(Scanner leitor) {

		System.out.println("Escreva o Id");

		Livro livro1 = new Livro();

		livro1.setId(leitor.nextLong());

	

		Optional<Livro> livro = livroRepository.findById(leitor.nextLong());
		System.out.println("Nome do Livro: " + livro.get().getNome());

	}

}
