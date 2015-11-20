# DFA-Tool
This tool can be used to create and simulate DFA. 


#TO CREATE DFA
You just need to write down the structure of a DFA in a text file
  #Structure of DFA file
      #line1 => Number of States.
      
      #line2 => Alphabet (All character of alphabet as a string).
      
      #line3 => Start state number and Finish state number (Remeber state numbers are 0 indexed, i.e. first state is 0.) start and finish state number should be comma seperated.
      
      #line4 - End of File => These lines should be in the following format "S,c,F" where S is the start state for an edge in DFA, e is tha triggering character and F is the finish state. One line represents one edge. 
      
      
      
  #EXAMPLE => The DFA definition file should be like following.
      2<br/>
      01<br/>
      0,1<br/>
      0,0,0<br/>
      0,1,1<br/>
      1,0,0<br/>
      1,1,1<br/>
      
      #Explanation => In this example DFA there are 2 state as state in line 1. The alphabet of this DFA contains only 0 and 1.
      The start state is 0 and the finish state is 1.
      There are 4 transition functions in this DFA.
          #1. from state 0 to state 0 is the input is 0
          #2. from state 0 to state 1 is the input is 1
          #3. from state 1 to state 0 is the input is 0
          #4. from state 1 to state 1 is the input is 1
