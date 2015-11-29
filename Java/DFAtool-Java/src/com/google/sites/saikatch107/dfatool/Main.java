package com.google.sites.saikatch107.dfatool;

import com.google.sites.saikatch107.dfatool.dfa.Dfa;

/**
 *
 * @author Saikat
 */
public class Main {

    /**
     * Create a Dfa with the DFA definition filename(with path) as argument
     * if the DFA construction is successful You will see a message "DFA construction successful"
     * Simulate a string with DFA by calling dfa.simulateDfa(string);
     **/
    public static void main(String[] args) {
        // TODO code application logic here
        Dfa dfa = Dfa.createDfa("definition.txt");
        //dfa.debug(); 
        dfa.simulateDfa("ba");
    }
    
}
