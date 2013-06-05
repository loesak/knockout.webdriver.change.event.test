knockout.webdriver.change.event.test
====================================
the purpose of this project was to provide a proof that WebDriver was not firing an input's change event properly. In building this project, I realized that I was the fool who was taking focus of the browser away from WebDriver while debugging in eclipse.

the project is an eclipse webapp project so you can run it on a server within eclipse and execute the test. or you can run it via maven (mvn clean install) which will start up the application in a server and execute the tests for you.