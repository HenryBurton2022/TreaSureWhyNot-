public class GameRun {
/*---------------------------------------------WHAT TO KNOW----------------------------------------------------*//*
1) THIS makes everything run
*/
/*--------------------------------------Declare/Call/Iniltize Varaibles-----------------------------------------------*/
    //region ---Misc: Assign Var To CLasses---
    static PrintGame print = new PrintGame();
    static Text text = new Text();
    //endregion
    //region Synchronized necessities
    static final GameRun runner = new GameRun();
    static final PrintGame printGame = new PrintGame();
    public GameRun getGameRunClass(){return runner;}
    //endregion

    public static void main(String[] args) throws InterruptedException {
        if (print.getDoneWStartup()){
            synchronized (runner) {runner.wait();} //create the scrolling text NOTE: find way to produce live printing text w/out being inside main
            text.interactableCheck(text.getPlayerDirection(),text.getVoidTempArray());
            text.getTextInteractions();
            text.createText();
            synchronized(printGame.getPrintGameClassObject()) {printGame.getPrintGameClassObject().notifyAll();}
        }
        else {
            System.out.println("WENT THROUGH ELSE!!!!!!");
            print.startOfGame();
            print.getKeyListener();
            print.printLevel();
            PrintGame.changeKeyPressed("N/A"); //adding this because if don't bugs accrue
            print.changeDoneWStartup(true);

            //add keylisten and only display what key was pressed
        }
        GameRun.main(null);
    }
}

/*


TODO
-------------STUFF TO LEARN-----------
find out more about setCharacterAttributes and what u can do with it
LOOK UP HOW TO COLLAPSE ALL REGIONS


-----------Stuff to fully add--------------
ADD: CONTROL CENTER where can change starting level/items i cheat in/Toggle debugger/
ADD: so when done w/text and > than max storage cut out last 5 chars add" --->"
ADD: Level editor class where everything needed to create the game is added so don't have to find it.
    OR: Mark them with a sign of some sort
ADD: for each level add walkable surface because some are walkable and some arent
ADD: TABLE DIALOG
CAN: add a layer in between background & text and add very similar to front layer so can use characters w/awkward spacing
ADD: the shop level & a option game state where textbox now becomes a thing where can select options presented
ADD: A gameState and level called loading where it waits 2.5 seconds then continues putting up a thing called loading
ADD: TILDA AND HYPHIN=STILL WATER
ADD SO WHEN IN BAG STATE HUD IS REPLACED W/CURRENT INFO ON BAG PAGE AND STUFF
ADD Mini Map
ADD MENU
ADD when all treasure is gotten in the area it text of hud indiactor turns green
---MAYBE ADD.............
ADD: grass to move across insted of random

----------Things to change/minor add ----------
CHANGE: make it so when move clear text
make it so when text exceeds box cap print and put rest of text
    COULD MAE A SEPERATE GAME STATE CALLED TEXT WHERE DISABLES MOVEMENT AND CUTS OFF THE TEXT SETING ENTER --> AT THE END
    AND IF PRESS ENETER THEN GOES TO NEXT AREA AND CHANGE GAME STATE
        if length is > than text box cut off & add add ENTER --> grab substring of not displayed text insert it over again and keep sutracting substring until <textbox limit
        once that is true make game state = Level
make non editable text in JFRAME
Instead of lines of code when switch states make a method called EX:enterBagState and run code need to start up that task

-------------------BUGS--------------------
Pressing enter when game starts breaks game
text will presist after walking CLEAR TEXT
WHEN CHANGING TO BAG NOT WORK
picking up treasure and (I think having active dialogue)
when dialouge activated and go into different section pressing enter again will interact with latest interactions
    NOTE: will be fixed when freeze player until done w/text
------------------INEFFICIENT CODE/what to tidy up----------
Bag.B.2 (Check notes) w/Bag.C.2
CHANGE OBJECT NAMES SO INSTEAD OF bag.bagColor DO bag.color
Class Print 159
JFRAME 67-132
    make it so it just addRows as it is only being declared in once
    Look up String builder to simplify PrintGame 117 for loops
Treasure.mainAreaInteractions <---
LevelsLib --> make it so not every row has own array just make 1 and assign it
MAKE BAG UPDATER CHECK TO SEE IF ALREADY HAVE ARRAY MODIFIED SO SAVES RESOURCES



-------------Game Design-----------
 HAVE PARETNS LEAVE AFTER GET FIRST TREASURE AND UNLOCK OTHER AREAS/GET OUT OF TUTORIAL


 HOW TO CREATE...
   To create a new level need to...
    1)
   To create item
    1)
   To create

 */

