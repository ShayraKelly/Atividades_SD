import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;

public class ClienteControle {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("26.231.8.119", 3019);
            IFuncoesControle controle = (IFuncoesControle) registry.lookup("TelevisaoObj");

            Scanner scan = new Scanner(System.in);
            int op = 0;
            do{
                System.out.println("================== CONTROLE ==================");
                System.out.println("1 - Power");
                System.out.println("2 - Aumenta Volume");
                System.out.println("3 - Diminui Volume");
                System.out.println("4 - Avanca Canal");
                System.out.println("5 - Volta Canal");
                System.out.println("0 - Sair");
                System.out.printf("Selecione a Opção : ");
                op = scan.nextInt();
                System.out.println("==============================================");

                switch (op) {
                    case 1:
                        controle.btnPower();
                        break;
                        
                    case 2:
                        controle.btnAumentaVolume();
                        break;
                    case 3:
                        controle.btnDiminuiVolume();
                        break;
                    case 4:
                        controle.btnAvancaCanal();
                        break;
                    case 5:
                        controle.btnVoltaCanal();
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;
                
                    default:
                        break;
                }
            }while(op != 0);
            scan.close();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e);
            e.printStackTrace();
        }
    }
}