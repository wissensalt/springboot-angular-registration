-- Table: public.sec_user

-- DROP TABLE public.sec_user;

CREATE TABLE public.sec_user
(
  id bigserial,
  code character varying(50),
  name character varying(150),
  first_name character varying(50),
  last_name character varying(50),
  mobile_number character varying(13),
  date_of_birth timestamp without time zone,
  email character varying(256),
  remarks character varying(256),
  status boolean,
  created_by character varying(50),
  created_on timestamp without time zone,
  updated_by character varying(50),
  updated_on timestamp without time zone,
  password character varying(256),
  enabled boolean,
  expired_date timestamp without time zone,
  account_non_locked boolean,
  login_status boolean,
  last_login timestamp without time zone,
  credentials_expired_date timestamp without time zone,
  gender smallint,
  CONSTRAINT pk_user PRIMARY KEY (id),
  CONSTRAINT unique_code_user UNIQUE (code)
);

-- Table: public.sec_role

-- DROP TABLE public.sec_role;

CREATE TABLE public.sec_role
(
  id bigserial,
  code character varying(50),
  name character varying(150),
  remarks character varying(256),
  status boolean,
  created_by character varying(50),
  created_on timestamp without time zone,
  updated_by character varying(50),
  updated_on timestamp without time zone,
  CONSTRAINT pk_role PRIMARY KEY (id),
  CONSTRAINT unique_role UNIQUE (code)
);


-- Table: public.link_user_role

-- DROP TABLE public.link_user_role;

CREATE TABLE public.link_user_role
(
  user_id bigint,
  role_id bigint,
  CONSTRAINT fk_role_id FOREIGN KEY (role_id)
      REFERENCES public.sec_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT role_id FOREIGN KEY (user_id)
      REFERENCES public.sec_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

