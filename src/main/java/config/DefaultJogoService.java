package config;

import java.util.Scanner;

public class DefaultJogoService implements JogoService {

	@Override
	public void jogo() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite uma palavra: ");
		String palavras = teclado.next();
		char[] traco = new char[palavras.length()];
		for (int i = 0; i < palavras.length(); i++) {
			traco[i] = '_';
		}

		System.out.println("Digite a quantidade de tentativas: ");

		int tentativas = Integer.parseInt(teclado.next());
		int tamPalavra = palavras.length();
		int contador = 0;
		String letrasDigitadas[] = new String[20];

		while (tentativas > 0) {
			int existePalavra = 0;

			System.out.println();
			for (int i = 0; i < palavras.length(); i++) {
				System.out.print(" " + traco[i] + " ");
			}
			System.out.println();

			System.out.println("Digite uma letra: ");

			char letra = teclado.next().charAt(0);
			
			if(!matchesOnlyText(String.valueOf(letra))) {			
				System.out.println("Somente letras é permitido!");
				 continue;
			
			}
			
			boolean iscorrect = false;

			letrasDigitadas[contador] = String.valueOf(letra);

			existePalavra = existePalavra(letrasDigitadas, existePalavra, letra);

			if (!(existePalavra > 1)) {
				for (int i = 0; i < traco.length; i++) {
					if (palavras.charAt(i) == letra) {

						System.out.println("Letra correta.");
						traco[i] = letra;
						tamPalavra--;
						iscorrect = true;
					}
				}

			} else {
				System.out.println("Essa letra já foi digitada." + "\r\n");
				tentativas--;

				System.out.println("Você ainda possui " + tentativas + " tentativas.");

			}

			if (!iscorrect && !(existePalavra > 1)) {
				tentativas--;

				System.out.println("Letra: " + letra + " inexistente" + " Você ainda possui " + tentativas + " tentativas.");						
			}
			contador++;
		}
		
		verificaPalavra(tamPalavra);
	}
	
	
	private  int existePalavra(String[] letrasDigitadas, int existePalavra, char letra) {
		for (int i = 0; i < letrasDigitadas.length; i++) {
			if (letrasDigitadas[i] != null) {
				if (letrasDigitadas[i].equals(String.valueOf(letra))) {
					existePalavra++;
				}
			}
		}
		return existePalavra;
	}

	private  void verificaPalavra(int tamPalavra) {
		if (tamPalavra == 0) {
			System.out.println("PARABENS!Você ACERTOU! :)");
		} else {
			System.out.println("Infelizmente Você Perdeu :(");
		}
	}
	
	public  boolean matchesOnlyText(String text) {
	    return text.matches("[^\\d]+");	    
	}


}
