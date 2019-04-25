# FOODIES APP

**A. Getting Started**

 1. Clone the repo https://github.com/KaraboCoder/foodies-app.git
 2. Import the project on IntelliJ IDEA / CD into the project folders
 
 **Install Maven and project dependencies**
 
 *  Make sure you install maven cli from https://maven.apache.org/guides/getting-started/windows-prerequisites.html
 *  mvn install    
 
 **B. MySQL Database setup**
 
 4. Install MySQL from https://dev.mysql.com/downloads/mysql/
 5. Create a root user on MySQL with username:root and password:root
 6. Create a database with the name "foodiesapp"
 7. Make sure MySQL is running on port 3306
 
 **C. Run Project with intelliJ**
 * Run FoodiesApplication.java as spring project

<hr>

**D. Working on new features and creating pull requests**

 - When working on a ticket, please create a new branch from master as follows: git checkout -b <new_branch_name>
 
 - When you push your work for the first time, run * git push --set-upstream origin <new_branch_name>*

 - After completing the work on your ticket, please create a pull request to master as follows:
 
   * Go to github.com/<our_repo>
   * Select the branch you've been working on and generate a new pull request
   * On the next page, change the base dropdown to point to master
   * Reference: https://help.github.com/en/articles/creating-a-pull-request
