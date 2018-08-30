@echo off
color E
FOR /F "tokens=4 delims= " %%i in ('route print ^| find " 0.0.0.0"') do set localIp=%%i
echo ------------------------------------------------------------------
echo **** Selenium server IP and Port: %localIp%:4444
echo *  * To shutdown the server press ctrl+c
echo *  * Note: Make sure you run this batch file from test-data folder
echo **** Note: Make sure test-data folder contains IE/chrome executables
echo ------------------------------------------------------------------
echo  >NUL

java -jar selenium-server-standalone-2.45.0.jar -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.ie.driver=IEDriverServer.exe

