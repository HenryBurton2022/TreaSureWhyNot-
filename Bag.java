import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.ArrayList;

public class Bag {
    /*---------------------------------------------WHAT TO KNOW------------------------------------------------*//*
1) How this class switches gameState and level Display:
    This class a Dominate Array that contains and final version of what needs to be be displayed so
    When switching game state (handled object.method gameStateSwitcher) it will assign the arrays from different
    class to single one. keeping the state of other classes arrays when switch states.
2) KeyListener and Main Move independently of each other So I've used a |synchronize| for the sole reason of having
    scrolling text (might do more w/it
3) Read the Summary for clarification of code
*/
    /*--------------------------------------Declare/Call/Initialize/Variables-----------------------------------------*/
    //region ---Misc: assign Vars To Class---
    static Text text = PrintGame.getText();
    static DeBugger debug = new DeBugger();
    static Treasure treasure = PrintGame.getTreasure();
    static BagLib bagLib = new BagLib();
    static Background BG= PrintGame.getBackground();
    //endregion
    //region ---D&I : Vars
    static String bagPageState="",arrowKey="";
    static boolean TorF=false;
    static ArrayList<String> bag1 = bagLib.getIB1();
    static ArrayList<String> bag2 = bagLib.getIB2();
    static ArrayList<String> tres1Bag = bagLib.getTB1();
    static ArrayList<String> currentBagPage = new ArrayList<>();

    StringBuilder bagDebugger = new StringBuilder();
    //endregion
    /*------------------------------------------Main Parts of Code----------------------------------------------------*/
    /*NOTE: B.2 DOING BAG UPDATE SEEMS INEFFICIENT: as it will always every time check and
      reprint something it doesn't need to reprint*/
    //region B)--------------------!BIG: Bag Navigator & Relevant Component        w/Summary
                    /*Summary: Takes |keyPressed| from |PrintGame|'s Key Listener and Displays Bag depending on what
                    state the bag is in.
     1) Has: Debugger Reset-er and Start Point
     2) Will: change Var |arrowKey| to input when method called  & |.clear| current bag  &  calls |bagUpdater|
     3) Will: check what page its on & use arrow keys to find where it needs to go (& print debugger)
     4) Has: GET and CHANG methods for bagPageState & currentBagPage
     GENERAL NOTE: IB#=item bag #   &   TB#=treasure bag #
     */
        //region 0)---Vars Specific to Bag Navigator Code---
    static boolean shouldMoveBox=true;
    static String strCurBox="";
    static Integer intCurBox=1; //intCurBox = integer version of variable |current box|
    static String rB ="|5| |10| |15| |20| "; //rB = Right Boarder
    static String lB ="|1|  |6| |11| |16| "; //lB = Left  Boarder
    //endregion
    public void navigation(String keyPressed){
        //region 1)---Debugger---
        bagDebugger.delete(0,bagDebugger.length());
        bagDebugger.append("Bag -> navigation -> ");
        //endregion
        //region 2)---Prep-er---
        arrowKey="N/A";
        arrowKey=keyPressed;
        PrintGame.hasPrintedChange(false);
        shouldMoveBox=true;
        //endregion
        //region 3)---Bag Navigator---
        // 5 columns & 4 rows
        switch(bagPageState){
            case"IB1"-> {
                switch (arrowKey) {
                    case"UP"   ->{if (intCurBox <= 5){bagPageChanger(tres1Bag,"TB1",true);}}
                    case"RIGHT"->{if (rB.contains(strCurBox)){bagPageChanger(bag2,"IB2",true);}}
                    default    ->{bagPageChanger(bag1,"IB1",false);}}
            }
            case"IB2"-> {
                switch (arrowKey) {
                    case"UP"   ->{if (intCurBox <= 5){bagPageChanger(tres1Bag,"TB1",true);}}
                    case"LEFT" ->{if (lB.contains(strCurBox)){bagPageChanger(bag1,"IB1",true);}}
                    case"RIGHT"->{if (rB.contains(strCurBox)){bagPageChanger(bag2,"IB2",true);}}
                        //Change Right to when have next page
                    default ->     {bagPageChanger(bag2,"IB2",false);}}
            }
            case"TB1"-> {
                switch (arrowKey) {
                    case"DOWN" ->{if (intCurBox > 15){bagPageChanger(bag1,"IB1",true);}}
                    //case"LEFT" ->{if (lB.contains(strCurBox)){bagPageChanger(bag1,"IB1",true);}}
                    //case"RIGHT"->{if (rB.contains(strCurBox)){bagPageChanger(tres1Bag,"TB1",true);}}
                    //Change Right to when have next page
                    default    ->{bagPageChanger(tres1Bag,"TB1",false);}
                    }
                }
            default -> {System.out.print("ERROR IN FINDING CURRENT PAGE STATE");}
            }
        if(shouldMoveBox){moveBoxSelect(keyPressed);}
        if(PrintGame.getGameState().equals("LEVEL")){bagPageChanger(bag1,"IB1",true);strCurBox="|1|";intCurBox=1;}

        //region end debugger
        bagDebugger.append("KeyPressed("+arrowKey+") / PageState("+bagPageState+") / " +
                "intCurBox("+intCurBox+") / strCurBox("+strCurBox+") / ");
        if(DeBugger.bagCLass()){System.out.println(bagDebugger);}

        //endregion
        //endregion
    }
        //region 3.1)---Methods For Navigator---
    public void bagPageChanger(ArrayList<String> nAPage, String nPage,boolean cPage){
        //nAPage = new array page | nPage = new page | cPage = change page
        currentBagPage.clear();currentBagPage.addAll(nAPage);
        bagPageState = nPage;  shouldMoveBox=!cPage;
        if(cPage){intCurBox=1;strCurBox="|1|";BG.setBagCords(19,71);}
    }
    public void moveBoxSelect(String move){
        switch (move) {
            case "UP"   ->{if((intCurBox-5)>0)  {intCurBox-=5;BG.changeBagCords(0,-130);}}
            case "DOWN" ->{if((intCurBox+5)<21) {intCurBox+=5;BG.changeBagCords(0,130);}}
            case "RIGHT"->{if(intCurBox+1<21 && !(rB.contains(strCurBox))){intCurBox+=1;BG.changeBagCords(120,0);}}
            case "LEFT" ->{if(intCurBox-1>0  && !(lB.contains(strCurBox))){intCurBox-=1;BG.changeBagCords(-120,0);}}
        }
        strCurBox="|"+intCurBox.toString()+"|";
    }
    public static int getCurrentBox(){return intCurBox;}
    public static void changeCurrentBox(int temp){intCurBox=temp;}
        //endregion
        //region 4)---GET AND CHANG: BagPageState  &  GET: currentBagPage---
        public ArrayList<String> getBag1(){return bag1;}
    public static void changeBagPageState(String bagState){bagPageState=bagState;}
    public static String getBagPageState(){return bagPageState;}
    public static ArrayList<String> getCurrentBagPage(){return currentBagPage;}
        //endregion
    //endregion


    //region C)--------------------!BIG: Bag Updater  &  Color Bag                 w/Summary
                    /*Summary: This will update if obtained item and color it when viewing bag
     1) Will: D&I row margins so easy to read
     2) Will: Checks to see if player has an Item if so add it to the array
     3) Will: Colors the rows depending on if have item
     */
    //region 1)---D&I Row Margins---
    int row01=42,row02=42*2,row03=42*3,row04=42*4;
    //endregion
    //region 2)---Bag Updater---

    public static void bagUpdater(){
        if(playerHas("SHOVEL"))    {bagLib.drawObject("SHOVEL"); }
        if(playerHas("GOLD COIN")) {bagLib.drawObject("GOLD COIN");}
        if(playerHas("BOOTS"))     {bagLib.drawObject("BOOTS");}
    }
    //endregion
    //region 3)---Color Bag---
    public void bagColorer(StyledDocument r01,StyledDocument r02,StyledDocument r03,StyledDocument r04,StyledDocument r05,
                           StyledDocument r06,StyledDocument r07,StyledDocument r08,StyledDocument r09,StyledDocument r10,
                           StyledDocument r11,StyledDocument r12,StyledDocument r13,StyledDocument r14,StyledDocument r15,
                           StyledDocument r16,StyledDocument r17,StyledDocument r18,StyledDocument r19,StyledDocument r20){
        SimpleAttributeSet black     = new SimpleAttributeSet();StyleConstants.setForeground(black,    new Color(0, 0, 0));
        SimpleAttributeSet white     = new SimpleAttributeSet();StyleConstants.setForeground(white,    new Color(225, 225, 225));
        SimpleAttributeSet shinyGold = new SimpleAttributeSet();StyleConstants.setForeground(shinyGold,new Color(255, 215, 30));
        SimpleAttributeSet riverBlue = new SimpleAttributeSet();StyleConstants.setForeground(riverBlue,new Color(62, 68, 246));
        SimpleAttributeSet brown     = new SimpleAttributeSet();StyleConstants.setForeground(brown    ,new Color(150, 75, 1));
        // Type Of Bag /box # / object
        //Treasure Bag /box 1 / GOLD COIN
        if(treasure.playerHas("GOLD COIN") && getBagPageState().equals("TB1")){ //So if player has X and is on the proper page color
            r01.setCharacterAttributes(1, 7, shinyGold, true);
            r02.setCharacterAttributes(1, 7, shinyGold, true);
            r03.setCharacterAttributes(1, 7, shinyGold, true);
            r04.setCharacterAttributes(1, 7, shinyGold, true);
        }//Item Bag / box 1 / SHOVEL
        if(playerHas("SHOVEL") && getBagPageState().equals("IB1")){
            r01.setCharacterAttributes(1, 6, black, true);
            r02.setCharacterAttributes(1, 6, black, true);
            r03.setCharacterAttributes(1, 6, black, true);
            r04.setCharacterAttributes(1, 6, black, true);
        }
    }


    //endregion
    //endregion
    //region D)--------------------!BIG: Check & Change Player Items               w/Summary
                    /*Summary: This can GET or CHANG if has item
     1) D&I all obtainable items
     2) Checks Players Items and return a true or false
     3) Change whether or not Player Has Item
     */
    //region 1)---D&I items---
    static boolean shovel=false,boots=false;
    //endregion
    //region 2)---GET: if player has an item---
    public static boolean playerHas(String item){
        switch(item){
            case"SHOVEL"->{TorF=shovel;}
            case"BOOTS" ->{TorF=boots;}
        }
        return TorF;
    }
    //endregion
    //region 3)---CHANG: if player has an item---
    public static void changePlayerHas(String item, boolean temp){
        switch(item){
            case"SHOVEL"->{shovel=temp;}
            case"BOOTS" ->{boots=temp;}
        }
    }
    //endregion
    //endregion
    //region E)-----------------Shop Purchase Item
    public static void shopSelect(String selection) {
      switch (Text.getIntractableVarPos()) {
        case 853 -> {/*BOOTS*/
          if (selection.equals("Yes")) {
            if (treasure.getMoney() >= 200) {
              treasure.changeMoney("SUB", 200);
              changePlayerHas("BOOTS", true);text.PPBootsIC();
            } else {
                text.createText("You look at the wallet an notice you don't have enough");
            }
          }
        }
      }
    }
    //endregion
}
