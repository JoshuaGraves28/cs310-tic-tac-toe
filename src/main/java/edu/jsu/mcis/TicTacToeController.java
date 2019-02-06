package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToeController  implements ActionListener{

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this,width);
        
    }
    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source instanceof JButton){
        JButton buttons =(JButton)event.getSource();
        String buttonName = buttons.getName();

        int row = Integer.valueOf(buttonName.substring(6, 7));
        int col = Integer.valueOf(buttonName.substring(7, 8));
        System.out.println("" + row + " " + col);

        if(model.makeMark(row, col)) {view.updateSquares();}
        
        String result = model.getResult().toString();

        if(!result.equals("NONE")){
            view.disableSquares();
            view.showResult(result);
         }
        }
    }
    

  
  }
