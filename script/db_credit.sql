--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2020-06-21 00:46:20 CEST

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
-- TOC entry 3181 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 202 (class 1259 OID 1827644)
-- Name: credit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE credit (
    id bigint NOT NULL,
    assurance character varying(255),
    duree character varying(255),
    montant character varying(255),
    nature character varying(255),
    objet character varying(255),
    siret_client character varying(255),
    status character varying(255),
    echeance_emprunt character varying(255),
    reference_dossier character varying(255),
    taux character varying(255),
    cout_global character varying(255),
    decision_id bigint
);


ALTER TABLE credit OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 1828196)
-- Name: credit_decisions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE credit_decisions (
    credit_id bigint NOT NULL,
    decisions_id bigint NOT NULL
);


ALTER TABLE credit_decisions OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 1827565)
-- Name: credit_garantie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE credit_garantie (
    creditid integer NOT NULL,
    garantieid integer NOT NULL
);


ALTER TABLE credit_garantie OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 1827642)
-- Name: credit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE credit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE credit_id_seq OWNER TO postgres;

--
-- TOC entry 3182 (class 0 OID 0)
-- Dependencies: 201
-- Name: credit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE credit_id_seq OWNED BY credit.id;


--
-- TOC entry 204 (class 1259 OID 1827655)
-- Name: decision; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE decision (
    id bigint NOT NULL,
    commentaire character varying(255),
    date_decision character varying(255),
    statuts character varying(255),
    edition_id bigint
);


ALTER TABLE decision OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 1828290)
-- Name: decision_editions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE decision_editions (
    decision_id bigint NOT NULL,
    editions_id bigint NOT NULL
);


ALTER TABLE decision_editions OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 1827653)
-- Name: decision_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE decision_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE decision_id_seq1 OWNER TO postgres;

--
-- TOC entry 3183 (class 0 OID 0)
-- Dependencies: 203
-- Name: decision_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE decision_id_seq1 OWNED BY decision.id;


--
-- TOC entry 206 (class 1259 OID 1827693)
-- Name: edition; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE edition (
    id bigint NOT NULL,
    date_edition character varying(255),
    statuts character varying(255),
    commentaire character varying(255),
    date_deblocage character varying(255)
);


ALTER TABLE edition OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 1827691)
-- Name: edition_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE edition_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE edition_id_seq OWNER TO postgres;

--
-- TOC entry 3184 (class 0 OID 0)
-- Dependencies: 205
-- Name: edition_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE edition_id_seq OWNED BY edition.id;


--
-- TOC entry 199 (class 1259 OID 1827559)
-- Name: garantie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE garantie (
    id integer NOT NULL,
    intitule_garantie character(50),
    type_garantie character(50)
);


ALTER TABLE garantie OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 1827557)
-- Name: garantie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE garantie_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE garantie_id_seq OWNER TO postgres;

--
-- TOC entry 3185 (class 0 OID 0)
-- Dependencies: 198
-- Name: garantie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE garantie_id_seq OWNED BY garantie.id;


--
-- TOC entry 197 (class 1259 OID 1827551)
-- Name: statuts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE statuts (
    id integer NOT NULL,
    statuts character(50)
);


ALTER TABLE statuts OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 1827549)
-- Name: statuts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE statuts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE statuts_id_seq OWNER TO postgres;

--
-- TOC entry 3186 (class 0 OID 0)
-- Dependencies: 196
-- Name: statuts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE statuts_id_seq OWNED BY statuts.id;


--
-- TOC entry 3028 (class 2604 OID 1827647)
-- Name: credit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit ALTER COLUMN id SET DEFAULT nextval('credit_id_seq'::regclass);


--
-- TOC entry 3029 (class 2604 OID 1827658)
-- Name: decision id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY decision ALTER COLUMN id SET DEFAULT nextval('decision_id_seq1'::regclass);


--
-- TOC entry 3030 (class 2604 OID 1827696)
-- Name: edition id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY edition ALTER COLUMN id SET DEFAULT nextval('edition_id_seq'::regclass);


--
-- TOC entry 3027 (class 2604 OID 1827562)
-- Name: garantie id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY garantie ALTER COLUMN id SET DEFAULT nextval('garantie_id_seq'::regclass);


--
-- TOC entry 3026 (class 2604 OID 1827554)
-- Name: statuts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY statuts ALTER COLUMN id SET DEFAULT nextval('statuts_id_seq'::regclass);


--
-- TOC entry 3036 (class 2606 OID 1827569)
-- Name: credit_garantie credit_garantie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit_garantie
    ADD CONSTRAINT credit_garantie_pkey PRIMARY KEY (creditid, garantieid);


--
-- TOC entry 3038 (class 2606 OID 1827652)
-- Name: credit credit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit
    ADD CONSTRAINT credit_pkey PRIMARY KEY (id);


--
-- TOC entry 3040 (class 2606 OID 1827663)
-- Name: decision decision_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY decision
    ADD CONSTRAINT decision_pkey1 PRIMARY KEY (id);


--
-- TOC entry 3042 (class 2606 OID 1827701)
-- Name: edition edition_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY edition
    ADD CONSTRAINT edition_pkey PRIMARY KEY (id);


--
-- TOC entry 3034 (class 2606 OID 1827564)
-- Name: garantie garantie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY garantie
    ADD CONSTRAINT garantie_pkey PRIMARY KEY (id);


--
-- TOC entry 3032 (class 2606 OID 1827556)
-- Name: statuts statuts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY statuts
    ADD CONSTRAINT statuts_pkey PRIMARY KEY (id);


--
-- TOC entry 3046 (class 2606 OID 1828294)
-- Name: decision_editions uk_315s406fm7wp3e5whhlch07r3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY decision_editions
    ADD CONSTRAINT uk_315s406fm7wp3e5whhlch07r3 UNIQUE (editions_id);


--
-- TOC entry 3044 (class 2606 OID 1828200)
-- Name: credit_decisions uk_mvtr4m103lg0qwvilfv6cmg8b; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit_decisions
    ADD CONSTRAINT uk_mvtr4m103lg0qwvilfv6cmg8b UNIQUE (decisions_id);


--
-- TOC entry 3048 (class 2606 OID 1828211)
-- Name: credit fk3cfj4o8r8vi0gbtvdrjr5hna2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit
    ADD CONSTRAINT fk3cfj4o8r8vi0gbtvdrjr5hna2 FOREIGN KEY (decision_id) REFERENCES decision(id);


--
-- TOC entry 3050 (class 2606 OID 1828201)
-- Name: credit_decisions fk3gkvmen0ah8qxe7jjgaren1w5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit_decisions
    ADD CONSTRAINT fk3gkvmen0ah8qxe7jjgaren1w5 FOREIGN KEY (decisions_id) REFERENCES decision(id);


--
-- TOC entry 3052 (class 2606 OID 1828295)
-- Name: decision_editions fka3ixr1t7ge957f57hxbqealgg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY decision_editions
    ADD CONSTRAINT fka3ixr1t7ge957f57hxbqealgg FOREIGN KEY (editions_id) REFERENCES edition(id);


--
-- TOC entry 3047 (class 2606 OID 1827585)
-- Name: credit_garantie fkcredit_gar932660; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit_garantie
    ADD CONSTRAINT fkcredit_gar932660 FOREIGN KEY (garantieid) REFERENCES garantie(id);


--
-- TOC entry 3053 (class 2606 OID 1828300)
-- Name: decision_editions fkevv5bdle9mdl7cjtvlsc02tlq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY decision_editions
    ADD CONSTRAINT fkevv5bdle9mdl7cjtvlsc02tlq FOREIGN KEY (decision_id) REFERENCES decision(id);


--
-- TOC entry 3051 (class 2606 OID 1828206)
-- Name: credit_decisions fkri189naejo5dh3k57hff88ss1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY credit_decisions
    ADD CONSTRAINT fkri189naejo5dh3k57hff88ss1 FOREIGN KEY (credit_id) REFERENCES credit(id);


--
-- TOC entry 3049 (class 2606 OID 1828325)
-- Name: decision fktcm6ob1p1phxvi8aysivfjgqe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY decision
    ADD CONSTRAINT fktcm6ob1p1phxvi8aysivfjgqe FOREIGN KEY (edition_id) REFERENCES edition(id);


-- Completed on 2020-06-21 00:46:21 CEST

--
-- PostgreSQL database dump complete
--

