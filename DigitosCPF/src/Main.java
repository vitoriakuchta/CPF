import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Didite os 9 primeiros numeros do seu CPF: ");
        String numerosCPF = scan.nextLine();
        boolean contemSomenteNumeros = numerosCPF.matches("[0-9]+"); // true
        contemSomenteNumeros = numerosCPF == "";
        if (contemSomenteNumeros == false)
            System.out.println("Precisa conter apenas numeros");
        if (numerosCPF == "")
        {
            Random gerador = new Random();
            long numeroAleatorio = gerador.nextLong(); // Gera um número aleatório long
            String numero = String.format("%09d", Math.abs(numeroAleatorio)).substring(0,9);
            numerosCPF = numero;
        }
        if(numerosCPF.length() == 9){
            int soma = 0;
            for (int i = 0; i < numerosCPF.length(); i++){
                int digito10 = Integer.parseInt(numerosCPF.substring(i,i+1)) * (i+1);
                soma += digito10;
            }
            int digito10 = soma%11;
            String cpf10 = numerosCPF + digito10;
            if(digito10 == 10)
                cpf10 = numerosCPF + 0;
            int soma2 = 0;
            for (int i = 1; i < cpf10.length(); i++){
                    int digito11 = Integer.parseInt(cpf10.substring(i,i+1)) * i;
                    soma2 += digito11;
            }
            int digito11 = soma2%11;
            String cpf11 = cpf10 + digito11;
            if(digito11 == 10)
                cpf11 = cpf10 + 0;
            System.out.println("O CPF é: " + cpf11.substring(0,3) + "." + cpf11.substring(3,6) + "." + cpf11.substring(6,9) + "-" + cpf11.substring(9,11));
        }
        else
            System.out.print("Valor invalido!");
    }
}