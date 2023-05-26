<!---
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->

Apache Commons FileUpload
===================

It is a semester project README file. It includes comprehensive details about dependability analysis on commons-fileupload library.

Report structure 
-------------
project is about comprehensive assessment of a project's reliability, dependability, and security. It covers various aspects of the analysis and procedures conducted.

the report introduces the project and defines its scope. It discusses the external software and tools that were utilized during the process. The focal point of the report, providing detailed analyses , procedures and the outcomes of these analyses and the subsequent changes made based on the findings. This file covers a wide range of topics, including system construction, project orchestration using Docker and Docker Hub, quality analysis with Sonar, code coverage assessment using JaCoCo, mutation testing, evaluation of energy consumption with EcoCode, performance testing using JMH, generation of regression test cases, and scrutiny of security aspects within the project.

Tools and softwares
-----------------------------------
+ [Git](https://git-scm.com/)
+ [GitHub](https://github.com/)
+ [Intellij](https://www.jetbrains.com/idea/)
+ [Docker](https://www.docker.com/products/docker-desktop/)

Building the system
-----------------------------------
+ [apache maven 3.9.1](https://maven.apache.org/download.cgi)
+ [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
+ [JDK 8](https://www.oracle.com/it/java/technologies/javase/javase8-archive-downloads.html)


Analysis 
------------
After successfully building the project, the first analysis is the sonar cloud analysis.  In this analysis I made initial checks on my project. This analysis resulted in a report which showed bugs and cord smells based on their severities. This analysis not only reported the bugs but also potential solutions to those issues. I refactored many code smells and bugs with the help of solutions provided by sonar cloud. 

After an initial check with my project, I did the orchestration of my project through docker. In this I containerized my whole project by simply adding a docker file into my project directory. This file contained the instructions which were used to build my docker image. Later I downloaded that image via get on my local machine. After successfully creating the image, I published that image to the docker hub by using GitHub actions. 

In this project I computed the code coverage via Cobertura and JaCoCo. After successfully building their project the code coverage report can be found under the target folder. 

Part of this project was also about assisting the test suite itself. For that I used mutation testing analysis. In this analysis I deliberately introduced artificial defects in my code to check if my test suite was able to kill those mutants. For this I made use of PI test plugin along with its dependency with JUnit 5. The detailed report of this test can be found under the test report folder on this repository.

Under scope of this project, I computed the energy greediness of my project via EcoCode. I analyzed this project with SonarQube and then installed EcoCode plugin through marketplace in SonarQube account and imported the EcoCode rules in my project. In this way I was able to report all the quote smells related to energy. 

The performance testing of this project was carried out by Java microbench harness. Janet is basically a framework offered by open JDK which allows us to create and execute benchmarks for Java code. For executing benchmarks, we need to choose one class and its method. In my case I chose the setlowercasenames () method from parameter parser class and I created its benchmark annotation by making juice of new public class. This benchmark computed the performance and the average time of the method.

To improve the code coverage, I made use of EvoSuite and Randoop. These two are the tools used for automated software testing, they generate unit tests for Java applications. EvoSuite uses a technique called search-based software engineering to generate test cases which ultimately results in high code coverage. Randoop Generates regression tests and error tests. The EvoSuite and Randoop test cases can be found under EvoSuite-test and Randoop-test folders respectively. 

To run security analysis, I made use of FindSecBugs. This analysis discovered bugs and vulnerabilities related to security. This analysis resulted in nothing because as per this analysis this library doesn't have any potential security vulnerability or bug. 

For examining the vulnerability related to dependencies I made use of OWASP DC. It examines the dependencies and matches them with the database of recognized vulnerabilities. The result of this analysis is found as an HTML report and in which we can find a list of affected dependencies.

OWASP ZAP can also be used for running security analysis, but it is designed for web application specifically and this project itself is a Java library. Therefore, this analysis cannot be executed on this project. 


Conclusion
-------
This report is written to fulfil the semester project requirement of Software dependability course. This report showcases the practical knowledge which I gained in three months during my lessons on this course.

In this report I have mentioned all the software dependability analysis I ran on apache software foundation project name “commons-fileupload” and orchestration of this library on my local docker desktop. 



Additional Resources
--------------------

+ For more information about this project mail me at a.faiz@studenti.unisa.it

