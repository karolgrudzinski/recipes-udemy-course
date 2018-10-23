## Use to run mysql db docker image, optional if you're not using a local mysqldb'
## docker run --name recipes -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
# Create Databases
CREATE DATABASE recipes_dev;
CREATE DATABASE recipes_prod;

#Create database service accounts
CREATE USER 'recipes_dev_user'@'localhost' IDENTIFIED BY 'password1';
CREATE USER 'recipes_prod_user'@'localhost' IDENTIFIED BY 'password1';
CREATE USER 'recipes_dev_user'@'%' IDENTIFIED BY 'password1';
CREATE USER 'recipes_prod_user'@'%' IDENTIFIED BY 'password1';

#Database grants
GRANT SELECT ON recipes_dev.* to 'recipes_dev_user'@'localhost';
GRANT INSERT ON recipes_dev.* to 'recipes_dev_user'@'localhost';
GRANT DELETE ON recipes_dev.* to 'recipes_dev_user'@'localhost';
GRANT UPDATE ON recipes_dev.* to 'recipes_dev_user'@'localhost';
GRANT SELECT ON recipes_prod.* to 'recipes_prod_user'@'localhost';
GRANT INSERT ON recipes_prod.* to 'recipes_prod_user'@'localhost';
GRANT DELETE ON recipes_prod.* to 'recipes_prod_user'@'localhost';
GRANT UPDATE ON recipes_prod.* to 'recipes_prod_user'@'localhost';
GRANT SELECT ON recipes_dev.* to 'recipes_dev_user'@'%';
GRANT INSERT ON recipes_dev.* to 'recipes_dev_user'@'%';
GRANT DELETE ON recipes_dev.* to 'recipes_dev_user'@'%';
GRANT UPDATE ON recipes_dev.* to 'recipes_dev_user'@'%';
GRANT SELECT ON recipes_prod.* to 'recipes_prod_user'@'%';
GRANT INSERT ON recipes_prod.* to 'recipes_prod_user'@'%';
GRANT DELETE ON recipes_prod.* to 'recipes_prod_user'@'%';
GRANT UPDATE ON recipes_prod.* to 'recipes_prod_user'@'%';
