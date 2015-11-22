#DFA-Tool
This tool can be used to create and simulate DFA. 

#TO CREATE DFA
You just need to write down the structure of a DFA in a text file<br/>

#STRUCTURE OF  THE DFA DEFINITION FILE
<p>      
      &nbsp&nbsp&nbsp&nbsp #line1 => Number of States.<br/>
      &nbsp&nbsp&nbsp&nbsp #line2 => Alphabet (All character of alphabet as a string).<br/>
      &nbsp&nbsp&nbsp&nbsp #line3 => Start state number (Remember state numbers are 0 indexed, i.e. first state is 0.) <br/>
      &nbsp&nbsp&nbsp&nbsp #line4 => Set on finish state numbers; comma separated;<br/>
      &nbsp&nbsp&nbsp&nbsp#line5 - End of File => These lines should be in the following format "S,c,F" where S is the start state for an edge in DFA, e is tha triggering character and F is the finish state. One line represents one edge. <br/>
 </p>
  #EXAMPLE 
  <p>
   The DFA definition file should be like following.<br/>
      &nbsp&nbsp&nbsp&nbsp 2<br/>
      &nbsp&nbsp&nbsp&nbsp 01<br/>
      &nbsp&nbsp&nbsp&nbsp 0<br/>
      &nbsp&nbsp&nbsp&nbsp 1<br/>
      &nbsp&nbsp&nbsp&nbsp 0,0,0<br/>
      &nbsp&nbsp&nbsp&nbsp 0,1,1<br/>
      &nbsp&nbsp&nbsp&nbsp 1,0,0<br/>
      &nbsp&nbsp&nbsp&nbsp 1,1,1<br/>
      <br/>
      </p>
      #Explanation 
      <p>In this example DFA there are 2 state as state in line 1. The alphabet of this DFA contains only 0 and 1.<br/><br/>
      The start state is 0 and the finish state is 1.<br/>
      There are 4 transition functions in this DFA.<br/>
          &nbsp&nbsp&nbsp&nbsp #1. from state 0 to state 0 is the input is 0<br/>
          &nbsp&nbsp&nbsp&nbsp #2. from state 0 to state 1 is the input is 1<br/>
          &nbsp&nbsp&nbsp&nbsp #3. from state 1 to state 0 is the input is 0<br/>
          &nbsp&nbsp&nbsp&nbsp #4. from state 1 to state 1 is the input is 1<br/>
</p>
