# About the Project
This is a Java project to perform automated test that opens Google.com in Firefox Web browser, performs search for "Selenium",
and verifies result on first two pages.

## Prerequisites
In order to utilise this project you need to have the following latest versions installed locally:
Intellij Idea;
JDK;
Firefox (If Firefox is already installed, make sure it's up-to-date);
Geckodriver (place it under C - Program files - Windows-System32; 
Markdown plug-in;
Registered account at Github.

## Running Tests
1. Run cmd.exe
2. Enter "mvn -f C:\local\path\to\pom.xml clean install"

# Repo Structure
## Pages
1. GoogleBasePage (basic class that contains objects and elements for all pages);
2. GoogleSearchPage (contains objects and elements for page that opens after user enters google.com in the browser);
3. GoogleSearchResultOnePage (contains objects and elements for first page with search results);
4. GoogleSearchResultTwoPage ()contains objects and elements for second page with search results).

## Tests
1. GoogleBaseTest (basic test for all tests);
2. GoogleSearchTest (test that performs search and verifies results).



