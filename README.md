# foodies-app Dev

## Getting started
This assumes that you already have  MySQL server installed and running on localhost:3306
<hr>

* Clone or update your local repo using:  *git clone <repo_url>* or *git fetch* respectively
* Checkout dev branch using: *git checkout dev*

<hr>

* Login to mysql server as root and run the script located in ** src/main/resources/scripts/00_init.sql**
* This will setup the user that the app will use to communicate with database
* Run the main application and ensure that the index page appears on **localhost:8080**
