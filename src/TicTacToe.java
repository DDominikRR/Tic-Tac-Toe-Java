import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    Boolean player1_turn;

    //constructor
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(255,255,190));
        text_field.setFont(new Font("Times New Roman",Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(25,144,25));

        for(int i=0;i<=8;i++)
        {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman",Font.BOLD,90));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<=8;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color (255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        text_field.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color( 0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        text_field.setText("X turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn(){
        //delay title->who's turn
        try{
            Thread.sleep(1250);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn = true;
            text_field.setText("X Turn");
        }
        else{
            player1_turn = false;
            text_field.setText("O Turn");
        }
    }

    public void check(){
        //check X
        //Horizontal
        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
        ){
            xWins(0,1,2);
        }
        else if(
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        else if(
                (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }
        //Vertical
        else if(
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        else if(
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        else if(
                (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }
        //Diagonal
        else if(
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        else if(
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }

        //Check O
        //Horizontal
        else if(
                (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }
        else if(
                (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }
        else if(
                (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }
        //Vertical
        else if(
                (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }
        else if(
                (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }
        else if(
                (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }
        //Diagonal
        else if(
                (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        else if(
                (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }
        else if(
                (((buttons[0]).getText()=="X") || ((buttons[0]).getText()=="O")) &&
                (((buttons[1]).getText()=="X") || ((buttons[1]).getText()=="O")) &&
                (((buttons[2]).getText()=="X") || ((buttons[2]).getText()=="O")) &&
                (((buttons[3]).getText()=="X") || ((buttons[3]).getText()=="O")) &&
                (((buttons[4]).getText()=="X") || ((buttons[4]).getText()=="O")) &&
                (((buttons[5]).getText()=="X") || ((buttons[5]).getText()=="O")) &&
                (((buttons[6]).getText()=="X") || ((buttons[6]).getText()=="O")) &&
                (((buttons[7]).getText()=="X") || ((buttons[7]).getText()=="O")) &&
                (((buttons[8]).getText()=="X") || ((buttons[8]).getText()=="O"))
        ){
            tie();
        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<=8;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X wins!");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<=8;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O wins!");
    }
    public void tie(){
        for(int i=0;i<9;i++){
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setEnabled(false);
        }
        text_field.setText("Tie!");
        //restart();
    }

    public void restart(){

        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            Thread.currentThread().interrupt();
        }
        text_field.setText("Restart?");
        buttons[0].setBackground(Color.GREEN);
        buttons[2].setBackground(Color.RED);
        buttons[0].setForeground(Color.WHITE);
        buttons[2].setForeground(Color.WHITE);
        buttons[0].setText("Yes!");
        buttons[2].setText("No.");
        buttons[0].setEnabled(true);
        buttons[2].setEnabled(true);
    }
}
