# Foodie App

## Class
**User**
	**Properties**
	
	1. FullName
	2. Email
	3. Mobile
	4. Password
	5. AccountStatus
	6. CreatedAt
	7. UpdatedAt
	
## SQL Schema	

**This schema will generate a new database and creates a User table**

```
create database if not exists spring_demo;

use spring_demo;

DROP TABLE IF EXISTS `spring_demo`.`user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `account_inactive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) /*!80000 INVISIBLE */
);

insert into user(id, full_name, email, mobile, password) values(1, "SethuKarthik", "sethu@gmail.com", "+919566841129", "123456");
insert into user(id, full_name, email, mobile, password) values(2, "ShriNagaKali", "shri@gmail.com", "+918666841129", "123456");
insert into user(id, full_name, email, mobile, password) values(3, "NirmalKumar", "nirmal@gmail.com", "+917866841129", "123456");
insert into user(id, full_name, email, mobile, password) values(4, "Nageswaran", "nagesh@gmail.com", "+916666841129", "123456");

select * from user;
commit; 

```


## List of Request for Users Controller

**Get All Customer**
``` 
Request Method - GET
URL - **http://localhost:8080/customer/allCustomers**
Response - [{
        "id": 1,
        "customerName": "SethuKarthik",
        "email": "sethu@gmail.com",
        "mobile": "+919566841129",
        "accountStatus": "ACTIVE",
        "createdAt": "2021-03-24T11:18:06.000+00:00",
        "updatedAt": "2021-03-24T11:18:06.000+00:00"
    },
    {
        "id": 2,
        "customerName": "ShriNagaKali",
        "email": "shri@gmail.com",
        "mobile": "+9145556688445",
        "accountStatus": "ACTIVE",
        "createdAt": "2021-03-24T11:18:06.000+00:00",
        "updatedAt": "2021-03-24T11:18:06.000+00:00"
    }
]
```

**Find Customer by Customer Id**
```
Request Method - GET
URL - http://localhost:8080/customer/13
Response - {
    "id": 1,
    "customerName": "SethuKarthik",
    "email": "sethu@gmail.com",
    "mobile": "+919566841129",
    "accountStatus": "ACTIVE",
    "createdAt": "2021-03-24T11:18:06.000+00:00",
    "updatedAt": "2021-03-24T11:18:06.000+00:00"
}
```

**Register New User**
```
Request Method - POST
URL - http://localhost:8080/customer
Payload - {
    "customerName": "TestUset-10",
    "email": "test10@gmail.com",
    "mobile": "+919566841129",
    "password": "8745ASF"
}
```

**Update User info**
```
Request Method - PUT
URL - http://localhost:8080/customer
Payload - {
    "id": 2,
    "customerName": "TestUset-10",
    "email": "test10@gmail.com",
    "mobile": "+919566841129",
    "password": "8745ASF"
}
```

**Delete User Account**
```
Request Method - DELETE
URL - http://localhost:8080/customer?id=3
Params - id
Response - 200
```

**Get Active User**
```
Request Method - GET
URL - http://localhost:8080/customer/activeCustomerInfo
Response - [{
        "id": 1,
        "customerName": "SethuKarthik",
        "email": "sethu@gmail.com",
        "mobile": "+919566841129",
        "accountStatus": "ACTIVE",
        "createdAt": "2021-03-24T11:18:06.000+00:00",
        "updatedAt": "2021-03-24T11:18:06.000+00:00"
    },
    {
        "id": 2,
        "customerName": "ShriNagaKali",
        "email": "shri@gmail.com",
        "mobile": "+9145556688445",
        "accountStatus": "ACTIVE",
        "createdAt": "2021-03-24T11:18:06.000+00:00",
        "updatedAt": "2021-03-24T11:18:06.000+00:00"
    }
]
```

**Get Inactive User**
```
Request Method - GET
URL - http://localhost:8080/customer/inactiveCustomerInfo
Response - [{
        "id": 1,
        "customerName": "SethuKarthik",
        "email": "sethu@gmail.com",
        "mobile": "+919566841129",
        "accountStatus": "INACTIVE",
        "createdAt": "2021-03-24T11:18:06.000+00:00",
        "updatedAt": "2021-03-24T11:18:06.000+00:00"
    },
    {
        "id": 2,
        "customerName": "ShriNagaKali",
        "email": "shri@gmail.com",
        "mobile": "+9145556688445",
        "accountStatus": "INACTIVE",
        "createdAt": "2021-03-24T11:18:06.000+00:00",
        "updatedAt": "2021-03-24T11:18:06.000+00:00"
    }
]
```

**Update User Account Status**
```
Request Method - PATCH
URL - http://localhost:8080/customer/updateAccountStatus
Payload - {
    "id": 2,
    "accountStatus": "ACTIVE"
}
```