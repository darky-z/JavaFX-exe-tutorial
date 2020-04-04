# JavaFX-exe-tutorial
JDK 14 comes with a much awaited tool called [jpackage](https://docs.oracle.com/en/java/javase/14/docs/specs/man/jpackage.html#jpackage-options) which allows developers to package their programs into native bundles such as exe, deb, pkg, etc. So to put this tool in action, this tutorial will explain how to package your JavaFX module into an exe file (or any other file type the jpackage command supports). Once the exe file is generated, you can run it to install it on any windows machine as a standalone application.

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
└───mods
    └───com.darky.hello
   	│   module-info.class
   	│
    	└───com
            └───darky
                    Hello.class

```

`com.darky.hello` is the folder containing all the source files. After compiling the source files the output folder `mods` is produced.

## Creating an exe file
### Compiling the source files
To create an exe file we will first have to compile the source files (in this case it has already been done for you and the ouput is in the `mods` folder). You can either use an IDE of your choice or just run the following command line argument.

```
javac -p %Path_to_javafx-sdk_lib% -d mods\com.darky.hello .\com.darky.hello\src\com\darky\Hello.java .\com.darky.hello\src\module-info.java
```
The `%Path_to_javafx-sdk_lib%` is the path to where your javafx SDK lib folder is on your computer.

**Note:** Instead of the javafx SDK lib folder, it is also possible to specify the path to your javafx jmods folder. 

### Using jpackage
Next we need to run the jpackage command from the command line to generate the exe file.

```
jpackage --type exe -n Hello --module-path "%Path_to_javafx_jmods%;mods"  -m com.darky.hello/com.darky.Hello --win-shortcut
```
The `%Path_to_javafx_jmods%` is the path to where your javafx jmods folder is on your computer, and `mods` is the mods folder in this case (or the path to where your compiled module is).

**Note:** Unlike when you are compiling the source files, you can only use the path to the jmods folder when using jpackage. You cannot use the javafx SDK lib path in this case.

`--type` specifies the type of native bundle to package the application into.

`-n`specifies what you want to name your application.

`--module-path` has been explained above.

`-m` is the module name followed by the main class name after the `/`.

`--win-shortcut` will make your app put a shortcut on the desktop when it installs.

Once jpackage runs it will generate an exe with the name you specified with the `-n` option. For this demo it will generate `Hello.exe`. Once you run it, it will install our modular app and put a shortcut on the desktop.

That's it for this tutorial! Be sure to check out [jpackage](https://docs.oracle.com/en/java/javase/14/docs/specs/man/jpackage.html#jpackage-options) and see what other options it has to offer. You can also check out [this](https://www.youtube.com/watch?v=ZGW9AalZLN4) YouTube video about jpackage with some demos.
