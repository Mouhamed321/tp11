package bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
	private List<Integer> lancers;
	private int tourActuel;
	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		lancers = new ArrayList<>();
		tourActuel = 0;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon
	 * @throws IllegalStateException si la partie est terminée
	 */

	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (estTerminee()) {
			throw new IllegalStateException("La partie est déjà terminée.");
		}

		lancers.add(nombreDeQuillesAbattues);

		if (tourActuel < 9) {
			// Si ce n'est pas le dernier tour
			if (nombreDeQuillesAbattues == 10) {
				// Strike, le tour est terminé
				tourActuel++;
			} else {
				// Non-strike, le joueur doit lancer à nouveau si c'est le premier lancer du tour
				tourActuel = (lancers.size() % 2 == 0) ? tourActuel + 1 : tourActuel;
			}
		} else {
			// Dernier tour
			if (nombreDeQuillesAbattues == 10 || lancers.size() % 2 == 0) {
				// Strike ou spare, le joueur peut lancer à nouveau
			} else {
				// Le joueur a terminé le dernier tour
				tourActuel++;
			}
		}
		return false;
	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */

	public int score() {
		int score = 0;
		int tour = 0;

		for (int i = 0; i < 10; i++) {
			if (Strike(tour)) {
				score += 10 + bonusStrike(tour);
				tour++;
			} else if (estSpare(tour)) {
				score += 10 + bonusSpare(tour);
				tour += 2;
			} else {
				score += lancers.get(tour) + lancers.get(tour + 1);
				tour += 2;
			}
		}

		// Considère que les lancers restants abattent 0 quille
		int lancersRestants = lancers.size() % 2 == 0 ? 0 : 1; // 0 si pair, 1 si impair
		for (int i = 0; i < lancersRestants; i++) {
			score += 0;
		}

		return score;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		throw new UnsupportedOperationException("Pas encore implémenté");
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		throw new UnsupportedOperationException("Pas encore implémenté");
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		throw new UnsupportedOperationException("Pas encore implémenté");
	}

}
