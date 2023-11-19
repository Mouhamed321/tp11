package bowling;

public class Tour {

	private int numTour;
	private int nbQuTmbLancer1 = 0;
	private int nbQuTmbLancer2 = 0;
	private int nbQuTmbLancer3 = 0;
	private int numCoup = 1;
	boolean estFini = false;

	public Tour(int numTour){
		this.numTour = numTour;
	}

	public boolean estFini(){
		return estFini;
	}

	public boolean estStrike(){
		return nbQuTmbLancer1 == PartieMonoJoueur.Nbre_Quilles;
	}

	public boolean estSpare(){
		return numCoup == 2 && nbQuTmbLancer1 + nbQuTmbLancer2 == PartieMonoJoueur.Nbre_Quilles && numTour != PartieMonoJoueur.Nbre_Tours;
	}

	public void lancer(int valeur){
		switch (numCoup){
			case 1:
				nbQuTmbLancer1 += valeur;
				if (nbQuTmbLancer1 == PartieMonoJoueur.Nbre_Quilles && numTour != PartieMonoJoueur.Nbre_Tours) estFini = true;
				else if (nbQuTmbLancer1 == PartieMonoJoueur.Nbre_Quilles) numCoup += 1;
				else numCoup++;
				break;
			case 2:
				nbQuTmbLancer2 += valeur;
				estFini = true;
				if (numTour == PartieMonoJoueur.Nbre_Tours) {
					if (!(nbQuTmbLancer1 + nbQuTmbLancer2 < PartieMonoJoueur.Nbre_Quilles)){
						numCoup++;
						estFini = false;
					}
				}
				break;
			case 3:
				nbQuTmbLancer3 += valeur;
				estFini = true;
				break;
		}
	}

	public int getNbQuilleTombeesLancer1() {
		return nbQuTmbLancer1;
	}

	public int getNbQuilleTombeesLancer2() {
		return nbQuTmbLancer2;
	}

	public int getNbQuilleTombeesLancer3() {
		return nbQuTmbLancer3;
	}

	public int getNumCoup() {
		return numCoup;
	}
}