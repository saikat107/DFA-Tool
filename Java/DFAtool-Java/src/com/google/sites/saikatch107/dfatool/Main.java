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
    public static void main(String[] args) {
        // TODO code application logic here
        Dfa dfa = new Dfa("G:\\AUST\\Fall 2015\\Compiler Lab\\DFA Tool\\Java\\DFAtool-Java\\settings.txt");
        dfa.simulateDfa("0101");
    }
    
}
