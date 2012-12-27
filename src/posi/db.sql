SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `posi` DEFAULT CHARACTER SET latin1 ;
USE `posi` ;
-- -----------------------------------------------------
-- Table `posi`.`items_warehouses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`items_warehouses` (
  `items_warehouses_id` INT NOT NULL AUTO_INCREMENT ,
  `item_id` INT NULL ,
  `warehouse_id` INT NULL ,
  `item_min_qty` INT NULL ,
  `item_qty` INT NULL ,
  `item_price` DOUBLE NULL ,
  PRIMARY KEY (`items_warehouses_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `posi`.`diminate_details`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`diminate_details` (
  `diminate_detail_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `diminate_id` INT(11) NOT NULL ,
  `item_id` INT(11) NOT NULL ,
  `item_qty` INT(11) NULL DEFAULT NULL ,
  `item_price` DOUBLE NULL DEFAULT NULL ,
  `item_bar_code` VARCHAR(254) NULL DEFAULT NULL ,
  `item_warehouse_places_id` INT(11) NULL DEFAULT NULL ,
  `item_status` INT(11) NOT NULL ,
  `transaction_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`diminate_detail_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`diminate_types`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`diminate_types` (
  `diminate_type_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `diminate_type_name` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`diminate_type_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`diminates`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`diminates` (
  `diminate_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `proliferate_type` INT(11) NOT NULL ,
  `diminate_description` TEXT NULL DEFAULT NULL ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  `transaction_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`diminate_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`employee_roles`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`employee_roles` (
  `employee_role_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `employee_role_name` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`employee_role_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`employees`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`employees` (
  `employee_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `employee_fname` VARCHAR(254) NULL DEFAULT NULL ,
  `employee_mname` VARCHAR(254) NULL DEFAULT NULL ,
  `employee_lname` VARCHAR(254) NULL DEFAULT NULL ,
  `employee_dob` DATE NULL DEFAULT NULL,
  `employee_idnum` INT NULL DEFAULT NULL,
  `employee_serial_num` VARCHAR(254) NOT NULL ,
  `employee_kra_pin` VARCHAR(254) NOT NULL ,
  `employee_nssf_num` VARCHAR(254) NULL ,
  `employee_date_enrolled` VARCHAR(254) NULL,
  `employee_rank` VARCHAR(254) NULL ,
  `employee_salary` VARCHAR(254) NULL,
  `employee_role_id` INT(11) NOT NULL ,
  PRIMARY KEY (`employee_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- 
-- -----------------------------------------------------
-- Table `posi`.`item_conversions`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_conversions` (
  `item_conversion_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_conversion_name` VARCHAR(254) NULL DEFAULT NULL ,
  `item_conversion_qty` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`item_conversion_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`item_manuf_goods_types`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_manuf_goods_types` (
  `item_manuf_goods_types` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_manuf_id` INT(11) NOT NULL ,
  `item_id` INT(11) NOT NULL ,
  PRIMARY KEY (`item_manuf_goods_types`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`item_manufacturer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_manufacturer` (
  `item_manuf_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_manuf_name` VARCHAR(254) NULL DEFAULT NULL ,
  `item_manuf_location` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`item_manuf_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`item_quality`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_quality` (
  `item_quality_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_quality_value` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`item_quality_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`item_status`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_status` (
  `item_status_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_status_name` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`item_status_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`item_supp_goods_types`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_supp_goods_types` (
  `item_supp_goods_types` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_supp_id` INT(11) NOT NULL ,
  `item_id` INT(11) NOT NULL ,
  PRIMARY KEY (`item_supp_goods_types`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`item_supplier`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`item_supplier` (
  `item_supp_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_supp_name` VARCHAR(254) NULL DEFAULT NULL ,
  `item_supp_location` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`item_supp_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`items`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`items` (
  `item_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_name` VARCHAR(254) NULL DEFAULT NULL ,
  `item_description` TEXT NULL DEFAULT NULL ,
  `item_default_bar_code` VARCHAR(254) NULL DEFAULT NULL ,
  `item_default_loc` VARCHAR(254) NULL DEFAULT NULL ,
  `item_default_price` DOUBLE NULL DEFAULT NULL ,
  `item_default_min_price` DOUBLE NULL DEFAULT '0' ,
  `item_default_per_disc` INT(11) NULL DEFAULT NULL ,
  `item_qty` INT(11) NULL DEFAULT NULL ,
  `item_min_qty` INT(11) NULL DEFAULT '0' ,
  `item_category` INT(11) NOT NULL ,
  `item_conversion_id` INT(11) NULL DEFAULT NULL ,
  `item_pic` VARCHAR(254) NULL DEFAULT NULL ,
  `item_manuf` INT(11) NULL DEFAULT NULL ,
  `item_warehouse_location` INT(11) NULL DEFAULT NULL ,
  `item_weight` VARCHAR(200) NULL DEFAULT NULL ,
  `item_quality` INT(11) NULL DEFAULT NULL ,
  `item_make` VARCHAR(254) NULL DEFAULT NULL ,
  `item_color` VARCHAR(254) NULL DEFAULT NULL ,
  `item_size` VARCHAR(200) NULL DEFAULT NULL ,
  `item_status` INT(11) NOT NULL ,
  `created_at` DATETIME NULL DEFAULT NULL ,
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`item_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`items_categories`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`items_categories` (
  `item_category_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `item_category_name` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`item_category_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`proliferate_details`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`proliferate_details` (
  `proliferate_detail_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `proliferate_id` INT(11) NOT NULL ,
  `item_id` INT(11) NOT NULL ,
  `item_qty` INT(11) NULL DEFAULT NULL ,
  `item_price` DOUBLE NULL DEFAULT NULL ,
  `item_expiry_date` DATE NULL DEFAULT NULL ,
  `item_bar_code` VARCHAR(254) NULL DEFAULT NULL ,
  `item_warehouse_places_id` INT(11) NULL DEFAULT NULL ,
  `item_status` INT(11) NOT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `transaction_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`proliferate_detail_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`proliferate_types`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`proliferate_types` (
  `proliferate_type_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `proliferate_type_name` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`proliferate_type_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`proliferates`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`proliferates` (
  `proliferate_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `proliferate_type` INT(11) NOT NULL ,
  `proliferate_description` TEXT NULL DEFAULT NULL ,
  `reception_user_id` INT(11) NULL DEFAULT NULL ,
  `transaction_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`proliferate_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`warehouse_places`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`warehouse_places` (
  `warehouse_place_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `warehouse_id` INT(11) NOT NULL ,
  `warehouse_place_name` VARCHAR(254) NULL DEFAULT NULL ,
  `warehouse_place_loc` VARCHAR(254) NULL DEFAULT NULL ,
  PRIMARY KEY (`warehouse_place_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`warehouse_places_default_items`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`warehouse_places_default_items` (
  `warehouse_places_default_item_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `warehouse_places_id` INT(11) NOT NULL ,
  `warehouse_places_item_id` INT(11) NOT NULL ,
  PRIMARY KEY (`warehouse_places_default_item_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`warehouse_places_transfers`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`warehouse_places_transfers` (
  `warehouse_places_transfer_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `from_place` INT(11) NOT NULL ,
  `to_place` INT(11) NOT NULL ,
  `trasaction_user` INT(11) NOT NULL ,
  `item_id` INT(11) NOT NULL ,
  `item_qty` INT(11) NULL DEFAULT NULL ,
  `item_price` DOUBLE NULL DEFAULT NULL ,
  `item_default_bar_code` VARCHAR(254) NULL DEFAULT NULL ,
  `item_bar_code` VARCHAR(254) NULL DEFAULT NULL ,
  `duration` TIME NULL DEFAULT NULL ,
  `item_status` INT(11) NOT NULL ,
  `responsible_user` INT(11) NOT NULL ,
  `transaction_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`warehouse_places_transfer_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `posi`.`customers`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `posi`.`customers` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `customer_fname` VARCHAR(254) NOT NULL ,
  `customer_lname` VARCHAR(254) NOT NULL ,
  `customer_idnum` INT(15) NOT NULL ,
  `customer_passportNum` INT(20) NOT NULL ,
  `customer_preference_id` INT(11) NULL DEFAULT NULL ,
  `customer_subscriber_id` INT(11) NULL DEFAULT NULL ,
  `customer_points` INT(11) NULL DEFAULT NULL ,
  `customer_addded_date` DATETIME NULL DEFAULT NULL ,
  `customer_updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `customer_status` INT(11) NOT NULL ,
  PRIMARY KEY (`customer_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `posi`.`customer_preference`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `posi`.`customer_preference` (
  `preference_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `customer_id` INT(11) NOT NULL ,
  `preference_item_id` INT(11) NOT NULL ,
  `preference_item_qty` INT(15) NOT NULL ,
  `preference_item_price` DOUBLE NOT NULL ,
  PRIMARY KEY (`preference_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `posi`.`customer_status`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `posi`.`customer_status` (
  `customer_status_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `customer_status_name` VARCHAR(250) NULL DEFAULT NULL ,

  PRIMARY KEY (`customer_status_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
