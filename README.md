# 🌾 Supply Chain Management System

An end-to-end Java-based web application that connects **farmers**, **buyers**, and **administrators** to streamline agricultural product management, order processing, and contract tracking.

---

## 🚀 Features

### 👤 User Roles
- **Admin**: Manage users and monitor system activity.
- **Farmer**: Add products for sale and view incoming orders.
- **Buyer**: Browse available products and place orders.

### 🛒 Core Functionalities
- **User Authentication**: Secure login & signup with Spring Security.
- **Product Management**: Farmers can add, update, and delete their products.
- **Order Management**: Buyers can place orders; farmers can track order status.
- **Dashboard Views**: Role-based dashboards showing relevant data.
- **Order Status Tracking**: Admins and farmers can update order shipment status.
- **Responsive UI**: Enhanced using JSP, JSTL, and Bootstrap.

---

## 🧰 Tech Stack

| Layer              | Technology                            |
|--------------------|----------------------------------------|
| Language           | Java 20                                |
| Framework          | Spring Boot, Spring MVC, Spring Security |
| UI                 | JSP, JSTL, HTML, CSS, Bootstrap        |
| ORM & DB           | Hibernate, MySQL                       |
| Build Tool         | Maven                                  |
| Authentication     | Spring Security + BCrypt               |
| Deployment Ready   | WAR packaging                          |

---



| Role   | Path                | Description                    |
| ------ | ------------------- | ------------------------------ |
| Common | `/login`, `/signup` | Authentication Pages           |
| Admin  | `/admin/dashboard`  | Admin Dashboard                |
| Admin  | `/admin/users`      | Manage Users                   |
| Buyer  | `/buyer/dashboard`  | Buyer Dashboard                |
| Buyer  | `/buyer/products`   | Browse Products                |
| Buyer  | `/order/place`      | Place an Order                 |
| Buyer  | `/buyer/orders`     | View My Orders                 |
| Farmer | `/farmer/dashboard` | Farmer Dashboard               |
| Farmer | `/farmer/products`  | Manage Own Products            |
| Farmer | `/farmer/orders`    | View Orders for Their Products |


