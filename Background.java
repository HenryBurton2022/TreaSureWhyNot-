import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class Background {

    static int xCords=0,yCords=0;
    static int tempXCords=0,tempYCords=0;
    static int tempWidth=0 ,tempHeight=0;
    static boolean test=false;
    static int shapeState=0;
    static int bagXC=19,bagYC=71;
//
    //Note: Perfect width for boarders:41*15+3   perfect hight is 750/28
    //NOTE: everytime a variable inside JPanel changes it will update automatically
    //NOTE: add a local variable to tells when its time to change level and then and only then will stuff update so not
            //checking every time it can
    //static int tempVar=1;
    JPanel  backgroundPanel = new JPanel(){
        @Override
        public void paintComponent (Graphics g){
            //System.out.println(tempVar);tempVar++;
            super.paintComponent(g);
            //region BOARDERS
            g.setColor(Color.gray);
            g.fillRect(10-4, 10, 41*15+3, (750 / 28)*2+2);//hud
            g.fillRect(620+1, 60+2, 15*11+3, (750 / 28)*21+2);//SideMenu
            g.fillRect(6, 64, 4, 546);//left boarder boarder
            //g.fillRect(6, 64, 4, 546);//bottom boarder boarder
            //NOTE: COLMB = +15 |  ROW = +25
            //endregion
            super.paintComponent(g);
            switch(PrintGame.getGameState()){
                case"BAG"->{
                    g.setColor(new Color(82, 82, 82));
                    g.fillRect(10,64,611,544);//background
                    g.setColor(new Color(77, 49, 23));
                    g.fillRect(18,71,598,530);//sub-Background
                    g.setColor(new Color(133, 86, 40));
                    g.fillRect(bagXC, bagYC, 100, 112); //moving box
                    switch(Bag.getBagPageState()){
                      case"IB1"->{
                        if(Bag.playerHas("SHOVEL")){g.setColor(new Color(70, 70, 70));
                          g.fillRect(85,104,27,24);g.fillRect(24,111,61,8);}
                        }
                    }
                }
                case"START SCREEN"->{}
                case"LEVEL"->{
                    switch (Levels.getLEVELNAME()) {
                    case "MAIN AREA" -> {
                        //region Grass Background
                        g.setColor(new Color(49, 94, 32));
                        g.fillRect(9, 64, 621 - 8, 608 - 64);
                        //endregion
                        //region Dirt Path
                        g.setColor(new Color(156, 125, 54));
                        g.fillRect(8, 111, 30 - 8, 161 - 111);
                        g.fillRect(8, 137, 91 - 8, 161 - 137);
                        g.fillRect(44, 161, 317, 27);
                        g.fillRect(105, 185, 516, 28);
                        g.fillRect(166, 213, 28, 79);
                        g.fillRect(346, 213, 276, 26);
                        g.fillRect(150, 292, 29, 104);
                        g.fillRect(136, 396, 29, 104);
                        g.fillRect(120, 500, 29, 26);
                        g.fillRect(105, 526, 29, 26);
                        g.fillRect(45, 551, 74, 27);
                        g.fillRect(30, 396, 106, 26);
                        g.fillRect(56, 382, 23, 15);
                        g.fillRect(165,396,29,78);
                        g.fillRect(194,396,255,52);
                        g.fillRect(436,366,30,56);
                        g.fillRect(436+15,366-28*2+4,30,56);
                        g.fillRect(436+15*2,366-28*4+4*2-56/2,30,56/2*3);
                        //endregion
                        //region Water & Sand
                        //sand
                        g.setColor(new Color(215, 224, 83));
                        g.fillRect(585 - 3, 497 - 13, 37 + 3, 111);
                        g.fillRect(570 - 3, 522 - 12, 37 + 3, 86);
                        g.fillRect(555 - 3, 547 - 11, 37 + 3, 61);
                        g.fillRect(540 - 3, 572 - 10, 37 + 3, 36 + 10);
                        //water
                        g.setColor(new Color(78, 141, 186));
                        g.fillRect(585, 497, 37, 111);
                        g.fillRect(570, 522, 37, 86);
                        g.fillRect(555, 547, 37, 61);
                        g.fillRect(540, 572, 37, 36);
                        //endregion
                        //region Shop
                        g.setColor(new Color(207, 217, 124));
                        g.fillRect(51, 367, 33, 20);//base
                        g.setColor(new Color(84, 65, 23));
                        g.fillRect(57, 367, 21, 18);//roof
                        g.setColor(Color.black);
                        g.fillRect(58, 387, 19, 8);//doorMatBorder
                        g.setColor(Color.gray);
                        g.fillRect(59, 387, 17, 7);//doorMat
                        //endregion
                        //region Home
                        g.setColor(new Color(242, 255, 99));
                        g.fillRect(36, 574, 33, 19);//base of house
                        g.setColor(new Color(102, 81, 34));
                        g.fillRect(41, 577, 23, 17);//roof
                        g.setColor(Color.black);
                        g.fillRect(46, 567, 13, 6);//doorMatOutLine
                        g.setColor(Color.gray);
                        g.fillRect(47, 568, 11, 5);//doorMat
                        //endregion
                    }
                    case "HOME" -> {
                        //region background
                        g.setColor(Color.gray);//background
                        g.fillRect(9, 64, 621 - 8, 608 - 64);
                        g.fillRect(561, 298, 61, 76);
                        g.setColor(Color.lightGray);//foreground
                        g.fillRect(309, 298, 312, 310);
                        g.setColor(Color.gray);//background
                        g.fillRect(562, 298, 62, 78);
                        //endregion
                        //region Room Floors
                        //Main Room
                        g.setColor(new Color(171, 196, 190));
                        g.fillRect(309, 374, 193, 235); // foreground
                        //Kitchen
                        g.setColor(new Color(205, 212, 210));
                        g.fillRect(309, 298, 149, 76);
                        //Bathroom
                        g.setColor(new Color(208, 209, 194));
                        g.fillRect(458, 298, 104, 77);
                        //Parent's Bedroom
                        g.setColor(new Color(207, 199, 180));
                        g.fillRect(503, 375, 119, 130);
                        //Player's Bedroom
                        g.setColor(new Color(208, 209, 194));
                        g.fillRect(503,506,118,103);
                        //endregion

                        //region Main Room
                        g.setColor(new Color(125, 100, 44));
                        g.fillRect(325, 547, 55, 20); //Couch

                        g.setColor(new Color(235, 227, 209));
                        g.fillRect(398, 441, 44, 51); //table
                        g.setColor(new Color(125, 100, 44));
                        g.fillRect(376, 448, 16, 14);//Top Left Chair
                        g.fillRect(376, 474, 16, 14);//Bot Left Chair
                        g.fillRect(448, 448, 16, 14);//Top Right Chair
                        g.fillRect(448, 474, 16, 14);//Bottom Right Chair


                        //endregion
                        //region Parent's Room
                        //Bed
                        g.setColor(new Color(217, 219, 193));
                        g.fillRect(508, 442, 16, 47);//PILLOWS
                        g.setColor(new Color(240, 75, 60));
                        g.fillRect(524, 442, 30, 46); //SHEETS
                        //Chest
                        g.setColor(new Color(89, 71, 30));
                        g.fillRect(563, 467, 44, 22);
                        //Mirror
                        g.setColor(new Color(234, 235, 225));
                        g.fillRect(604, 393, 3, 18);
                        //endregion
                        //region Kitchen
                        g.setColor(new Color(234, 235, 225));
                        g.fillRect(325, 314, 40, 22);//bruner/oven
                        g.fillRect(429, 314, 12, 19);//fridge
                        //endregion
                        //region BathRoom
                        g.setColor(new Color(234, 235, 225));
                        g.fillRect(527, 314, 22, 19); //shower
                        g.fillRect(526, 340, 20, 18);
                        //endregion
                        //region Player's Room
                        //Bed
                        g.setColor(new Color(217, 219, 193));
                        g.fillRect(508, 572, 16, 20); //Pillow
                        g.setColor(new Color(240, 75, 60));
                        g.fillRect(508 + 16, 572, 16, 20); //Sheets
                        g.fillRect(508 + 16 * 2, 572, 16, 20);
                        //chest
                        g.setColor(new Color(89, 71, 30));
                        g.fillRect(578, 571, 29, 22);
                        //Closet
                        g.setColor(new Color(135, 103, 31));
                        g.fillRect(593, 522, 14, 19);
                        //endregion
                    }
                    case "SHOP" ->{}
                }}
                default-> {
                }
            }
            //shape maker for level layout
            super.paintComponent(g);
            g.setColor(Color.red);
            {
                switch (Levels.getLEVELNAME()) {
                    case "MAIN AREA" -> {}
                    case "HOME" -> {
                        //region background
                        g.setColor(Color.gray);//background
                        g.fillRect(9, 64, 621 - 8, 608 - 64);
                        g.fillRect(561, 298, 61, 76);
                        g.setColor(Color.lightGray);//foreground
                        g.fillRect(309, 298, 312, 310);
                        g.setColor(Color.gray);//background
                        g.fillRect(562, 298, 62, 78);
                        //endregion
                        //region Room Floors
                        //Main Room
                        g.setColor(new Color(171, 196, 190));
                        g.fillRect(309, 374, 193, 235); // foreground
                        //Kitchen
                        g.setColor(new Color(205, 212, 210));
                        g.fillRect(309, 298, 149, 76);
                        //Bathroom
                        g.setColor(new Color(208, 209, 194));
                        g.fillRect(458, 298, 104, 77);
                        //Parent's Bedroom
                        g.setColor(new Color(207, 199, 180));
                        g.fillRect(503, 375, 119, 130);
                        //Player's Bedroom
                        g.setColor(new Color(208, 209, 194));
                        g.fillRect(503,506,118,103);
                        //endregion

                        //region Main Room
                        g.setColor(new Color(125, 100, 44));
                        g.fillRect(325, 547, 55, 20); //Couch

                        g.setColor(new Color(235, 227, 209));
                        g.fillRect(398, 441, 44, 51); //table
                        g.setColor(new Color(125, 100, 44));
                        g.fillRect(376, 448, 16, 14);//Top Left Chair
                        g.fillRect(376, 474, 16, 14);//Bot Left Chair
                        g.fillRect(448, 448, 16, 14);//Top Right Chair
                        g.fillRect(448, 474, 16, 14);//Bottom Right Chair


                        //endregion
                        //region Parent's Room
                        //Bed
                        g.setColor(new Color(217, 219, 193));
                        g.fillRect(508, 442, 16, 47);//PILLOWS
                        g.setColor(new Color(240, 75, 60));
                        g.fillRect(524, 442, 30, 46); //SHEETS
                        //Chest
                        g.setColor(new Color(89, 71, 30));
                        g.fillRect(563, 467, 44, 22);
                        //Mirror
                        g.setColor(new Color(234, 235, 225));
                        g.fillRect(604, 393, 3, 18);
                        //endregion
                        //region Kitchen
                        g.setColor(new Color(234, 235, 225));
                        g.fillRect(325, 314, 40, 22);//bruner/oven
                        g.fillRect(429, 314, 12, 19);//fridge
                        //endregion
                        //region BathRoom
                        g.setColor(new Color(234, 235, 225));
                        g.fillRect(527, 314, 22, 19); //shower
                        g.fillRect(526, 340, 20, 18);
                        //endregion
                        //region Player's Room
                        //Bed
                        g.setColor(new Color(217, 219, 193));
                        g.fillRect(508, 572, 16, 20); //Pillow
                        g.setColor(new Color(240, 75, 60));
                        g.fillRect(508 + 16, 572, 16, 20); //Sheets
                        g.fillRect(508 + 16 * 2, 572, 16, 20);
                        //chest
                        g.setColor(new Color(89, 71, 30));
                        g.fillRect(578, 571, 29, 22);
                        //Closet
                        g.setColor(new Color(135, 103, 31));
                        g.fillRect(593, 522, 14, 19);
                        //endregion
                    }
                }}
            switch(shapeState){
                case 0-> {super.paintComponent(g);
                    g.setColor(Color.red);
                    g.fillRect(xCords, yCords, 15, 20);}
                case 1-> {
                    super.paintComponent(g);
                    g.setColor(Color.red);
                    g.fillRect(tempXCords,tempYCords,xCords,yCords);
                }
                case 2-> {tempWidth=xCords-tempXCords;tempHeight=yCords-tempYCords;}
            }
        }
    };

    public void changeBagCords(int xCord, int yCord){bagXC+=xCord;bagYC+=yCord;}
    public void setBagCords(int xCord, int yCord){bagXC=xCord;bagYC=yCord;}
    //region vars
    static int moveNumPerm=1;
    static int moveNum=1;
    static int moveFastNum=20;
    //endregion
    //region change X&Y Cords and Move Num
    public void leftXCords() { xCords-=moveNum; }
    public void rightXCords(){ xCords+=moveNum; }
    public void downYCords() { yCords+=moveNum; }
    public void upYCords()   { yCords-=moveNum; }
    public void changeCords(int xCord, int yCord){xCords=xCord;yCords=yCord;}
    public void changeMoveNum(int temp){moveNum=temp;}
    //endregion
    //region getter methods
    public int getShapeState(){return shapeState;}
    public int getTempXCords(){return tempXCords;}
    public int getTempYCords(){return tempYCords;}
    public int getMoveNum(){return moveNum;}
    public int getMoveFastNum(){return moveFastNum;}
    public int getMoveNumPerm(){return moveNumPerm;}
    public int getXCords(){return xCords;}
    public int getYCords(){return yCords;}
    //endregion
    public void changeShapeState(int temp){shapeState=temp;}
    public void changeTempCords(int xCord,int yCord){tempXCords=xCord;tempYCords=yCord;}
    public void toggleTest(boolean temp){ test=temp;}
    public JPanel getBackgroundPanel(){return backgroundPanel;}
    public void setBackgroundPanelAttributes(){
        backgroundPanel.setBounds(0,0,1400,800);
        backgroundPanel.setOpaque(false);
    }
}

//remeber: ^3 ABOVE | v4 BELOW | @----}  1 LEFT   | @-} 1 RIGHT    FROM PLAYER TO PATH WAY SHAPES