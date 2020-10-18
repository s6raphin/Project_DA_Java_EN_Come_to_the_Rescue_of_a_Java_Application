package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	// FIXME 1 : il y a 3 compteurs sp�cifiques pour 3 symptomes hors la liste des symptomes n'est pas fixes.
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {
		// first get input
		// FIXME 2 : le chemin du fichier n'est pas param�trable. Ceci pose un probl�me de flexibilit�.
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();
		// FIXME 3 : Le compteur i ne sert � rien. Pas utiliser apr�s dans la boucle.
		int i = 0; // set i to 0

		// FIXME 4 : d�claration d'une variable en doublon pour le m�me symptome cr�� en param�tre de classe.
		int headCount = 0; // counts headaches
		// FIXME 7 : traiment globale de la boucle qui pourrait �tre g�r�e par une m�thode.
		while (line != null) {
			i++; // increment i
			System.out.println("symptom from file: " + line);

			// FIXME 6 : m�me probl�me que le 1.
			if (line.equals("headache")) {
				headCount++;
				// FIXME 5 : sysout inutile de l'afficher dans la boucle.
				//FIXME 13 : m�me probl�me que sur le 4
				System.out.println("number of headaches: " + headCount);
			} else if (line.equals("rush")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}
		// FIXME 11 :pas de fermeture de la boucle.
		
		// FIXME 8 traitement global de l'ecriture qui peut �tre trait� pa rune m�thode.
		// FIXME 9 : le chemin du fichier n'est pas param�trable. Ceci pose un probl�me de flexibilit�.

		FileWriter writer = new FileWriter("result.out");
		
		// FIXME 10 : meme probl�me que le 1 conditionn� sur 3 symptomes.
		//FIXME 12 : probl�me li� au fixme4 et confusion sur headcount.
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
