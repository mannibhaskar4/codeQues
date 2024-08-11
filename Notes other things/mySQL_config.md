username - axidAcid
password - passwordA123#


# IF its isntalled start from step 1 and then goto step 6

- Step 1: Stop MySQL Service
First, stop the MySQL service to ensure no processes are running:  
```sudo systemctl stop mysql```
- Step 2: Uninstall MySQL
Next, uninstall MySQL along with all related packages:
```sudo apt-get remove --purge  mysql-server mysql-client mysql-common mysql-server-core-* mysql-client-core-*```


- Step 3: Remove MySQL Data Directory
Delete all MySQL data and configuration files to reset everything:  
```
sudo rm -rf /etc/mysql /var/lib/mysql
sudo rm -rf /var/log/mysql
sudo rm -rf /var/log/mysql.*
````
- Step 4: Remove MySQL User and Group (Optional)
You can also remove the MySQL user and group if you want to reset everything:
```
sudo deluser mysql
sudo delgroup mysql
```
- Step 5: Update Package Index
Update the package index to ensure the removal is reflected:  ```sudo apt-get update```

- Step 6: Reinstall MySQL
Now, reinstall MySQL:  
```sudo apt-get install mysql-server```   
During the installation, you'll be prompted to set a root password. After installation, MySQL should be in its default state.

- Step 7: Run MySQL Secure Installation
After reinstalling, run the mysql_secure_installation script to set up security settings:  
```sudo mysql_secure_installation```  
Follow the prompts to configure the security settings according to your requirements.

- Step 8: Verify the Installation
Finally, check that MySQL is running and functioning as expected:   
```sudo systemctl status mysql```
Log in to MySQL to ensure everything is reset:  
```sudo mysql -u root -p```


# Adding new user

- Step 1: Log in to MySQL
First, log in to the MySQL server using the root account or any other account with sufficient privileges:  
```sudo mysql -u root -p```
- Step 2: Create a New User
Once you're logged in, you can create a new MySQL user by running the following SQL command. Replace new_user with your desired username and new_password with your desired password:
```CREATE USER 'new_user'@'localhost' IDENTIFIED BY 'new_password';```  
'new_user': This is the username for the new MySQL user.
'localhost': This specifies that the new user can only connect from the local machine. If you want the user to be able to connect from any host, use '%' instead of 'localhost'.
'new_password': This is the password for the new MySQL user.  


- Step 3: Grant Privileges to the User
To grant the new user permissions on a specific database, use the following command:
```GRANT ALL PRIVILEGES ON database_name.* TO 'new_user'@'localhost';```  
Replace database_name with the name of the database you want the user to access. If you want to grant the user access to all databases, use *.* instead of database_name.*.

For example, to grant access to all databases:
```GRANT ALL PRIVILEGES ON *.* TO 'new_user'@'localhost' WITH GRANT OPTION;```


- Step 4: Apply Privileges
After setting up the user and granting privileges, you need to reload the privilege tables to ensure that the changes take effect:  
```FLUSH PRIVILEGES;```


- Step 5: Test the New User
You can now exit MySQL and test the new user by logging in with the newly created credentials:
```mysql -u new_user -p```
You'll be prompted to enter the password you set for the new user.

- Step 6: (Optional) Grant Additional Privileges
If you need to grant specific privileges rather than all privileges, you can use a command like:
```GRANT SELECT, INSERT, UPDATE, DELETE ON database_name.* TO 'new_user'@'localhost';```  
This grants the user permission to select, insert, update, and delete data in the specified database.

- Step 7: (Optional) Revoke Privileges
If you need to revoke privileges from the user, use a command like:
```REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'new_user'@'localhost';```