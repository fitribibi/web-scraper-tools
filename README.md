# web-scraper-tools

Web scraping is an activity to extract data information by parsing the html of a web page. Three main processes in web scraping are connecting to the target URL, then extracting the data, and storing the output as final steps. 

In this project, I tried to get top 100 mobile phone products from an e-commerce website so I use Selenium for connecting to the target website URL, and then extract the data using Jsoup, and store the data as a CSV file using OpenCSV.

What I used:
- Maven
- Java 1.8
- Selenium
- Chrome driver executable jar
- Jsoup
- OpenCSV

Run the program
- To run the program, execute commands below in the root of project

```
mvn clean dependency:copy-dependencies package
java -jar target/web-scraper-1.0-SNAPSHOT.jar
```
