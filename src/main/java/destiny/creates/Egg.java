package destiny.creates;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit.*;

public class Egg {

    //TO-DO: change the time to seconds and increase by one
    public enum EGG {
        FRIED{
            public String getEggType(){
                return "FRIED";
            }
            public long getCookTime() {return 120L;} //30s for testing purposes
        },
        HARD_BOILED{
            public String getEggType(){
                return "HARD-BOILED";
            }
            public long getCookTime() {return 480L;} //30s for testing purposes
        },
        SOFT_BOILED{
            public String getEggType(){
                return "SOFT-BOILED";
            }
            public long getCookTime() {return 360L;} //30s for testing purposes
        },
        SEMI_HARD_BOILED{
            public String getEggType(){
                return "SEMI HARD-BOILED";
            }
            public long getCookTime() {return 720L;} //30s for testing purposes
        };

        /**
         * This method will return the value of the current EGG enum type.
         * @return eggType as a string
         */
        public abstract String getEggType();

        /**
         * This method will return the cook time for the specific EGG enum type.
         * @return eggType cook time
         */
        public abstract long getCookTime();
    }//ENUM

    private final EGG eggType;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    /**
     * Default constructor that sets the chosen eggType to the private global variable.
     * @param eggType
     */
    public Egg(EGG eggType){
        this.eggType = eggType;
    }

    /**
     * This method will print the value of the EGG enum type to the user.
     */
    public void printEggType(){
        System.out.println(this.eggType.getEggType());
    }

    /**
     * This method will start the timer based on the current eggType. A message will print to the user, regardless of
     * eggType, stating that their egg is done.
     * @param eggType
     */
    public void startTimer(EGG eggType){
        final Runnable eggMessage = new Runnable() {
            @Override
            public void run() {
                System.out.println("\nYour egg is done!");
                scheduler.shutdown();
            }
        };

        final ScheduledFuture<?> eggTimerHandle = scheduler.schedule(eggMessage, eggType.getCookTime(), TimeUnit.SECONDS);
        try{
            visualCount(eggTimerHandle);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    private void visualCount(ScheduledFuture<?> eggTimerHandle) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        while(!eggTimerHandle.isDone()){
            long elapsedTime = System.currentTimeMillis() - startTime;
            long elapsedSeconds = eggType.getCookTime() - elapsedTime/1000;
            //System.out.println(elapsedSeconds);

            String seconds = Integer.toString((int) (elapsedSeconds % 60));
            String minutes = Integer.toString((int) ((elapsedSeconds % 3600) / 60));
            String hours = Integer.toString((int) (elapsedSeconds / 3600));

            if (seconds.length() < 2) seconds = "0" + seconds;
            if (minutes.length() < 2) minutes = "0" + minutes;
            if (hours.length() < 2) hours = "0" + hours;

            String timeDisplay = hours + ":" + minutes + ":" + seconds;
            System.out.print("\r" + timeDisplay);
            Thread.sleep(100);
        }
    }
}
