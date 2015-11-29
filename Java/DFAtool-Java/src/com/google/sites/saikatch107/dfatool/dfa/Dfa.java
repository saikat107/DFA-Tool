/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.sites.saikatch107.dfatool.dfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
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
    private String filename = null;
    private Map<String , Integer> stateMap = null;
    private Dfa(String filename){
        this.filename = filename;
        stateMap = new HashMap<String , Integer>();
    }
    
    public static Dfa createDfa(String filename){
        Dfa dfa = new Dfa(filename);
        Scanner fileScanner = null;
        try {
             fileScanner = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dfa.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        String stateLine = fileScanner.nextLine();
        StringTokenizer stateLineTokenizer = new StringTokenizer(stateLine, ", \t");
        dfa.numberOfState = 0;
        while(stateLineTokenizer.hasMoreTokens()){
            String stateName = stateLineTokenizer.nextToken().trim();
            dfa.stateMap.put(stateName, dfa.numberOfState);
            dfa.numberOfState++;
        }
        dfa.states = new State[dfa.numberOfState];
        for(int i = 0 ; i < dfa.numberOfState ; i++){
            dfa.states[i] = new State();
            dfa.states[i].setId(i);
            dfa.states[i].markAsStartState(false);
            dfa.states[i].markAsFinishedState(false);
        }
        String alp = fileScanner.nextLine();
        dfa.alphabet = alp.toCharArray();
        String st = fileScanner.nextLine().trim();
        if(dfa.stateMap.containsKey(st)){
            dfa.startIndex = dfa.stateMap.get(st);
        }
        else{
            System.err.println("Start state is not present in the state list."
                    + "\nError in definition file!");
            System.exit(-1);
        }
        dfa.states[dfa.startIndex].markAsStartState(true);
        String finishIndices = fileScanner.nextLine();
        StringTokenizer tok = new StringTokenizer(finishIndices,", \t");
        while(tok.hasMoreTokens()){
            String fi = tok.nextToken();
            if(dfa.stateMap.containsKey(fi)){
                dfa.finishIndex = dfa.stateMap.get(fi);
                dfa.states[dfa.finishIndex].markAsFinishedState(true);
            }
            else{
                System.err.println("At least one of Accepting states is not present in the state list."
                    + "\nError in definition file!");
                System.exit(-1);
            }
        }
        
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line,", \t");
            String start = tokenizer.nextToken();
            char ch = tokenizer.nextToken().trim().charAt(0);
            String finish = tokenizer.nextToken();
            try {
                if(!dfa.stateMap.containsKey(start)){
                    System.err.println("State " + start + "is not present in the state list."
                    + "\nError in definition file!");
                    System.exit(-1);
                }
                int startIdx = dfa.stateMap.get(start);
                int finishIdx = dfa.stateMap.get(finish);
                if(!dfa.stateMap.containsKey(finish)){
                    System.err.println("State " + finish + "is not present in the state list."
                    + "\nError in definition file!");
                    System.exit(-1);
                }
                dfa.states[startIdx].addTransitionEntry(ch, dfa.states[finishIdx]);
            } catch (DfaException ex) {
                Logger.getLogger(Dfa.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        try {
            dfa.validateDfa();
            System.out.println("DFA construction Successful!");
        } catch (DfaException ex) {
            Logger.getLogger(Dfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfa;
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
