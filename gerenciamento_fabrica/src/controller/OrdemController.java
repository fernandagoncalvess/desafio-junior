package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Ordem;

public class OrdemController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Ordem> ordens = new ArrayList<>();

		int opcao;

		do {
			while (true) {
				System.out.println("Menu:");
				System.out.println("1. Registrar nova ordem de produção");
				System.out.println("2. Listar ordens de produção");
				System.out.println("3. Verificar materiais");
				System.out.println("4. Atualizar status de uma ordem de produção");
				System.out.println("5. Inserir um material");
				System.out.println("6. Atualizar materiais");
				System.out.println("7. Visualizar relaórios de produção");
				System.out.println("6. Sair");
				System.out.println("Selecione uma opção:");

				opcao = sc.nextInt();
				sc.nextLine();

				switch (opcao) {
				case 1:
					System.out.println("Digite o id da ordem");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Nome do produto: ");
					String nomeProduto = sc.nextLine();

					System.out.println("Quantidade: ");
					int quantidade = sc.nextInt();
					sc.nextLine();
					System.out.println("Descrição do produto: ");
					String descricao = sc.nextLine();

					System.out.print("Data de entrega (dd/MM/yyyy): ");
					String dateInput = sc.nextLine();
					try {
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dataEntrega = LocalDate.parse(dateInput, fmt);
						boolean concluido = false;
						Ordem ordem = new Ordem(id, nomeProduto, quantidade, dataEntrega, descricao, concluido);
						ordens.add(ordem);

						System.out.println("Ordem de produção registrada com sucesso.");
					} catch (Exception e) {
						System.out.println("Formato de data inválido. A ordem de produção não foi registrada.");
					}
					break;
				case 2:
					if (ordens.isEmpty()) {
						System.out.println("Nenhuma ordem de produção registrada.");
					} else {
						System.out.println("Lista de Ordens de Produção:");
						for (Ordem item : ordens) {
							System.out.println("Nome: " + item.getNomeProduto());
							System.out.println("Descrição: " + item.getDescricao());
							System.out.println("Quantidade: " + item.getQuantidade());
							System.out.println("Data entrega: " + item.getDataEntrega());
						}
					}

					break;
				case 3:
					int resp;
					int quantidadeMaterial;
					String nomeMaterial;
					do {
						System.out.println("Digite o nome do material que o produto precisa:");
						nomeMaterial = sc.nextLine();
						System.out.println("Digite a quantidade do material que o produto precisa");
						quantidadeMaterial = sc.nextInt();
						sc.nextLine();
						System.out.println("Tem mais materiais? 1-sim 2-não");
						resp = sc.nextInt();
					} while (resp == 1);

					if (quantidadeMaterial > 60) {
						System.out.println("A produção não é possível devido a dalta de material");
					} else {
						System.out.println("Produção disponíveis, mateiral suficiente.");
					}

					break;
				case 4:

					System.out.println("Digite o id da ordem de produção que deseja atualizar o status: ");
					int idOrdem = sc.nextInt();
					if (ordens.isEmpty()) {
						System.out.println("Nenhuma ordem de produção registrada.");
					} else {
						for (Ordem item : ordens) {
							if (item.getId() == idOrdem) {
								System.out.println(item.isConcluido());
							} else {
								System.out.println("Valor inválido");
							}
						}
					}

					break;
				case 5:
					if (ordens.isEmpty()) {
						System.out.println("Nenhuma ordem de produção registrada.");
					} else {
						System.out.println("Lista de Ordens de Produção:");
						for (int i = 0; i < ordens.size(); i++) {
							System.out.println("Ordem " + (i + 1) + ": " + ordens.get(i));
						}
					}

					break;
				case 6:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida. Tente novamente");
				}

			}
		} while (opcao != 0);
	}

}
