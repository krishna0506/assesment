Pre requisites: 

a. Java 8 JDK

If you have java, run java -version to check which version you are using. 
If you don't have java, [here](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html) is the place to look for JDK installation.

b. Gatling charts, [here](https://gatling.io/download/) Download Now.

c. gradle 3.1 or above

You may find [here](https://gradle.org/install/#manually) the steps to install gradle.

d. Scala SDK no t compulsary.

Install Scala binaries as mentioned [here](https://www.journaldev.com/7456/download-install-scala-linux-unix-windows)

# Env var

Add JAVA_HOME=<jdkhome>
ex: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home 
  
Add TOKEN to path, with new api key

# Steps to run test

1. cd assessment

2. run gradle wrapper.

3. Run Simulation from terminal:

./gradlew clean gatlingRun-simulations.GetCatogoriesSimulation

# Reports
Reports are generated under *build/reports*.
The simulation result is available in *build/reports/gatling/{simulation-number}/index.html*

In the result you will able to see the table as. following
```$xslt
Requests.....
> Global                                                   (OK=3      KO=0     )
> Get Cities for supported country                (OK=1      KO=0     )
> Get Cities with unsupported country                    (OK=1      KO=0     )
> Get Catogories                                           (OK=1      KO=0     )
```
 
 
 
