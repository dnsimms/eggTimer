package destiny.creates;

import javafx.application.Application;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EggDriver {
    static void main(String[] args) {
//        Egg firstEgg = new Egg(Egg.EGG.FRIED);
//        firstEgg.printEggType();
//        firstEgg.startTimer(Egg.EGG.FRIED);

        try{
            Application.launch(EggApp.class,args);
        }catch (UnsupportedOperationException e){
            System.out.println("An error occurred when trying to launch the game.");
            System.out.println("Please try again.");
            System.exit(1);
        }//catch
    }//main

}//EggDriver
