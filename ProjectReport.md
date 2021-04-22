# Project Report

William English

## Challenge #1 Complete

Within the QueryEngineModule, the FakeQueryEngine was being passed and bound to the QueryEngine that is used within the application. 
I imported the WikipediaQueryEngine instead and bound it to the QueryEngine removing the FakeQueryEngine from being used.

## Challenge #2 Complete

Many changes were made to get the new Formatter interface setup and the RevisionFormatter opposing execution flow. 
First, I made a Formatter interface that includes format function. I then moved the RevisionFormatter to be in the model folder with the Formatter interface. I changed RevisionFormatter to implement Formatter.
Then, I created a FormatterModule to bind the RevisionFormatter to the interface Formatter. In App file, I added the FormatterModule to the Guice Injector. 
Within the WikipediaAnalyzer, I was now able to add the Formatter as an Injection. Then I took out the line that created a new object of RevisionsFormatter. The newly injected Formatter now formats in the revision. 
Finally, I changed the RevisionFormatter to now output each revision as "User made a change at ISO_INSTANT_TIME".


## Challenge #3 Complete

There weren't many changes, but I removed the for loop printing the revisions. I then took the list and converted to stream. That stream was then mapped and within the map function I used the Formatter to format the revisions and add a line break.
The map was then collected and joined using the Collectors class and its joining function. This made the map into one string. The string was then put into the outputArea like before.

## Reflection Question #1: Functional vs OO

(Write one or more paragraphs comparing and contrasting the iterative and functional  
approaches to string concatenation you explored in challenge #3. Which do you
prefer, and why?)

## Reflection Question #2: Polymorphism and Dependency Inversion

(Explain how polymorphism engendered dependency inversion in this little
application. Be clear and precise here, as this is, in part, an assessment of
your correct use of technical terminology.
Consider, for example, where exactly is polymorphism used?
Where exactly is a dependency inverted?)

