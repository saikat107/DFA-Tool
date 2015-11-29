#DFA-Tool
This tool can be used to create and simulate DFA. 

#TO CREATE DFA
You just need to write down the structure of a DFA in a text file<br/>

#STRUCTURE OF  THE DFA DEFINITION FILE
<p>      
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #line1 => List of all states; comma seperated.<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #line2 => Alphabet (All character of alphabet as a string).<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #line3 => Start state <br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #line4 => Set on accepting states; comma separated;<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp#line5 - End of File => These lines should be in the following format "S,c,F" where S is the start state for an edge in DFA, e is tha triggering character and F is the finish state. One line represents one edge. <br/>
 </p>
#EXAMPLE 
  <p>
   The DFA definition file should be like following.<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp A,B<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 01<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp A<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp B<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp A,0,A<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp A,1,B<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp B,0,A<br/>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp B,1,B<br/>
      <br/>
  </p>
 #Explanation 
      <p>In this example DFA there are 2 state as state in line 1. The alphabet of this DFA contains only 0 and 1.<br/><br/>
      The start state is A and the finish state is B.<br/>
      There are 4 transition functions in this DFA.<br/>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #1. from state A to state A for the input is 0<br/>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #2. from state A to state B for the input is 1<br/>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #3. from state B to state A for the input is 0<br/>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp #4. from state B to state B for the input is 1<br/>
</p>
