public class TextLib {
    /*NOTE: IF TEXT IS TO LONG END WITH ---> SO ENCOURAGES PLAYER TO HIT ENTER WHICH WILL WORK*/
    /*-------------------------------------TERMS & DEFINITIONS:---------------------------------------
     Speak:what a character openly speaks: usually associated with EX: "Person Name: Misc dialogue"
     Think:what the player/himself thinks

    */

    //region NPC INTERACTIONS
   public String getDadSpeak(String textNum){
        switch(textNum){
            case "1.0"->{return "Dad: Hey you've always wanted to go treasure hunting. I bought you a shovel take, good care of it.";}
            case "2.0"->{return "Nice coin, your on your way to becoming rich. Keep at it.";}
            case "2.1"->{return "Dad: Hey I think I saw thing shiny in the dirt over there *He points*";}
            case "3.0"->{return "Keep at it son.";}
        }
    return "ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }
    public String getMomSpeak(String textNum){
        switch(textNum){
            case "1.0"->{return "Mom: Hello son";}
        }
        return "ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }
    //endregion
    //region TREASURE INTERACTIONS
        //region Main Area
    public String getDigGoldCoin(String textNum){
        switch(textNum){
            case "1.0"->{return "You see a shine underneath the dirt, but the dirt pile is to heavy for you. Perhaps a shovel would help";}
            case "2.0"->{return "You lift the mound of dirt out of the way to reveal a shiny coin   --->";}
            case "2.1"->{return "!Shiny Gold Coin Obtained!";}
        }
        return "ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }
        //endregion
        //region Home
        public String getHomeThink(String object){
            switch(object){
                //region Player Bed Room Objects
                case "@ BED 1.0"->{return "Though sleeping in would be nice, I got a great day ahead of me";}
                case "@ CHEST 1.0"->{return "My big hearty chest filled with all my little trinkets collected " +
                        "around the world";}
                case "@ CLOSET 1.0"->{return "My closet. Contains shirts that look all the same, but with each one" +
                        " differently colored";}
                //endregion
                //region Parent Bed Room Object
                case "M&D BED 1.0"->{return "It's my parents bed";}
                case "M&D CHEST 1.0"->{return "My parent's chest. I proberly should be snooping around in their room";}
                case "M&D MIRROR 1.0"->{return "My closet. Contains shirts all the same but differently colored";}
                //endregion
                //region Bathroom Objects
                case "BATHR TOILET 1.0"->{return "Das za toileh";}
                case "BATHR SHOWER 1.0"->{return "My shower... A good place to wipe away your sorrows";}
                //endregion
                //region Kitchen
                case "KITCH STOVE 1.0" ->{return "A fire wood stove... the flames often give a magical touch to mom's cooking";}
                case "KITCH FRIDGE 1.0"->{return "The fridge is running like ice in a closed box, better not open it.";}
                //endregion
                //region MainRoom Objects
                case "MAIN COUCH 1.0"-> {return "Our dark brown cracked leather couch... I'm pretty sure this couch is older than.";}
                case "MAIN TABLE 1.O"-> {return "A table where the family meets and eats";}
                //endregion
                default ->{System.out.println("ERROR: TextLib->getHomeThink: CANT FIND REQUEST OBJECT (DOESN'T EXIST)");}
            }
            return "ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        }
        //endregion
        //region Shop
        public String getShopBuyText(String object){
            switch(object){
                //region Player Bed Room Objects
                case "BOOTS"->{return "Fine pair of boots, gona buy em?";}
            }
            return "ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        }
        //endregion
    //endregion
    //region Bag
        public String getItemText(String item){
            switch(item){
                //Item Bag 1
                case "IB1 1.0"->{return "A shovel... Useful for digging";}
                case "IB1 2.0"->{return "BOOTS YEE";}
                //Item Bag 2

                //Treasure Bag 1
                case "TB1 1.0"->{return "A shiny gold coin... Its glimmery reflection is quite something";}
            }
            return "Nothing there... yet.";
        }
    //endregion
}
