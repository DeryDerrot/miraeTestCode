CREATE TABLE IF NOT EXISTS testing.`customers` (
    `customer_id` INT NOT NULL AUTO_INCREMENT,
    `company_name` VARCHAR(50) NOT NULL,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL ,
    `billing_address` VARCHAR(255) NOT NULL,
    `city` VARCHAR(50) NOT NULL,
    `state_or_province` VARCHAR(20) NOT NULL,
    `zip_code` VARCHAR(20) NOT NULL,
    `email` VARCHAR(75) NOT NULL,
    `company_website` VARCHAR(200) NOT NULL,
    `phone_number` VARCHAR(30) NOT NULL,
    `fax_number` VARCHAR(30) NOT NULL,
    `ship_address` VARCHAR(255) NOT NULL,
    `ship_city` VARCHAR(50) NOT NULL,
    `ship_state_or_province` VARCHAR(50) NOT NULL,
    `ship_zip_code` VARCHAR(20) NOT NULL,
    `ship_phone_number` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`customer_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS testing.`employees` (
    `employees_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL ,
    `title` VARCHAR(50) NOT NULL,
    `work_phone` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`employees_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS testing.`shipping_methods` (
    `shipping_method_id` INT NOT NULL AUTO_INCREMENT,
    `shipping_method` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`shipping_method_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS testing.`products` (
    `product_id` INT NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(50) NOT NULL,
    `unit_price` INT NOT NULL ,
    `in_stock` CHAR(1) NOT NULL,
    PRIMARY KEY (`product_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS testing.`orders` (
    `order_id` INT NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `employees_id` INT NOT NULL ,
    `order_date` DATE NOT NULL,
    `purchase_order_number` VARCHAR(30) NOT NULL,
    `ship_date` DATE NOT NULL ,
    `shipping_method_id` INT NOT NULL,
    `freight_charge` INT NOT NULL,
    `taxes` INT NOT NULL,
    `payment_received` CHAR(1) NOT NULL ,
    `comment` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`order_id`),
    CONSTRAINT FK_customer_order FOREIGN KEY (`customer_id`) REFERENCES customers(`customer_id`),
    CONSTRAINT FK_shipping_order FOREIGN KEY (`shipping_method_id`) REFERENCES shipping_methods(`shipping_method_id`),
    CONSTRAINT FK_employee_order FOREIGN KEY (`employees_id`) REFERENCES employees(`employees_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS testing.`order_details` (
     `order_detail_id` INT NOT NULL AUTO_INCREMENT,
     `order_id` INT NOT NULL,
     `product_id` INT NOT NULL ,
     `quantity` INT NOT NULL,
     `unit_price` INT NOT NULL,
     `discount` INT NOT NULL,
    PRIMARY KEY (`order_detail_id`),
    CONSTRAINT FK_product_order_detail FOREIGN KEY (`product_id`) REFERENCES products(`product_id`),
    CONSTRAINT FK_order_order_detail FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;