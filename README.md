# JavaFX-exe-tutorial
This tutorial will explain how to package your JavaFX project into an exe file (or any other file type the jpackage command supports). Once the exe file is generated, you can run it to install it on any windows machine as a standalone application.
As this is just a simple demo, the program will not do anything fancy - it will just open a window saying hello world and have a button which does nothing when you click on it.

## Overview
Below is a file tree showing the structure and contents of the directories in this repo.
```
├───com.darky.hello
│   └───src
│   │   module-info.java
│   │
│   ├───com
│   │   └───darky
│   │           Hello.java
│   │
│   └───META-INF
│            MANIFEST.MF
├───mods
│   └───com.darky.hello
│   	│   module-info.class
│   	│
│   	└───com
│           └───darky
│                   Hello.class
└───out
    └───production
    	└───com.darky.hello
            │   module-info.class
            │
            ├───com
	    │   └───darky
	    │           Hello.class
            │
	    └───META-INF
	            MANIFEST.MF
```

`com.darky.hello` is the folder containing all the source files. After compiling the source files the output folder `mods` is produced.

## Creating an exe file
To create an exe file we will first have to compile the source code (in this case it has already been done for you and the ouput is in the `mods` folder). You can either use an IDE of your choice or just run the following command line argument.

```
javac -p %Path_to_javafx-sdk_lib% -d mods\com.darky.hello .\com.darky.hello\src\com\darky\Hello.java .\com.darky.hello\src\module-info.java
```
The `%Path_to_javafx-sdk_lib%` is the path to where your javafx SDK lib folder is on your computer.

Next we need to run the jpackage command from the command line to generate the exe file.

```
jpackage --type exe -n Hello --module-path "%Path_to_javafx_jmods%;mods"  -m com.darky.hello/com.darky.Hello --win-shortcut
```
