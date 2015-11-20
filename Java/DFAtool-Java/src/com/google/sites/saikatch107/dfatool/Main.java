package com.google.sites.saikatch107.dfatool;

import com.google.sites.saikatch107.dfatool.dfa.Dfa;

/**
 *
 * @author Saikat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    /**
     * Create a Dfa with the DFA definition filename(with path) as argument
     * if the DFA contruction is successful You will see a message "DFA contruction successful"
     * Simulate a string with DFA by calling dfa.simulateDfa(string);
     **/
    public static void main(String[] args) {
        // TODO code application logic here
        Dfa dfa = new Dfa("settings.txt");
        dfa.simulateDfa("0101");
    }
    
}
