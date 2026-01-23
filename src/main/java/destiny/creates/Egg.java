package destiny.creates;


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
}
