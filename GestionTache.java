import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;


public class GestionTache {

    static void menu() {
    
        System.out.println("______________________________________________\n");
        System.out.println("                Menu TODOLIST               \n");
        System.out.println("\t1: Ajouter une tache");
        System.out.println("\t2: Supprimer une tache");
        System.out.println("\t3: Modifier une tache");
        System.out.println("\t4: Lister toutes les taches");
        System.out.println("\t5: Lister les taches selon l'etat:");
        System.out.println("\t\t51: En cours");
        System.out.println("\t\t51: Prevues");
        System.out.println("\t\t51: Terminées");
        System.out.println("\t0: Pour quitter\n");
        
    }
  
    public  static void order() {

        String again ;
        Scanner fd = new Scanner(System.in);
        System.out.println("=================== DALAL AK DIAM  ===============");
        System.out.println("__________________________________________________\n");
        System.out.println("\n\t\t1:Ajouter des taches pour commencer");
        System.out.println("\n__________________________________________________");
        
        System.out.print("Veuillez nous donner le nombre de tache(s) que vous voudriez avoir dans votre gestionnaire ?\n");
        
        int nombreTache = fd.nextInt();
        
        GestionnaireTache gest = new GestionnaireTache(nombreTache);
        Tache tache ;
        
        System.out.println("Youpi! vous aviez un stockage de "+nombreTache+" dans votre gestionnaire");
        menu();
        
      
       while(true){
        System.out.print("\tQue voulez - vous faire : \n");
        int choix = fd.nextInt();
        System.out.println("----------------------------------------------------");
        switch (choix){
            case 1:                                                  
                    System.out.println("Saisir le titre de la tache: \n");
                    String titre = fd.next();
                    tache = new Tache(titre);
                    
                    if(gest.ajouter(tache)==true){
                        System.out.println("Bingo-) votre tache "+titre+" taches sont ajoutes avec succes");
                    }else{
                        System.out.println("Oups!!! Malheureusement votre gestionnaire est pleine");
                    }
                                             
            break;
            case 2:
                System.out.println("Saisir l'identifiant de la tache à supprimer");
                int id = fd.nextInt();
                if(gest.supprimer(id)== true)
                    System.out.println("La Tache "+id+"  a ete supprimer avec succes");
                else
                    System.out.println("Cette tache n'existe pas dans votre gestionnaire");
            break;
            case 3:
                System.out.println("Quelle tache voulez-vous modifier ?");
                String titreM= fd.next();
                
                System.out.println("La tache "+titreM+" va etre modifier");
        
                tache = new Tache(titreM);
                gest.modifier(tache);     

            break;
            case 4:
                System.out.println(Arrays.toString(gest.lister()));
            break;
            case 5:

            break;
            default:
            break;
        }
        System.out.println("");
        System.out.println("Voulez-vous quitter votre TODOLIST (Y/N)");
        again = fd.next();
        if(again.equalsIgnoreCase("N")){
            menu();
            
            
        }
            
        else if (again.equalsIgnoreCase("Y")){
            System.out.println("SAYONARA ....!!!!");
            break;
        }
        else 
            System.out.println("Invalide choice");

       }
    }
     public static void main(String[] args) {
        menu();
        order();
    }
    
}
