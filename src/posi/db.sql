CREATE TABLE IF NOT EXISTS items(
    item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(254),
    item_description TEXT,
    item_default_bar_code VARCHAR(254),
    item_default_loc VARCHAR(254),
    item_default_price DOUBLE,
    item_qty INT,
    item_category INT NOT NULL REFERENCES items_categories(item_category_id),
    item_status INT  NOT NULL REFERENCES item_status(item_status_id),

    created_at DATETIME,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS item_status(
    item_status_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_status_name VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS proliferates(
    proliferate_id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    proliferate_type INT NOT NULL REFERENCES proliferate_types(proliferate_type_id),

    proliferate_description TEXT,

    reception_user_id INT,
    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS proliferate_details(
    proliferate_detail_id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    proliferate_id INT NOT NULL REFERENCES proliferates(proliferate_id),

    item_id INT NOT NULL REFERENCES items(item_id),
    item_qty INT,
    item_price DOUBLE,
    item_expiry_date DATE,
    item_bar_code VARCHAR(254), /*create new bar code */
    item_warehouse_places_id INT REFERENCES warehouse_places(warehouse_place_id),
    item_status INT  NOT NULL REFERENCES item_status(item_status_id),
 
    description TEXT,

    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS proliferate_types(
    proliferate_type_id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    proliferate_type_name VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS diminate_types(
    diminate_type_id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    diminate_type_name VARCHAR(254)
);

CREATE TABLE diminates(
    diminate_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    proliferate_type INT NOT NULL REFERENCES proliferate_types(proliferate_type_id),

    diminate_description TEXT,
    user_id INT,

    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS diminate_details(
    diminate_detail_id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    diminate_id INT NOT NULL REFERENCES proliferates(proliferate_id),

    item_id INT NOT NULL REFERENCES items(item_id),
    item_qty INT,
    item_price DOUBLE,
    item_bar_code VARCHAR(254),
    item_warehouse_places_id INT REFERENCES warehouse_places(warehouse_place_id),
    item_status INT  NOT NULL REFERENCES item_status(item_status_id),

    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS warehouses(
    warehouse_id INT  NOT NULL primary key AUTO_INCREMENT,
    warehouse_name VARCHAR(250),
    warehouse_location VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS warehouse_places(
    warehouse_place_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    warehouse_id INT NOT NULL REFERENCES warehouses(warehouse_id),
    warehouse_place_name VARCHAR(254),
    warehouse_place_loc VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS warehouse_places_transfers(
    warehouse_places_transfer_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    from_place INT NOT NULL REFERENCES warehouses(warehouse_id),
    to_place INT NOT NULL REFERENCES warehouses(warehouse_id),
    
    trasaction_user INT NOT NULL REFERENCES employees(employee_id),
    item_id INT NOT NULL REFERENCES items(item_id),
    item_qty INT,
    item_price DOUBLE,
    item_default_bar_code VARCHAR(254),
    item_bar_code VARCHAR(254),
    duration TIME,
    item_status INT  NOT NULL REFERENCES item_status(item_status_id),
    responsible_user INT NOT NULL REFERENCES employees(employee_id),

    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS warehouse_places_default_items(
    warehouse_places_default_item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    warehouse_places_id INT NOT NULL REFERENCES warehouse_places(warehouse_place_id),
    warehouse_places_item_id INT NOT NULL REFERENCES items(item_id)
);

CREATE TABLE IF NOT EXISTS items_categories(
    item_category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_category_name  VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS employees(
    employee_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_fname VARCHAR(254),
    employee_mname VARCHAR(254),
    employee_lname VARCHAR(254),
    employee_national_id INT,
    employee_role_id INT NOT NULL REFERENCES employee_roles(employee_role_id)
);

CREATE TABLE IF NOT EXISTS employee_roles(
    employee_role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_role_name VARCHAR(254)
);