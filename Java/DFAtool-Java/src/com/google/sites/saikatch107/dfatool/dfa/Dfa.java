/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.sites.saikatch107.dfatool.dfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saikat
 */
public class Dfa {
    private State[] states;
    private int numberOfState;
    private char[] alphabet;    
    private int startIndex;
    private int finishIndex;
    
    public Dfa(String filename){
        Scanner fileScanner = null;
        try {
             fileScanner = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dfa.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        numberOfState = Integer.parseInt(fileScanner.nextLine());
        states = new State[numberOfState];
        for(int i = 0 ; i < numberOfState ; i++){
            states[i] = new State();
            states[i].setId(i);
            states[i].markAsStartState(false);
            states[i].markAsFinishedState(false);
        }
        String alp = fileScanner.nextLine();
        alphabet = alp.toCharArray();
        String st = fileScanner.nextLine();
        startIndex = Integer.parseInt(st);
        states[startIndex].markAsStartState(true);
        String finishIndices = fileScanner.nextLine();
        StringTokenizer tok = new StringTokenizer(finishIndices,",");
        while(tok.hasMoreTokens()){
            finishIndex = Integer.parseInt(tok.nextToken());
            states[finishIndex].markAsFinishedState(true);
        }
        
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line,",");
            int start = Integer.parseInt(tokenizer.nextToken());
            char ch = tokenizer.nextToken().trim().charAt(0);
            int finish = Integer.parseInt(tokenizer.nextToken());
            try {
                states[start].addTransitionEntry(ch, states[finish]);
            } catch (DfaException ex) {
                Logger.getLogger(Dfa.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        try {
            validateDfa();
            System.out.println("DFA construction Successful!");
        } catch (DfaException ex) {
            Logger.getLogger(Dfa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void validateDfa() throws DfaException {
        for(int i = 0 ; i < numberOfState ; i++){
            for(int j = 0; j < alphabet.length ; j++){
                if(states[i].getNextState(alphabet[j]) == null){
                    throw new DfaException("All transition Function is not given");
                }
            }
        }
    }
    
    public void simulateDfa(String string){
        int len = string.length();
        State startState = states[startIndex];
        State currentState = startState;
        for (int i = 0; i < len; i++){
            char ch = string.charAt(i);
            currentState = currentState.getNextState(ch);
        }
        if(currentState.isFinishedState()){
            System.out.println("DFA Simulation Successful");
        }
        else{
            System.out.println("DFA simulation Unsuccessful");
        }
    }
    
    public void debug(){
        for(int i = 0; i < numberOfState; i++){
            System.out.println(states[i].getId() + " " + 
                    states[i].isStartState() + " " + states[i].isFinishedState());
            for(int j = 0; j < alphabet.length ; j++){
                System.out.println("\t" + alphabet[j] + " " + 
                        states[i].getNextState(alphabet[j]).getId());
            }
        }
    }
}
