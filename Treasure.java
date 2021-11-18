import java.util.ArrayList;

public class Treasure {
/*--------------------------------------Declare/Call/Iniltize Varaibles-----------------------------------------------*/
    //region ---Misc: Assign Vars To Classes---
    static Text text = new Text();
     Levels getLevels = new Levels();
     Bag bag = new Bag();
     HudAndUI hud=new HudAndUI();
     TextLib textLib = new TextLib();
    //endregion
    //region ---D&I Vars & Arrays
    static ArrayList<String> tempRay = new ArrayList<>();
    static String customText="";
    static int symbolInteraction;
    static boolean goldCoin=false;
    static Integer money = 0;
    //endregion
/*------------------------------------------Main Parts of Code--------------------------------------------------------*/
    //region A)--------------------!BIG:Treasure Text Interactions   w/Summary
/*Summary: When called, ussally when intracts with a treasure and text is needed, checks to see what level the player is on
  Then calls designated interaction and outputs text given to Text class
1) Checks to see what level player on and calls a interaction method
2) Contains all the interactions organized by level (might put in differnt class as would get long)

*/
    //region 1)---Treasure Checker---
    public void treasureChecker(){ //gets interactions w/treasure
        switch(getLevels.getLEVELNAME()) {
            case "MAIN AREA" -> { mainAreaInteractions(); }
            case "HOME"->       { homeInteractions();}
            default -> {customText="                         ";}
        }
    }
    public String getCustomText(){return customText;}
    //endregion
    //region 2)---Level Interactions---
    //region Main Area
    static int goldCoinIC=1;
    public void mainAreaInteractions(){
        symbolInteraction=text.getIntractableVarPos();
        if(symbolInteraction==816&&text.getIntractableVar().equals("*")){
            if(bag.playerHas("SHOVEL")&&goldCoinIC==1){customText=textLib.getDigGoldCoin("2.0");goldCoinIC=2;
            }else if(goldCoinIC==2){//DO HAVE SHOVEL AND HITS ENTER AGAIN
                customText= textLib.getDigGoldCoin("2.1");changePlayerHas("GOLD COIN",true);
                tempRay=text.getTempArray(); tempRay.set(816,"X"); getLevels.changeCurrentLevelTemp(tempRay); // REPLACES TREASURE SYMBOL W/"X"
                hud.changeMainAreaTreasureCounter(); money+=999; goldCoinIC=3;
            }else if(!playerHas("SHOVEL")){customText=textLib.getDigGoldCoin("1.0");
            }else{customText="           ";}
        }
        else{customText="           ";}
    }
    //endregion
    //endregion
    //endregion
    //region B)--------------------Check Player Treasure             w/Summary
/*Summary: Methods that either check to see if player has a certain treasure or changes if player has it.
1) D&I all variables the player could have
2) Check to see if Player has a certain treasure and returns a boolean
3) Change if a player has a certain item
*/
    //region 1)---D&I Treasure---

    //endregion
    // region 2)---GET: see if player has a treasure---
    public boolean playerHas(String treasure){
        switch(treasure){
            case"GOLD COIN"->{return goldCoin;}
        }
        return false;
    }
    //endregion
    //region 3)---CHANG: if player has a treasure---
    public boolean changePlayerHas(String treasure, boolean temp){
        switch(treasure){
            case"GOLD COIN"->{goldCoin=temp;}
        }
        return false;
    }
    //endregion
    //endregion
    public void homeInteractions(){symbolInteraction=text.getIntractableVarPos();} //receives what symbol was interacted with
    public void changeMoney(String ADDorSUB,int num){if(ADDorSUB.equals("ADD")){money+=num;}else{money-=num;}}
    public Integer getMoney(){return money;}
}