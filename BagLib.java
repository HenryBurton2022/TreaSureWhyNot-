import java.util.ArrayList;
import java.util.Arrays;

public class BagLib {
    static ArrayList<String> IB1 = new ArrayList<>();
    static ArrayList<String> IB2  = new ArrayList<>();
    static ArrayList<String> TB1  = new ArrayList<>();
    static ArrayList<String> IB1P = new ArrayList<>();
    static ArrayList<String> IB2P = new ArrayList<>();
    static ArrayList<String> TB1P = new ArrayList<>();

    String W="|" , b="-" , B="_", E=" ",P="+"; /*Boarders & Empty Space*/
    static String u="^"; static String R=">"; static String V="v"; static String L="<"; /*Directions*/



    //region A)----------Bag Pages w/return methods
    public BagLib(){
        //region ITEM BAG PAGE 1
        String [] BAG1tBord = new String[]{W,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,W};
        String [] BAG1row01 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row02 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row03 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row04 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row05 = new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,R};
        String [] BAG1row06 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row07 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row08 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row09 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row10 = new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,R};
        String [] BAG1row11 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row12 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row13 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row14 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row15 = new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,R};
        String [] BAG1row16 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row17 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row18 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row19 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        String [] BAG1row20 = new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,R};
        String [] BAG1bBord = new String[]{W,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,W};
        IB1P.addAll(Arrays.asList(BAG1tBord));IB1P.addAll(Arrays.asList(BAG1row01));IB1P.addAll(Arrays.asList(BAG1row02));
        IB1P.addAll(Arrays.asList(BAG1row03));IB1P.addAll(Arrays.asList(BAG1row04));IB1P.addAll(Arrays.asList(BAG1row05));
        IB1P.addAll(Arrays.asList(BAG1row06));IB1P.addAll(Arrays.asList(BAG1row07));IB1P.addAll(Arrays.asList(BAG1row08));
        IB1P.addAll(Arrays.asList(BAG1row09));IB1P.addAll(Arrays.asList(BAG1row10));IB1P.addAll(Arrays.asList(BAG1row11));
        IB1P.addAll(Arrays.asList(BAG1row12));IB1P.addAll(Arrays.asList(BAG1row13));IB1P.addAll(Arrays.asList(BAG1row14));
        IB1P.addAll(Arrays.asList(BAG1row15));IB1P.addAll(Arrays.asList(BAG1row16));IB1P.addAll(Arrays.asList(BAG1row17));
        IB1P.addAll(Arrays.asList(BAG1row18));IB1P.addAll(Arrays.asList(BAG1row19));IB1P.addAll(Arrays.asList(BAG1row20));
        IB1P.addAll(Arrays.asList(BAG1bBord));
        //endregion
        //region ITEM BAG PAGE 2
        String [] BAG2tBord = new String[]{W,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,W};
        String [] BAG2row1 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row2 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row03 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row04 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row05 = new String[]{L,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] BAG2row06 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row07 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row08 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row09 = new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row10= new String[]{L,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] BAG2row11= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row12= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row13= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row14= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row15= new String[]{L,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] BAG2row16= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row17= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row18= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row19= new String[]{L,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] BAG2row20= new String[]{L,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] BAG2bBord = new String[]{L,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,W};
        IB2P.addAll(Arrays.asList(BAG2tBord));IB2P.addAll(Arrays.asList(BAG2row1));IB2P.addAll(Arrays.asList(BAG2row2));
        IB2P.addAll(Arrays.asList(BAG2row03));IB2P.addAll(Arrays.asList(BAG2row04));IB2P.addAll(Arrays.asList(BAG2row05));
        IB2P.addAll(Arrays.asList(BAG2row06));IB2P.addAll(Arrays.asList(BAG2row07));IB2P.addAll(Arrays.asList(BAG2row08));
        IB2P.addAll(Arrays.asList(BAG2row09));IB2P.addAll(Arrays.asList(BAG2row10));IB2P.addAll(Arrays.asList(BAG2row11));
        IB2P.addAll(Arrays.asList(BAG2row12));IB2P.addAll(Arrays.asList(BAG2row13));IB2P.addAll(Arrays.asList(BAG2row14));
        IB2P.addAll(Arrays.asList(BAG2row15));IB2P.addAll(Arrays.asList(BAG2row16));IB2P.addAll(Arrays.asList(BAG2row17));
        IB2P.addAll(Arrays.asList(BAG2row18));IB2P.addAll(Arrays.asList(BAG2row19));IB2P.addAll(Arrays.asList(BAG2row20));
        IB2P.addAll(Arrays.asList(BAG2bBord));
        //endregion
        //region TREASURE BAG PAGE 1
        String [] TREStBord = new String[]{W,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,W};
        String [] TRESrow01 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow02 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow03 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow04 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow05 = new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] TRESrow06 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow07 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow08 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow09 = new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow10= new String[] {W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] TRESrow11= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow12= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow13= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow14= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow15= new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] TRESrow16= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow17= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow18= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow19= new String[]{W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,W};
        String [] TRESrow20= new String[]{W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,W};
        String [] TRESbBord = new String[]{W,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,W};
        TB1P.addAll(Arrays.asList(TREStBord));TB1P.addAll(Arrays.asList(TRESrow01));TB1P.addAll(Arrays.asList(TRESrow02));
        TB1P.addAll(Arrays.asList(TRESrow03));TB1P.addAll(Arrays.asList(TRESrow04));TB1P.addAll(Arrays.asList(TRESrow05));
        TB1P.addAll(Arrays.asList(TRESrow06));TB1P.addAll(Arrays.asList(TRESrow07));TB1P.addAll(Arrays.asList(TRESrow08));
        TB1P.addAll(Arrays.asList(TRESrow09));TB1P.addAll(Arrays.asList(TRESrow10));TB1P.addAll(Arrays.asList(TRESrow11));
        TB1P.addAll(Arrays.asList(TRESrow12));TB1P.addAll(Arrays.asList(TRESrow13));TB1P.addAll(Arrays.asList(TRESrow14));
        TB1P.addAll(Arrays.asList(TRESrow15));TB1P.addAll(Arrays.asList(TRESrow16));TB1P.addAll(Arrays.asList(TRESrow17));
        TB1P.addAll(Arrays.asList(TRESrow18));TB1P.addAll(Arrays.asList(TRESrow19));TB1P.addAll(Arrays.asList(TRESrow20));
        TB1P.addAll(Arrays.asList(TRESbBord));

        //endregion
        IB1.addAll(IB1P); //Item Bag 1
        IB2.addAll(IB2P); //Item Bag 2
        TB1.addAll(TB1P); //Treasure Bag 1
    }

    //region RETURN METHODS
    public ArrayList<String> getIB1(){return IB1;}
    public ArrayList<String> getIB2(){return IB2;}
    public ArrayList<String> getTB1(){return TB1;}
    //endregion
    //endregion
    //region Bag Items
            /* REFERENCE GUIDE
        {W,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,W};
        {W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        {W,E,|,E,E,|,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        {W,E,|,E,E,|,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        {W,_,|,E,_,|,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,W,E,E,E,E,E,E,E,E,R};
        {W,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,P,b,b,b,b,b,b,b,b,R};
         */

    static int row01=42,row02=42*2,row03=42*3,row04=42*4;
    static int          box02=8,box03=16; /*goes by 8 left*/
    //region Item Bag->Page 1
    //static ArrayList<String> drawOBJTemp = new ArrayList<>();
    public void drawObject(String object){
        switch(object){
            case"SHOVEL"->{
                IB1.set(row01+6, "_");
                IB1.set(row02+1, "|");IB1.set(row02+2, "=");IB1.set(row02+3, "=");IB1.set(row02+4, "=");IB1.set(row02+5, "|");IB1.set(row02+6, "_");IB1.set(row02+7, "}");
            }
            case"BOOTS"->{
                IB1.set(row02+box02+2,"|");IB1.set(row02+box02+5,"|");
                IB1.set(row03+box02+2,"|");IB1.set(row03+box02+5,"|");
                IB1.set(row04+box02+1,"_");IB1.set(row04+box02+4,"_");
            }
            case"GOLD COIN"->{
                for (int i = 44; i < 49; i++) { TB1.set(i, "-"); }
                TB1.set((43+42),"|"); TB1.set((49+42),"|");
                for (int i = (44+42*2); i < (49+42*2); i++) {TB1.set(i, "-"); }
            }
        }
    }
}

    //endRegion
