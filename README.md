# foodies-app Dev

<span style="color: red; font-weight: bolder;">Please note that this is not ready for use yet!</span>

## Getting started
This assumes that you already have  MySQL server installed and running on localhost:3306
<hr>

* Clone or update your local repo using:  *git clone <repo_url>* or *git fetch* respectively
* Checkout dev branch using: *git checkout dev*

<hr>

* Login to mysql server as root and run the script located in ** src/main/resources/scripts/00_init.sql**
* This will setup the user that the app will use to communicate with database
* Run the main application and ensure that the index page appears on **localhost:8080**

## Creating a pull request
* When working on a ticket, please create a new branch from dev as follows: *git checkout -b <new_branch_name>*
* When you push your work for the **first time**, run * git push --set-upstream origin <new_branch_name>* 
* After completing the work on your ticket, please **create a pull request to dev** as follows:
  *  Go to github.com/<our_repo>
  *  Select the branch you've been working on and generate a new pull request
  *  On the next page, change the base dropdown to point to dev
  *  Reference: https://help.github.com/en/articles/creating-a-pull-request
