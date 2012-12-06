CREATE TABLE IF NOT EXISTS items(
    item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(254),
    item_description TEXT,
    item_default_bar_code VARCHAR(254),
    item_default_loc VARCHAR(254),
    item_default_price DOUBLE,
    item_default_min_price DOUBLE,
    item_default_per_disc DOUBLE,
    item_qty INT,
    item_min_qty INT,
    item_category INT NOT NULL REFERENCES items_categories(item_category_id),
    item_conversion_id int,
    item_pic VARCHAR(254),
    item_manuf INT NULL REFERENCES item_manufacturer(item_manuf_id),
    item_weight VARCHAR(200),
    item_quality INT NULL REFERENCES item_quality(item_quality_id),,
    item_make VARCHAR(254),
    item_color VARCHAR(254),
    item_size VARCHAR(200),
    item_status INT  NOT NULL REFERENCES item_status(item_status_id),
    created_at DATETIME,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS item_manuf_goods_types(
    item_manuf_goods_types INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_manuf_id INT NOT NULL REFERENCES item_manufacturer(item_manuf_id),
    item_id INT NOT NULL REFERENCES items(item_id)
);

CREATE TABLE IF NOT EXISTS item_supp_goods_types(
    item_supp_goods_types INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_supp_id INT NOT NULL REFERENCES item_supplier(item_supp_id),
    item_id INT NOT NULL REFERENCES items(item_id)
);

CREATE TABLE IF NOT EXISTS item_supplier(
    item_supp_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_supp_name VARCHAR(254),
    item_supp_location VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS item_manufacturer(
    item_manuf_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_manuf_name VARCHAR(254),
    item_manuf_location VARCHAR(254)
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

CREATE TABLE IF NOT EXISTS item_quality(
    item_quality_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_quality_value VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS item_conversions(
    item_conversion_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_conversion_name VARCHAR(254),
    item_conversion_qty INT
);

#trigger

# Items table trigger update item_default_min_qty if empty using percentage_disc

CREATE TRIGGER itemsref AFTER INSERT ON items
FOR EACH ROW BEGIN
INSERT INTO test2 SET a2 = NEW.a1;
DELETE FROM test3 WHERE a3 = NEW.a1;
UPDATE test4 SET b4 = b4 + 1 WHERE a4 = NEW.a1;
END;
*/

CREATE TRIGGER itemsref AFTER INSERT ON items
    FOR EACH ROW BEGIN
        IF (NEW.item_default_min_price = 0)
            UPDATE items SET item_default_min_price = (NEW.item_default_per_disc * NEW.item_default_price)
END;

