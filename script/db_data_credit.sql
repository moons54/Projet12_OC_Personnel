--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2020-06-21 00:47:32 CEST

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
-- TOC entry 3181 (class 0 OID 1827644)
-- Dependencies: 202
-- Data for Name: credit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY credit (id, assurance, duree, montant, nature, objet, siret_client, status, echeance_emprunt, reference_dossier, taux, cout_global, decision_id) FROM stdin;
75	Couverture Décés et invalidité	134000	240	Pret Professionnel	Trésorerie	31144222100013	ok	671.5557858717002	Pro311799Tr	1.9	27173.38860920805	23
76	Couverture Décés et invalidité	432555	240	Pret Professionnel	Création	31144222100013	ok	2167.7971116248755	Pro311324Cr	1.9	87716.30678997014	24
\.


--
-- TOC entry 3186 (class 0 OID 1828196)
-- Dependencies: 207
-- Data for Name: credit_decisions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY credit_decisions (credit_id, decisions_id) FROM stdin;
\.


--
-- TOC entry 3179 (class 0 OID 1827565)
-- Dependencies: 200
-- Data for Name: credit_garantie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY credit_garantie (creditid, garantieid) FROM stdin;
1	2
1	3
\.


--
-- TOC entry 3183 (class 0 OID 1827655)
-- Dependencies: 204
-- Data for Name: decision; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY decision (id, commentaire, date_decision, statuts, edition_id) FROM stdin;
24	\N	\N	ajourné	\N
23	bon dossier en attente assurance	23/05/2020	accepté	13
\.


--
-- TOC entry 3187 (class 0 OID 1828290)
-- Dependencies: 208
-- Data for Name: decision_editions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY decision_editions (decision_id, editions_id) FROM stdin;
\.


--
-- TOC entry 3185 (class 0 OID 1827693)
-- Dependencies: 206
-- Data for Name: edition; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY edition (id, date_edition, statuts, commentaire, date_deblocage) FROM stdin;
10	\N	en attente d'edition	\N	\N
13	\N	en attente d'edition	\N	\N
\.


--
-- TOC entry 3178 (class 0 OID 1827559)
-- Dependencies: 199
-- Data for Name: garantie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY garantie (id, intitule_garantie, type_garantie) FROM stdin;
1	Hypotheque                                        	Sureté réelle                                     
2	Privilège preteur de denier                       	Sureté réelle                                     
3	Caution Personne physique                         	Caution                                           
4	Caution mutuelle                                  	Caution                                           
5	Gage                                              	Gage                                              
6	Nantissement sur Fdc                              	Sureté relle                                      
7	Blocage du compte courant                         	autres                                            
8	Nantissement sur instruments financiers           	autres                                            
\.


--
-- TOC entry 3176 (class 0 OID 1827551)
-- Dependencies: 197
-- Data for Name: statuts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY statuts (id, statuts) FROM stdin;
1	Dossier Accepté                                   
2	Dossier Ajournée                                  
3	Dossier Refusé                                    
4	Dossier en cours                                  
\.


--
-- TOC entry 3200 (class 0 OID 0)
-- Dependencies: 201
-- Name: credit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('credit_id_seq', 76, true);


--
-- TOC entry 3201 (class 0 OID 0)
-- Dependencies: 203
-- Name: decision_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('decision_id_seq1', 24, true);


--
-- TOC entry 3202 (class 0 OID 0)
-- Dependencies: 205
-- Name: edition_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('edition_id_seq', 13, true);


--
-- TOC entry 3203 (class 0 OID 0)
-- Dependencies: 198
-- Name: garantie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('garantie_id_seq', 8, true);


--
-- TOC entry 3204 (class 0 OID 0)
-- Dependencies: 196
-- Name: statuts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('statuts_id_seq', 4, true);


-- Completed on 2020-06-21 00:47:33 CEST

--
-- PostgreSQL database dump complete
--

