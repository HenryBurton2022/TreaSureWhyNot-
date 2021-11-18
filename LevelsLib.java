import java.util.ArrayList;
import java.util.Arrays;

public class LevelsLib {
    //region Declaring Vars
    static String W="|" , b="-" , B="_";                        /*Borders or intangable*/
    static String g="," , G="." , E=" " , h="H", c=":";         /*walkable surface*/    static String walkableSurface = g+G+E+h;
    static String w="~";                                        /*walkable surface W/item*/
    static String p="@" , e="=";                                /*special types*/
    static String D="&" , M="%";                                /*NPC*/
    static String X="*";                                        /*treasure icons*/
    static String d="$";                                        /*icons*/
    static String LEVELNAME="";
    static String LCVAR="";
    static String P="+";
    static String mainAreaLCVars="="+"$";
    static String homeLCVars="=";
    //endregion
    //region class misc
    //endregion
    //region Arrays
    static ArrayList<String> mainAreaTemp = new ArrayList<>();static ArrayList<String> mainAreaPerm = new ArrayList<>();
    static ArrayList<String> homePerm = new ArrayList<>();    static ArrayList<String> homeTemp = new ArrayList<>();
    static ArrayList<String> shopPerm = new ArrayList<>();    static ArrayList<String> shopTemp = new ArrayList<>();
    static ArrayList<String> sMArray = new ArrayList<>();
    //endregion

    //region A)--------------------Create Levels + GET & CHANG: methods
    //region template
    String [] templateTemp= new String[]{
//    |       00's      |        10's       |        20's       |        30's       | 40's|
/*Rows|1|2|3|4|5|6|7|8|9|0|1|2|3|4|5|6|7|8|9|0|1|2|3|4|5|6|7|8|9|0|1|2|3|4|5|6|7|8|9|0|1|2|   */
/*01*/ W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W,
/*02*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*03*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*04*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*05*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*06*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*07*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*08*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*09*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*10*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*11*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*12*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*13*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*14*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*15*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*16*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*17*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*18*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*19*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*20*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*21*/ W,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,p,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*22*/ W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,e,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W};
    //endregion
    public LevelsLib(){
        //region Areas
            //region MAIN AREA
        String [] tBord= new String[]{W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W};
        String [] row01= new String[]{W,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,W};
        String [] row02= new String[]{W,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,W};
        String [] row03= new String[]{W,G,G,G,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,W};
        String [] row04= new String[]{W,g,g,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,W};
        String [] row05= new String[]{W,g,g,g,g,g,g,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,W};
        String [] row06= new String[]{W,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,W};
        String [] row07= new String[]{W,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,W};
        String [] row08= new String[]{W,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,W};
        String [] row09= new String[]{W,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,W};
        String [] row10= new String[]{W,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,W};
        String [] row11= new String[]{W,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,W};
        String [] row12= new String[]{W,g,g,W,d,W,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,W};
        String [] row13= new String[]{W,g,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,g,g,g,g,g,g,g,g,g,g,W};
        String [] row14= new String[]{W,g,g,g,g,g,g,g,g,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,g,g,g,g,g,g,g,g,g,g,g,W};
        String [] row15= new String[]{W,g,g,g,g,g,g,g,g,G,G,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,W};
        String [] row16= new String[]{W,g,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,c,c,W};
        String [] row17= new String[]{W,g,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,c,w,w,W};
        String [] row18= new String[]{W,g,g,g,g,g,g,G,G,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,c,w,w,w,W};
        String [] row19= new String[]{W,g,g,G,p,G,G,G,g,g,g,g,g,g,g,g,g,g,X,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,c,w,w,w,w,W};
        String [] row20= new String[]{W,g,W,e,W,D,M,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,c,w,w,w,w,w,W};
        String [] bBord = new String[]{W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W};
        mainAreaTemp.addAll(Arrays.asList(tBord));mainAreaTemp.addAll(Arrays.asList(row01));mainAreaTemp.addAll(Arrays.asList(row02));
        mainAreaTemp.addAll(Arrays.asList(row03));mainAreaTemp.addAll(Arrays.asList(row04));mainAreaTemp.addAll(Arrays.asList(row05));
        mainAreaTemp.addAll(Arrays.asList(row06));mainAreaTemp.addAll(Arrays.asList(row07));mainAreaTemp.addAll(Arrays.asList(row08));
        mainAreaTemp.addAll(Arrays.asList(row09));mainAreaTemp.addAll(Arrays.asList(row10));mainAreaTemp.addAll(Arrays.asList(row11));
        mainAreaTemp.addAll(Arrays.asList(row12));mainAreaTemp.addAll(Arrays.asList(row13));mainAreaTemp.addAll(Arrays.asList(row14));
        mainAreaTemp.addAll(Arrays.asList(row15));mainAreaTemp.addAll(Arrays.asList(row16));mainAreaTemp.addAll(Arrays.asList(row17));
        mainAreaTemp.addAll(Arrays.asList(row18));mainAreaTemp.addAll(Arrays.asList(row19));mainAreaTemp.addAll(Arrays.asList(row20));
        mainAreaTemp.addAll(Arrays.asList(bBord));

        mainAreaPerm.addAll(mainAreaTemp);
        mainAreaPerm.set(mainAreaTemp.indexOf("@"),"."); //takes player out of the level and replaces with grass
            //endregion
                //region inside areas
                    //region HOME
        //ADD: 2 bedroom, kitchen, living room, a table that is a hexagon for 3 people
        String [] HOMEtBord= new String[]{W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W};
        String [] HOMErow01= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow02= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow03= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow04= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow05= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow06= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow07= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow08= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W};
        String [] HOMErow09= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,b,b,b,b,b,b,b,b,b,W,b,b,b,b,b,b,W,E,E,E,W};
        String [] HOMErow10= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,"(","∗","∗",")",E,E,E,"[","]",W,E,E, E , E ,".","]",W,E,E,E,W};
        String [] HOMErow11= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,W,E,E,E,E,"C","|",W,E,E,E,W};
        String [] HOMErow12= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,W,b,b,b,b,b,E,b,W,b,b,b,b,b,b,b,W};
        String [] HOMErow13= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E, E , E , E , E , E , E ,"}",W};
        String [] HOMErow14= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,"_","_",E,E,E,E,W, E , E , E , E , E , E , E ,W};
        String [] HOMErow15= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,"o","|",E,E,"|","o",E,E,W,"8","#","#", E , B , B , E ,W};
        String [] HOMErow16= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,"o","|","_","_","|","o",E,E,W,"8","#","#", W ,"+","+", W ,W};
        String [] HOMErow17= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,W,b,b,b,b,b,b,b,W};
        String [] HOMErow18= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,"_","_","_",E,E,E,E,E,E,E,E,E,E,E,E,E,E,"|","]",W};
        String [] HOMErow19= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,"|","o","o","o","|",E,E,E,E,E,E,E,W,E,E,E,E,E,"_",E,W};
        String [] HOMErow20= new String[]{W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,B,B,B,B,E,E,E,E,E,E,p,E,W,"8","#","#",E,"|","+","|",W};
        String [] HOMEbBord = new String[]{W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,e,b,b,b,b,b,b,b,b,b,W};
        homeTemp.addAll(Arrays.asList(HOMEtBord));homeTemp.addAll(Arrays.asList(HOMErow01));homeTemp.addAll(Arrays.asList(HOMErow02));
        homeTemp.addAll(Arrays.asList(HOMErow03));homeTemp.addAll(Arrays.asList(HOMErow04));homeTemp.addAll(Arrays.asList(HOMErow05));
        homeTemp.addAll(Arrays.asList(HOMErow06));homeTemp.addAll(Arrays.asList(HOMErow07));homeTemp.addAll(Arrays.asList(HOMErow08));
        homeTemp.addAll(Arrays.asList(HOMErow09));homeTemp.addAll(Arrays.asList(HOMErow10));homeTemp.addAll(Arrays.asList(HOMErow11));
        homeTemp.addAll(Arrays.asList(HOMErow12));homeTemp.addAll(Arrays.asList(HOMErow13));homeTemp.addAll(Arrays.asList(HOMErow14));
        homeTemp.addAll(Arrays.asList(HOMErow15));homeTemp.addAll(Arrays.asList(HOMErow16));homeTemp.addAll(Arrays.asList(HOMErow17));
        homeTemp.addAll(Arrays.asList(HOMErow18));homeTemp.addAll(Arrays.asList(HOMErow19));homeTemp.addAll(Arrays.asList(HOMErow20));
        homeTemp.addAll(Arrays.asList(HOMEbBord));
        homePerm.addAll(homeTemp);
        homePerm.set(homeTemp.indexOf("@")," ");
                //endregion
                    //region SHOP
        String [] shopLevel= new String[]{
//    |       00's      |        10's       |        20's       |        30's       | 40's|
/*Rows|1|2|3|4|5|6|7|8|9|0|1|2|3|4|5|6|7|8|9|0|1|2|3|4|5|6|7|8|9|0|1|2|3|4|5|6|7|8|9|0|1|2|   */
/*01*/ W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W,
/*02*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*03*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*04*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*05*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*06*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*07*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*08*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*09*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*10*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*11*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*12*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*13*/ W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*14*/ W,E,E,E,E,E,E,E,E,E,E,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*15*/ W,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,"⫿",E,"§",W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*16*/ W,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,b,b,b,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*17*/ W,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*18*/ W,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*19*/ W,E,E,E,E,E,E,E,E,E,E,W,E,"⌉",E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*20*/ W,E,E,E,E,E,E,E,E,E,E,W,"U",W,E,E,E,E,E,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*21*/ W,E,E,E,E,E,E,E,E,E,E,W,"B","⌋",E,E,E,E,E,p,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,E,E,E,E,E,E,W,
/*22*/ W,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,e,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,W

        };
        shopTemp.addAll(Arrays.asList(shopLevel));
        shopPerm.addAll(shopTemp);
        shopPerm.set(shopTemp.indexOf("@")," ");
                  //endregion
                //endregion
        //endregion

        // region SIDE MENU
        String [] tSMenu = new String[]   {b,b,b,b,b,b,b,b,b,b,W};
        String [] sMenuRow1 = new String[]{E,"1",")","S","a","v","e",E,E,E,W};
        String [] sMenuRow2 = new String[]{E,E,E,E,E,E,E,E,E,E,W};
        String [] sMenurow03 = new String[]{E,"2",")","M","e","n","u",E,E,E,W};
        String [] sMenurow04 = new String[]{E,E,E,E,E,E,E,E,E,E,W};
        String [] sMenurow05 = new String[]{E,"3",")","O","p","t","i","o","n",E,W};
        String [] sMenurow06 = new String[]{E,E,E,E,E,E,E,E,E,E,W};
        String [] sMenurow07 = new String[]{E,"4",")","Q","u","i","t",E,E,E,W};
        String [] sMenurow08 = new String[]{E,E,E,E,E,E,E,E,E,E,W};
        String [] sMenurow09 = new String[]{E,E,E,E,E,E,E,E,E,E,W};
        String [] sMenuRow10= new String[]{E,E,E,E,E,E,E,E,E,E,W};
        String [] bSMenu = new String[]   {b,b,b,b,b,b,b,b,b,b,W};
        sMArray.addAll(Arrays.asList(tSMenu));   sMArray.addAll(Arrays.asList(sMenuRow1));sMArray.addAll(Arrays.asList(sMenuRow2));
        sMArray.addAll(Arrays.asList(sMenurow03));sMArray.addAll(Arrays.asList(sMenurow04));sMArray.addAll(Arrays.asList(sMenurow05));
        sMArray.addAll(Arrays.asList(sMenurow06));sMArray.addAll(Arrays.asList(sMenurow07));sMArray.addAll(Arrays.asList(sMenurow08));
        sMArray.addAll(Arrays.asList(sMenurow09));sMArray.addAll(Arrays.asList(sMenuRow10));sMArray.addAll(Arrays.asList(bSMenu));

        //endregion
        //region Loading Text
        //endregion
    }

    public ArrayList<String> getLibMainArea(String PorT){if(PorT.equals("P")){return mainAreaPerm;}return mainAreaTemp;}
    public ArrayList<String> getLibHome(String PorT)    {if(PorT.equals("P")){return homePerm;}return homeTemp;}
    public ArrayList<String> getLibShop(String PorT)    {if(PorT.equals("P")){return shopPerm;}return shopTemp;}
    public ArrayList<String> getLibsMArray(){return sMArray;}
    //endregion
}
