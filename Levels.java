import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

//region DEFINITIONS AND TERMS
/*
LCVAR: Level Change Variable
   LS: Level Switch
*/
//endregion
public class Levels {
/*---------------------------------------------WHAT TO KNOW----------------------------------------------------*//*
1) LCVAR is updated Every time Movement is ran. so if not ran can alwyas KEEP LCVAR MIGHT CREATE BUGS
*/
/*--------------------------------------Declare/Call/Iniltize Varaibles-----------------------------------------------*/
//region Assigning Classes to Vars
    DeBugger debug = new DeBugger();
    static LevelsLib levelsLib= new LevelsLib();
    //endregion
    //region Declaring Vars
    static String LEVELNAME="";
    static String LCVAR="";
    static String P="+";
    static String mainAreaLCVars="="+"$";
    static String homeLCVars="=",shopLCVars="=";
    //endregion
    //region Arrays
    static ArrayList<String> mainAreaTemp = (levelsLib.getLibMainArea("T"));
    static ArrayList<String> mainAreaPerm = levelsLib.getLibMainArea("P");
    static ArrayList<String> homePerm=levelsLib.getLibHome("P");
    static ArrayList<String> homeTemp=levelsLib.getLibHome("T");
    static ArrayList<String> shopPerm=levelsLib.getLibShop("P");
    static ArrayList<String> shopTemp=levelsLib.getLibShop("T");
    static ArrayList<String> sMArray = levelsLib.getLibsMArray();
    static ArrayList<String> currentLevelTemp = new ArrayList<>();
    static ArrayList<String> currentLevel = new ArrayList<>();
    //endregion

    StringBuilder LevelsDebugger = new StringBuilder(); //DEBUGGER
/*------------------------------------------Main Parts of Code--------------------------------------------------------*/
    //region B)--------------------LEVEL SWITCHING      w/Summary
                /*Summary: When |LEVELCHANGE| called upon will save current level check to see what level it needs to
                go to then takes they level it needs and replaces the current level variable accordingly.
     1) Will: When called will use current level to determin what method to run and does that
     2) Will: takes level name Temp and Perm, clear it, then saves |currentLevel| Temp & Perm to it
     3) Will: see what level the player entered and change the level Name then clear |currentLevel| and assign
              |currentLevel| to the level it is entering obtained from |collisionLCVar|
     4) Will: Depending on the symbol it interacts with, switch level accordingly &
        Has : a collision method where it detect to see the symbol interacted with need to trigger a level change

     */
    //region 1)---Level Change---
    public void LEVELCHANGE(){
        LevelsDebugger.delete(0,LevelsDebugger.length());
        switch(LEVELNAME){
            case"MAIN AREA"->{mainAreaLS();}
            default ->{if(LCVAR.equals("=")){saveLevel(LEVELNAME); changeLevel("MAIN AREA");}}}
        LCVAR="";
        if(debug.levelClass()){System.out.println(LevelsDebugger);}
    }
    //endregion
    //region 2)---Save Level---
    public void saveLevel(String level){ LEVELNAME=level;
        LevelsDebugger.append("Level Saved:("+LEVELNAME+") / ");
        switch(LEVELNAME){
            case "MAIN AREA"->{
                mainAreaPerm.clear();                mainAreaTemp.clear();
                mainAreaPerm.addAll(currentLevel);   mainAreaTemp.addAll(currentLevelTemp);
            }
            case "HOME"->     {
                homePerm.clear();                homeTemp.clear();
                homePerm.addAll(currentLevel);   homeTemp.addAll(currentLevelTemp);
            }
            case "SHOP"->     {
                shopPerm.clear();                shopTemp.clear();
                shopPerm.addAll(currentLevel);   shopTemp.addAll(currentLevelTemp);
            }
        }
    }
    //endregion
    //region 3)---change Level---
    public void changeLevel(String levelPlayerEnter){
        LEVELNAME=levelPlayerEnter;
        LevelsDebugger.append("Level Enter:("+LEVELNAME+") / ");
        switch(LEVELNAME){

            case "MAIN AREA"->{
                currentLevel.clear();                currentLevelTemp.clear();             //clear currentLevel arrays
                currentLevel.addAll(mainAreaPerm);   currentLevelTemp.addAll(mainAreaTemp);//addAll array of that level
            }
            case "HOME"->{
                currentLevel.clear();                currentLevelTemp.clear();
                currentLevel.addAll(homePerm);       currentLevelTemp.addAll(homeTemp);
            }
            case "SHOP"->{
                currentLevel.clear();                currentLevelTemp.clear();
                currentLevel.addAll(shopPerm);       currentLevelTemp.addAll(shopTemp);
            }
            default->{System.out.println("COULD NOT FIND LEVEL INPUTTED: VALUE EITHER MISSPELLED OR DOESN'T EXIST ");}
        }
    }
    //endregion
    //region 4)---Level Switches--- (LE)
    public void  mainAreaLS(){
        LevelsDebugger.append("Levels -> mainAreaLS -> saveLevel, changeLevel -> Level Before Switch:("+LEVELNAME+") / LCVAR:("+LCVAR+") / ");
        switch(LCVAR){
            case"="-> {saveLevel(LEVELNAME); changeLevel("HOME");}
            case"$"-> {saveLevel(LEVELNAME); changeLevel("SHOP");}
        }
    }
    public static void collisionLCVar(String levelChangeVar){
        switch(LEVELNAME){
            case "MAIN AREA"->{if(mainAreaLCVars.contains(levelChangeVar)){LCVAR=levelChangeVar;}}
            case "HOME"     ->{if(homeLCVars.contains(levelChangeVar))    {LCVAR=levelChangeVar;}}
            case "SHOP"     ->{if(shopLCVars.contains(levelChangeVar))    {LCVAR=levelChangeVar;}}
        }
    }
    //endregion
    //endregion
    //region random methods
    public static String getLEVELNAME(){return LEVELNAME;}
    //region Current Level: GETTER & CHANGE METHOD
    public static void changeCurrentLevelTemp(ArrayList<String> areaTemp){currentLevelTemp=areaTemp;}
    public void changeCharInCurrentLevelTemp(int pos,String temp){currentLevelTemp.set(pos,temp);}
    public static ArrayList<String> getCurrentLevelTemp(){ return currentLevelTemp; }

    public void changeCurrentLevel(ArrayList<String> areaPerm){ currentLevel=areaPerm; }
    public static ArrayList<String> getCurrentLevel(){
        return currentLevel;
    }
    //endregion
    //region SideMenu     : GETTER METHOD
    public ArrayList<String> getSM(){return sMArray;}
    //endregion
    //regionMAIN AREA    : GETTER & CHANGE METHOD & LEVEL SWITCH
    public ArrayList<String> getMainAreaPerm(){return mainAreaPerm;}
    public void mainAreaPermChange(ArrayList<String> temp){mainAreaPerm=temp;}

    public ArrayList<String> getMainAreaTemp(){return mainAreaTemp;}
    public void mainAreaTempChange(ArrayList<String> temp){mainAreaTemp=temp;}


    //endregion
    //region HOME         : GETTER & CHANGE METHOD & LEVEL SWITCH
    public ArrayList<String> getHomeTemp()            {return homeTemp;}
    public ArrayList<String> getHomePerm()            {return homePerm;}
    public void homePermChange(ArrayList<String> temp){homePerm=temp;}
    public void homeTempChange(ArrayList<String> temp){homeTemp=temp;}
    public ArrayList<String> getShopTemp()            {return shopTemp;}



    //endregion
    //endregion
    //region shop methods

    //endregion

}
