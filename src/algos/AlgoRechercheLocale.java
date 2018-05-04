package algos;

import donneesDuProbleme.Probleme;
import donneesDuProbleme.Solution;

import static algos.GenererVoisinnages.OSPermutation;

public class AlgoRechercheLocale {

    private Probleme probleme;

    public AlgoRechercheLocale(Probleme pb ) {
        this.probleme = pb;
    }

    public Solution rechercheLocaleParPermutationsSimples(Solution solutionInitiale) {

        Solution inter = solutionInitiale;
        Integer coutInter;
        int taille = solutionInitiale.getOperationSequence().size();
        System.out.println("Taille du OS : "+taille);
        boolean over = false;

        for (int ind1 = 0; ((ind1 < taille) && !over); ind1++) {
            for (int ind2 = 1; ((ind2 < taille) && !over); ind2++) {
                inter = OSPermutation(solutionInitiale, ind1, ind2);
                coutInter = inter.getCout();
                //inter.getGantt().afficherGantt();

                if (coutInter < solutionInitiale.getCout()) {
                    System.out.println("Nouveau meilleur coût trouvé : " + coutInter);
                    inter.afficherSolution();
                    over = true;
                }
            }

        }

        Solution solutionFinale = solutionInitiale;
        if (over) {
            solutionFinale = rechercheLocaleParPermutationsSimples(inter);
        } else {
            solutionFinale = solutionInitiale;
        }

        return solutionFinale;
    }

}
