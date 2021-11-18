import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.lang.Math;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
        //Basic Navigation Below
/*NOTE: basic naviagation for code is:
| misc = miscellaneous                | I&D = initialise and Declare       | Method: = public void                     |
| ! = Import at overall code          |------------------=big chunk of code| --INFO-- : = basic lines of code          |
| GET: getting something              | |     | = This is a specific name  | CHANG: = a method that changes a variable |
| (LE) = used for level editor used for when finding code that when stuff is added, adds to the game                   |

Summary: summary of the code it contains (Note: Summaries first say what it do then the Will/Has/Upon/etc doing)
*/
public class PrintGame {
/*---------------------------------------------WHAT TO KNOW----------------------------------------------------*//*
1) How this class switches gameState and level Display:
    This class a Dominate Array that contains and final version of what needs to be be displayed so
    When switching game state (handled object.method gameStateSwitcher) it will assign the arrays from different
    class to single one. keeping the state of other classes arrays when switch states.
2) KeyListener and Main Move independently of each other So I've used a |synchronize| for the sole reason of having
    scrolling text (might do more w/it)
3) hasPrinted make sure that nothing is change until not print anything until either Level or Bag Movement is detected
NOTE) Read the Summary for clarification of code
*/
/*-------------------------------------Declare/Call/Initialize/Variables----------------------------------------------*/
    //region ---Misc: assign Var To Classes---

    static JframeMethod windowInfo = new JframeMethod();
            public static JframeMethod getWindowInfo() { return windowInfo;}
    static Levels levels = new Levels();
            public static Levels getLevels() { return levels;}
    static Movement movement = new Movement();
            public static Movement getMovement() { return movement;}
    static Text text = new Text();
            public static Text getText() { return text;}
    static HudAndUI hud = new HudAndUI();
            public static HudAndUI getHud() { return hud;}
    static Bag bag = new Bag();
            public static Bag getBag() { return bag;}
    static Treasure treasure = new Treasure();
            public static Treasure getTreasure() {return treasure;}
    static Background background = new Background();
            public static Background getBackground() {return background;}
    static final PrintGame printGame = new PrintGame();
    public PrintGame getPrintGameClassObject(){return printGame;} //used for threads
    static final GameRun runner = new GameRun(); //used for threads


    //endregion
    //region ---D&I: Vars---
    static boolean hasPrinted;
    static String gameState = "";
    static ArrayList<String> gameArray = new ArrayList<>();
    static int numOfColomsMA = 42, numOfColomsSM = 11;
    static String keyPressed="";
    static String validKeys="LEFT"+"RIGHT"+"UP"+"DOWN"+"ENTER"+"B"+"N/A";
    static String validMoveKeys="LEFT"+"RIGHT"+"UP"+"DOWN";
    static boolean doneWStartup=false;
    static boolean firstTemp=false;

    StringBuilder printGameDeBugger = new StringBuilder(); //part of the debugger
    //endregion

/*------------------------------------------Main Parts of Code--------------------------------------------------------*/
    //region A)--------------------!BIG: Starts the game
    public void startOfGame(){
        windowInfo.createJframe();  //add JFrame and main Panel for rows
        windowInfo.executeWindowProperties();
        System.out.println("START GAME");                         //debugger for start of game
        levels.changeLevel("MAIN AREA");          //Sets the level to main area
        gameState="LEVEL";                                        //makes class know that it should be displaying Levels
        gameStateSwitcher();                                       //Makes it so the what is displayed is = to the proper arrays
        printLevel();                                              //the entirety of the game
        text.getTextInteractions();                                //Have this so it can display box in the bottom for text
        text.createText();
        //region GIVE ITEMS/TREASURE
        DeBugger.giveTreasure(true);
        DeBugger.giveItem(true);
        treasure.changeMoney("ADD",999);
        //endregion
    }
    public boolean getDoneWStartup() {return doneWStartup;}           //Method used tell Main that it is done with loading game
    public void changeDoneWStartup(boolean temp) {doneWStartup=temp; }
    //endregion
    //region B)--------------------!BIG: Key Listener    w/Summary
                /*Summary: The Key Listener gets assigned to JFrame at start of game in main method and will/has/upon->
     1) Has: printGameDeBugger string builder reset value & starting text
     2) Will: when press key calls changeKeyPressed if it is a assigned key & if not becomes "ALL
     3) Upon: completion will call gameProcessor.
     */
    public void getKeyListener() {
        KeyListener listener = new KeyListener() {
            @Override public void keyTyped(KeyEvent e) { }
            @Override public void keyPressed(KeyEvent e){int keycode = e.getKeyCode();
                //region 1)---printGameDeBugger---
                printGameDeBugger.delete(0,printGameDeBugger.length());
                printGameDeBugger.append("PrintGame -> GameStateBefore(").append(gameState).append(") / ");
                //printGameDeBugger.append("KeyPressed BEFORE Listner:("+getKeyPressed()+") / "); //detects to see if key changed at any point in code
                //endregion
                //region 2)---Assigning Keys---
                switch(keycode){
                    case KeyEvent.VK_LEFT-> {changeKeyPressed("LEFT");}
                    case KeyEvent.VK_RIGHT->{changeKeyPressed("RIGHT");}
                    case KeyEvent.VK_UP->   {changeKeyPressed("UP");}
                    case KeyEvent.VK_DOWN-> {changeKeyPressed("DOWN");}
                    case KeyEvent.VK_ENTER->{changeKeyPressed("ENTER");}
                    case KeyEvent.VK_B->    {changeKeyPressed("B");}
                    case KeyEvent.VK_F->    {changeKeyPressed("F");}
                    case KeyEvent.VK_S->    {changeKeyPressed("S");}
                    default -> {changeKeyPressed("N/A");}
                }
                //System.out.print("X:"+background.getXCords()+"    Y:"+background.getYCords()); //DEBUGGER FOR BACKGROUND
                //endregion
                //region 3)---Ending Process---
                printGameDeBugger.append("KeyPressed AFTER Listner:("+getKeyPressed()+") / ");
                gameProcessor();
                //endregion

            }@Override public void keyReleased(KeyEvent e) {}
        };windowInfo.getJframe().addKeyListener(listener); //adds keylistner to JFrame
    }
    //endregion
    //region C)--------------------!BIG gameProcessor    w/Summary
                    /*Summary: The gameProcessor Check the game state and runs code accordingly (The brains of the code) ->
     1) Will: PrintLevel for every game state
     2) Will: Move Player when a valid movement key is pressed & change level when needed
     3) Has: DeBugger for each class and other debugging misc
     4) Upon completion will have successfully printed out
     */
    public void gameProcessor(){
      if(Text.getIsTextDone() && !Text.getTBSelectActiveState()){
          text.changeText(" ");
        switch(gameState)
        {
            case "LEVEL"-> {
                if(validMoveKeys.contains(getKeyPressed())) {
                    Movement.receiveMovement(getKeyPressed(), Levels.getCurrentLevelTemp(), Levels.getCurrentLevel());
                    Movement.movePlayer();
                    text.createText(" ");
                    levels.LEVELCHANGE();
                }
                else if(getKeyPressed().equals("B"))
                {
                    Bag.bagUpdater();
                    levels.saveLevel(Levels.getLEVELNAME()); gameState="BAG";
                    Bag.changeBagPageState("IB1");bag.navigation("N/A");
                    Bag.changeCurrentBox(1);
                    text.createText(" ");
                }
                else if(getKeyPressed().equals("ENTER")){
                    synchronized(runner.getGameRunClass()) {runner.getGameRunClass().notifyAll();}
                }
                else if(getKeyPressed().equals("S")){ gameState="shapeDeBugger"; background.toggleTest(true);}

            }
            case "BAG"->{
                if(validMoveKeys.contains(getKeyPressed())){bag.navigation(getKeyPressed());text.createText(" ");}

                else if(getKeyPressed().equals("B")){
                    levels.changeLevel(Levels.getLEVELNAME());gameState="LEVEL";
                    bag.navigation("N/A");
                    text.createText(" ");
                }
                else if(getKeyPressed().equals("ENTER")){
                    synchronized(runner.getGameRunClass()) {runner.getGameRunClass().notifyAll();}}
            }
            case "shapeDeBugger"->{
                switch(keyPressed){
                    case "LEFT"  -> { background.leftXCords();}
                    case "RIGHT" -> { background.rightXCords();}
                    case "UP"    -> { background.upYCords();}
                    case "DOWN"  -> { background.downYCords();}
                    case "ENTER" -> {
                        switch (background.getShapeState()){
                            case 0 ->{
                                System.out.println(" STAGE 1 -> X ["+background.getXCords()+"]   "+" Y ["+background.getYCords()+"]   ");
                                background.changeShapeState(1);
                                //System.out.println("PRINT GAME -> X CORD"+tempXCord+"     Y CORD"+tempYCord);
                                background.changeTempCords(background.getXCords(),background.getYCords());
                            }
                            case 1 ->{background.changeShapeState(2);
                                System.out.println("STAGE 2 -> X ["+background.getXCords()+"]   "+" Y ["+background.getYCords()+"]   ");
                                System.out.println(
                                        " Temp X ["+background.getTempXCords()+"]   "
                                                +" Temp Y ["+background.getTempYCords()+"]   "
                                                +" Temp Width ["+(background.getXCords())+"]   "
                                                +" Temp Height["+(background.getYCords()+"]"));

                                System.out.println("g.fillRect("
                                        +background.getTempXCords()+","+background.getTempYCords()+","
                                        +background.getXCords()+"," +background.getYCords()+");");
                            }
                            case 2 ->{background.changeShapeState(0);
                                background.changeCords(background.getXCords()+15,background.getYCords()+20);
                            }
                        }
                    }
                    case "F"     -> {
                        if(background.getMoveNum()==background.getMoveFastNum()){
                     background.changeMoveNum(background.getMoveNumPerm());
                    }else{ background.changeMoveNum(background.getMoveFastNum());}
                    }
                    case "S"->{gameState="LEVEL"; background.toggleTest(false);}
                }
            }
            case "MAIN MENU"->{}
        }
      }
      else if (text.getTBSelectActiveState()&&text.getIsTextDone()){text.confirmSelection();
          if(getKeyPressed().equals("ENTER")){text.changeTBSelectActiveState(false);}
      }
        gameStateSwitcher(); //Makes it so the what is displayed is = to the proper arrays
        printLevel();
        //DEBUGGER: USE THIS WHEN WANTING TO CHECK CERTAIN CLASS AND OTHER IMPORTANT INFO
        DeBugger.misc(false, false, false, false,
                false, false);
        DeBugger.classes(false, false, false, false, false, false);



        //NOTE: have gameStateSwitcher & printLevel inside ifs because so when press any key wont print level saving resources

    }
//endregion
    // region D)--------------------!BIG:printLevel       w/Summary
                        /*Summary: This Method is how game show up how colors are added
     1)Will: Declared Strings for each part the needs to be in 1 row
     2)Will: Call what is assigned to |gameArray|(modified in |gameStateSwitcher|) and will string together (For Loops)
     the declared Strings from before, reassigning them.
     3)Will: get JFrame rows and update them to the Strings in step 2
     4)Will: set each character inside each row to a color (color determind by |colorLEVELRows| method)
     5)Upon: Completion will print out debugger and change hasPrinted(used to not print if not nessessary) to true
     6)Has: a method that will taken in any character and depending on the level ill change colors
     7)Has: a method that will randomly change colors attached to |colorLEVELRows|
     8)Has: a Change method that causes the text box to change at will of other classes
     */
    public void printLevel(){
        //region 1) ---Declared Variables---
        String tBord = "", row01 = "", row02 = "", row03 = "", row04 = "", row05 = "";
        String row06 = "", row07 = "", row08 = "", row09 = "", row10 = "", BBor = "";
        String row11 = "", row12 = "", row13 = "", row14 = "", row15 = "";
        String row16 = "", row17 = "", row18 = "", row19 = "", row20 = "";
        String TSM = "", SMrow01 = "", SMrow02 = "", SMrow03 = "", SMrow04 = "", SMrow05 = "";
        String SMrow06 = "", SMrow07 = "", SMrow08 = "", SMrow09 = "", SMrow10 = "", BSM = "";
        //endregion
        //region 2) ---Array to String Loop---
        for (int i = 0; i < numOfColomsMA; i++) {
            tBord += gameArray.get(i);
            row01 += gameArray.get(i + numOfColomsMA);
            row02 += gameArray.get(i + numOfColomsMA * 2);
            row03 += gameArray.get(i + numOfColomsMA * 3);
            row04 += gameArray.get(i + numOfColomsMA * 4);
            row05 += gameArray.get(i + numOfColomsMA * 5);
            row06 += gameArray.get(i + numOfColomsMA * 6);
            row07 += gameArray.get(i + numOfColomsMA * 7);
            row08 += gameArray.get(i + numOfColomsMA * 8);
            row09 += gameArray.get(i + numOfColomsMA * 9);
            row10 += gameArray.get(i + numOfColomsMA * 10);
            row11 += gameArray.get(i + numOfColomsMA * 11);
            row12 += gameArray.get(i + numOfColomsMA * 12);
            row13 += gameArray.get(i + numOfColomsMA * 13);
            row14 += gameArray.get(i + numOfColomsMA * 14);
            row15 += gameArray.get(i + numOfColomsMA * 15);
            row16 += gameArray.get(i + numOfColomsMA * 16);
            row17 += gameArray.get(i + numOfColomsMA * 17);
            row18 += gameArray.get(i + numOfColomsMA * 18);
            row19 += gameArray.get(i + numOfColomsMA * 19);
            row20 += gameArray.get(i + numOfColomsMA * 20);
            BBor += gameArray.get(i + numOfColomsMA * 21);
        }
        for (int i=0; i <numOfColomsSM; i++)    {
            TSM    += levels.getSM().get(i);
            SMrow01 += levels.getSM().get(i + numOfColomsSM);
            SMrow02 += levels.getSM().get(i + numOfColomsSM * 2);
            SMrow03 += levels.getSM().get(i + numOfColomsSM * 3);
            SMrow04 += levels.getSM().get(i + numOfColomsSM * 4);
            SMrow05 += levels.getSM().get(i + numOfColomsSM * 5);
            SMrow06 += levels.getSM().get(i + numOfColomsSM * 6);
            SMrow07 += levels.getSM().get(i + numOfColomsSM * 7);
            SMrow08 += levels.getSM().get(i + numOfColomsSM * 8);
            SMrow09 += levels.getSM().get(i + numOfColomsSM * 9);
            SMrow10+= levels.getSM().get(i + numOfColomsSM * 10);
            BSM    += levels.getSM().get(i + numOfColomsSM * 11);
        }
        //endregion
        //region 3) ---GET: rows and reassign JFrame Rows---
        windowInfo.replaceRow("hud00",hud.getHud00());
        windowInfo.replaceRow("hud01",hud.getHud());
        windowInfo.replaceRow("tBord",(tBord+TSM));
        windowInfo.replaceRow("row01",(row01+SMrow01));windowInfo.replaceRow("row02",(row02+SMrow02));
        windowInfo.replaceRow("row03",(row03+SMrow03));windowInfo.replaceRow("row04",(row04+SMrow04));
        windowInfo.replaceRow("row05",(row05+SMrow05));windowInfo.replaceRow("row06",(row06+SMrow06));
        windowInfo.replaceRow("row07",(row07+SMrow07));windowInfo.replaceRow("row08",(row08+SMrow08));
        windowInfo.replaceRow("row09",(row09+SMrow09));windowInfo.replaceRow("row10",(row10+SMrow10));
        windowInfo.replaceRow("row11",(row11));windowInfo.replaceRow("row12",(row12));
        windowInfo.replaceRow("row13",(row13));windowInfo.replaceRow("row14",(row14));
        windowInfo.replaceRow("row15",(row15));windowInfo.replaceRow("row16",(row16));
        windowInfo.replaceRow("row17",(row17));windowInfo.replaceRow("row18",(row18));
        windowInfo.replaceRow("row19",(row19));windowInfo.replaceRow("row20",(row20));
        windowInfo.replaceRow("bBord",(BBor+BSM));
        //endregion
        //region 4) ---Color chars---
        switch(gameState) {
            case "LEVEL" -> {
                colorLevelRows(windowInfo.getCrow("01"), row01);
                colorLevelRows(windowInfo.getCrow("02"), row02);
                colorLevelRows(windowInfo.getCrow("03"), row03);
                colorLevelRows(windowInfo.getCrow("04"), row04);
                colorLevelRows(windowInfo.getCrow("05"), row05);
                colorLevelRows(windowInfo.getCrow("06"), row06);
                colorLevelRows(windowInfo.getCrow("07"), row07);
                colorLevelRows(windowInfo.getCrow("08"), row08);
                colorLevelRows(windowInfo.getCrow("09"), row09);
                colorLevelRows(windowInfo.getCrow("10"), row10);
                colorLevelRows(windowInfo.getCrow("11"), row11);
                colorLevelRows(windowInfo.getCrow("12"), row12);
                colorLevelRows(windowInfo.getCrow("13"), row13);
                colorLevelRows(windowInfo.getCrow("14"), row14);
                colorLevelRows(windowInfo.getCrow("15"), row15);
                colorLevelRows(windowInfo.getCrow("16"), row16);
                colorLevelRows(windowInfo.getCrow("17"), row17);
                colorLevelRows(windowInfo.getCrow("18"), row18);
                colorLevelRows(windowInfo.getCrow("19"), row19);
                colorLevelRows(windowInfo.getCrow("20"), row20);
            }
            case "BAG" -> {
                bag.bagColorer(
                        windowInfo.getCrow("01"),windowInfo.getCrow("02"),windowInfo.getCrow("03"),windowInfo.getCrow("04"),
                        windowInfo.getCrow("05"),windowInfo.getCrow("06"),windowInfo.getCrow("07"),windowInfo.getCrow("08"),
                        windowInfo.getCrow("09"),windowInfo.getCrow("10"),windowInfo.getCrow("11"),windowInfo.getCrow("12"),
                        windowInfo.getCrow("13"),windowInfo.getCrow("14"),windowInfo.getCrow("15"),windowInfo.getCrow("16"),
                        windowInfo.getCrow("17"),windowInfo.getCrow("18"),windowInfo.getCrow("19"),windowInfo.getCrow("20"));
            }
        }


        //endregion
        //region 5) ---PrintGame DeBugger---
        hasPrintedChange(true);
        printGameDeBugger.append("Has Print:("+hasPrinted()+") / "+"GameStateAfter("+gameState+") / "); //add to PrintClass DeBugger
        if(DeBugger.printClass()){System.out.println(printGameDeBugger);}//Prints debugger for class
        //endregion
    }
        //region 6) ---GET: Color acording to Char
    public void colorLevelRows(StyledDocument colorRow,String row){
        for (int i = 0; i < 42; i++) {
            colorRow.setCharacterAttributes(i, 1, colorLEVELRows(row.charAt(i)),true);}
    }
    public SimpleAttributeSet colorLEVELRows(char character){
        SimpleAttributeSet black     = new SimpleAttributeSet();StyleConstants.setForeground(black,    new Color(0, 0, 0));
        SimpleAttributeSet white     = new SimpleAttributeSet();StyleConstants.setForeground(white,    new Color(225, 225, 225));
        SimpleAttributeSet shinyGold = new SimpleAttributeSet();StyleConstants.setForeground(shinyGold,new Color(255, 215, 0));
        SimpleAttributeSet blue      = new SimpleAttributeSet();StyleConstants.setForeground(blue,getRandomColors("WATER"));
        SimpleAttributeSet brown     = new SimpleAttributeSet();StyleConstants.setForeground(brown    ,new Color(150, 75, 1));
        SimpleAttributeSet green     = new SimpleAttributeSet();StyleConstants.setForeground(green,getRandomColors("GRASS"));
        SimpleAttributeSet lowYellow = new SimpleAttributeSet();StyleConstants.setForeground(lowYellow,new Color(242,209,107));
        switch(Levels.getLEVELNAME())//depending on which level in, change char color
        {case"MAIN AREA"->{
            switch(character) {
                case ',' -> {return green;}
                case '.' -> {return brown;}
                case '*' -> {return shinyGold;}
                case '~' -> {return blue;}
                case ':' -> {return lowYellow;}
            }
        }case"HOUSE"    ->{}
        }
        return black;
    }
    //endregion
        //region 7) ---GET: RandomColor
    public Color getRandomColors(String toColor) { //this makes random colors that will be assigned to a StyleConstant.setForeground
        switch (toColor) {
            case "GRASS" -> { //Will get various colors of green
                switch(((int)(Math.random()*20)+1)){
                    case 1->{ return new Color(34, 153, 34);}// has 1/10 grass=this color
                    case 2->{ return new Color(32, 200, 32);}// has 1/10 grass=this color
                    default ->{return new Color(7, 165, 7); }// has 8/10 grass=this color
                }
            }
            case "WATER" -> { //Will get various colors of green
                switch(((int)(Math.random()*20)+1)){
                    case 1->{ return new Color(46, 98, 158);}
                    case 2->{ return new Color(82, 88, 250);}
                    default ->{return new Color(62, 68, 246);}
                }
            }
            case "Filler"->{}
        }
        return new Color(1,1,1);
    }
    //endregion
        //region 8)---CHANG: textBoxes
    public static void changeTBox1(String arrayString){windowInfo.getTbox(1).setText(arrayString);}
    public static void changeTBox2(String arrayString){windowInfo.getTbox(2).setText(arrayString);}
    public static void changeTBox3(String arrayString){windowInfo.getTbox(3).setText(arrayString);}
    public static void changeTBoxB(String arrayString){windowInfo.getTbox(4).setText(arrayString);}
    //endregion
    //endregion

/*------------------------------------------------Other---------------------------------------------------------------*/
            /*
            public static PrintGame[] classObj = new PrintGame [10];
            public static void getObject(String CLASS){
                classObj[0] = getLevels();
              switch(CLASS){
                  case "PrintGame"->{ return classObj[0] = new PrintGame();

                  }
              }


                return
            }
*/



            //region ---GET: & CHANG: keyPressed
    public static String getKeyPressed() {return keyPressed; }
    public static void changeKeyPressed(String temp){ keyPressed=temp; }
    //endregion
    //region ---!CHANG: gameArray depending on gameState
    public static String getGameState(){return gameState;}
    public void gameStateSwitcher() {
        switch(gameState){
            case"LEVEL"->{gameArray=Levels.getCurrentLevelTemp();}
            case"BAG"  ->{gameArray=Bag.getCurrentBagPage();}
        }
    }
    //endregion
    //region ---GET: & CHANG: hasPrinted
    public static boolean hasPrinted() {return hasPrinted; }
    public static void hasPrintedChange(boolean temp){ hasPrinted=temp;}

    public void changeGameState(String temp){gameState=temp;}

    //endregion

}


