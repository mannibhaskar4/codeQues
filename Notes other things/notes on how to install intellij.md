# Download IntelliJ IDEA Community Edition:
- Go to the official JetBrains website and download the tar.gz file for IntelliJ IDEA Community Edition:
[Download IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=linux)  
Alternatively, you can download it using wget:  
```wget https://download.jetbrains.com/idea/ideaIC-2023.1.4.tar.gz```


- Extract the Downloaded Archive:
Extract the tar.gz file to a directory of your choice:  
```tar -xzf ideaIC-2023.1.4.tar.gz```


- Move the extracted folder to /opt (recommended location for optional software):  
```sudo mv idea-IC-* /opt/intellij-idea-community```  

- Create a Desktop Entry:
To add IntelliJ IDEA to your application menu, create a .desktop file:
```sudo nano /usr/share/applications/intellij-idea-community.desktop```  



- Add the following content to the file:


```
[Desktop Entry]
Version=1.0
Type=Application
Name=IntelliJ IDEA Community Edition
Icon=/opt/intellij-idea-community/bin/idea.png
Exec="/opt/intellij-idea-community/bin/idea.sh" %f
Comment=The Drive to Develop
Categories=Development;IDE;
Terminal=false
StartupWMClass=jetbrains-idea
```

- Save the file and exit the text editor(ctrl+o to save and ctrl+x to exit).

- Make the Script Executable:
Ensure the IntelliJ IDEA launch script is executable:  
```sudo chmod +x /opt/intellij-idea-community/bin/idea.sh```


Launch IntelliJ IDEA:
You should now see IntelliJ IDEA Community Edition in your application menu. You can search for "IntelliJ IDEA" and launch it like any other app.