@echo off

SET /P ANSWER=Type robot to access robot, Type internet to access internet.
echo You chose: %ANSWER%
if /i {%ANSWER%}=={robot} (goto :robot)
if /i {%ANSWER%}=={internet} (goto :internet)
:robot
netsh interface ip set address "Wireless Network Connection 2" static 10.44.0.4 255.0.0.0 %gateway%
echo Successful, you should be able to connect to the robot now.
PAUSE
EXIT

:internet
netsh interface ip set address "Wireless Network Connection 2" dhcp
echo Successful, you should be able to access the internet now.
PAUSE
EXIT 