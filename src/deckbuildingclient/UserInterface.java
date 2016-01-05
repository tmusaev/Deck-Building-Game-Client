package deckbuildingclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class UserInterface {
    private JFrame frame = new JFrame("Deckbuilding Game");
    public JLabel messageLabel = new JLabel("Welcome!");
    public JLabel powerLabel = new JLabel("Power: 0");
    public JLabel deckLabel = new JLabel("Deck: ");
    public JLabel mainDeckLabel = new JLabel("Main Deck: ");
    public JLabel oppDeckLabel = new JLabel("Opp Deck: ");
    public JLabel oppPowerLabel = new JLabel("Opp Power: ");
    JButton button;
    JButton endTurn = new JButton("END TURN");
    JPanel discardUI = new JPanel();
    JPanel handUI = new JPanel();
    JPanel inPlayUI = new JPanel();
    JPanel playerUI = new JPanel();
    JPanel handDiscard = new JPanel();
    JPanel lineUpUI = new JPanel();
    JPanel labels = new JPanel();
    JPanel lineUpContainer = new JPanel();
    JPanel handContainer = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel p1 = new JPanel();
    JPanel labelsContainer = new JPanel();
    JPanel discardContainer = new JPanel();
    JPanel inPlayContainer = new JPanel();
    JPanel kickUI = new JPanel();
    JPanel kickContainer = new JPanel();
    JPanel toolTip = new JPanel();
    JPanel superVillainUI = new JPanel();
    JLabel kickCount = new JLabel();
    JLabel superVillainCount = new JLabel();
    JLabel discardCount = new JLabel();
    JPanel superVillainContainer = new JPanel();
    JPanel oppHandContainer = new JPanel();
    JPanel oppHandUI = new JPanel();
    JPanel oppInPlayContainer = new JPanel();
    JPanel oppInPlayUI = new JPanel();
    JPanel oppDiscardContainer = new JPanel();
    JPanel oppDiscardUI = new JPanel();
    JLabel oppDiscardCount = new JLabel();
    
    
    PrintWriter out;
    
    public UserInterface(PrintWriter o)
    {
        out = o;
        //p1.setBackground(Color.black);
        //toolTip.setBackground(Color.black);
        superVillainContainer.setLayout(new BoxLayout(superVillainContainer, BoxLayout.PAGE_AXIS));
        superVillainContainer.setPreferredSize(new Dimension(0,0));
        superVillainUI.setPreferredSize(new Dimension(0,0));
        superVillainContainer.add(superVillainCount);
        superVillainContainer.add(superVillainUI);
        toolTip.setPreferredSize(new Dimension(0,0));
        kickUI.setPreferredSize(new Dimension(0,0));
        //kickUI.add(kickCount);
        kickContainer.setLayout(new BoxLayout(kickContainer, BoxLayout.PAGE_AXIS));
        kickContainer.setPreferredSize(new Dimension(0,0));
        kickContainer.add(kickCount);
        kickContainer.add(kickUI);
        endTurn.addActionListener(new endListener());
        discardContainer.setLayout(new BoxLayout(discardContainer, BoxLayout.PAGE_AXIS));
        oppDiscardContainer.setLayout(new BoxLayout(oppDiscardContainer, BoxLayout.PAGE_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        /////frame.add(discardUI, BorderLayout.WEST);
        //frame.add(endTurn, BorderLayout.EAST);
        //handDiscard.add(discardUI);
        discardContainer.add(discardCount);
        discardContainer.add(discardUI);
        discardContainer.setPreferredSize(new Dimension(0,0));
        oppDiscardContainer.add(oppDiscardCount);
        oppDiscardContainer.add(oppDiscardUI);
        oppDiscardContainer.setPreferredSize(new Dimension(0,0));
        handUI.setBackground(Color.yellow);
        handContainer.setPreferredSize(new Dimension(0, 0));
        handContainer.add(handUI);
        oppHandContainer.setPreferredSize(new Dimension(400, 0));
        oppHandContainer.add(oppHandUI);
        //handDiscard.add(handUI);
        playerUI.setLayout(new BoxLayout(playerUI, BoxLayout.PAGE_AXIS));
        lineUpUI.setBackground(Color.red);
        lineUpContainer.setPreferredSize(new Dimension(0, 0));
        lineUpContainer.add(lineUpUI);
        //lineUpContainer.add(superVillainUI);
        //playerUI.add(lineUpContainer);
        inPlayContainer.setPreferredSize(new Dimension(0, 0));
        inPlayContainer.add(inPlayUI);
        oppInPlayContainer.setPreferredSize(new Dimension(0, 0));
        oppInPlayContainer.add(oppInPlayUI);
        //playerUI.add(inPlayUI);
        handDiscard.setPreferredSize(new Dimension(0, 0));
        playerUI.add(handDiscard);
        ////frame.add(playerUI, BorderLayout.SOUTH);
        //frame.add(inPlayUI, BorderLayout.CENTER);
        //frame.add(powerLabel, BorderLayout.CENTER);
        labels.setLayout(new BoxLayout(labels, BoxLayout.PAGE_AXIS));
        labels.add(messageLabel);
        labels.add(powerLabel);
        labels.add(oppPowerLabel);
        labels.add(deckLabel);
        labels.add(oppDeckLabel);
        labels.add(mainDeckLabel);
        labels.add(endTurn);
        labelsContainer.add(labels);
        labelsContainer.setPreferredSize(new Dimension(0,0));
        lineUpContainer.add(labels);
        //frame.getContentPane().add(messageLabel, "South");
        //rightPanel.add(labels);
        //rightPanel.add(endTurn);
        /////frame.add(labels, BorderLayout.WEST);
        
        frame.add(p1);
        GridBagLayout gm1 = new GridBagLayout();
        p1.setLayout(gm1);
        GridBagConstraints cns = new GridBagConstraints();

        JButton b1 = new JButton("Button 1");
        JPanel p11 = new JPanel();
        cns.gridx = 0;
        cns.gridy = 0;
        cns.weightx = 0.1;
        cns.weighty = 0.1;
        cns.fill = GridBagConstraints.BOTH;

        //p1.add(p11, cns);
        
        JButton b10 = new JButton("Button 10");
        JPanel p6 = new JPanel();
        cns.gridx = 1;
        cns.gridy = 0;
        cns.gridwidth = 1;
        //p1.add(p6, cns);
        //p1.add(b10, cns);
        
        JButton b11 = new JButton("Button 11");
        JPanel p7 = new JPanel();
        cns.gridx = 2;
        cns.gridy = 0;
        cns.gridwidth = 1;
        //p1.add(p7, cns);
        //p1.add(b11, cns);
        
        JButton b12 = new JButton("Button 12");
        JPanel p8 = new JPanel();
        cns.gridx = 3;
        cns.gridy = 0;
        //p1.add(p8, cns);
        //p1.add(b12, cns);
        
        JButton b13 = new JButton("Button 13");
        cns.gridx = 4;
        cns.gridy = 0;
        cns.gridheight = 1;
        p1.add(toolTip, cns);
        //p1.add(b13, cns);
        
        JButton b15 = new JButton("Button 15");
        JPanel p41 = new JPanel();
        p41.setPreferredSize(new Dimension(100,0));
        cns.gridx = 6;
        cns.gridy = 0;
        cns.gridheight = 1;
        p1.add(toolTip, cns);
        //p1.add(p41, cns);
        
        JButton b14 = new JButton("Button 14");
        JPanel p40 = new JPanel();
        //p40.setBackground(Color.black);
        p40.setPreferredSize(new Dimension(100,0));
        cns.gridx = 5;
        cns.gridy = 0;
        cns.gridheight = 1;
        //p1.add(toolTip, cns);
        p1.add(p40, cns);
        
        cns.gridx = 5;
        cns.gridy = 1;
        cns.gridwidth = 3;
        cns.gridheight = 3;
        p1.add(toolTip, cns);
        
        JButton b2 = new JButton("Button 2");
        JPanel p9 = new JPanel();
        cns.gridx = 0;
        cns.gridy = 1;
        cns.gridwidth = 1;
        cns.gridheight = 1;
        p1.add(p9, cns);
        //p1.add(b2, cns);
        
        JButton b3 = new JButton("Button 3");
        cns.gridx = 0;
        cns.gridy = 2;
        p1.add(superVillainContainer, cns);
        
        JButton b4 = new JButton("Button 4");
        JPanel p10 = new JPanel();
        cns.gridx = 0;
        cns.gridy = 3;
        p1.add(p10, cns);
        //p1.add(b4, cns);
        
        JButton b5 = new JButton("Button 5");
        cns.gridx = 0;
        cns.gridy = 4;
        p1.add(discardContainer, cns);
        
        
        cns.gridx = 1;
        cns.gridy = 2;
        cns.gridwidth = 3;
        cns.weightx = 0.1;
        cns.weighty = 0;
        cns.fill = GridBagConstraints.BOTH;

        p1.add(lineUpContainer, cns);
        
        cns.gridx = 4;
        cns.gridy = 2;
        cns.gridwidth = 1;
        cns.weightx = 0.1;
        cns.weighty = 0;
        cns.fill = GridBagConstraints.BOTH;

        p1.add(kickContainer, cns);
        
        cns.gridx = 1;
        cns.gridy = 3;
        cns.gridwidth = 3;
        cns.weightx = 0.1;
        cns.weighty = 0;
        cns.fill = GridBagConstraints.BOTH;

        p1.add(inPlayContainer, cns);
        
        cns.gridx = 1;
        cns.gridy = 4;
        cns.gridwidth = 3;
        cns.weightx = 0.1;
        cns.weighty = 0;
        cns.fill = GridBagConstraints.BOTH;

        p1.add(handContainer, cns);
        
        cns.gridx = 1;
        cns.gridy = 0;
        cns.gridwidth = 3;
        p1.add(oppHandContainer, cns);
        //p1.add(b10, cns);
        
        cns.gridx = 1;
        cns.gridy = 1;
        cns.gridwidth = 3;
        p1.add(oppInPlayContainer, cns);
        
        cns.gridx = 0;
        cns.gridy = 0;
        cns.gridwidth = 1;
        p1.add(oppDiscardContainer, cns);
        
        
        
        //frame.add(labels, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800, 800);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    
    private class kickListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent e)
        {
            out.println("KICK");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }	
    }
    
    private class superVillainListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent e)
        {
            out.println("SV");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }	
    }
    
    private class endListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent e)
        {
            out.println("END");
        }	
    }
    
    private class lineUpListener implements ActionListener
    {
        int index;
        PrintWriter out;
        int x = 1;
        
        public lineUpListener(int i, PrintWriter o)
        {
            index = i;
            out = o;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if (x == 1)
            {
                out.println("BUY "+index);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                x = 0;
            }
        }	
    } 
    
    private class handListener implements ActionListener
    {
        int index;
        PrintWriter out;
        int x = 1;
        
        public handListener(int i, PrintWriter o)
        {
            index = i;
            out = o;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if(x == 1)
            {
                out.println("PLAY "+index);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                x = 0;
            }
        }	
    }
    
    private class atkDiscardListener implements ActionListener
    {
        int index;
        PrintWriter out;
        JFrame handFrame;
        int x = 1;
        
        public atkDiscardListener(int i, PrintWriter o, JFrame f)
        {
            index = i;
            out = o;
            handFrame = f;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if(x == 1)
            {
                out.println("DISCARD "+index);
                handFrame.setVisible(false);
                handFrame.dispose();
                messageLabel.setText("OPPONENT'S TURN");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                x = 0;
            }
        }	
    }
    
    private class batSignalListener implements ActionListener
    {
        int index;
        PrintWriter out;
        JFrame discardFrame;
        int x = 1;
        
        public batSignalListener(int i, PrintWriter o, JFrame f)
        {
            index = i;
            out = o;
            discardFrame = f;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if(x == 1)
            {
                out.println("BATSIGNAL "+index);
                discardFrame.setVisible(false);
                discardFrame.dispose();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                x = 0;
            }
        }	
    }
    
    private class discardPileListener implements ActionListener
    {
        ArrayList<Card> discardPile = new ArrayList();
        JPanel container = new JPanel();
        public discardPileListener(ArrayList<Card> d)
        {
            discardPile = d;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            JFrame frame = new JFrame("Discard Pile");
            container.removeAll();
            Border empty = BorderFactory.createEmptyBorder();
        for(Card c:discardPile)
        {
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            //button.addActionListener(new lineUpListener(i, out));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            //button.setMargin(new Insets(0, 0, 0, 0));
            //button.setBorder(new EmptyBorder(0, 0, 0, 0));
            container.add(button);
        }
            frame.add(container);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setAlwaysOnTop(true);
            frame.setVisible(true);
        }	
    }
    
     public void drawLineUp(ArrayList<Card> lineUp)
    {
        lineUpUI.removeAll();
        int i = 0;
        Border empty = BorderFactory.createEmptyBorder();
        for(Card c:lineUp)
        {
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new lineUpListener(i, out));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            //button.setMargin(new Insets(0, 0, 0, 0));
            //button.setBorder(new EmptyBorder(0, 0, 0, 0));
            lineUpUI.add(button);
            i++;
        }
        lineUpUI.revalidate();
        lineUpUI.repaint();
    }
    
    public void drawHand(ArrayList<Card> hand)
    {
        handUI.removeAll();
        handUI.setBackground(Color.yellow);
        int i = 0;
        Border empty = BorderFactory.createEmptyBorder();
        for(Card c:hand)
        {
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new handListener(i, out));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            //button.setMargin(new Insets(0, 0, 0, 0));
            //button.setBorder(new EmptyBorder(0, 0, 0, 0));
            handUI.add(button);
            i++;
        }
        handUI.revalidate();
        handUI.repaint();
    }
    
    public void drawHandAtkDiscard(ArrayList<Card> hand)
    {
        JFrame handFrame = new JFrame("Discard a card");
        JPanel container = new JPanel();
            
            Border empty = BorderFactory.createEmptyBorder();
        int i = 0;
        for(Card c:hand)
        {
            
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new atkDiscardListener(i, out, handFrame));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            //button.setMargin(new Insets(0, 0, 0, 0));
            //button.setBorder(new EmptyBorder(0, 0, 0, 0));
            container.add(button);
            
            i++;
        }
            handFrame.add(container);
            handFrame.setSize(400, 400);
            handFrame.setLocationRelativeTo(null);
            handFrame.setAlwaysOnTop(true);
            handFrame.setVisible(true);
    }
    
    public void drawInPlay(ArrayList<Card> inPlay)
    {
        inPlayUI.removeAll();
        int i = 0;
        Border empty = BorderFactory.createEmptyBorder();
        for(Card c:inPlay)
        {
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            //button.addActionListener(new handListener(i, out));
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            inPlayUI.add(button);
            i++;
        }
        inPlayUI.revalidate();
        inPlayUI.repaint();
    }
    
    public void drawOppInPlay(ArrayList<Card> inPlay)
    {
        oppInPlayUI.removeAll();
        int i = 0;
        Border empty = BorderFactory.createEmptyBorder();
        for(Card c:inPlay)
        {
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            //button.addActionListener(new handListener(i, out));
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            oppInPlayUI.add(button);
            i++;
        }
        oppInPlayUI.revalidate();
        oppInPlayUI.repaint();
    }
    
    public void drawDiscardPile(ArrayList<Card> discardPile)
    {
        Card c;
        discardUI.removeAll();
        discardCount.setText("");
        Border empty = BorderFactory.createEmptyBorder();
        if(discardPile.size() > 0)
        {
            discardCount.setText(""+discardPile.size());
            c = discardPile.get(discardPile.size()-1);
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new discardPileListener(discardPile));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            discardUI.add(button);
        }
        discardUI.revalidate();
        discardUI.repaint();
    }
    
    public void drawOppDiscard(ArrayList<Card> discardPile)
    {
        Card c;
        oppDiscardUI.removeAll();
        oppDiscardCount.setText("");
        Border empty = BorderFactory.createEmptyBorder();
        if(discardPile.size() > 0)
        {
            oppDiscardCount.setText(""+discardPile.size());
            c = discardPile.get(discardPile.size()-1);
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            oppDiscardUI.add(button);
        }
        oppDiscardUI.revalidate();
        oppDiscardUI.repaint();
    }
    
    public void drawKickStack(ArrayList<Card> kickStack)
    {
        Card c;
        Border empty = BorderFactory.createEmptyBorder();
        kickUI.removeAll();
        if(kickStack.size() > 0)
        {
            kickCount.setText(""+kickStack.size());
            c = kickStack.get(0);
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new kickListener());
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            kickUI.add(button);
        }
        kickUI.revalidate();
        kickUI.repaint();
    }
    
    public void drawOppHand(ArrayList<Card> hand)
    {
        oppHandUI.removeAll();
        int i = 0;
        Border empty = BorderFactory.createEmptyBorder();
        for(Card c:hand)
        {
            button = new JButton(new ImageIcon(getClass().getResource("/images/back.jpg")));
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            //button.setMargin(new Insets(0, 0, 0, 0));
            //button.setBorder(new EmptyBorder(0, 0, 0, 0));
            oppHandUI.add(button);
            i++;
        }
        oppHandUI.revalidate();
        oppHandUI.repaint();
    }
    
    public void drawSuperVillains(ArrayList<Card> superVillainStack)
    {
        Card c;
        Border empty = BorderFactory.createEmptyBorder();
        superVillainUI.removeAll();
        if(superVillainStack.size() > 0)
        {
            superVillainCount.setText(""+superVillainStack.size());
            c = superVillainStack.get(0);
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new superVillainListener());
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            superVillainUI.add(button);
        }
        superVillainUI.revalidate();
        superVillainUI.repaint();
    }
    
    public void batSignal(ArrayList<Card> discardPile)
    {
        JFrame discardFrame = new JFrame("Discard Pile");
        JPanel container = new JPanel();
            
            Border empty = BorderFactory.createEmptyBorder();
        int i = 0;
        for(Card c:discardPile)
        {
            if(c.type.equals("Hero"))
            {
            button = new JButton(new ImageIcon(getClass().getResource(c.imagepath)));
            button.addActionListener(new batSignalListener(i, out, discardFrame));
            button.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent evt)
                {
                    toolTip.removeAll();
                    JButton button2 = new JButton(new ImageIcon(getClass().getResource(c.tooltip)));
                    button2.setBorder(empty); 
                    button2.setContentAreaFilled(false); 
                    button2.setFocusPainted(false); 
                    button2.setOpaque(false);
                    toolTip.add(button2);
                    toolTip.revalidate();
                    toolTip.repaint();
                }
                
            });
            button.setBorder(empty);
            //button.setBorderPainted(false); 
            button.setContentAreaFilled(false); 
            button.setFocusPainted(false); 
            button.setOpaque(false);
            //button.setMargin(new Insets(0, 0, 0, 0));
            //button.setBorder(new EmptyBorder(0, 0, 0, 0));
            container.add(button);
            }
            i++;
        }
            discardFrame.add(container);
            discardFrame.setSize(400, 400);
            discardFrame.setLocationRelativeTo(null);
            discardFrame.setAlwaysOnTop(true);
            discardFrame.setVisible(true);
    }
    
    public void gameOver()
    {
        frame.dispose();
    }

}
