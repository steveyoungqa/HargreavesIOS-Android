# Hargreaves Lansdown Automation Framework

### Prepare your machine:
JDK Install (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
and let it install to the default directory

IDE Install of your choice (IntelliJ Idea/Eclipse)

## OSX:

In Mac OSX 10.5 or later, Apple recommends to set the $JAVA_HOME variable to 
/usr/libexec/java_home in file ~/. bash_profile or ~/.profile.

##### Set JAVA_HOME

Open a new Terminal: 
**cd ~** 
**vim .bash_profile** 
(This creates a new .bash_profile file using text editor VIM in your root directory)

Press **I** to Insert a new line and add:
**export JAVA_HOME=$(/usr/libexec/java_home)**

To exit and Save VIM press **ESC**, then **:** and type **wq** and **Return** to save your changes

In Terminal use:
**source .bash_profile**
so your machine recognises the changes

Now enter
**echo $JAVA_HOME**
and a path to your Java installation should be shown correctly eg: 
*/Library/Java/JavaVirtualMachines/1.7.0.jdk/Contents/Home*

#### MAVEN installation 

The easiest way to install Maven correctly is to use Homebrew.
Open a Terminal and paste this command to install Homebrew:
**/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"**

Install Maven with these two commands in Terminal:
**brew doctor**
**brew install maven**

To ensure Maven has been installed correctly 
**mvn -v** 
and you should see something similar to this output:

*Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_73, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.11.3", arch: "x86_64", family: "mac"*




#### Run the Tests a Terminal command line

Navigate to the directory where you cloned the repo and run this command

**mvn test -Dcucumber.options=" --tags @regression" 

Change the @debug to other tags to run various Feature files
Chrome can be replaced with Firefox to run those browser tests


## Installing Appium on a New Mac

Software required:

IntelliJ Idea (Ultimate ideally for Cucumber support, or use Free Community edition)
https://www.jetbrains.com/idea/download/#section=mac

X-Code 9.2 
Download from iTunes
Install IOS versions required for testing from X-Code>Preferences>Components menu option

Java SDK (Download jdk-8u161-macosx-x64.dmg)
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Android Studio 
https://developer.android.com/studio/index.html
Install required Android SDK versions required for testing

Install Appium Desktop from here:
http://appium.io/

Install Homebrew
Copy and paste this into a new Terminal window:

/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
Install Node JS and Appium Server
Copy and paste this into a new Terminal window:
brew install node

Copy and paste this into a new Terminal window:
npm install -g appium@1.7.2
(Alternatively you can check the very latest version on Github, for compatability it is usually best to go with the very latest beta version. eg: npm install -g appium@1.8.0-beta4)
https://github.com/appium/appium/tags

You may need to change perms to install the above, if so use


sudo chmod -R 777 /usr/local/lib/node_modules
npm install -g appium@1.7.2


Maven Installation
The easiest way to install Maven correctly is to use Homebrew.

Open a Terminal and paste this command to install Homebrew:
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

Install Maven with these two commands in Terminal:
brew doctor
brew install maven

To ensure Maven has been installed correctly
mvn -v
and you should see something similar to this output:

*Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_73, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.11.3", arch: "x86_64", family: "mac"*



Setting ANDROID_HOME and JAVA_HOME
In Terminal 
go to your home directory cd ~
ls -la to show all files 
Use touch .bash_profile to create cdf
edit bash_profile with Vim using vi .bash_profile 
enter your machines Android and Java home Paths as below, replacing steveyoung with your machine username and ensuring the the JDK version matches the one you installed above

In VIM use I to insert the text paths, 
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home
export ANDROID_HOME=/Users/steve.young/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platforms
export PATH=$PATH:$ANDROID_HOME/platform-tools
export ANDROID_SDK=$ANDROID_HOME
export PATH=${PATH}$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$JAVA_HOME/bin
export PATH="$PATH:$HOME/.rvm/bin" # Add RVM to PATH for scripting

to Save press ESC , then Shift and : and type wq
Use source ~/.bash_profile to force the changes


Install Appium Doctor 


npm install appium-doctor -g

Install Carthage/WebAgent for IOS


brew install carthage

And in a Terminal window run
appium-doctor 

to see if you have all the dependencies required to run Appium

X-Code p-list error fix
When running an IOS Appium test for the first time you will probably get this error message:
Could not determine Xcode version: Could not get Xcode version. /Library/Developer/Info.plist does not exist on disk.

In an Terminal window run this command:
sudo xcode-select --switch /Applications/Xcode.app


##### DEVICE MATRIX
Chrome 55 (Mac OS Yosemite & Sierra)

Safari 10 (Mac OS Sierra)


Firefox 51 (Mac OS Yosemite)

Edge 14 (Windows 10)

Safari (iPhone 6 Plus)

Chrome (Samsung Galaxy S7 Edge)

Stock Internet App (Galaxy S6)

iPad Air 2 (iOS 11)

##### JENKINS/TERMINAL
(Make sure you are in the Project Repo directory)

Change tags to match Feature file tags
Change Dbrowser to either chrome or firefox

mvn test -Dcucumber.options=" --tags @demo" -Dbrowser=chrome
mvn test -Dcucumber.options=" --tags @demo" -Dbrowser=firefox

##### TO DO:
Increase Copy/Image verification
Appium/X-Code/Android SDK/iso simulators/android avds etc on CI box
Safari browser?? 

Detail Project structure - Page Objects, Driver Factory etc
CI Server setup
Real Devices CI Server


9.2.2. Android
The application will be developed against Android 8.1 and it will be compatible on 4.3+.
The application will be compatible with devices that support 4.3+, including devices that support Android
8.0 as of the Commencement Date.
Big Radical will focus testing on the following devices: Samsung S6, S7, S7 Edge, LG Nexus 6p, Nexus 5x, HTC
One mini 2, Sony Xperia Z, Moto G(2).


