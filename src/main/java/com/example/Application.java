package com.example;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.service.LivroService;

@SpringBootApplication

public class Application implements CommandLineRunner {

	private final LivroService livroService;

	private Boolean system = true;

	public Application(LivroService livroservice) {
		this.livroService = livroservice;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);

		while (system) {
			System.out.println("Qaul acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Nome do Livro");
			System.out.println("2 - para Excluir");
			System.out.println("3 - update");
			int action = leitor.nextInt();

			if (action == 1) {
				livroService.inicial(leitor);

			}

			if (action == 2) {

				livroService.exclusao(leitor);

			}

			if (action == 3) {

				livroService.upadate(leitor);
			}

			else {

				system = false;
			}
		}

	}

}
