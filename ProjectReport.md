# Project Report

William English

## Challenge #1 Complete

Within the QueryEngineModule, the FakeQueryEngine was being passed and bound to the QueryEngine that is used in WikipediaAnalyzer. 
I imported the WikipediaQueryEngine instead and bound it to the QueryEngine removing the FakeQueryEngine from being used.

## Challenge #2 Complete

Many changes were made to get the new Formatter interface setup and the RevisionFormatter opposing execution flow. 
First, I made a Formatter interface that includes a format function. I then moved the RevisionFormatter to be in the model folder with the Formatter interface. I changed RevisionFormatter to implement Formatter.
Then, I created a FormatterModule to bind the RevisionFormatter to the interface Formatter. In App, I added the FormatterModule to the Guice Injector. 
Within the WikipediaAnalyzer, I could now add the Formatter as an Injection. Then I took out the line that created a new object of RevisionsFormatter. The newly injected Formatter now formats in the revision. 
Finally, I changed the RevisionFormatter to now output each revision as "On *DATE*, *USER* made a change at *TIME*". I did this by using the LocalDateTime class to convert the Instant time into a LocalDateTime format. Then, I split the string into a string array by the "T" which splits the date and time from each other. 

## Challenge #3 Complete

I removed the for loop printing the revisions. I converted the response revisions into a stream. That stream was mapped. Within the map function, I used the Formatter to format the revisions and add a line break.
The map was then collected and joined using the Collectors class and its joining function. This converted the map into string. The string is then passed into the outputArea like before.

## Reflection Question #1: Functional vs OO

From a clean code standpoint, I am conflicted on whether I like the functional or iterative approach. The functional approach looks clean as it reduces many lines into one. 
It can also be difficult to understand how it works because there are so many functions calls. I felt like spitting the statement up wouldn't help our understanding and would only clutter with extra variables that would not be used again.
The iterative approach is much easier to understand line by line but is crowded. Before this course, I would have used the iterative approach. Now, I will heavily consider the use of maps and the functional approach for its conciseness.
My preference lies with who I am working with. If surrounding people would be more comfortable using and reading the iterative approach, then I would be willing to. Although, I will make my case for the functional approach as I continue developing software.

## Reflection Question #2: Polymorphism and Dependency Inversion

Polymorphism is used with the Formatter/QueryEngine, and the dependency is inverted in the WikipediaAnalyzer. The Formatter can take on different forms which is by definition what polymorphism is. This also applies to the QueryEngine where it could be the FakeQueryEngine or the WikipediaQueryEngine. 
In the WikipediaAnalyzer before the assignment, it was declaring and initializing the RevisionFormatter. If we wanted a different type of formatter for testing or other purposes, we'd have to change the behavior in the WikipediaAnalyzer. 
The dependency inversions occurs when using Guice to inject a Formatter as a constructor argument. If we want to change the form of the Formatter, we no longer have to alter WikipediaAnalyzer. Instead, we change the argument given. 
