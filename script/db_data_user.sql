--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2020-06-21 00:48:34 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 3130 (class 0 OID 1829911)
-- Dependencies: 197
-- Data for Name: app_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY app_role (id, role_name) FROM stdin;
1	ADMIN
2	USER
\.


--
-- TOC entry 3132 (class 0 OID 1829919)
-- Dependencies: 199
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY app_user (id, actived, adresse, code_postal, email, nom, password, prenom, siret_client, societe, telephone, username, ville) FROM stdin;
1	t	rue des tilleuils	95000	paulson.rob@gmail.com	paulson	$2a$10$7Vg1GUzIlcbgBxKf0GQ9xeXX0uoqERT.7kiNgeAyXSWV.hvQnQAPW	robert	543456143	myfrabriq	0645361155	admin	paris
2	t	14 rue des bosquet	95000	gilet.er@gmail.com	gilevitch	$2a$10$2ngR4u5FQqNqTD1NS6h56.bu42GoY0VvTp94/DXQk2oGWuYflGaj2	eric	31144222100013	Brasserie OPEN ROOM	0645361534	barroom	paris
\.


--
-- TOC entry 3133 (class 0 OID 1829928)
-- Dependencies: 200
-- Data for Name: app_user_app_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY app_user_app_roles (app_user_id, app_roles_id) FROM stdin;
1	2
1	1
2	2
\.


--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 196
-- Name: app_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('app_role_id_seq', 2, true);


--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 198
-- Name: app_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('app_user_id_seq', 2, true);


-- Completed on 2020-06-21 00:48:34 CEST

--
-- PostgreSQL database dump complete
--

