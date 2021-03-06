CREATE TABLE SELLER
(
  "SELLER_ID"               VARCHAR2(20)            NOT NULL,
  "BUSINESS_REG_NO"         VARCHAR2(20),
  "IS_B2C"                  VARCHAR2(1) DEFAULT 'N',
  "IS_B2B1"                 VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "IS_B2B2"                 VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "IS_DD"                   VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "IS_CANCEL"               VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "CIS_NUMBER"              VARCHAR2(20),
  "BANK_CODE"               VARCHAR2(50),
  "COMPANY_NAME"            VARCHAR2(100),
  "BUSINESS_DESC"           VARCHAR2(150),
  "EXCHANGE_ID"             VARCHAR2(20),
  "EXCHANGE_DESCRIPTION"    VARCHAR2(100),
  "ADDRESS1"                VARCHAR2(300),
  "ADDRESS2"                VARCHAR2(300),
  "ADDRESS3"                VARCHAR2(300),
  "STATE"                   VARCHAR2(2),
  "POSTCODE"                VARCHAR2(5),
  "TELEPHONE_NO"            VARCHAR2(20),
  "FAX_NO"                  VARCHAR2(20),
  "P_CONTACT_PERSON_NAME"   VARCHAR2(150), -- Size follow USER_PROFILE.DISPLAY_NAME
  "P_CONTACT_PERSON_IC_NO"  VARCHAR2(15),
  "P_CONTACT_PERSON_TEL_NO" VARCHAR2(16),
  "S_CONTACT_PERSON_NAME"   VARCHAR2(150), -- Size follow USER_PROFILE.DISPLAY_NAME
  "S_CONTACT_PERSON_IC_NO"  VARCHAR2(15),
  "S_CONTACT_PERSON_TEL_NO" VARCHAR2(16),
  "WEBSITE_URL"             VARCHAR2(100),
  "IP_ADDRESS"              VARCHAR2(30),
  "IS_CHARGE_SELLER"        VARCHAR2(1),
  "IS_CHARGE_BUYER"         VARCHAR2(1),
  "EMAIL"                   VARCHAR2(100),
  "OTHER_BANK_ACCOUNT_NO"   VARCHAR2(50),
  "OTHER_BANK_NAME"         VARCHAR2(50),
  "OTHER_DETAILS"           VARCHAR2(150),
  "IS_ACTIVE"               VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "PRINT_NOTIF_LETTER"      VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "IS_TXN_FINGERPRINT"      VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "IS_DDR"                  VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "REMARKS"                 VARCHAR2(200),

  "SELLER_CODE"             VARCHAR2(20),
  "TXN_KEY"                 VARCHAR2(50),
  "COMPANY_CODE"            VARCHAR2(20),
  "COMPANY_SUB_CODE"        VARCHAR2(20),

  "CREATE_MAKE_DATE_TIME"   TIMESTAMP   DEFAULT SYSTIMESTAMP,
  "CREATE_MAKER_ID"         VARCHAR2(50),
  "CREATE_CHECK_DATE_TIME"  TIMESTAMP   DEFAULT SYSTIMESTAMP,
  "CREATE_CHECKER_ID"       VARCHAR2(50),
  "UPDATE_MAKE_DATE_TIME"   TIMESTAMP,
  "UPDATE_MAKER_ID"         VARCHAR2(50),
  "UPDATE_CHECK_DATE_TIME"  TIMESTAMP,
  "UPDATE_CHECKER_ID"       VARCHAR2(50),

  CONSTRAINT SELLER_PK PRIMARY KEY (SELLER_ID)
);


CREATE TABLE BANK_PROFILE
(
  "BANK_CODE"           VARCHAR2(50)  NOT NULL,
  "BANK_NAME"           VARCHAR2(100) NOT NULL,
  "ADDRESS"             VARCHAR2(300) NOT NULL,
  "STATE"               VARCHAR2(2),
  "POSTCODE"            VARCHAR2(5),
  "TELEPHONE_NO"        VARCHAR2(20),
  "FAX_NO"              VARCHAR2(20),
  "CONTACT_PERSON_NAME" VARCHAR2(150), -- Size follow USER_PROFILE.DISPLAY_NAME
  "BANK_URL"            VARCHAR2(30),
  "STATUS"              VARCHAR2(2)   NOT NULL, -- Size follow MASTER_COL_DEFINITION.DEF_CODE

  routing_number        VARCHAR2(9),

  CONSTRAINT BANK_PROFILE_PK PRIMARY KEY (BANK_CODE)
);

CREATE TABLE SELLER_CHARGE
(
  "SELLER_ID"                 VARCHAR2(20)            NOT NULL,
  "BIZ_MODEL"                 VARCHAR2(4)             NOT NULL, --Values: B2C , B2B1 , B2B2
  "SELLER_BILLING_TYPE"       VARCHAR2(10)            NOT NULL, -- Values:Auto , Manual
  "IS_DRC"                    VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "BILLING_FREQUENCY"         VARCHAR2(20),
  "IS_CREDITCARD_SELLER"      VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "IS_FIXED_RATE"             VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "FIXED_RATE"                VARCHAR2(20),
  "IS_PERCENTAGE_RATE"        VARCHAR2(1) DEFAULT 'N' NOT NULL,
  "PERCENTAGE_RATE"           VARCHAR2(20),
  "MIN_AMOUNT"                VARCHAR2(20),
  "MIX_AMOUNT"                VARCHAR2(20),
  "SELLER_BANK_CHARGES_SHARE" VARCHAR2(20),
  "BUYER_BANK_CHARGES_SHARE"  VARCHAR2(20),
  "FPX_CHARGES_SHARE"         VARCHAR2(20),
  CONSTRAINT SELLER_CHARGE_PK PRIMARY KEY (SELLER_ID, BIZ_MODEL),
  CONSTRAINT SELLER_CHARGE_SELLER_ID_FK FOREIGN KEY (SELLER_ID) REFERENCES SELLER (SELLER_ID)
);

CREATE TABLE SELLER_ACCOUNT
(
  "SELLER_ID"  VARCHAR2(20) NOT NULL,
  "BIZ_MODEL"  VARCHAR2(4)  NOT NULL, --Values: B2C , B2B1 , B2B2
  "ACCOUNT_NO" VARCHAR2(20) NOT NULL,
  CONSTRAINT SELLER_ACCOUNT_PK PRIMARY KEY (SELLER_ID, BIZ_MODEL),
  CONSTRAINT SELLER_ACCOUNT_SELLER_ID_FK FOREIGN KEY (SELLER_ID) REFERENCES SELLER (SELLER_ID)

);