--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2020-06-21 00:42:12 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13241)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3135 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 1829911)
-- Name: app_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE app_role (
    id bigint NOT NULL,
    role_name character varying(255)
);


ALTER TABLE app_role OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 1829909)
-- Name: app_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE app_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_role_id_seq OWNER TO postgres;

--
-- TOC entry 3136 (class 0 OID 0)
-- Dependencies: 196
-- Name: app_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE app_role_id_seq OWNED BY app_role.id;


--
-- TOC entry 199 (class 1259 OID 1829919)
-- Name: app_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE app_user (
    id bigint NOT NULL,
    actived boolean NOT NULL,
    adresse character varying(255),
    code_postal character varying(255),
    email character varying(255),
    nom character varying(255),
    password character varying(255),
    prenom character varying(255),
    siret_client character varying(255),
    societe character varying(255),
    telephone character varying(255),
    username character varying(255),
    ville character varying(255)
);


ALTER TABLE app_user OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 1829928)
-- Name: app_user_app_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE app_user_app_roles (
    app_user_id bigint NOT NULL,
    app_roles_id bigint NOT NULL
);


ALTER TABLE app_user_app_roles OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 1829917)
-- Name: app_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE app_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_user_id_seq OWNER TO postgres;

--
-- TOC entry 3137 (class 0 OID 0)
-- Dependencies: 198
-- Name: app_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE app_user_id_seq OWNED BY app_user.id;


--
-- TOC entry 2998 (class 2604 OID 1829914)
-- Name: app_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_role ALTER COLUMN id SET DEFAULT nextval('app_role_id_seq'::regclass);


--
-- TOC entry 2999 (class 2604 OID 1829922)
-- Name: app_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_user ALTER COLUMN id SET DEFAULT nextval('app_user_id_seq'::regclass);


--
-- TOC entry 3001 (class 2606 OID 1829916)
-- Name: app_role app_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_role
    ADD CONSTRAINT app_role_pkey PRIMARY KEY (id);


--
-- TOC entry 3003 (class 2606 OID 1829927)
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);


--
-- TOC entry 3005 (class 2606 OID 1829932)
-- Name: app_user uk_3k4cplvh82srueuttfkwnylq0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_user
    ADD CONSTRAINT uk_3k4cplvh82srueuttfkwnylq0 UNIQUE (username);


--
-- TOC entry 3006 (class 2606 OID 1829933)
-- Name: app_user_app_roles fk8caosscox5onsgcvll6tqmk21; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_user_app_roles
    ADD CONSTRAINT fk8caosscox5onsgcvll6tqmk21 FOREIGN KEY (app_roles_id) REFERENCES app_role(id);


--
-- TOC entry 3007 (class 2606 OID 1829938)
-- Name: app_user_app_roles fksno3iwx8ppdc085g7ovuc8h7w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY app_user_app_roles
    ADD CONSTRAINT fksno3iwx8ppdc085g7ovuc8h7w FOREIGN KEY (app_user_id) REFERENCES app_user(id);


-- Completed on 2020-06-21 00:42:12 CEST

--
-- PostgreSQL database dump complete
--

