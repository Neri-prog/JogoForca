import java.util.Scanner;

public class JogoDaForca {
    private String palavraSecreta;
    private StringBuilder palavraAtual;
    private int tentativasRestantes;
    public JogoDaForca(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta.toLowerCase();
        this.palavraAtual = new StringBuilder("_".repeat(palavraSecreta.length()));
        this.tentativasRestantes = 10;
    }
    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0 && palavraAtual.indexOf("_") != -1) {
            System.out.println("Palavra atual: " + palavraAtual);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char tentativa = scanner.next().toLowerCase().charAt(0);

            if (palavraSecreta.contains(String.valueOf(tentativa))) {
                atualizarPalavraAtual(tentativa);
            } else {
                tentativasRestantes--;
                System.out.println("Letra incorreta. Tente novamente.");
            }
        }
        scanner.close();
        if (tentativasRestantes > 0) {
            System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
        } else {
            System.out.println("Game over. A palavra correta era: " + palavraSecreta);
        }
    }
    private void atualizarPalavraAtual(char letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraAtual.setCharAt(i, letra);
            }
        }
    }
    public static void main(String[] args) {
        JogoDaForca jogo = new JogoDaForca("Corinthians");
        jogo.jogar();
    }
}
