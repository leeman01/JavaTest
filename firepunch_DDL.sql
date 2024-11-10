-- firepunch.auth_user definition

CREATE TABLE `auth_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(128) DEFAULT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` int DEFAULT NULL,
  `username` varchar(150) DEFAULT NULL,
  `first_name` varchar(150) DEFAULT NULL,
  `last_name` varchar(150) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `is_staff` int DEFAULT NULL,
  `is_active` int DEFAULT NULL,
  `date_joined` datetime(6) DEFAULT NULL,
  `register_company_name` varchar(20) DEFAULT NULL,
  `register_company_id` varchar(50) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.booking_shipment_company definition

CREATE TABLE `booking_shipment_company` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `description` longtext,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.booking_shipment_priceof definition

CREATE TABLE `booking_shipment_priceof` (
  `of_id` bigint NOT NULL AUTO_INCREMENT,
  `prediction_date` date DEFAULT NULL,
  `loading_port` int DEFAULT NULL,
  `discharge_port` varchar(256) DEFAULT NULL,
  `of_week_1` double DEFAULT NULL,
  `of_week_2` double DEFAULT NULL,
  `of_week_3` double DEFAULT NULL,
  `of_week_4` double DEFAULT NULL,
  PRIMARY KEY (`of_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2833 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.product definition

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_description` text,
  `product_price` varchar(50) DEFAULT NULL,
  `product_date` datetime DEFAULT NULL,
  `product_image_file` blob,
  `original_file_name` varchar(255) DEFAULT NULL,
  `saved_file_name` varchar(255) DEFAULT NULL,
  `daily_views` int DEFAULT '0',
  `total_views` int DEFAULT '0',
  `company_name` varchar(255) DEFAULT NULL,
  `founded_year` int DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.account_company definition

CREATE TABLE `account_company` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `registration_no` varchar(20) DEFAULT NULL,
  `signature_image` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `account_company_user_id_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.exporting_export definition

CREATE TABLE `exporting_export` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `buyer_company_name` varchar(150) DEFAULT NULL,
  `buyer_company_address` varchar(200) DEFAULT NULL,
  `buyer_company_tel` varchar(50) DEFAULT NULL,
  `buyer_email` varchar(254) DEFAULT NULL,
  `buyer_country` varchar(30) DEFAULT NULL,
  `incoterm` varchar(5) DEFAULT NULL,
  `payment_method` varchar(5) DEFAULT NULL,
  `place_of_loading` varchar(50) DEFAULT NULL,
  `place_of_unloading` varchar(50) DEFAULT NULL,
  `contract_date` date DEFAULT NULL,
  `deadline_date` date DEFAULT NULL,
  `registered_datetime` datetime(6) DEFAULT NULL,
  `process` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exporting_export_user_id_fk_auth_user_id` (`user_id`),
  CONSTRAINT `exporting_export_user_id_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.exporting_product definition

CREATE TABLE `exporting_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `hscode` varchar(10) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price_per_unit` double DEFAULT NULL,
  `export_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exporting_product_export_id_fk_exporting_export` (`export_id`),
  CONSTRAINT `exporting_product_export_id_fk_exporting_export` FOREIGN KEY (`export_id`) REFERENCES `exporting_export` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.managing_document_document definition

CREATE TABLE `managing_document_document` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `issue_date` date DEFAULT NULL,
  `is_paid` tinyint DEFAULT NULL,
  `export_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `managing_document_export_id_fk_exporting_export` (`export_id`),
  CONSTRAINT `managing_document_export_id_fk_exporting_export` FOREIGN KEY (`export_id`) REFERENCES `exporting_export` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.managing_document_exportdeclaration definition

CREATE TABLE `managing_document_exportdeclaration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `document_ptr_id` bigint NOT NULL,
  `export_declaration_number` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_document_ptr_id` (`document_ptr_id`),
  CONSTRAINT `fk_document_ptr_id` FOREIGN KEY (`document_ptr_id`) REFERENCES `managing_document_document` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.managing_document_invoice definition

CREATE TABLE `managing_document_invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `document_ptr_id` bigint NOT NULL,
  `invoice_number` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `document_ptr_id` (`document_ptr_id`),
  CONSTRAINT `managing_document_invoice_ibfk_1` FOREIGN KEY (`document_ptr_id`) REFERENCES `managing_document_document` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.managing_document_packinglist definition

CREATE TABLE `managing_document_packinglist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `document_ptr_id` bigint NOT NULL,
  `packing_list_number` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `document_ptr_id` (`document_ptr_id`),
  CONSTRAINT `managing_document_packinglist_ibfk_1` FOREIGN KEY (`document_ptr_id`) REFERENCES `managing_document_document` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.marketing_post definition

CREATE TABLE `marketing_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `price_per_unit` double DEFAULT NULL,
  `content` longtext,
  `category` varchar(4) DEFAULT NULL,
  `moq` int DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `updated_datetime` datetime(6) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `marketing_post_user_id_fk_auth_user_id` (`user_id`),
  CONSTRAINT `marketing_post_user_id_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.booking_shipment_requestquotation definition

CREATE TABLE `booking_shipment_requestquotation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `expected_shipping_date` date DEFAULT NULL,
  `requested_content` longtext,
  `requested_date` date DEFAULT NULL,
  `replied_content` longtext,
  `replied_date` date DEFAULT NULL,
  `is_accepted` tinyint DEFAULT NULL,
  `export_id` bigint DEFAULT NULL,
  `forwarder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_forwarder_id` (`forwarder_id`),
  KEY `idx_export_id` (`export_id`),
  CONSTRAINT `fk_requestquotation_export` FOREIGN KEY (`export_id`) REFERENCES `exporting_export` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.exporting_cargo definition

CREATE TABLE `exporting_cargo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `width` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `container_type` varchar(5) DEFAULT NULL,
  `is_dangerous` tinyint(1) DEFAULT NULL,
  `export_id` bigint DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exporting_cargo_export_id_c17bc991_fk_exporting_export_id` (`export_id`),
  CONSTRAINT `exporting_cargo_export_id_c17bc991_fk_exporting_export_id` FOREIGN KEY (`export_id`) REFERENCES `exporting_export` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8mb3;


-- firepunch.managing_document_certificateorigin definition

CREATE TABLE `managing_document_certificateorigin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `document_ptr_id` bigint NOT NULL,
  `certificate_origin_number` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `managing_document_ce_document_ptr_id_8525346b_fk_managing_` (`document_ptr_id`),
  CONSTRAINT `managing_document_ce_document_ptr_id_8525346b_fk_managing_` FOREIGN KEY (`document_ptr_id`) REFERENCES `managing_document_document` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.marketing_hit definition

CREATE TABLE `marketing_hit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_datetime` datetime(6) NOT NULL,
  `post_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `marketing_hit_post_id_92ba75ec_fk_marketing_post_id` (`post_id`),
  CONSTRAINT `marketing_hit_post_id_92ba75ec_fk_marketing_post_id` FOREIGN KEY (`post_id`) REFERENCES `marketing_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- firepunch.marketing_image definition

CREATE TABLE `marketing_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_path` varchar(250) NOT NULL,
  `post_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `marketing_image_post_id_94cfdd5c_fk_marketing_post_id` (`post_id`),
  CONSTRAINT `marketing_image_post_id_94cfdd5c_fk_marketing_post_id` FOREIGN KEY (`post_id`) REFERENCES `marketing_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- firepunch.marketing_inquiry definition

CREATE TABLE `marketing_inquiry` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(254) NOT NULL,
  `password` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `created_datetime` datetime(6) NOT NULL,
  `updated_datetime` datetime(6) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  `post_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `marketing_inquiry_post_id_fd8c09fa_fk_marketing_post_id` (`post_id`),
  CONSTRAINT `marketing_inquiry_post_id_fd8c09fa_fk_marketing_post_id` FOREIGN KEY (`post_id`) REFERENCES `marketing_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- firepunch.booking_shipment_billoflading definition

CREATE TABLE `booking_shipment_billoflading` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bl_number` varchar(50) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `vessel_name` varchar(100) DEFAULT NULL,
  `loading_port` varchar(100) DEFAULT NULL,
  `discharge_port` varchar(100) DEFAULT NULL,
  `is_clean` tinyint(1) DEFAULT '0',
  `is_endorsed` tinyint(1) DEFAULT '0',
  `insurance_policy_number` varchar(50) DEFAULT NULL,
  `file_path` varchar(250) DEFAULT NULL,
  `request_quotation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_bl_number` (`bl_number`),
  UNIQUE KEY `uq_request_quotation_id` (`request_quotation_id`),
  CONSTRAINT `fk_request_quotation_id` FOREIGN KEY (`request_quotation_id`) REFERENCES `booking_shipment_requestquotation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;