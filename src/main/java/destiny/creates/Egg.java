package destiny.creates;
import java.util.Timer;
import java.util.TimerTask;

public class Egg {

    public enum EGG {
        FRIED{
            public String getEggType(){
                return "FRIED";
            }
        },
        HARD_BOILED{
            public String getEggType(){
                return "HARD-BOILED";
            }
        },
        SOFT_BOILED{
            public String getEggType(){
                return "SOFT-BOILED";
            }
        },
        SEMI_HARD_BOILED{
            public String getEggType(){
                return "SEMI HARD-BOILED";
            }
        };

        public abstract String getEggType();
    }//ENUM

    private final EGG eggType;


    public Egg(EGG eggType){
        this.eggType = eggType;
    }

    public void printEggType(){
        System.out.println(this.eggType.getEggType());
    }

    public void startTimer(EGG eggType){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                switch (eggType){
                    case EGG.FRIED:
                        System.out.println("Egg successfully fried!");
                        break;
                    case EGG.HARD_BOILED:
                        System.out.println("Egg successfully hard-boiled!");
                        break;
                    case EGG.SOFT_BOILED:
                        System.out.println("Egg successfully soft-boiled!");
                        break;
                    case EGG.SEMI_HARD_BOILED:
                        System.out.println("Egg successfully semi-hard boiled!");
                        break;
                    default:
                        break;
                }
                System.out.println("Finished egg timer");
                timer.cancel();
            }
        };//timer


        long delay = 30000L;
        System.out.println("Starting egg timer");
        timer.schedule(task,delay);




    }
}
