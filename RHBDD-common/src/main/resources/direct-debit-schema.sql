CREATE TABLE SERVER_CONFIGURATION
(
  server_configuration_id NUMBER(19, 0) NOT NULL,
  server_ip               VARCHAR2(20)  NOT NULL,
  server_port             NUMBER(8, 0)  NOT NULL,
  transmission_method     VARCHAR2(20)  NOT NULL, -- possible values: SFTP or FTP
  server_username         VARCHAR2(40)  NOT NULL,
  server_password         VARCHAR2(40)  NOT NULL,
  CONSTRAINT server_configuration_pk PRIMARY KEY (server_configuration_id)
);

CREATE TABLE FOLDER_CONFIGURATION
(
  folder_type             VARCHAR2(20)  NOT NULL,
  folder_path             VARCHAR2(100) NOT NULL,
  seller_id               VARCHAR2(20)  NOT NULL,
  server_configuration_id NUMBER(19, 0) NOT NULL,
  CONSTRAINT FOLDER_CONFIGURATION_UN UNIQUE (seller_id, folder_type),
  CONSTRAINT FC_SERVER_CONFIG_ID_FK FOREIGN KEY (server_configuration_id) REFERENCES SERVER_CONFIGURATION (server_configuration_id),
  CONSTRAINT FC_SELLER_ID_FK FOREIGN KEY (seller_id) REFERENCES SELLER (seller_id)
);

CREATE TABLE CFT_FILE (
  cft_file_id             NUMBER(28, 0) NOT NULL,
  filename                VARCHAR2(50)  NOT NULL,
  payment_mode            VARCHAR2(10),
  seller_transaction_date TIMESTAMP,
  seller_id               VARCHAR2(20)  NOT NULL,
  status                  VARCHAR2(10),
  total_item              NUMBER(10, 0),
  total_amount_in_cent    NUMBER(15, 0),
  hash_total              VARCHAR2(20),
  date_file_processed     TIMESTAMP,
  CONSTRAINT cft_file_pk PRIMARY KEY (cft_file_id),
  CONSTRAINT cft_seller_id_fk FOREIGN KEY (seller_id) REFERENCES SELLER (SELLER_ID)
);

CREATE TABLE CFT_FILE_DETAIL (
  cft_file_detail_id     NUMBER(28, 0) NOT NULL,
  cft_file_id            NUMBER(28, 0) NOT NULL,
  seller_order_no        VARCHAR2(30),
  seller_account_no      VARCHAR2(30),
  payer_bank_id          VARCHAR2(15),
  payer_bank_branch_code VARCHAR2(15),
  payer_account_no       VARCHAR2(30),
  payer_name             VARCHAR2(60),
  payer_id_type          VARCHAR2(5),
  payer_id_no            VARCHAR2(30),
  transaction_amount     NUMBER(15, 2),
  transaction_currency   VARCHAR2(5),
  charge_type            VARCHAR2(6),
  reference_no1          VARCHAR2(30),
  reference_no2          VARCHAR2(30),
  payment_reference_no   VARCHAR2(45),
  mandate_no             VARCHAR2(45),
  debit_retry            NUMBER(2, 0) DEFAULT 0,
  transaction_status     VARCHAR2(4),
  debit_status           VARCHAR2(5),
  credit_status          VARCHAR2(5),
  CONSTRAINT cft_file_detail_pk PRIMARY KEY (cft_file_detail_id),
  CONSTRAINT cft_file_id_fk FOREIGN KEY (cft_file_id) REFERENCES cft_file (cft_file_id)
);

CREATE TABLE RES_FILE (
  res_file_id             NUMBER(28, 0) NOT NULL,
  filename                VARCHAR2(50)  NOT NULL,
  payment_mode            VARCHAR2(10),
  seller_transaction_date TIMESTAMP,
  seller_id               VARCHAR2(20)  NOT NULL,
  status                  VARCHAR2(10),
  total_item              NUMBER(10, 0),
  total_amount_in_cent    NUMBER(15, 0),
  hash_total              VARCHAR2(20),
  date_file_created       TIMESTAMP,
  cft_file_id             NUMBER(19, 0) NOT NULL,
  CONSTRAINT res_file_pk PRIMARY KEY (res_file_id),
  CONSTRAINT res_cft_file_id_fk FOREIGN KEY (cft_file_id) REFERENCES cft_file (cft_file_id),
  CONSTRAINT res_seller_id_fk FOREIGN KEY (seller_id) REFERENCES SELLER (SELLER_ID)
);

CREATE TABLE RES_FILE_DETAIL (
  res_file_detail_id NUMBER(28, 0) NOT NULL,
  res_file_id        NUMBER(28, 0) NOT NULL,

  cft_file_detail_id NUMBER(28, 0) NOT NULL,

  CONSTRAINT res_file_detail_pk PRIMARY KEY (res_file_detail_id),
  CONSTRAINT res_file_id_fk FOREIGN KEY (res_file_id) REFERENCES res_file (res_file_id),
  CONSTRAINT res_cft_detail_id_fk FOREIGN KEY (cft_file_detail_id) REFERENCES cft_file_detail (cft_file_detail_id)
);

CREATE TABLE IBG_FILE (
  ibg_file_id                NUMBER(28, 0) NOT NULL,
  filename                   VARCHAR2(50)  NOT NULL,

  rec_type_code              VARCHAR2(2),
  priority_code              VARCHAR2(4),
  immediate_destination      VARCHAR2(20),
  immediate_origin           VARCHAR2(20),
  file_creation_date         VARCHAR2(6),
  file_creation_time         VARCHAR2(4),
  file_id_modifier           VARCHAR2(2),
  record_size                VARCHAR2(3),
  blocking_factor            VARCHAR2(4),
  format_code                VARCHAR2(2),
  immediate_destination_name VARCHAR2(40),
  immediate_origin_name      VARCHAR2(40),
  reference_code             VARCHAR2(16),

  CONSTRAINT ibg_file_pk PRIMARY KEY (ibg_file_id)
);

CREATE TABLE IBG_FILE_BATCH (
  ibg_file_batch_id             NUMBER(28, 0) NOT NULL,
  ibg_file_id                   NUMBER(28, 0) NOT NULL,

  rec_type_code                 VARCHAR2(2),
  service_class_code            VARCHAR2(6),
  company_name                  VARCHAR2(32),
  company_discretionary_data    VARCHAR2(40),
  company_identification        VARCHAR2(20),
  standard_entry_class_code     VARCHAR2(6),
  company_entry_description     VARCHAR2(20),
  company_descriptive_date      VARCHAR2(6),
  effective_entry_date          VARCHAR2(6),
  settlement_date               VARCHAR2(6),
  originator_status_code        VARCHAR2(2),
  originating_fi_identification VARCHAR2(16),
  batch_number                  VARCHAR2(17),

  CONSTRAINT ibg_file_batch_id_pk PRIMARY KEY (ibg_file_batch_id),
  CONSTRAINT ibg_file_detail_id_fk FOREIGN KEY (ibg_file_id) REFERENCES ibg_file (ibg_file_id)
);

CREATE TABLE IBG_FILE_ENTRY (
  ibg_file_entry_id           NUMBER(28, 0) NOT NULL,
  ibg_file_batch_id           NUMBER(28, 0) NOT NULL,

  rec_type_code               VARCHAR2(2),
  transaction_code            VARCHAR2(4),
  receiving_fi_identification VARCHAR2(16),
  check_digit                 VARCHAR2(2),
  rfi_account_number          VARCHAR2(34),
  amount_in_cent              VARCHAR2(15),
  individual_id_number        VARCHAR2(30),
  no_of_addenda_records       VARCHAR2(8),
  individual_name             VARCHAR2(32),
  reserved                    VARCHAR2(4),
  discretionary_data          VARCHAR2(4),
  addenda_records_indicator   VARCHAR2(2),
  trace_number                VARCHAR2(30),

  CONSTRAINT ibg_file_entry_id_pk PRIMARY KEY (ibg_file_entry_id),
  CONSTRAINT ibg_file_entry_id_fk FOREIGN KEY (ibg_file_batch_id) REFERENCES ibg_file_batch (ibg_file_batch_id)
);

CREATE TABLE ibg_first_addenda (
  ibg_first_addenda_id         NUMBER(28, 0) NOT NULL,
  ibg_file_entry_id            NUMBER(28, 0) NOT NULL,

  rec_type_code                VARCHAR2(2),
  addenda_type_code            VARCHAR2(4),
  biller_name                  VARCHAR2(45),
  biller_code                  VARCHAR2(30),
  mandate_number               VARCHAR2(30),
  debit_retry                  NUMBER(2),
  account_type                 VARCHAR2(2),
  fee_amount_in_cent           VARCHAR2(15),
  fee_charge_type              VARCHAR2(2),
  reserved                     VARCHAR2(4),
  addenda_sequence_number      VARCHAR2(6),
  entry_detail_sequence_number VARCHAR2(10),

  CONSTRAINT ibg_first_addenda_id_pk PRIMARY KEY (ibg_file_entry_id),
  CONSTRAINT ibg_first_addenda_id_fk FOREIGN KEY (ibg_file_entry_id) REFERENCES ibg_file_entry (ibg_file_entry_id)
);

CREATE TABLE ibg_second_addenda (
  ibg_second_addenda_id        NUMBER(28, 0) NOT NULL,
  ibg_file_entry_id            NUMBER(28, 0) NOT NULL,

  rec_type_code                VARCHAR2(2),
  addenda_type_code            VARCHAR2(4),
  other_payment_details        VARCHAR2(30),
  recipient_reference          VARCHAR2(30),
  reserved                     VARCHAR2(50),
  addenda_sequence_number      VARCHAR2(6),
  entry_detail_sequence_number VARCHAR2(10),

  CONSTRAINT ibg_second_addenda_id_pk PRIMARY KEY (ibg_second_addenda_id),
  CONSTRAINT ibg_second_addenda_id_fk FOREIGN KEY (ibg_file_entry_id) REFERENCES ibg_file_entry (ibg_file_entry_id)
);

CREATE TABLE ibg_return_addenda (
  ibg_return_addenda_id       NUMBER(28, 0) NOT NULL,
  ibg_file_entry_id           NUMBER(28, 0) NOT NULL,

  rec_type_code               VARCHAR2(2),
  return_reason_code          VARCHAR2(6),
  addenda_type_code           VARCHAR2(4),
  original_entry_trace_number VARCHAR2(30),
  date_of_death               VARCHAR2(12),
  original_rfi_identification VARCHAR2(16),
  biller_code                 VARCHAR2(20),
  recipient_reference         VARCHAR2(40),
  debit_retry                 NUMBER(2),
  account_type                VARCHAR2(2),
  addenda_information         VARCHAR2(24),
  trace_number                VARCHAR2(30),

  CONSTRAINT ibg_return_addenda_id_pk PRIMARY KEY (ibg_return_addenda_id),
  CONSTRAINT ibg_return_addenda_id_fk FOREIGN KEY (ibg_file_entry_id) REFERENCES ibg_file_entry (ibg_file_entry_id)
);

CREATE TABLE payment_instruction (
  payment_instruction_id        NUMBER(28, 0)       NOT NULL,

  ibg_file_entry_id             NUMBER(28, 0),
  cft_file_detail_id            NUMBER(28, 0),

  is_interbank                  CHAR(1) DEFAULT '1' NOT NULL, -- 1 - Interbank , 0 - Intrabank a.k.a RHB to RHB

  transaction_type              VARCHAR2(40), -- outward_dn - To debit other bank's account, inward_dn - To debit RHB's account

  transaction_status_code       VARCHAR2(50),
  ibg_return_code               VARCHAR2(50),

  creation_date                 TIMESTAMP,

  ibg_sent_date                 TIMESTAMP, -- the date that submitted to MyClear IBG
  settlement_date               TIMESTAMP,
  settlement_window             VARCHAR2(8),

  eai_posting_status            VARCHAR2(50),
  eai_response_code             VARCHAR2(50),
  last_eai_posting_date         TIMESTAMP,
  last_eai_posting_window       VARCHAR2(8), -- 0700, 1000, 1300, 1600 and 1900
  eai_ref_number                VARCHAR2(50),

  is_delay_cr_posting           CHAR(1) DEFAULT '0' NOT NULL,

  credit_card_fee               NUMBER(15, 2),
  credit_card_fee_gst           NUMBER(15, 2),

  capture_reimbursement_fee     NUMBER(15, 2),
  capture_reimbursement_fee_gst NUMBER(15, 2),

  processing_fee                NUMBER(15, 2),
  processing_fee_gst            NUMBER(15, 2),

  service_fee                   NUMBER(15, 2),
  service_fee_gst               NUMBER(15, 2),

  ofi_routing_number            NUMBER(20),
  ofi_bank_name                 VARCHAR2(100),

  rfi_routing_number            NUMBER(20),
  rfi_bank_name                 VARCHAR2(100),

  segment_code                  CHAR(1),
  element_code                  CHAR(1),

  payer_account_type            CHAR(1),

  CONSTRAINT payment_instruction_id_pk PRIMARY KEY (payment_instruction_id),

  CONSTRAINT payment_ibg_file_entry_id_fk FOREIGN KEY (ibg_file_entry_id) REFERENCES IBG_FILE_ENTRY (ibg_file_entry_id),
  CONSTRAINT payment_cft_file_detail_id_fk FOREIGN KEY (cft_file_detail_id) REFERENCES CFT_FILE_DETAIL (cft_file_detail_id)
);

CREATE TABLE EMAIL_NOTIFICATION
(
  "EMAIL_NOTIFICATION_ID"     NUMBER(28, 0) NOT NULL,
  "TRANSACTION_ID"            VARCHAR2(10), -- referennce to COLLECTION.COLLECTION_ID or MANDATE.ID
  "PURPOSE"                   VARCHAR2(20),
  "EMAIL_ACC"                 VARCHAR2(100),
  "EMAIL_FROM"                VARCHAR2(50),
  "EMAIL_SUBJECT"             VARCHAR2(50),
  "EMAIL_BODY"                BLOB,
  "DELIVERY"                  CHAR(1)   DEFAULT 'N',
  "DELIVERY_STATUS"           VARCHAR2(100),
  "CREATE_DATE_TIME"          TIMESTAMP DEFAULT SYSTIMESTAMP,
  "DELIVERY_DATE_TIME"        TIMESTAMP,
  "DELIVERY_RESULT_DATE_TIME" TIMESTAMP
);


CREATE TABLE SMS_NOTIFICATION
(
  "SMS_NOTIFICATION_ID"       NUMBER(28, 0) NOT NULL,
  "TRANSACTION_ID"            VARCHAR2(10), -- referennce to COLLECTION.COLLECTION_ID or MANDATE.ID
  "PURPOSE"                   VARCHAR2(20),
  "CONTACT_NO"                VARCHAR2(20),
  "SMS_TEXT"                  VARCHAR2(2000),
  "DELIVERY"                  CHAR(1)   DEFAULT 'N',
  "DELIVERY_STATUS"           VARCHAR2(100),
  "CREATE_DATE_TIME"          TIMESTAMP DEFAULT SYSTIMESTAMP,
  "DELIVERY_DATE_TIME"        TIMESTAMP,
  "DELIVERY_RESULT_DATE_TIME" TIMESTAMP
);

CREATE SEQUENCE trace_number_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999    -- recycle the trace number once reached 9,999,999
CYCLE
NOCACHE;

CREATE SEQUENCE ibg_file_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

CREATE SEQUENCE ibg_file_batch_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

CREATE SEQUENCE ibg_file_entry_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

CREATE SEQUENCE ibg_first_addenda_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

CREATE SEQUENCE ibg_second_addenda_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

CREATE SEQUENCE ibg_return_addenda_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

CREATE SEQUENCE eai_dd_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999999999
CYCLE
NOCACHE;





