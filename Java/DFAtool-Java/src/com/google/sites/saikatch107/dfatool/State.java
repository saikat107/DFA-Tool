package com.google.sites.saikatch107.dfatool;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Saikat
 */
public class State {
    private int id;
    private boolean isStartState;
    private boolean isFinishedState;
    private Map<Character, State> transitionMap;
    
    public State(){
        transitionMap = new HashMap<Character, State>();
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public boolean isStartState(){
        return this.isStartState;
    }
    
    public boolean isFinishedState(){
        return this.isFinishedState;
    }
    
    public void markAsStartState(boolean mark){
        isStartState = mark;
    }
    
    public void markAsFinishedState(boolean mark){
        isFinishedState = mark;
    }
    
    protected void addTransitionEntry(Character ch , State next)
            throws DfaException
    {
        if(transitionMap.containsKey(ch)){
            throw new DfaException("Already Contains the transition function");
        }
        transitionMap.put(ch, next);
        
    }
    
    State getNextState(char ch){
        return transitionMap.get(ch);
    }
}
