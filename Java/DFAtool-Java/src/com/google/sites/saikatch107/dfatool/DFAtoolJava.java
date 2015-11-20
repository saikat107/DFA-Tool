package com.google.sites.saikatch107.dfatool;

/**
 *
 * @author Saikat
 */
public class DFAtoolJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dfa dfa = new Dfa("G:\\AUST\\Fall 2015\\Compiler Lab\\DFA Tool\\Java\\DFAtool-Java\\settings.txt");
        dfa.simulateDfa("010");
    }
    
}
