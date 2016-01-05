package deckbuildingclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.net.Socket;
import java.util.ArrayList;

public class DeckBuildingClient {
    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectInputStream inputStream;
    CardTable cardTable = new CardTable();
    ArrayList<ArrayList<String>> gameState = new ArrayList();
    ArrayList<ArrayList<String>> oppState = new ArrayList();
    UserInterface UI;
        
    
    public DeckBuildingClient(String serverAddress) throws Exception 
    {
        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        inputStream = new ObjectInputStream(socket.getInputStream());
        
        gameState = (ArrayList<ArrayList<String>>)inputStream.readObject();
        UI = new UserInterface(out);
        UI.drawHand(getHand());
        UI.drawLineUp(getLineUp());
        UI.deckLabel.setText("Deck: "+countDeck());
        UI.mainDeckLabel.setText("Main Deck: "+countMainDeck());
        UI.drawKickStack(getKickStack());
        UI.drawSuperVillains(getSuperVillains());
        //UI.drawOppHand(getOppHand());
    }
    
    public ArrayList<Card> getHand()
    {
        return stringToCard(cardTable, 0);
    }
    
    public ArrayList<Card> getOppHand()
    {
        return stringToCard2(cardTable, 0);
    }
    
    public int getOppPower()
    {
        ArrayList<String> stringList = new ArrayList();
        String s;
        stringList = oppState.get(4);
        s = stringList.get(0);
        return Integer.parseInt(s);
    }
    
    public ArrayList<Card> getInPlay()
    {
        return stringToCard(cardTable, 1);
    }
    
    public ArrayList<Card> getOppInPlay()
    {
        return stringToCard2(cardTable, 1);
    }
    
    public ArrayList<Card> getDiscard()
    {
        return stringToCard(cardTable, 2);
    }
    
    public ArrayList<Card> getOppDiscard()
    {
        return stringToCard2(cardTable, 2);
    }
    
    public ArrayList<Card> getLineUp()
    {
        return stringToCard(cardTable, 5);
    }
    
    public ArrayList<Card> getKickStack()
    {
        return stringToCard(cardTable, 6);
    }
    
    public ArrayList<Card> getSuperVillains()
    {
        return stringToCard(cardTable, 8);
    }
    
    public int countDeck()
    {
        return countString(3);
    }
    
    public int countOppDeck()
    {
        return countString2(3);
    }
    
    public int countMainDeck()
    {
        return countString(4);
    }
    
    public int countString(int i)
    {
        ArrayList<String> stringList = new ArrayList();
        stringList = gameState.get(i);
        return stringList == null ? 0 : stringList.size();
    }
    
    public int countString2(int i)
    {
        ArrayList<String> stringList = new ArrayList();
        stringList = oppState.get(i);
        return stringList == null ? 0 : stringList.size();
    }
    
    public ArrayList<Card> stringToCard (CardTable cardTable, int i)
    {
        ArrayList<String> stringList = new ArrayList();
        ArrayList<Card> cardList = new ArrayList();
        stringList = (ArrayList<String>)gameState.get(i);
        for(String s: stringList)
        {
            cardList.add(cardTable.get(s));
        }
        return cardList;
    }
    
     public ArrayList<Card> stringToCard2 (CardTable cardTable, int i)
    {
        ArrayList<String> stringList = new ArrayList();
        ArrayList<Card> cardList = new ArrayList();
        stringList = (ArrayList<String>)oppState.get(i);
        for(String s: stringList)
        {
            cardList.add(cardTable.get(s));
        }
        return cardList;
    }
    
    public void play() throws Exception {
        String response;
        //oppState = (ArrayList<ArrayList<String>>)inputStream.readObject();
        //UI.drawOppHand(getOppHand());
        try {
            /*response = in.readLine();
            if (response.startsWith("WELCOME")) {
       
            */
            while (true) {
                response = in.readLine();
                if (response.startsWith("MESSAGE")) {
                    UI.messageLabel.setText(response.substring(8));
                }
                else if (response.startsWith("POWER")) {
                    int power = Integer.parseInt(response.substring(6));
                    UI.powerLabel.setText("Power: "+power);
                }
                else if (response.startsWith("UPDATE"))
                {
                    gameState = (ArrayList<ArrayList<String>>)inputStream.readObject();
                    UI.drawHand(getHand());
                    UI.drawInPlay(getInPlay());
                    UI.drawDiscardPile(getDiscard());
                    UI.drawLineUp(getLineUp());
                    UI.deckLabel.setText("Deck: "+countDeck());
                    UI.mainDeckLabel.setText("Main Deck: "+countMainDeck());
                    UI.drawKickStack(getKickStack());
                    UI.drawSuperVillains(getSuperVillains());
                }
                else if (response.startsWith("GAMEOVER"))
                {
                    UI.gameOver();
                    break;
                }
                else if (response.startsWith("OPP"))
                {
                    try{
                    oppState = (ArrayList<ArrayList<String>>)inputStream.readObject();
                    }
                    catch(StreamCorruptedException e){
                        e.printStackTrace();
                    }
                    UI.drawOppHand(getOppHand());
                    UI.drawOppInPlay(getOppInPlay());
                    UI.drawOppDiscard(getOppDiscard());
                    UI.oppDeckLabel.setText("Opp Deck: "+countOppDeck());
                    UI.oppPowerLabel.setText("Opp Power: "+getOppPower());
                }
                else if (response.startsWith("TAKE"))
                {
                    out.println("GIMME");
                }
                else if (response.startsWith("UPP"))
                    out.println("GIMMEUPP");
                else if (response.startsWith("BATSIGNAL"))
                {
                    UI.batSignal(getDiscard());
                }
                else if (response.startsWith("ATKDISCARD"))
                {
                    UI.messageLabel.setText("ATTACK: Discard a card.");
                    UI.drawHandAtkDiscard(getHand());
                }
            }
        }
        finally {
            socket.close();
        }
    }
    
    public static void main(String[] args) throws Exception {
        //while (true) {
            //String serverAddress = (args.length == 0) ? "localhost" : args[1];
            String serverAddress = "142.196.224.227";
            DeckBuildingClient client = new DeckBuildingClient(serverAddress);
            client.play();
            //if (!client.wantsToPlayAgain()) {
            //    break;
            //}
        //}
    }
}

