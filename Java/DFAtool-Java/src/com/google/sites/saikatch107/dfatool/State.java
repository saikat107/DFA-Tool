package com.google.sites.saikatch107.dfatool;

/**
 *
 * @author Saikat
 */
public class State {
    private int id;
    private boolean isStartState;
    private boolean isFinishedState;
    
    public State(){
        
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
    
    public void markAsStartState(){
        isStartState = true;
    }
    
    public void markAsFinishedState(){
        isFinishedState = true;
    }
}
