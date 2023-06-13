import extensions.CSVFile;
import extensions.File;

class MathematicsTraveler extends Program {


    void algorithm() {

        afficherTitre();
        println("Menu principal :\nCréer un profil (1).\nCharger un profil (2).\nSupprimer un profil (3).\nQuitter (4).");

        String choixMenu = readString();
        while (!equals(choixMenu, "1") && !equals(choixMenu, "2") && !equals(choixMenu, "3") && !equals(choixMenu, "4")) {
            println("Choix invalide. Veuillez rentrer 1, 2, 3 ou 4.");
            choixMenu = readString();
        }

        while(!equals(choixMenu,"4")){

            if (equals(choixMenu, "1")) {
                Joueur j;
                j = creerProfil();

            } else if (equals(choixMenu, "2")){

                Joueur j = loadJoueur();

                choixNiveau(j);

            } else if (equals(choixMenu, "3")) {
                supprimerProfil();
            }

            println("Menu:\nCréer un profil (1).\nCharger un profil (2).\nSupprimer un profil (3).\nQuitter (4).");
            choixMenu = readString();
        }
    }


    /////////////////////////////////////////////////////
    // FONCTIONS EXECUTANT LES ATTAQUES INTERACTIVES
    /////////////////////////////////////////////////////
    

    // Vérifie que le contenu de la chaine de caractère passée en paramètre ne contient que des chiffres, renvoie un booléen.
    boolean estEntier(String chaine){
        int i = 0;
        boolean nombre = true;
        if(length(chaine)==0){
            return false;
        }
        while(i<length(chaine) && nombre){
            char c = charAt(chaine,i);
            if(c<'0'|| c>'9'){
                nombre=false;
            }
            i++;
        }
        return nombre;
    }

    // Demande à l'utilisateur de répondre à deux calculs soustractifs, renvoie un booléen en fonction de la réussite des calculs.
    boolean soustractionsDefensive(){
        for(int i=0;i<2;i++){
            int x=(int) (random()*800)+100;
            int y=(int) (random()*60)+20;
            println(x +" - " + y +" = ?");
            String reponse=readString();
            while(!estEntier(reponse) || length(reponse)>=4) {
                println("Veuillez rentrer un nombre à trois chiffres ou moins.");
                reponse=readString();
            }
            int rep = stringToInt(reponse);
            if(x-y != rep){
                println("\nDommage! C'est un échec.");
                return false;
            }
            if(i==0){
                println("\nPassons au calcul suivant.");
            }
            if(i==1){
                println("\nBravo, votre défense est une réussite!");
            }
        }
        return true;
    }

    // Demande à l'utilisateur de répondre à trois calculs additionnels, renvoie un booléen en fonction de la réussite des calculs.
    boolean attaqueAdditionnelle(){
        for(int i=0;i<2;i++){
            int x=(int) (random()*20)+40;
            int y=(int) (random()*20)+10;
            println(x +" + " + y +" = ?");
            String reponse=readString();
            while(!estEntier(reponse) || length(reponse)>=3) {
                println("Veuillez rentrer un nombre à deux chiffres ou moins.");
                reponse=readString();
            }
            int rep = stringToInt(reponse);
            if(x+y != rep){
                println("\nDommage! C'est un échec.");
                return false;
            }
            if(i==0){
                println("\nPassons au calcul suivant.");
            }
            if(i==1){
                println("\nBravo, votre attaque est une réussite!");
            }
        }
        return true;
    }
    
    // Demande à l'utilisateur de répondre à trois calculs multiplicatifs, renvoie le nombre de calculs réussis.
    int multiplicationMultiple () {

        int nbAttaque = 0;

        for(int i=0;i<3;i=i+1) {
            int x = (int) (random()*8) +2;
            int y = (int)(random()*8) +2;

            println(x + " * " + y +" = ?");
            String reponse = readString();
            while (!estEntier(reponse) || length(reponse)>=3) {
                println("Veuillez rentrer un nombre à deux chiffres ou moins.");
                reponse = readString();
            }
            int rep = stringToInt(reponse);
            if (x*y == rep) {
                nbAttaque=nbAttaque+1;
            }

        }

        return nbAttaque;
    }

    // Demande à l'utilisateur de répondre à trois calculs divisifs, renvoie un booléen en fonction de la réussite des calculs.
    boolean divisions(){

        for(int i=0;i<2;i++){

            int x=(int) (random()*88)+8;
            int y=(int) (random()*20)+3;
            while (x%y!=0) {
                x=(int) (random()*88)+8;
                y=(int) (random()*20)+3;
            }
            println(x + " / " + y + " = ?");

            String reponse=readString();
            while (!estEntier(reponse) || length(reponse)>=3) {
                println("Veuillez rentrer un nombre à deux chiffres ou moins.");
                reponse=readString();
            }
            int rep = stringToInt(reponse);

            if(x/y != rep){
                println("\nDommage! C'est un échec.");
                return false;
            }
            if(i==0){
                println("\nPassons au calcul suivant.");
            }
            if(i==1){
                println("\nBravo, votre attaque est une réussite!");
            }
        }
        return true;
    }

    // Demande à l'utilisateur de répondre à tout type de calculs, renvoie un booléen en fonction de la réussite des calculs.
    boolean allIn(){
        for(int i=0;i<4;i++){
            if(i == 0){
                int x=(int) (random()*800)+100;
                int y=(int) (random()*60)+20;
                println(x + " - " + y + " = ?");
                String reponse = readString();
                while(!estEntier(reponse) || length(reponse)>=4) {
                    println("Veuillez rentrer un nombre à trois chiffres ou moins.");
                    reponse = readString();
                }
                int rep = stringToInt(reponse);
                if (x-y != rep) {
                    return false;
                }else{
                    println("\nBravo, votre calcul est une réussite!");
                    println("\nPassons au calcul suivant.");
                }
            }
            if(i == 1){
                int x=(int) (random()*20)+40;
                int y=(int) (random()*20)+10;
                println(x + " + " + y + " = ?");
                String reponse = readString();
                while(!estEntier(reponse) || length(reponse)>=3) {
                    println("Veuillez rentrer un nombre à deux chiffres ou moins.");
                    reponse=readString();
                }
                int rep = stringToInt(reponse);
                if (x+y != rep) {
                    return false;
                }else{
                    println("\nBravo, votre calcul est une réussite!");
                    println("\nPassons au calcul suivant.");
                }
            }
            if(i == 2){
                int x = (int) (random()*8) +2;
                int y = (int)(random()*8) +2;

                println(x + " * " + y +" = ?");
                String reponse = readString();
                while (!estEntier(reponse) || length(reponse)>=3) {
                    println("Veuillez rentrer un nombre à deux chiffres ou moins.");
                    reponse = readString();
                }
                int rep = stringToInt(reponse);
                if (x*y != rep) {
                    return false;
                }else{
                    println("\nBravo, votre calcul est une réussite!");
                    println("\nPassons au calcul suivant.");
                }
            }
            if(i == 3){
                int x=(int) (random()*88)+8;
                int y=(int) (random()*20)+3;
                while (x%y!=0) {
                    x=(int) (random()*88)+8;
                    y=(int) (random()*20)+3;
                }
                println(x + " / " + y + " = ?");

                String reponse=readString();
                while (!estEntier(reponse) || length(reponse)>=3) {
                    println("Veuillez rentrer un nombre à deux chiffres ou moins.");
                    reponse=readString();
                }
                int rep = stringToInt(reponse);
                if (x/y != rep) {
                    return false;
                }else{
                    println("\nBravo, votre attaque est une réussite!");
                }
            }
        }
        return true;
    }


    //////////////////////////////////////////////////////////
    // FONCTIONS EXECUTANT LES MECANIQUES DES COMBATS
    //////////////////////////////////////////////////////////


    void afficherTitre() {
        File titre= newFile("../ressources/img/MathematicsTraveler.txt");
        while(ready(titre)){
            println(readLine(titre));
        }
    }

    void afficherPersonnages(String nomEnnemi){
        File imgEnnemi = newFile("../ressources/img/" + nomEnnemi + ".txt");
        File imgJoueur = newFile("../ressources/img/Joueur.txt");
        while(ready(imgJoueur)){
            println(readLine(imgJoueur) + "     " + readLine(imgEnnemi));
        }
    }

    // Lors d'un combat, affiche les différentes informations nécessaires telles que le tour, les points de vie, les intentions de l'ennemi..
    void afficherInterface(int pvJ, int pvE, int tour, Ennemi e, Competence[] competences) {

        println("Tour : " + tour);
        print("PV Joueur : ");
        for (int i=0; i<pvJ; i++) {
            print("\u001b[31m♥ \u001b[0m");
        }
        for (int i=0; i<43-2*pvJ; i++) {
            print(" ");
        }
        print("PV "+ e.nom + " : ");
        for (int i=0; i<pvE; i++) {
            print("\u001b[31m♥ \u001b[0m");
        }
        
        println();
        afficherPersonnages(e.nom);
        println();

        if(e.frequenceAttaqueForte != 0) {
            if(tour%e.frequenceAttaqueForte == 0) {
                println("L'ennemi se prépare à faire une attaque dévastatrice !");
                println();
            }
        }

        for (int i=0; i<length(competences); i++) {
            if (competences[i].tpsAvantUtilisation != 0) {
                print("( " + (i+1) + " - " + competences[i].nom + " ) Temps avant utilisation : " + competences[i].tpsAvantUtilisation + " tour(s).\n");
            } else  {
                print((i+1) + " - " + competences[i].nom + "\n");
            }
            
        }
        println();
    }

    // Execute l'attaque demandée, renvoie un positif correpondant aux dégats du joueur, ou -1 pour une attaque ennemie, ou 0 pour une défense parfaite ne causant aucun dégats.
    int lancerAttaque(int choix){
        if (choix==1) {
            boolean resultat=soustractionsDefensive();
            if (resultat) {
                return 0;
            } else {
                return -1;
            }
        } else if (choix==2){
            boolean resultat=attaqueAdditionnelle();
            if (resultat) {
                return 1;
            } else {
                return -1;
            }
        }else if(choix==3){
            int resultat =multiplicationMultiple();
            if(resultat==0){
                return -1;
            }else{
                return resultat;
            }
        }else if(choix==4){
            boolean resultat = divisions();
            if (resultat) {
                return 2;
            } else {
                return -1;
            }
        }else{
            boolean resultat = allIn();
            if (resultat) {
                return 5;
            } else {
                return -1;
            }
        }
    }

    // Lors d'un combat, met à jour les points de vie du joueur et de l'ennemi.
    int miseAJourPv(int[] pvs, int attaque, Ennemi e, int tour) {
        if (attaque>0) {
            pvs[1] = pvs[1] - attaque;
            if(e.frequenceAttaqueForte != 0) {
                if(tour%e.frequenceAttaqueForte == 0) {
                    pvs[0] = pvs[0] - e.force;
                    return 100+attaque;
                }
            }
            return attaque;
        } else if (attaque<0) {
            if(e.frequenceAttaqueForte != 0) {
                if(tour%e.frequenceAttaqueForte == 0) {
                    pvs[0] = pvs[0] - e.force*2;
                    return -e.force*2;
                } else {
                    pvs[0] = pvs[0] - e.force;
                    return -e.force;
                }
            } else {
                pvs[0] = pvs[0] - e.force;
                return -e.force;
            }
        }
        return 0;
    }

    // Lance un combat tour par tour jusqu'à ce que le joueur ou l'ennemi soit battu. Renvoie un booléen en fonction de la réussite du joueur.
    boolean lancerCombat(Joueur j, Ennemi e) {

        int pvJ = j.pvMax;
        int pvE = e.pvMax;
        int[] pvs = new int[]{pvJ,pvE};

        Competence[] competences = initialiserCompetences(j.competenceDebloquee);

        int tour = 1;
        while(pvs[0] > 0 && pvs[1] > 0) {
            afficherInterface(pvs[0], pvs[1], tour, e, competences);
            String choix = readString();
            while (!estEntier(choix) || length(choix)!=1 || stringToInt(choix)<=0 || stringToInt(choix)>nbCompetencesDebloquees(j.competenceDebloquee) || competences[stringToInt(choix)-1].tpsAvantUtilisation !=0) {
                println("Veuillez rentrer un chiffre correct.");
                choix = readString();
            }
            int choixChiffre = stringToInt(choix);
            competences[choixChiffre-1].tpsAvantUtilisation = competences[choixChiffre-1].cooldown+1;
            int attaque = lancerAttaque(choixChiffre);

            int resultat = miseAJourPv(pvs, attaque, e, tour);
            tour++;

            for (int i=0; i<length(competences); i++) {
                if (competences[i].tpsAvantUtilisation>0) {
                    competences[i].tpsAvantUtilisation = competences[i].tpsAvantUtilisation-1;
                }
            }
            
            // Permet d'effacer ce que la console a affiché jusque là et remonte en haut de l'écran les prochains affichages.
            print("\033[H\033[2J");
            
            if (resultat == 0) {
                println("Tout le monde reste sain et sauf pour ce tour !");
            } else if (resultat>100) {
                // Si le résultat vaut plus de 100, cela veut dire que le joueur à infligé résultat-100 dégâts mais que l'ennemi à frapper également.
                println("Tu as infligé " + (resultat-100) + " points de dégâts à l'ennemi mais celui-ci t'as également infligé " + e.force + " points de dégâts...");
            } else if (resultat>0) {
                println("Tu as infligé " + resultat + " points de dégâts à l'ennemi !");
            } else {
                println("L'ennemi vient de t'infliger " + abs(resultat) + " points de dégâts !");
            }
        }
        if(pvs[1] <= 0 && pvs[0] > 0){
            return true;
        }
        return false;
    }

    // Renvoie un entier correspondant au nombre de compétences que le joueur actif a débloqué jusqu'ici.
    int nbCompetencesDebloquees(boolean[] competenceDebloquee){
        int nbcomp=0;
        for (int i=0; i<length(competenceDebloquee); i++) {
            if (competenceDebloquee[i]) {
                nbcomp++;
            }
        }
        return nbcomp;
    }

    // Initialise un tableau de compétence pour le joueur en début de combat, avec le temps de recharge de chaque attaque à zéro.
    Competence[] initialiserCompetences (boolean[] competenceDebloquee) {
        Competence[] competences = new Competence[nbCompetencesDebloquees(competenceDebloquee)];

        CSVFile compCSV = loadCSV("../ressources/CSV/competences.csv");

        for (int i=0; i<length(competences); i++) {
            String nom = getCell(compCSV, i+1, 0);
            int puissance = stringToInt(getCell(compCSV, i+1, 1));
            int cooldown = stringToInt(getCell(compCSV, i+1, 2));
            int tpsAvantUtilisation = stringToInt(getCell(compCSV, i+1, 3));
            Competence currentCompetence = newCompetence(nom, puissance, cooldown, tpsAvantUtilisation);
            competences[i] = currentCompetence;
        }

        return competences;
    }

    // Permet au joueur de sélectionner le niveau de difficulté de sa partie, parmi celles que ce dernier a déloqué. Renvoie le choix du joueur sous forme d'un entier.
    String choixNiveau(boolean[] completionNiveaux) {
        println("À quel niveau souhaitez vous jouer ?");

        println("Facile (1)");

        if (completionNiveaux[0]) {
            println("Moyen (2)");
        } else {
            println("( Moyen (2) ) Bloqué.");
        }

        if (completionNiveaux[1]) {
            println("Difficile (3)");
        } else {
            println("( Difficile (3) ) Bloqué.");
        }

        println("Pour revenir au menu, entrez 4.");

        String choixNiveau = readString();
        while (!equals(choixNiveau, "1") && !equals(choixNiveau, "2") && !equals(choixNiveau, "3") && !equals(choixNiveau, "4") ||((!completionNiveaux[0] && equals(choixNiveau, "2")) || (!completionNiveaux[1] && equals(choixNiveau, "3")))) {
            if ((!completionNiveaux[0] && equals(choixNiveau, "2")) || (!completionNiveaux[1] && equals(choixNiveau, "3"))) {
                println("Ce niveau est bloqué, veuillez réussir le niveau précédent d'abord.");
            } else {
                println("Choix invalide, veuillez rentrer 1, 2 ou 3.");
            }
            choixNiveau = readString();
        }

        return choixNiveau;
    }

    // Lance un des trois modes de jeu et réagis en fonction de la réussite ou non du joueur.
    void choixNiveau(Joueur j) {
        String choixNiveau = choixNiveau(j.completionNiveaux);
        if (equals(choixNiveau,"1")) {

            boolean resultat = modeFacile(j);
            if (resultat) {
                println("Bravo ! Vous avez réussi le mode facile !");
                if (!j.completionNiveaux[0]) {
                    miseAJourProfil(j);
                }
            } else {
                playSound("../ressources/sound/lose.wav");
                print("\033[H\033[2J");
                println("Dommage, vous avez perdu.");
            }

        } else if(equals(choixNiveau,"2")) {
            boolean resultat = modeMoyen(j);
            if (resultat) {
                println("Bravo ! Vous avez réussi le mode moyen !");
                if (!j.completionNiveaux[1]) {
                    miseAJourProfil(j);
                }
            } else {
                playSound("../ressources/sound/lose.wav");
                print("\033[H\033[2J");
                println("Dommage, vous avez perdu.");
            }
        } else if(equals(choixNiveau,"3")) {
            boolean resultat = modeDifficile(j);
            if (resultat) {
                println("Bravo ! Vous avez réussi le mode difficile !");
                if (!j.completionNiveaux[0]) {
                    miseAJourProfil(j);
                }
            } else {
                playSound("../ressources/sound/lose.wav");
                print("\033[H\033[2J");
                println("Dommage, vous avez perdu.");
            }
        } else {
            println("Vous allez revenir au menu.");
        }
    }

    // Les trois fonctions suivantes lancent une suite de trois combats tant que le joueur réussit à progresser. On peut ici modifier à notre guise les ennemis rencontrés dans chaque niveau. Renvoie un booléen en fonction de la réussite du joueur.
    boolean modeFacile (Joueur j){
        println("Le premier combat va commencer !");
        Ennemi e = loadEnnemi("Slime");
        boolean resultat1 = lancerCombat(j, e);
        if (resultat1) {
            playSound("../ressources/sound/win.wav");
            print("\033[H\033[2J");
            println("Le second combat va commencer !");
            e = loadEnnemi("Vampivol");
            boolean resultat2 = lancerCombat(j, e);
            if (resultat2) {
                playSound("../ressources/sound/win.wav");
                print("\033[H\033[2J");
                println("Le dernier combat va commencer !");
                e = loadEnnemi("Concombrageur");
                boolean resultat3 = lancerCombat(j, e);
                if(resultat3){
                    playSound("../ressources/sound/win.wav");
                    print("\033[H\033[2J");
                    return true;
                }
            }
        }                   
        return false;
    }

    boolean modeMoyen (Joueur j){
        println("Le premier combat va commencer !");
        Ennemi e = loadEnnemi("Diablotin");
        boolean resultat1 = lancerCombat(j, e);
        if (resultat1) {
            playSound("../ressources/sound/win.wav");
            print("\033[H\033[2J");
            println("Le second combat va commencer !");
            e = loadEnnemi("Marteleur");
            boolean resultat2 = lancerCombat(j, e);
            if (resultat2) {
                playSound("../ressources/sound/win.wav");
                print("\033[H\033[2J");
                println("Le dernier combat va commencer !");
                e = loadEnnemi("Golem");
                boolean resultat3 = lancerCombat(j, e);
                if(resultat3){
                    playSound("../ressources/sound/win.wav");
                    print("\033[H\033[2J");
                    return true;
                }
            }
        }                   
        return false;
    }

    boolean modeDifficile (Joueur j){
        println("Le premier combat va commencer !");
        Ennemi e = loadEnnemi("Marteleur");
        boolean resultat1 = lancerCombat(j, e);
        if (resultat1) {
            playSound("../ressources/sound/win.wav");
            print("\033[H\033[2J");
            println("Le second combat va commencer !");
            e = loadEnnemi("Chimère");
            boolean resultat2 = lancerCombat(j, e);
            if (resultat2) {
                playSound("../ressources/sound/win.wav");
                print("\033[H\033[2J");
                println("Le dernier combat va commencer !");
                e = loadEnnemi("Dragon");
                boolean resultat3 = lancerCombat(j, e);
                if(resultat3){
                    playSound("../ressources/sound/win.wav");
                    print("\033[H\033[2J");
                    return true;
                }
            }
        }                   
        return false;
    }


    ////////////////////////////////////////////////////////////////////////
    // INITIALISATION DE VARIABLES POUR LES TYPES QUE NOUS AVONS CREE
    ////////////////////////////////////////////////////////////////////////


    Joueur newJoueur(String nom, int pvMax, boolean[] completionNiveaux, boolean[] competenceDebloquee) {
        Joueur j = new Joueur();
        j.nom = nom;
        j.pvMax = pvMax;
        j.completionNiveaux = completionNiveaux;
        j.competenceDebloquee = competenceDebloquee;
        return j;
    }

    Ennemi newEnnemi(String nom, int pvMax, int force, int frequenceAttaqueForte) {
        Ennemi e = new Ennemi();
        e.nom = nom;
        e.pvMax = pvMax;
        e.force = force;
        e.frequenceAttaqueForte = frequenceAttaqueForte;
        return e;
    }

    Competence newCompetence(String nom, int puissance, int cooldown, int tpsAvantUtilisation) {
        Competence e = new Competence();
        e.nom = nom;
        e.puissance = puissance;
        e.cooldown = cooldown;
        e.tpsAvantUtilisation = tpsAvantUtilisation;
        return e;
    }


    //////////////////////////////////////////////////////////////////////////////////////
    // FONCTIONS SERVANT A CHARGER DES PROFILS OU DES ENNEMIS DEPUIS DES FICHIERS CSV
    //////////////////////////////////////////////////////////////////////////////////////


    // Charge la liste des profils de joueurs présent dans le fichier CSV demandé. Permet également de rajouter une case au besoin pour créer un nouveau profil.
    Joueur[] loadListeJoueurs(String nomFichier, int casesSuppl) {
        CSVFile joueurs = loadCSV(nomFichier);
        Joueur[] joueurList = new Joueur[rowCount(joueurs) + casesSuppl - 1];
        for (int i=1; i<rowCount(joueurs); i++) {
            String nom = getCell(joueurs, i, 0);
            int pvMax = stringToInt(getCell(joueurs, i, 1));
            boolean[] completionNiveaux = new boolean[3];
            for (int j=0; j<length(completionNiveaux); j++) {
                //Boolean.parseBoolean extrait la valeur booléenne d'un String en fonction de s'il vaut "true" ou non (ignore la casse).
                completionNiveaux[j] = Boolean.parseBoolean(getCell(joueurs, i, 2+j));
            }
            boolean[] competenceDebloquee = new boolean[5];
            for (int j=0; j<length(competenceDebloquee); j++) {
                competenceDebloquee[j] = Boolean.parseBoolean(getCell(joueurs, i, 5+j));
            }
            Joueur currentJoueur = newJoueur(nom, pvMax, completionNiveaux, competenceDebloquee);
            joueurList[i-1] = currentJoueur;
        }
        return joueurList;
    }

    // Charge une variable de type Joueur en cherchant par le nom rentré par l'utilisateur dans la liste existante dans le CSV.
    Joueur loadJoueur() {

        Joueur[] listeJoueurs = loadListeJoueurs("../ressources/CSV/joueurs.csv", 0);

        println("Liste des profils existants :");
        String[] profils = new String[length(listeJoueurs)];
        for (int i=0; i<length(listeJoueurs); i++) {
            profils[i] = listeJoueurs[i].nom;
            println(listeJoueurs[i].nom);
        }

        println("Veuillez rentrer votre nom de profil.");
        String nom = readString();
        while (numeroProfil(nom, profils) == -1) {
            println("Ce nom n'est pas présent dans les profils existants. Veuillez réessayer.");
            nom = readString();
        }
        return listeJoueurs[numeroProfil(nom, profils)];
    }

    // Trouve l'indice d'un profil dans une liste en recherchant par son nom, s'il n'est pas trouvé renvoie -1.
    int numeroProfil(String nom, String[] profils) {
        for (int i=0; i<length(profils); i++) {
            if (equals(nom, profils[i])) {
                return i;
            }
        }
        return -1;
    }

    // Fonction ajoutant un profil à la base de données des joueurs. Remplace le CSV précédent par un nouveau.
    Joueur creerProfil() {
        
        Joueur[] listeJoueurs = loadListeJoueurs("../ressources/CSV/joueurs.csv", 1);

        println("Liste des profils déjà existants :");
        String[] profils = new String[length(listeJoueurs)];
        for (int i=0; i<length(listeJoueurs)-1; i++) {
            profils[i] = listeJoueurs[i].nom;
            println(listeJoueurs[i].nom);
        }

        println("Veuillez rentrer votre nom de profil.");
        String nom = readString();
        while (numeroProfil(nom, profils) != -1) {
            println("Ce nom est déjà présent dans les profils existants. Veuillez entrer un autre nom.");
            nom = readString();
        }

        boolean[] completionNiveaux = new boolean[]{false, false, false};
        boolean[] competenceDebloquee = new boolean[]{true, true, true, false, false};
        Joueur nouveauProfil = newJoueur(nom, 3, completionNiveaux, competenceDebloquee);

        listeJoueurs[length(listeJoueurs)-1] = nouveauProfil;

        CSVFile joueurs = loadCSV("../ressources/CSV/joueurs.csv");
        String[][] newCSV = new String[length(listeJoueurs)+1][10];

        for (int i=0; i<rowCount(joueurs); i++) {
            for (int j=0; j<columnCount(joueurs); j++) {
                newCSV[i][j] = getCell(joueurs, i, j);
            }
        }
        newCSV[length(listeJoueurs)][0] = nom;
        newCSV[length(listeJoueurs)][1] = "3";
        newCSV[length(listeJoueurs)][2] = "false";
        newCSV[length(listeJoueurs)][3] = "false";
        newCSV[length(listeJoueurs)][4] = "false";
        newCSV[length(listeJoueurs)][5] = "true";
        newCSV[length(listeJoueurs)][6] = "true";
        newCSV[length(listeJoueurs)][7] = "true";
        newCSV[length(listeJoueurs)][8] = "false";
        newCSV[length(listeJoueurs)][9] = "false";
        
        saveCSV(newCSV, "../ressources/CSV/joueurs.csv");
        return nouveauProfil;
    }

    // Fonction supprimant un profil de la base de données des joueurs. Remplace le CSV précédent par un nouveau.
    void supprimerProfil(){

        Joueur[] listeJoueurs = loadListeJoueurs("../ressources/CSV/joueurs.csv", 1);

        println("Liste des profils déjà existants :");
        String[] profils = new String[length(listeJoueurs)];
        for (int i=0; i<length(listeJoueurs)-1; i++) {
            profils[i] = listeJoueurs[i].nom;
            println(listeJoueurs[i].nom);
        }

        println("Veuillez rentrer le nom du profil à supprimer.");
        String nom = readString();
        while (numeroProfil(nom, profils) == -1) {
            println("Ce nom n'est pas présent dans les profils existants. Veuillez entrer un nom présent dans la liste.");
            nom = readString();
        }

        int numProfil=numeroProfil(nom,profils);
        CSVFile joueurs = loadCSV("../ressources/CSV/joueurs.csv");
        String[][] transiCSV = new String[length(listeJoueurs)][10];
        for (int i=0; i<rowCount(joueurs); i++) {
            for (int j=0; j<columnCount(joueurs); j++) {
                transiCSV[i][j] = getCell(joueurs, i, j);
            }
        }
        for (int i=numProfil+1; i<rowCount(joueurs)-1; i++) {
            for (int j=0; j<columnCount(joueurs); j++) {
                transiCSV[i][j] = transiCSV[i+1][j];
            }
        }
        String[][] newCSV = new String[length(listeJoueurs)-1][10];
        for (int i=0; i<length(listeJoueurs)-1; i++) {
            for (int j=0; j<columnCount(joueurs); j++) {
                newCSV[i][j] = transiCSV[i][j];
            }
        }

        saveCSV(newCSV, "../ressources/CSV/joueurs.csv");
    }

    // Fonction utile lorsqu'un joueur finit un niveau pour la première fois. Mets alors à jour son profil pour le faire progresser.
    void miseAJourProfil(Joueur j){
        Joueur[] listeJoueurs = loadListeJoueurs("../ressources/CSV/joueurs.csv", 0);
        String[] profils = new String[length(listeJoueurs)];
        for (int i=0; i<length(listeJoueurs); i++) {
            profils[i] = listeJoueurs[i].nom;
        }
        
        int m=numeroProfil(j.nom,profils)+1;
        CSVFile joueursCSV = loadCSV("../ressources/CSV/joueurs.csv");
        String[][] newCSV = new String[length(listeJoueurs)+1][10];

        for (int k=0; k<rowCount(joueursCSV); k++) {
            for (int l=0; l<columnCount(joueursCSV); l++) {
                newCSV[k][l] = getCell(joueursCSV, k, l);
            }
        }

        if (!j.completionNiveaux[0]) {
            j.pvMax=5;
            j.completionNiveaux[0]=true;
            j.competenceDebloquee[3]=true;
            newCSV[m][1] = "5";
            newCSV[m][2] = "true";
            newCSV[m][8] = "true";

            println("Vous disposez désormais d'une nouvelle compétence et venez de débloquer une nouvelle difficulté !");
        } else if (!j.completionNiveaux[1]) {
            j.pvMax=7;
            j.completionNiveaux[1]=true;
            j.competenceDebloquee[4]=true;
            newCSV[m][1] = "7";
            newCSV[m][3] = "true";
            newCSV[m][9] = "true";

            println("Vous disposez désormais d'une nouvelle compétence et venez de débloquer une nouvelle difficulté !");
        } else { 
            j.pvMax=9;
            j.completionNiveaux[2]=true;
            newCSV[m][1] = "9";
            newCSV[m][4] = "true";
            
            println("Vous disposez de toutes les compétences disponibles.");
        }
        saveCSV(newCSV, "../ressources/CSV/joueurs.csv");
    }

    // Charge la liste des ennemis présent dans le fichier CSV demandé.
    Ennemi[] loadListeEnnemi(String nomFichier) {
        CSVFile ennemis = loadCSV(nomFichier);
        Ennemi[] ennemiList = new Ennemi[rowCount(ennemis) - 1];
        for (int i=1; i<rowCount(ennemis); i++) {
            String nom = getCell(ennemis, i, 0);
            int pvMax = stringToInt(getCell(ennemis, i, 1));
            int force = stringToInt(getCell(ennemis, i, 2));
            int frequenceAttaqueForte = stringToInt(getCell(ennemis, i, 3));
            Ennemi currentEnnemi = newEnnemi(nom, pvMax, force, frequenceAttaqueForte);
            ennemiList[i-1] = currentEnnemi;
        }
        return ennemiList;
    }

    // Charge une variable de type Ennemi en cherchant par le nom passé en paramètre dans la liste également passée en paramètre.
    Ennemi loadEnnemi(String nom) {

        Ennemi[] listeEnnemi = loadListeEnnemi("../ressources/CSV/ennemis.csv");

        // Crée un tableau de String contenant les noms des ennemis existants.
        String[] bestiaire = new String[length(listeEnnemi)];
        for (int i=0; i<length(listeEnnemi); i++) {
            bestiaire[i] = listeEnnemi[i].nom;
        }

        // Boucle infinie si l'algo essaie de charger un ennemi n'existant pas, on règle alors le problème.
        while (numeroBestiaire(nom, bestiaire) == -1) {
            println("Ce nom n'est pas présent dans le bestiaire. Veuillez réessayer.");
        }
        return listeEnnemi[numeroProfil(nom, bestiaire)];
    }

    // Trouve l'indice du bestiaire correpondant à nom, s'il n'est pas trouvé renvoie -1.
    int numeroBestiaire(String nom, String[] bestiaire) {
        for (int i=0; i<length(bestiaire); i++) {
            if (equals(nom, bestiaire[i])) {
                return i;
            }
        }
        return -1;
    }    

 
    /////// TESTS ///////


    void testEstEntier() {
        assertTrue(estEntier("09245"));
        assertTrue(estEntier("5"));
        assertFalse(estEntier(""));
        assertFalse(estEntier("abc"));
        assertFalse(estEntier("*"));
    }

    void testMiseAJourPv() {
        int[] pvs = new int[]{5,5};
        Ennemi e = newEnnemi("test", 7, 2, 2);

        // L'ennemi attaque, ce dernier possède 2 de force, donc -2 pv au joueur.
        assertEquals(-2, miseAJourPv(pvs, -1, e, 1));
        assertEquals(3, pvs[0]);
        assertEquals(5, pvs[1]);

        // La valeur d'attaque est à zéro, le joueur se défend et personne ne perd de points de vie.
        assertEquals(0, miseAJourPv(pvs, 0, e, 2));
        assertEquals(3, pvs[0]);
        assertEquals(5, pvs[1]);

        // Valeur d'attaque à 1, l'ennemi perd un point de vie.
        assertEquals(1, miseAJourPv(pvs, 1, e, 3));
        assertEquals(3, pvs[0]);
        assertEquals(4, pvs[1]);

        // Valeur d'attaque à 2 ET tour 4 alors que l'ennemi tape fort tous les deux tours. Ainsi -2 points de vie au joueur et à l'ennemi.
        assertEquals(102, miseAJourPv(pvs, 2, e, 4));
        assertEquals(1, pvs[0]);
        assertEquals(2, pvs[1]);

        // Tour 4 à nouveau et le joueur échoue, l'ennemi double ses dégàts de base.
        assertEquals(-2*e.force, miseAJourPv(pvs, -1, e, 4));
        assertEquals(-3, pvs[0]);
        assertEquals(2, pvs[1]);
    }

    void testNbCompetenceDebloquees () {
        boolean[] competenceDebloquee = new boolean[]{false, false, false, false, false};
        assertEquals(0, nbCompetencesDebloquees(competenceDebloquee));
        competenceDebloquee[0] = true;
        competenceDebloquee[4] = true;
        assertEquals(2, nbCompetencesDebloquees(competenceDebloquee));
        competenceDebloquee[1] = true;
        competenceDebloquee[2] = true;
        competenceDebloquee[3] = true;
        assertEquals(5, nbCompetencesDebloquees(competenceDebloquee));
    }

    void testInitialiserCompetences () {
        boolean[] competenceDebloquee = new boolean[]{true, true, true, false, false};
        Competence[] comp1 = initialiserCompetences(competenceDebloquee);

        assertEquals("Défense soustractive", comp1[0].nom);
        assertEquals(1, comp1[1].puissance);
        assertEquals(1, comp1[2].cooldown);
        assertEquals(0, comp1[2].tpsAvantUtilisation);

        competenceDebloquee[3] = true;
        competenceDebloquee[4] = true;
        Competence[] comp2 = initialiserCompetences(competenceDebloquee);

        assertEquals("Divisions", comp2[3].nom);
        assertEquals(2, comp2[3].puissance);
        assertEquals(4, comp2[4].cooldown);
        assertEquals(0, comp2[4].tpsAvantUtilisation);
    }

    void testNumeroProfil() {
        String[] profils = new String[]{"Bob", "Jean", "Daniel", "Hugh", "Axel"};
        String nomRecherche = "Bob";
        assertEquals(0, numeroProfil(nomRecherche, profils));
        nomRecherche = "Axel";
        assertEquals(4, numeroProfil(nomRecherche, profils));
        nomRecherche = "Danielle";
        assertEquals(-1, numeroProfil(nomRecherche, profils));
        nomRecherche = "JEAN";
        assertEquals(-1, numeroProfil(nomRecherche, profils));
    }

    void testLoadEnnemi() {
        // On rajoute une ligne "Test,5,1,2" dans le fichier CSV contenant les ennemis.
        assertEquals("Test", loadEnnemi("Test").nom);
        assertEquals(5, loadEnnemi("Test").pvMax);
        assertEquals(1, loadEnnemi("Test").force);
        assertEquals(2, loadEnnemi("Test").frequenceAttaqueForte);
    }

}