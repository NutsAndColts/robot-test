@echo off

:: BatchGotAdmin
:-------------------------------------
REM  --> Check for permissions
>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"

REM --> If error flag set, we do not have admin.
if '%errorlevel%' NEQ '0' (
    echo Requesting administrative privileges...
    goto UACPrompt
) else ( goto gotAdmin )

:UACPrompt
    echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
    set params = %*:"=""
    echo UAC.ShellExecute "cmd.exe", "/c %~s0 %params%", "", "runas", 1 >> "%temp%\getadmin.vbs"

    "%temp%\getadmin.vbs"
    del "%temp%\getadmin.vbs"
    exit /B

:gotAdmin
    pushd "%CD%"
    CD /D "%~dp0"
:--------------------------------------

SET /P ANSWER=Type deploy to deploy code, Type control to access robot, Type internet to access internet. 
echo You chose: %ANSWER%
if /i {%ANSWER%}=={deploy} (goto :deploy)
if /i {%ANSWER%}=={control} (goto :control)
if /i {%ANSWER%}=={internet} (goto :internet)

:deploy
netsh interface set interface "Wireless Network Connection" DISABLED
netsh interface set interface "Local Area Connection" ENABLED
netsh interface ip set address "Local Area Connection" static 10.44.4.6 255.0.0.0 %gateway%
echo Successful, you should be able to deploy.
PAUSE
EXIT

:control
netsh interface set interface "Local Area Connection" DISABLED
netsh interface set interface "Wireless Network Connection" ENABLED
netsh interface ip set address "Wireless Network Connection" static 10.44.4.51 255.0.0.0 %gateway%
echo Successful, you should be able to control robot.
EXIT


:internet
netsh interface set interface "Wireless Network Connection" ENABLED
netsh interface ip set address "Wireless Network Connection" dhcp
echo Successful, you should be able to access the internet now.
PAUSE
EXIT
