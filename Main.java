
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



public class main {
    public static void main(String[] args) {
        
        List <Contato> contatos = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        var opcao = 0;

       do {
        ExibirMenu();
        System.out.println("Informe a opçao: ");
        opcao = sc.nextInt();
        System.out.println("Opçao escolhida "+opcao);

        System.out.println();

        switch (opcao) {
            case 1:
            exibirEmOrdemCadrasto(contatos);
                
                break;
    
            case 2:
            ConsultarContatos(contatos);
    
                break;
            
            case 3:
            ExcluirContatos();

                break;

            case 4:
            ExibirEmOrdemAlfabetica();

                break;

            case 5:
            CadrastarContatos(contatos, sc);

                break;
            
            case 0:
            System.out.println("Saindo...");
            System.out.println("Programa encerrado");

                break;
    
           
            default:
            System.out.println("Digite uma opçao valida !");
                break;
           }

       }while (opcao !=0);


    }


    public static void exibirEmOrdemCadrasto (List <Contato> contatos){
        if (contatos.isEmpty()){
            System.out.println("A lista está vazia !");
            System.out.println();
        }else {
            System.out.println("Contatos em ordem de cadrasto --->");
            for (Contato contato: contatos){
                System.out.println(contatos);

            }
        }

    }

    public static void ConsultarContatos(List <Contato> contatos){
        if (contatos.isEmpty()){
            System.out.println("A lista está vazia !");
            System.out.println();
        }else {
            System.out.println("Contatos regristrados");
            for (Contato contato : contatos){
                System.out.println(contato);


            }

        }

    }

    public static void ExcluirContatos (){

    }

    public static void ExibirEmOrdemAlfabetica (){

    }

    public static void CadrastarContatos(List <Contato> contatos , Scanner sc){
        System.out.println("Nome :");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.println("Endereço: ");
        sc.nextLine();
        String endereco = sc.nextLine();
        
        System.out.print("Numero: ");
        sc.nextLine();
        String telefone = sc.nextLine();

        Contato novContato = new Contato(nome, endereco, telefone);

        contatos.add(novContato);

        System.out.println("Contato cadrastado com sucesso ✅ ");


    }

    public static void ExibirMenu(){
        System.out.println("1-Exibição em ordem de cadastro: ");
        System.out.println("2-Consultar contatos: ");
        System.out.println("3-Exlcuir contatos: ");
        System.out.println("4-Exibição de contatos em ordem alfabética.: ");
        System.out.println("5-Cadrasto de contatos: ");
        System.out.println("0-Sair: ");

    }    

}
