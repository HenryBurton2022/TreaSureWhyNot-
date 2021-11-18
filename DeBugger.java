import java.util.ArrayList;

public class DeBugger {
 /*--------------------------------------Declare/Call/Initialize/Variables-----------------------------------------*/
 static Levels getLevels = new Levels();
 static Treasure treasure = new Treasure();

    static boolean printLevelOnMove;
    static ArrayList<String> currentLevelDBug = new ArrayList<>();

    public static void levelExistance(){
        System.out.print("DeBugger -> LevelExistance -> Level Don't exist:");
        if(getLevels.getHomePerm().size()<=0){System.out.print("homePerm / ");}
        if(getLevels.getHomeTemp().size()<=0){System.out.print("homeTemp / ");}

        if(getLevels.getMainAreaPerm().size()<=0)    {System.out.print("mainAreaPerm / ");}
        if(getLevels.getMainAreaTemp().size()<=0)    {System.out.print("mainAreaTemp / ");}

        //if(getLevels.getCurrentLevel().size()<=0)    {System.out.print("currentLevel / ");}
        //Note: Idk why i keeps saying current level doesn't exists so I disabling it for now

        //if(getLevels.getCurrentLevelTemp().size()<=0){System.out.print("currentLevelTemp / ");}
        //Note: CurrentTemp isnt here because it declared in the for loop inside of PrintGame
        System.out.println();
    }
    public static void ifPermArraysHasPlayer(){
        System.out.print("DeBugger -> ifPermArraysHasPlayer -> Perm Levels w/player:");
        if(getLevels.getHomePerm().contains("@"))        {System.out.print("homePerm / ");}
        if(getLevels.getMainAreaPerm().contains("@"))    {System.out.print("mainAreaPerm / ");}
        if(getLevels.getCurrentLevel().contains("@"))    {System.out.print("currentLevel / ");}
        System.out.println();
    }
    public void changeLocationOfSymbols(ArrayList<String> areaTemp){currentLevelDBug=areaTemp;}
    public static void locationOfSymbols(){
        System.out.print("DeBugger-> locationOfSymbols -> The Location Of Char is... ");
        System.out.print("@:"+currentLevelDBug.indexOf("@"));
        System.out.print(" / =:"+currentLevelDBug.indexOf("="));
        System.out.print(" / &:"+currentLevelDBug.indexOf("&"));
        System.out.print(" / %:"+currentLevelDBug.indexOf("%"));
        System.out.print(" / *:"+currentLevelDBug.indexOf("*"));
        System.out.println();
    }
    //PL stands for Print Level
    public static void playerBag(){
        System.out.print("DeBugger-> playerBag-> Does Player Bag Have... ");
        System.out.print("Shovel:("+Bag.playerHas("SHOVEL")+") / ");
        System.out.println();
    }
    public static void playerTreasures(){
        System.out.print("DeBugger-> playerTreasures-> Treasure Player Have... ");
        System.out.print("Gold Coin:("+treasure.playerHas("GOLD COIN")+") / ");
        System.out.println();
    }
    public static void giveTreasure(boolean goldCoin){
        if(goldCoin){treasure.changePlayerHas("GOLD COIN",true);}

    }
    public static void giveItem(boolean shovel){
        if(shovel){Bag.changePlayerHas("SHOVEL",true);}

    }
    public static void misc(boolean levelExistenceOn, boolean ifPermArraysHasPlayerOn, boolean printLevelOnMovementOn, boolean locationOfCharsOn,
                            boolean checkPlayerBag, boolean checkPlayerTreasure){
        if(levelExistenceOn)       {levelExistance();}
        if(ifPermArraysHasPlayerOn){ifPermArraysHasPlayer();}
        if(printLevelOnMovementOn){printLevelOnMove=true;}else{printLevelOnMove=false;}
        if(locationOfCharsOn){locationOfSymbols();}
        if(checkPlayerBag && bagCLass()){playerBag();}
        if(checkPlayerTreasure&&treasureClass()){playerTreasures();}
    }
    public boolean getPLOnMove(){return printLevelOnMove;}

    //DB stands for DeBugger
    static boolean DBPrintGame,DBMovementClass,DBLevelClass,DBTreasureClass,DBBagClass,DBTextClass;
    public static void classes(boolean printClass, boolean movementClass, boolean levelClass, boolean treasureClass, boolean bagClass, boolean textClass){
        DBPrintGame=printClass;
        DBMovementClass=movementClass;
        DBLevelClass=levelClass;
        DBTreasureClass=treasureClass;
        DBBagClass=bagClass;
        DBTextClass=textClass;
        System.out.println();
    }
    //C in  Stands for class
    public static boolean printClass(){return DBPrintGame;}
    public boolean movementClass(){return DBMovementClass;}
    public boolean levelClass(){return DBLevelClass;}
    public static boolean treasureClass(){return DBTreasureClass;}
    public static boolean bagCLass(){return DBBagClass;}
    public boolean textClass(){return DBTextClass;}
}
