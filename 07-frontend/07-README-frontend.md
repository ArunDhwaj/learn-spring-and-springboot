
1. React Setup
==================

1.1 Installation
========================= 

Source: https://linuxize.com/post/how-to-install-node-js-on-ubuntu-22-04/

Step-1: Run the following command as a user with sudo privileges to download and execute the NodeSource installation script:

$ curl -sL https://deb.nodesource.com/setup_18.x | sudo -E bash -


Step-2: Once the NodeSource repository is enabled, install Node.js and npm:

$ sudo apt install nodejs

Step-3: Verify that the Node.js and npm were successfully installed by printing their versions:

$ node -v
>> v18.16.0

$ npm -v
>> 9.5.1


Step-4: To be able to compile native addons from npm you’ll need to install the development tools :

$ sudo apt install build-essential


1.2 Step: Application creation and running
============================================ 

Step-1: Create react application

$ npx create-react-app todo-app
>> Application will created

Step-2: Run the application:
$ npm start
>> Runs the app in development mode: Application will start at port 3000 on the localhost

Open this link: http://localhost:3000/

Step-3: Test the application:
$ npm test
>> Run unit tests


Step-4: Build a production deployment unit:
$ npm run build 

>> 
i) Minified
ii) Optimized for performance


Step-5: Install any package
$ npm install --save react-router-dom  

>> It will add a dependency to the project




