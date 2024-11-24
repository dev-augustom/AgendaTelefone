import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Augusto e Luiz henrique



public class Main {
    public static void main(String[] args) throws InterruptedException {
        
    	   System.out.println("╔══════════════════════════════════════════╗");
           System.out.println("║                                          ║");
           System.out.println("║   █████╗  ██████╗ ███████╗███╗   ██╗     ║");
           System.out.println("║  ██╔══██╗██╔════╝ ██╔════╝████╗  ██║     ║");
           System.out.println("║  ███████║██║  ███╗█████╗  ██╔██╗ ██║     ║");
           System.out.println("║  ██╔══██║██║   ██║██╔══╝  ██║╚██╗██║     ║");
           System.out.println("║  ██║  ██║╚██████╔╝███████╗██║ ╚████║     ║");
           System.out.println("║  ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝     ║");
           System.out.println("║                                          ║");
           System.out.println("║   	 📞  A G E N D A  T E L E F Ô N I C A ║");
           System.out.println("║                                          ║");
           System.out.println("╚══════════════════════════════════════════╝");
    	
        List <Contato> contatos = new ArrayList<>();
       
        Scanner sc = new Scanner(System.in);

        var opcao = "0";

       do {
        ExibirMenu();
        System.out.print("Informe a opção: ");
        opcao = sc.nextLine();
        
        
        System.out.println("\nOpção escolhida " + opcao);
        System.out.println();

        switch (opcao) {
            case "1":
            exibirEmOrdemCadrasto(contatos);
                
                break;
    
            case "2":
            ConsultarContatos(contatos, sc);
    
                break;
            
            case "3":
            ExcluirContatos(contatos, sc);

                break;

            case "4":
            ExibirEmOrdemAlfabetica(contatos);

                break;

            case "5":
            CadrastarContatos(contatos, sc);
            
            	break;
            
            case "6":
            EditarContato(contatos, sc);

                break;
            
            case "0":
            System.out.println("Saindo...");
            Thread.sleep(2000);
            System.out.println("Programa encerrado");

                break;
    
           
            default:
            System.out.println("Digite uma opção válida !");
                break;
           }

       }while (!opcao.equals("0"));


    }


    


	public static void exibirEmOrdemCadrasto (List <Contato> contatos){
        if (contatos.isEmpty()){
            System.out.println("A lista está vazia !");
            System.out.println();
        }else {
            System.out.println("Contatos em ordem de cadrasto --->\n");
            for (Contato contato: contatos){
                System.out.println(contato);

            }
        }

    }

    public static void ConsultarContatos(List <Contato> contatos, Scanner sc){
    	
    	 if (contatos.isEmpty()) {
             System.out.println("A lista está vazia!.");
             return;
         }
    	 
    	 System.out.println("Digite o ID do contato que deseja pesquisae:");
         int id = sc.nextInt();
         sc.nextLine();
         
         
         Contato contatoParaPesquisar = null;
         

         for (Contato contato : contatos) {
             if (contato.getId() == id) {
            	 contatoParaPesquisar = contato;
                 break;
             } }
             
         if (contatoParaPesquisar != null) {
        	 System.out.println("\nContato econtrado");
             
             System.out.println(contatoParaPesquisar);
         } else {
             System.out.println("Contato com ID " + id + " não encontrado.");
         }
     }


    	 
    	
       
    

    
    public static void ExcluirContatos(List<Contato> contatos, Scanner sc) {
        if (contatos.isEmpty()) {
            System.out.println("A lista está vazia! Não há contatos para excluir.");
            return;
        }

        System.out.println("Digite o ID do contato que deseja excluir:");
        int id = sc.nextInt();
        sc.nextLine();

        Contato contatoParaRemover = null;

        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                contatoParaRemover = contato;
                break;
            }
        }

        if (contatoParaRemover != null) {
            contatos.remove(contatoParaRemover);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato com ID " + id + " não encontrado.");
        }
    }

    
    public static void ExibirEmOrdemAlfabetica(List<Contato> contatos) {
        if (contatos.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        
        List<Contato> contatosOrdenados = new ArrayList<>(contatos);

        contatosOrdenados.sort(Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Contatos em ordem alfabética:");
        for (Contato contato : contatosOrdenados) {
            System.out.println(contato);
        }
    }

    
    public static void CadrastarContatos(List <Contato> contatos , Scanner sc){
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        
        
        System.out.print("Número: ");
        String telefone = sc.nextLine();

        Contato novoContato = new Contato(nome, endereco, telefone);

        contatos.add(novoContato);

        System.out.println("\nContato cadrastado com sucesso ✅ ");


    }
    
    private static void EditarContato(List <Contato> contatos , Scanner sc) {
		// TODO Auto-generated method stub
    	
    	
    	if (contatos.isEmpty()) {
            System.out.println("A lista está vazia! Não há contatos para editar.");
            return;
        }
    	
    	System.out.println("Digite o ID: ");
    	int id = sc.nextInt();
    	sc.nextLine();
    	
    	 Contato contatoPraEditar = null;

         for (Contato contato : contatos) {
             if (contato.getId() == id) {
            	 contatoPraEditar = contato;
                 break;
             }
         } if (contatoPraEditar != null) {
            
             System.out.println("Contato encontrado digite os novos dados!");
             
             System.out.println("DIgite o novo nome: ");
             String novoNome = sc.nextLine();
             
             System.out.println("DIgite o novo endereço: ");
             String novoEndereco = sc.nextLine();
             
             System.out.println("DIgite o novo telefone: ");
             String novoTelefone = sc.nextLine();
             
             contatoPraEditar.setNome(novoNome);
             contatoPraEditar.setEndereco(novoEndereco);
             contatoPraEditar.setTelefone(novoTelefone);
             
             System.out.println("Contato editado com sucesso!");

            
             
         } else {
             System.out.println("Contato com ID " + id + " não encontrado.");
         }
    	
    	
    	
		
	}

    public static void ExibirMenu(){
    	System.out.println("\n-= Lista Telefônica =- ");
        System.out.println("\n1-Exibição em ordem de cadastro: ");
        System.out.println("2-Consultar contatos: ");
        System.out.println("3-Excluir contatos: ");
        System.out.println("4-Exibição de contatos em ordem alfabética.: ");
        System.out.println("5-Cadrasto de contatos: ");
        System.out.println("6-Editar contato: ");
        
        System.out.println("0-Sair: \n");

    } 
    
}
