import java.util.ArrayList;

public class Text {
/*---------------------------------------------WHAT TO KNOW----------------------------------------------------*//*
1)contains all the text needed for each interaction or every text that will appear in the text box
2)create a sliding text when text is being displayed
*/
/*--------------------------------------Declare/Call/Initialize/Variables---------------------------------------------*/
    //region Class vars
     TextLib textLib = new TextLib();
     Treasure treasurerText = PrintGame.getTreasure();
    Bag bag = PrintGame.getBag();
    //endregion
    //region D&I Vars
    static int intractableVarPos=0;
    static String text = "";
    static int symbolInteraction=0;
    static String interactCord="";
    static String intractableVar ="";
    static ArrayList<String> tempArray = new ArrayList<>();
    static ArrayList<String> voidTempArray = new ArrayList<>();
    static int dadIC=1;
    static boolean isTextDone=true;
    static String PD="";
    static boolean TBSelectActive=false;
    static boolean runCreateText = true;
    String space="                                                                                                                  ";//38 *3 spaces
    //endregion
    static StringBuilder textDeBugger = new StringBuilder();

/*------------------------------------------Main Parts of Code--------------------------------------------------------*/
    //region A)--------------------!Interactions W/GET methods
    public void getTextInteractions() {
        switch(PrintGame.getGameState()){
            case "LEVEL"->{
                switch(Levels.getLEVELNAME()){
                    case "MAIN AREA"->{getMainAreaText();}
                    case "HOME"->{getHomeText();}
                    case "SHOP"->{getShopText();}
                    default -> text="";
                }
            }
            case "BAG"->{getBagText();}
            case "MAIN MENU"->{}
        }
    }
    //Note: "IC" standands for Interaction Chain  && when IC=0 is its default phrase
    //region MainArea Interactions
    public void getMainAreaText(){
        symbolInteraction=getIntractableVarPos();
        switch(symbolInteraction){
            //DAD TEXT
            case 845->{
                switch(dadIC) {
                    case 1 -> {text=textLib.getDadSpeak("1.0");dadIC=2;
                        Bag.changePlayerHas("SHOVEL",true); /*Give Shovel*/
                    }case 2 ->{ if(treasurerText.playerHas("GOLD COIN")){dadIC=3;
                        text= textLib.getDadSpeak("2.0");}
                    else{text=textLib.getDadSpeak("2.1");}
                    }
                    case 3->{text=textLib.getDadSpeak("3.0");;}
                }
            }
            case 846->{ text=textLib.getMomSpeak("1.0");}
            case 816->{
                treasurerText.treasureChecker();
                text=treasurerText.getCustomText();
            }
            default -> {text="                                         ";}
        }
    }
    //endregion
    //region Home Interactions
        //region Vars & CordVars

    static String playerChestPos="|878|837|"         ,playerBedPos="|874|875|876| ",playerClosetPos="|795| ";
    static String parentChestPos="|709|668|669|712| ",parentBedPos="|664|665|666| ",parentMirrorPos="|586| ";
    static String bathroomToilet="|497|"             ,bathroomShower="|456|";
    static String kitchenStove  ="|441|442|443|444|" ,kitchenFridge="|448|449| ";
    static String mainRoomTable ="|697|698|699|700|701|702|654|660|616|615|",
                  mainRoomCouch ="|819|820|821|822|823|778|779|780|";
    //endregion
    public void getHomeText(){
        symbolInteraction=getIntractableVarPos();
        interactCord="|"+symbolInteraction+"|";
        //region Sections of house
        //region PLayer Bed Room
        if(playerBedPos.contains(interactCord)){text=textLib.getHomeThink         ("@ BED 1.0"   );}
        else if(playerClosetPos.contains(interactCord)){text=textLib.getHomeThink ("@ CLOSET 1.0");}
        else if(playerChestPos.contains(interactCord)){text=textLib.getHomeThink  ("@ CHEST 1.0" );}
        //endregion
        //region Parent Bed Room
        else if(parentBedPos.contains(interactCord)){text=textLib.getHomeThink    ("M&D BED 1.0"   );}
        else if(parentMirrorPos.contains(interactCord)){text=textLib.getHomeThink ("M&D MIRROR 1.0");}
        else if(parentChestPos.contains(interactCord)){text=textLib.getHomeThink  ("M&D CHEST 1.0" );}
        //endregion
        //region Bathroom
        else if(bathroomToilet.contains(interactCord)){text=textLib.getHomeThink  ("BATHR TOILET 1.0");}
        else if(bathroomShower.contains(interactCord)){text=textLib.getHomeThink  ("BATHR SHOWER 1.0");}
        //endregion
        //region Kitchen
        else if(kitchenStove.contains(interactCord)){text=textLib.getHomeThink    ("KITCH STOVE 1.0");}
        else if(kitchenFridge.contains(interactCord)){text=textLib.getHomeThink   ("KITCH FRIDGE 1.0");}
        //endregion
        //region Main Room
        else if(mainRoomCouch.contains(interactCord)){text=textLib.getHomeThink   ("MAIN COUCH 1.0");}
        else if(mainRoomTable.contains(interactCord)){text=textLib.getHomeThink   ("MAIN TABLE 1.0");}
        //endregion
        //endregion
        else {text="                                         ";}
    }
    //endregion
    //region Shop Interactions
    static String shopOwnerPos  ="|655|";
    static String bootsPos  ="|853|";
    static int bootsIC=1;
    public void getShopText(){
        symbolInteraction=getIntractableVarPos();
        interactCord="|"+symbolInteraction+"|";
        if(bootsPos.equals(interactCord) && bootsIC==1){
            System.out.print("Text before if getShopText"+text);
            runCreateText=false;
            setSelectionText("Yes","No","Cancel","","","");
            confirmText(textLib.getShopBuyText("BOOTS"));TBSelectActive=true;
            text=selectTextFormatter();setSelectionTextMinMax(1,3);
            System.out.println("Text->TBSelectActive:"+TBSelectActive);
            System.out.print("Text before if getShopText"+text);
        }
    }
    //endregion
        public void getBagText(){
            String bagText = Bag.getBagPageState()+" "+Bag.getCurrentBox()+".0";
            System.out.print("BAG TEXT:"+bagText);
            text = textLib.getItemText(bagText);
            System.out.println("   WHAT IT SAY:"+text);
        }
        //endregion
    //region B)--------------------!Calculate Player Direction            w/Summary
                /*Summary: This code will take in the player direction & an array (both received from movement class)
                and see what variable it is looking at so if player where to ever press enter ti knows what it is
                interacting with
     1) Will: Calculate what varaible player is looking at (after movement is executed)
     2) Has : Debugger
     3) Has & Will: take info class/methods and create getter methods
     */
    public static void interactableCheck(String playerDirection, ArrayList<String> arrayTemp){ //gets what direction player facing
        //region 1)---Calculate var looking at---
        tempArray=arrayTemp;
        int playerPos=arrayTemp.indexOf("@");
        switch (playerDirection) {
            case "LEFT" ->{intractableVarPos=(playerPos-1); }
            case "RIGHT"->{intractableVarPos=(playerPos+1); }
            case "UP"   ->{intractableVarPos=(playerPos-42);}
            case "DOWN" ->{intractableVarPos=(playerPos+42);}
        }
        //endregion
        //region 2)---Debugger---
        intractableVar =arrayTemp.get(intractableVarPos);
        textDeBugger.delete(0,textDeBugger.length());
        textDeBugger.append("Text -> interactableCheck -> ");
        textDeBugger.append("Player Pos:("+playerPos+") / playerDirection:("+playerDirection+")");
        textDeBugger.append(" / intractableVarPos:("+intractableVarPos+") / intractableVar:("+ intractableVar +")");
        if(DeBugger.DBTextClass){System.out.println(textDeBugger);}
        //endregion
        //region 3.1)---Define vars for GET methods
        PD=playerDirection;
        voidTempArray=arrayTemp;
        //endregion
    }

        //region 3.2)---GET: terms in interaction check
    public String getPlayerDirection(){return PD;}
    public ArrayList<String> getTempArray(){return tempArray;}
    public ArrayList<String> getVoidTempArray(){return voidTempArray;}
    public static int getIntractableVarPos(){return intractableVarPos;}
    public String getIntractableVar(){return intractableVar;}
    //endregion

    //endregion

    //region C)--------------------!BIG:Creation of text                  w/Summary
                /*Summary: This will take |text| and will print with a delay the rows it needs to display
     1) Will: see what rows need wait until be displayed (NOTE THIS IS UNNECESSARY FIND FIX)
     2) Will: reset text box and display and generate scrolling text
     3) Has : Debugger
     */
    public void createText(){ //PRODUCE LIVE TEXT WHEN IN MAIN
        //region 1)---Checker for need to wait---
        boolean T1,T2,T3;
        if(text.trim().length()>37*2)   {T1=true ;T2=true ;T3=true ;}
        else if(text.trim().length()>37){T1=true ;T2=true ;T3=false;}
        else if(text.trim().length()>0) {T1=true ;T2=false;T3=false;}
        else                            {T1=false;T2=false;T3=false;}
        //endregion
        //region 2)---Text Creation & Reset er---
        text = text+"                                                                                                                                                    ";
        PrintGame.changeTBox1("|                                        |" + "          |");
        PrintGame.changeTBox2("|                                        |" + "          |");
        PrintGame.changeTBox3("|                                        |" + "          |");

        changeIsTextDone(false);
        for (int i = 0; i < 39; i++)  {PrintGame.changeTBox1("|" + text.substring(0, i+1)+space.substring(0,39-i)         + "|" + "          |");
            //make .05 wait time
            if(T1){try { Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}}
        }
        for (int i = 0; i < 39; i++)  {PrintGame.changeTBox2("|" + text.substring(39, i+39+1)+space.substring(0,39-i)     + "|" + "          |");
            if(T2){try { Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}}
        }
        for (int i = 0; i < 39; i++)  { PrintGame.changeTBox3("|" + text.substring(39*2, i+39*2+1)+space.substring(0,39-i)+ "|" + "          |");
            if(T3){try { Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}}
        }
        PrintGame.changeTBoxB("|________________________________________|" + "__________|");
        changeIsTextDone(true);
        text="";
        //endregion
        //region 3)---Debugger---
        textDeBugger.delete(0,textDeBugger.length());
        textDeBugger.append("Text -> createText");
        textDeBugger.append(" T1: ("+T1+") / T2:("+T2+") / T3:("+T3+") / ");
        textDeBugger.append("text:("+text.trim()+") / isTextDone("+isTextDone+") / ");

        if(DeBugger.DBTextClass){System.out.println(textDeBugger);}
        //endregion
    }
    public void createText(String quickDisplay){
        text = text+"                                                                                                                                                    ";
        for (int i = 0; i < 39; i++)  {
            PrintGame.changeTBox1("|" + text.substring(0, i)+space.substring(0,40-i)        + "|" + "          |");
            PrintGame.changeTBox2("|" + text.substring(38, i+38)+space.substring(0,40-i)    + "|" + "          |");
            PrintGame.changeTBox3("|" + text.substring(38*2, i+38*2)+space.substring(0,40-i)+ "|" + "          |");
        }
        PrintGame.changeTBoxB("|________________________________________|" + "__________|");
        text="";
    }
    //region Selection Text
    static String conSelText="";
    static int conSelBox=1;
    static int STMax=6,STMin=1;
    static String S1="",S2="",S3="",S4="",S5="",S6="";
    public void setSelectionTextMinMax(int mini, int maxi){STMin=mini;STMax=maxi;}
    public void setSelectionText(String T1, String T2, String T3, String T4, String T5, String T6){
        S1=T1;S2=T2;S3=T3;S4=T4;S5=T5;S6=T6;}
    //static String lSide="|1|3|5|",RSide="|2|4|6|",RSide="|2|4|6|",tSide="|1|0|",bSide="|5|6|";
    public void confirmText(String tempText){conSelText=tempText;}
//40 spaces
    public void confirmSelection(){
        String A1="  ",A2="  ",A3="  ",A4="  ",A5="  ",A6="  ";
        System.out.println("TBSelectActive:"+TBSelectActive);
        if(PrintGame.getKeyPressed().equals("LEFT") && conSelBox>STMin){conSelBox--;System.out.println("LEFT");}
        else if(PrintGame.getKeyPressed().equals("RIGHT") && conSelBox<STMax){conSelBox++;System.out.println("RIGHT");}
        else if(PrintGame.getKeyPressed().equals("UP") && conSelBox>3){conSelBox-=3;System.out.println("UP");}
        else if(PrintGame.getKeyPressed().equals("DOWN") && conSelBox<4 && STMax>=conSelBox+3){conSelBox+=3;System.out.println("DOWN");}
        conSelText+=space;
        PrintGame.changeTBox1("|"+conSelText.substring(0,39)+ " |" + "          |");
        switch(conSelBox){
            case 1->{A1="->";} case 2->{A2="->";} case 3->{A3="->";}
            case 4->{A4="->";} case 5->{A5="->";} case 6->{A6="->";}
        }
        //40  -6 (strating spaces) -3 ending spaces  | 13-2
        PrintGame.changeTBox2("|"+
                A1+S1+space.substring(0,10-(S1.length()))+" "+
                A2+S2+space.substring(0,11-(S2.length()))+" "+
                A3+S3+space.substring(0,10-(S3.length()))+" |"+"          |");
        PrintGame.changeTBox3("|"+
                A4+S4+space.substring(0,10-(S4.length()))+" "+
                A5+S5+space.substring(0,11-(S5.length()))+" "+
                A6+S6+space.substring(0,10-(S6.length()))+" |"+"          |");
        PrintGame.changeTBoxB("|________________________________________|" + "__________|");
        if(PrintGame.getKeyPressed().equals("ENTER")){
            conSelBox=1;createText("");
          switch(Levels.getLEVELNAME()){
            case "SHOP"->{Bag.shopSelect(selectReturner());
                Levels.currentLevel.set(852,"#");Levels.currentLevelTemp.set(852,"#");}
          }
        }
    }
    public String selectReturner(){
      switch(conSelBox){
        case 1->{return S1;} case 2->{return S2;} case 3->{return S3;}
        case 4->{return S4;} case 5->{return S5;} case 6->{return S6;}
          default -> {return "ERROR!!!!!!!!!!!!!!!!!!!!";}
      }
    }
    public String selectTextFormatter(){
        conSelText+=space;
        return conSelText.substring(0, 39)+
              "->"+S1+space.substring(0,10-(S1.length()))+" "+
              "  "+S2+space.substring(0,11-(S2.length()))+" "+
              "  "+S3+space.substring(0,10-(S3.length()))+""+
              "  "+S4+space.substring(0,10-(S4.length()))+" "+
              "  "+S5+space.substring(0,11-(S5.length()))+" "+
              "  "+S6+space.substring(0,10-(S6.length()))+" ";
    }
    //endregion
    //public void selectExecutor(){ }

    public static boolean getIsTextDone(){return isTextDone;}
    public void changeIsTextDone(boolean TorF){isTextDone=TorF;}
    public void changeText(String temp){text=temp;}
    public String getText(){return text;}
    public static boolean getTBSelectActiveState(){return TBSelectActive;}
    public boolean getRunCreateText(){return runCreateText;}
    public void changeRunCreateText(boolean temp){runCreateText=temp;}
    public void changeTBSelectActiveState(boolean TorF){TBSelectActive=TorF;}
    public void resetText(){text="";}
    public void PPBootsIC(){bootsIC=2;}
    public int getPPBootsIC(){return bootsIC;}
    //endregion
}

