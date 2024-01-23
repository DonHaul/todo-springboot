## Todo Spring Boot

(Code Challenge for job)

- Time: roughly 8 working hours
- Tools:
  - Intellij Idea: the autocompleting and in built compilation and git interface was much appreciated
  - VSCode: used to program a quick and barebones react front-end
  - Postman: Used to test the rest api: [API Test Link](https://www.postman.com/bazingow/workspace/springboottodo/request/3388796-2c6f5dff-9e2e-4be4-b41e-9337aad04828)
  - Chat GPT: Using it helped me prototype much faster than I usually could:
    - Spring Boot: https://chat.openai.com/c/eda501fd-f384-426b-95b2-27407e924dff 
    - React: https://chat.openai.com/c/af08e358-efa8-439c-88ac-668029eb8615


### General Thoughts

This was my first time using Spring Boot and also the first time in 2 years since I programmed in Java. Despite of this I am satisfied with what I did as well as impressed with how quickly I managed to come up with this small todo list app. I would say there are 4 main reasons for it:
1. Although not lately, I have programmed a lot in C# (not .net but in order to make UnityGames) which gave  me a good Object Oriented Basis
2. I have developed already REST Api with multiple apis (express.js, flask, php)
3. Chat GPT was my friend. Before checking some tutorials for spring boot that were not that helpfull, chat gpt really came through  It helped me with snippets of code here and there, both on the back and fron end sides.
4. My knowledge with `react` and `axios` which in conjuction with ye-olde chatgpt greatly decreased my time developing the frontend


### What else could be done:
- Prettier front end.
- Currently throught the frontend is not possible to delete `Categories`.
- Unit tests for the api
- Throwing errors in the rest api

----
Challenge:

This is a skeleton of Spring Boot application which should be used as a start point to create a working one.
The goal of this task is to create simple web application which allows users to create TODOs. In addition, the application should expose public REST API in order to allow to manipulate data programmatically.

Below you may find a proposition of the DB model:

![DB model](DBModel.png)

To complete the exercices please implement all missing classes and functonalites in order to be able to store and retrieve information about tasks and their categories.
Once you are ready, please send it to me (ie link to your git repository) before  our interview.
