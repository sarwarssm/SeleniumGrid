cd \
TIMEOUT 10
java -Dwebdriver.chrome.driver=chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://hp-5m8r3p4.healthpn.com:4444/register -browser browserName=chrome,maxInstances=10

cmd /k 

