import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.Locale;


public class JframeMethod {
/*---------------------------------------------WHAT TO KNOW----------------------------------------------------*//*
1) IDK
/*--------------------------------------Declare/Call/Initiate Variables-----------------------------------------------*/

    //region |OPEN ME|
    //region ---Misc assign Var To Classes
    DeBugger debug = new DeBugger();
    //endregion
    //region ---D&I: JFRAME realted vars
    JFrame frame = new JFrame();
    Background background = new Background();
    Font font = new Font("Monospaced", Font.CENTER_BASELINE, 25); //mess around with font to see what its good
    //endregion
    //endregion
/*-----------------------------------------------Code-----------------------------------------------------------------*/
    //region |OPEN ME|
    // region A)--------------------!Create and Assign attributes to JFrame & Panel
    //region 1) ---JFrame---
    public void createJframe() {
        frame.setResizable(false);
        frame.setVisible(true); //sets visibility of GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //says what happends when click close button
        frame.setSize(820, 800); // make it so when change font change window size
        frame.setFocusable(true);
    }
    //endregion
    //region 2) ---JPannel---
    JPanel  panel = new JPanel();

    JLayeredPane layeredPane = new JLayeredPane();
    public JFrame getJframe() { return frame;}
    public JLayeredPane getLayeredPane() { return layeredPane;}

    public void executeWindowProperties(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(0,0,1400,750);panel.setOpaque(false);
        background.setBackgroundPanelAttributes();
        layeredPane.setBounds(0,0,1400,750);layeredPane.setOpaque(false);
        layeredPane.add(panel);
        layeredPane.add(background.getBackgroundPanel());
        addRows();
        frame.add(layeredPane);
    }
    /*HOW TO MAKE COLORED BACKGROUNDS:
        -CAN:make multiple panel layers for each level
NOTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: LOOK UP CODE SO WHEN CLICK IN JFRAME GETS X & Y CORDS
    */
/* DEBUGGING LAYERED PLANEL
    JTextPane TEST = new JTextPane();
    public void testing(){
        background.getBackgroundPanel().add(TEST);  //<- adds JTextPane to JPanel
        TEST.setFont(font);                                            //<- makes row a certain font
        TEST.setMargin(new Insets(0,0,0,0)); //<- crops the row
        TEST.setOpaque(true); //<- toggles opacity
        TEST.setEditable(true); //<- toggles if can edit text
        TEST.setText("HDJKSDFHSDKFHLSDJKFHJLSFHKJSDFLJK");
    }
    */
//endregion
    //endregion
    // region B)--------------------!BIG:Creating, Modifying, and Methods for Rows     w/Summary
                        /*Summary: This chunk is responsible for creating the rows, assigning them to the JPanel.
    as well as giving the rows attributes and properties. Lastly an arrangement of methods are applied as to use
    the rows in other pieces of code
     1) Will: create and initialize rows
     2) Will: take initialized rows and put it through a method
     3) Have: A method that sets the properties of the rows
     4) Have: A method for changing each row: Used to update row with each |printLevel| Note: has a debugger |if|
        This is so that that code will print out each row when called if |if = true|
     5) Have: Getter method for |tBox|es so when called input number and gives row needed.
     */
    //region 1) ---Initialize Main Rows
    JTextPane hud00 = new JTextPane(),hud01 = new JTextPane();
    JTextPane tBord = new JTextPane(),row01 = new JTextPane(),row02 = new JTextPane();
    JTextPane row03 = new JTextPane(),row04 = new JTextPane(),row05 = new JTextPane();
    JTextPane row06 = new JTextPane(),row07 = new JTextPane(),row08 = new JTextPane();
    JTextPane row09 = new JTextPane(),row10 = new JTextPane(),row11 = new JTextPane();
    JTextPane row12 = new JTextPane(),row13 = new JTextPane(),row14 = new JTextPane();
    JTextPane row15 = new JTextPane(),row16 = new JTextPane(),row17 = new JTextPane();
    JTextPane row18 = new JTextPane(),row19 = new JTextPane(),row20 = new JTextPane();
    JTextPane bBord = new JTextPane();
    JTextPane tBox1 = new JTextPane(),tBox2 = new JTextPane(),tBox3 = new JTextPane(),tBoxB = new JTextPane();
    //endregion


    //region 2) ---Assign Rows Properties
    public void addRows(){
        modifyRow(hud00);modifyRow(hud01);modifyRow(tBord);
        modifyRow(row01);modifyRow(row02);modifyRow(row03);modifyRow(row04);
        modifyRow(row05);modifyRow(row06);modifyRow(row07);modifyRow(row08);
        modifyRow(row09);modifyRow(row10);modifyRow(row11);modifyRow(row12);
        modifyRow(row13);modifyRow(row14);modifyRow(row15);modifyRow(row16);
        modifyRow(row17);modifyRow(row18);modifyRow(row19);modifyRow(row20);
        modifyRow(bBord);modifyRow(tBox1);modifyRow(tBox2);modifyRow(tBox3);
        modifyRow(tBoxB);
    }
    //endregion

    //region 3) ---Method For Assign Rows Properties
    public void modifyRow(JTextPane row){

        panel.add(row);  //<- adds JTextPane to JPanel
        row.setFont(font);                                            //<- makes row a certain font
        row.setMargin(new Insets(-8,0,-20,0)); //<- crops the row
        row.setOpaque(false); //<- toggles opacity
        row.setEditable(true); //<- toggles if can edit text
    }
    //endregion
    //region 4) ---CHANG: each row
    public void replaceRow(String rowName,String arrayString){
        switch(rowName){
            case "hud00"-> hud00.setText(arrayString);
            case "hud01"-> hud01.setText(arrayString);
            case "tBord"-> tBord.setText(arrayString);
            case "row01"-> row01.setText(arrayString);
            case "row02"-> row02.setText(arrayString);
            case "row03"-> row03.setText(arrayString);
            case "row04"-> row04.setText(arrayString);
            case "row05"-> row05.setText(arrayString);
            case "row06"-> row06.setText(arrayString);
            case "row07"-> row07.setText(arrayString);
            case "row08"-> row08.setText(arrayString);
            case "row09"-> row09.setText(arrayString);
            case "row10"-> row10.setText(arrayString);
            case "row11"-> row11.setText(arrayString);
            case "row12"-> row12.setText(arrayString);
            case "row13"-> row13.setText(arrayString);
            case "row14"-> row14.setText(arrayString);
            case "row15"-> row15.setText(arrayString);
            case "row16"-> row16.setText(arrayString);
            case "row17"-> row17.setText(arrayString);
            case "row18"-> row18.setText(arrayString);
            case "row19"-> row19.setText(arrayString);
            case "row20"-> row20.setText(arrayString);
            case "bBord"-> bBord.setText(arrayString);
        }
        if(debug.getPLOnMove()){System.out.println(arrayString);}
    }
    //endregion
    //region 5) ---GET: method for tBox#
    public JTextPane getTbox(int num){
        switch(num){
            case 1->{return tBox1;}
            case 2->{return tBox2;}
            case 3->{return tBox3;}
            case 4->{return tBoxB;}
        }
    return tBoxB;
}
    //endregion
    //region 6) ---GET: row.StyledDocument Getter Method
        // NOTE: the c in cRow means color
    public StyledDocument getCrow(String row){
        switch(row){
            case "01"->{return row01.getStyledDocument();}
            case "02"->{return row02.getStyledDocument();}
            case "03"->{return row03.getStyledDocument();}
            case "04"->{return row04.getStyledDocument();}
            case "05"->{return row05.getStyledDocument();}
            case "06"->{return row06.getStyledDocument();}
            case "07"->{return row07.getStyledDocument();}
            case "08"->{return row08.getStyledDocument();}
            case "09"->{return row09.getStyledDocument();}
            case "10"->{return row10.getStyledDocument();}
            case "11"->{return row11.getStyledDocument();}
            case "12"->{return row12.getStyledDocument();}
            case "13"->{return row13.getStyledDocument();}
            case "14"->{return row14.getStyledDocument();}
            case "15"->{return row15.getStyledDocument();}
            case "16"->{return row16.getStyledDocument();}
            case "17"->{return row17.getStyledDocument();}
            case "18"->{return row18.getStyledDocument();}
            case "19"->{return row19.getStyledDocument();}
            case "20"->{return row20.getStyledDocument();}
            default -> throw new IllegalStateException("Unexpected value: " + row);
        }
    }

    //endregion
    //endregion
    //endregion
/*-----------------------------------------------NOTES---------------------------------------------------------*//*
    //region |OPEN ME|
    highlighter.removeAllHighlights();
    //Set up a function to draw the shapes
*/

    /*                                           MEMORY DATA
      | TIME |  DATE  | Rest Mem  | High Mem | Version |What Change? */
    /*|11:01 |11/11/21| 370-380   | 400-430  | 0.01.1  |CONTROL TEST */
    /*|11:34 |11/11/21| 361-364   | 370-400  | 0.01.2  |change D&I of class vars *//*
What I Change?:Took away static from declaring & initialing class variables & removed uneeded ones (kept static if error occured)
What Notice?:Movemnt is SMOOTH, Less Memort*/
    //Continuing off V0.01.2 because has shown good results w/out drawback
    /*|11:48 |11/11/21| 262-358   | 370      |  N/A    |Remove printLevel() method */
    /*|00:00 |11/11/21| 262-358   | 370      |  N/A    |Make static methods*//*
What I Change: Made important methods static
    */





/*

Things to try:
-


Discoveries/Notes: (!=break through) (~=helpful) (-=misc) (*=memory related)
*Disabling background affect memory by not that mach at all what so ever
*moving into buildings affects memory + or - 10mb at max
~Making textLib a object make sense as its refering to a library of things MEANING doesn't make sense to me a static
!deleting statics in movement class made the movement very smooth
*removing printLevel();

Issue/Hypothesis: (~=places where could slow down game)
- It has something to do with movement
~JframeMethod -> replaceRow -> (debug.getPLOnMove()){System.out.println(arrayString);} (144)





    */
}

