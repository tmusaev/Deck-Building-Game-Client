package deckbuildingclient;

import cards.Basic.Kick;
import cards.Basic.Punch;
import cards.Basic.Vulnerability;
import cards.Basic.Weakness;
import cards.Equipment.*;
import cards.Hero.*;
import cards.SuperPower.*;
import cards.SuperVillain.*;
import cards.Villain.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CardTable {
    ArrayList<Card> cardList = new ArrayList();
    HashMap<String, Card> cardMap = new HashMap();
    
    public CardTable()
    {
        cardList.add(new Punch());
        cardList.add(new Vulnerability());
        cardList.add(new Kick());
        cardList.add(new Weakness());
        cardList.add(new TheFastestManAlive());
        cardList.add(new RasAlGhul());
        cardList.add(new Catwoman());
        cardList.add(new TheBatSignal());
        cardList.add(new Bane());
        cardList.add(new SuperSpeed());
        
        for(Card c : cardList)
            cardMap.put(c.name, c);
    }
    
    public Card get(String s)
    {
        return cardMap.get(s);
    }

}
