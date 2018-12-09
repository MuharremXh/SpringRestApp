# SpringRestApp
This is a simple REST API done using Spring Boot,Spring MVC Rest,Hibernate(Jpa) and Jackson.

Endpoints for the application: 
GET {
/users -> shows a list of current users
/users/{id} -> shows the details for the specific user given his id,or show an error message if user not present;
/items -> shows a list of all available items;
/items/{id} -> shows the details for the specific items given his id,show an error message if item not present;
}

POST {
/users/addUser -> takes an user in Json and returns him if it is succesfully created;
/items/addItem -> takes an item in Json and returns it if it is succesfully created;
Note: You need to add a user field and give his id,because an item needs to have an owner
}


Note:Go to application.properties and configure your database properties for your schema

