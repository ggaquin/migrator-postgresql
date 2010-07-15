--
-- PostgreSQL database dump
--

-- Started on 2010-07-14 23:19:41

SET client_encoding = 'WIN1252';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 330 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 253 (class 1247 OID 3194682)
-- Dependencies: 3
-- Name: apellido; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN apellido AS character varying(30);


ALTER DOMAIN public.apellido OWNER TO postgres;

--
-- TOC entry 1811 (class 0 OID 0)
-- Dependencies: 253
-- Name: DOMAIN apellido; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN apellido IS 'Apellidos';


--
-- TOC entry 254 (class 1247 OID 3194683)
-- Dependencies: 3
-- Name: cuota; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN cuota AS numeric(3,0);


ALTER DOMAIN public.cuota OWNER TO postgres;

--
-- TOC entry 1812 (class 0 OID 0)
-- Dependencies: 254
-- Name: DOMAIN cuota; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN cuota IS 'Campos de cuotas';


--
-- TOC entry 255 (class 1247 OID 3194684)
-- Dependencies: 3
-- Name: descripcion; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN descripcion AS character varying(25);


ALTER DOMAIN public.descripcion OWNER TO postgres;

--
-- TOC entry 1813 (class 0 OID 0)
-- Dependencies: 255
-- Name: DOMAIN descripcion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN descripcion IS 'Campo de descripcion ';


--
-- TOC entry 256 (class 1247 OID 3194685)
-- Dependencies: 3
-- Name: fecha; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN fecha AS date;


ALTER DOMAIN public.fecha OWNER TO postgres;

--
-- TOC entry 1814 (class 0 OID 0)
-- Dependencies: 256
-- Name: DOMAIN fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN fecha IS 'Fechas';


--
-- TOC entry 293 (class 1247 OID 3194686)
-- Dependencies: 3
-- Name: monto; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN monto AS numeric(20,2);


ALTER DOMAIN public.monto OWNER TO postgres;

--
-- TOC entry 1815 (class 0 OID 0)
-- Dependencies: 293
-- Name: DOMAIN monto; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN monto IS 'Campos de montos';


--
-- TOC entry 294 (class 1247 OID 3194687)
-- Dependencies: 3
-- Name: nombres; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN nombres AS character varying(30);


ALTER DOMAIN public.nombres OWNER TO postgres;

--
-- TOC entry 1816 (class 0 OID 0)
-- Dependencies: 294
-- Name: DOMAIN nombres; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN nombres IS 'Nombres';


--
-- TOC entry 295 (class 1247 OID 3194688)
-- Dependencies: 3
-- Name: nro_documento; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN nro_documento AS character varying(15);


ALTER DOMAIN public.nro_documento OWNER TO postgres;

--
-- TOC entry 1817 (class 0 OID 0)
-- Dependencies: 295
-- Name: DOMAIN nro_documento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN nro_documento IS 'Numero de documentos';


--
-- TOC entry 296 (class 1247 OID 3194689)
-- Dependencies: 3
-- Name: pk_id; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN pk_id AS character varying(10);


ALTER DOMAIN public.pk_id OWNER TO postgres;

--
-- TOC entry 1818 (class 0 OID 0)
-- Dependencies: 296
-- Name: DOMAIN pk_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON DOMAIN pk_id IS 'Dominio para todos los campos que son ID de tablas';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1502 (class 1259 OID 3194690)
-- Dependencies: 296 3 293
-- Name: aportes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE aportes (
    nro_socio pk_id,
    monto monto
);


ALTER TABLE public.aportes OWNER TO postgres;

--
-- TOC entry 1819 (class 0 OID 0)
-- Dependencies: 1502
-- Name: TABLE aportes; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE aportes IS 'Tabla con los montos de aportes de los socios';


--
-- TOC entry 1503 (class 1259 OID 3194696)
-- Dependencies: 296 296 3 293 256
-- Name: creditos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE creditos (
    nro_credito pk_id NOT NULL,
    nro_solicitud character(10),
    cod_tip_credito pk_id,
    fec_desmbolso fecha,
    mon_total monto
);


ALTER TABLE public.creditos OWNER TO postgres;

--
-- TOC entry 1820 (class 0 OID 0)
-- Dependencies: 1503
-- Name: TABLE creditos; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE creditos IS 'Detalle de los creditos desembolsados
';


--
-- TOC entry 1505 (class 1259 OID 3194712)
-- Dependencies: 296 296 254 254 3
-- Name: cuo_pagadas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cuo_pagadas (
    cod_pago pk_id,
    nro_cuota pk_id,
    mon_pagado character(10),
    nro_cuo_desde cuota,
    nro_cuo_hasta cuota
);


ALTER TABLE public.cuo_pagadas OWNER TO postgres;

--
-- TOC entry 1821 (class 0 OID 0)
-- Dependencies: 1505
-- Name: TABLE cuo_pagadas; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE cuo_pagadas IS 'Detalle de los pagos por cuotas 
';


--
-- TOC entry 1504 (class 1259 OID 3194704)
-- Dependencies: 254 296 293 256 293 3
-- Name: cuotas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cuotas (
    nro_cuota pk_id NOT NULL,
    can_cuota cuota,
    mon_cuota monto,
    fec_ult_cuo_pagada fecha,
    sal_cuota monto
);


ALTER TABLE public.cuotas OWNER TO postgres;

--
-- TOC entry 1822 (class 0 OID 0)
-- Dependencies: 1504
-- Name: TABLE cuotas; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE cuotas IS 'Tabla con las cuotas generadas por los creditos desembolsados a los socios';


--
-- TOC entry 1506 (class 1259 OID 3194718)
-- Dependencies: 3 296 296 296
-- Name: det_pagos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE det_pagos (
    cod_tip_pago pk_id,
    cod_pago pk_id,
    cod_pag_detalle pk_id NOT NULL
);


ALTER TABLE public.det_pagos OWNER TO postgres;

--
-- TOC entry 1823 (class 0 OID 0)
-- Dependencies: 1506
-- Name: TABLE det_pagos; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE det_pagos IS 'Detalle de los pagos realizados por los socion';


--
-- TOC entry 1507 (class 1259 OID 3194724)
-- Dependencies: 256 3 293 296 296 296
-- Name: pagos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pagos (
    cod_pago pk_id NOT NULL,
    nro_socio pk_id,
    nro_credito pk_id,
    fec_pago fecha,
    monto monto
);


ALTER TABLE public.pagos OWNER TO postgres;

--
-- TOC entry 1824 (class 0 OID 0)
-- Dependencies: 1507
-- Name: TABLE pagos; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE pagos IS 'Pagos realizados';


--
-- TOC entry 1508 (class 1259 OID 3194732)
-- Dependencies: 3 256 295 253 294 296 296
-- Name: socios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE socios (
    nro_socio pk_id NOT NULL,
    cod_tip_documento pk_id,
    nombres nombres,
    apellidos apellido,
    nro_documento nro_documento NOT NULL,
    fec_ingreso fecha
);


ALTER TABLE public.socios OWNER TO postgres;

--
-- TOC entry 1825 (class 0 OID 0)
-- Dependencies: 1508
-- Name: TABLE socios; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE socios IS 'Tabla de socios de la cooperativa
';


--
-- TOC entry 1509 (class 1259 OID 3194740)
-- Dependencies: 296 3
-- Name: solicitudes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE solicitudes (
    nro_socio pk_id,
    nro_solicitud character(10) NOT NULL,
    fec_solicitud character(10)
);


ALTER TABLE public.solicitudes OWNER TO postgres;

--
-- TOC entry 1826 (class 0 OID 0)
-- Dependencies: 1509
-- Name: TABLE solicitudes; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE solicitudes IS 'Detalle de las solicitudes de creditos';


--
-- TOC entry 1510 (class 1259 OID 3194748)
-- Dependencies: 255 293 296 3
-- Name: tip_creditos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tip_creditos (
    cod_tip_credito pk_id NOT NULL,
    descripcion descripcion,
    rel_aporte numeric(2,0) NOT NULL,
    max_monto monto
);


ALTER TABLE public.tip_creditos OWNER TO postgres;

--
-- TOC entry 1827 (class 0 OID 0)
-- Dependencies: 1510
-- Name: TABLE tip_creditos; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE tip_creditos IS 'Tabla con los tipos de creditos disponibles para los socios';


--
-- TOC entry 1511 (class 1259 OID 3194756)
-- Dependencies: 296 3 255
-- Name: tip_documento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tip_documento (
    cod_tip_documento pk_id NOT NULL,
    descripcion descripcion,
    abreviacion character varying(3) NOT NULL
);


ALTER TABLE public.tip_documento OWNER TO postgres;

--
-- TOC entry 1828 (class 0 OID 0)
-- Dependencies: 1511
-- Name: TABLE tip_documento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE tip_documento IS 'Tabla con los tipos de documentos para las personas';


--
-- TOC entry 1512 (class 1259 OID 3194764)
-- Dependencies: 255 3 296
-- Name: tip_pagos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tip_pagos (
    cod_tip_pago pk_id NOT NULL,
    descripcion descripcion
);


ALTER TABLE public.tip_pagos OWNER TO postgres;

--
-- TOC entry 1780 (class 2606 OID 3194703)
-- Dependencies: 1503 1503
-- Name: pk_creditos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY creditos
    ADD CONSTRAINT pk_creditos PRIMARY KEY (nro_credito);


--
-- TOC entry 1782 (class 2606 OID 3194711)
-- Dependencies: 1504 1504
-- Name: pk_cuotas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuotas
    ADD CONSTRAINT pk_cuotas PRIMARY KEY (nro_cuota);


--
-- TOC entry 1784 (class 2606 OID 3194731)
-- Dependencies: 1507 1507
-- Name: pk_pagos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT pk_pagos PRIMARY KEY (cod_pago);


--
-- TOC entry 1786 (class 2606 OID 3194739)
-- Dependencies: 1508 1508
-- Name: pk_socios; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY socios
    ADD CONSTRAINT pk_socios PRIMARY KEY (nro_socio);


--
-- TOC entry 1788 (class 2606 OID 3194747)
-- Dependencies: 1509 1509
-- Name: pk_solicitudes; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY solicitudes
    ADD CONSTRAINT pk_solicitudes PRIMARY KEY (nro_solicitud);


--
-- TOC entry 1790 (class 2606 OID 3194755)
-- Dependencies: 1510 1510
-- Name: pk_tip_creditos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tip_creditos
    ADD CONSTRAINT pk_tip_creditos PRIMARY KEY (cod_tip_credito);


--
-- TOC entry 1792 (class 2606 OID 3194763)
-- Dependencies: 1511 1511
-- Name: pk_tip_documento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tip_documento
    ADD CONSTRAINT pk_tip_documento PRIMARY KEY (cod_tip_documento);


--
-- TOC entry 1794 (class 2606 OID 3194771)
-- Dependencies: 1512 1512
-- Name: pk_tip_pagos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tip_pagos
    ADD CONSTRAINT pk_tip_pagos PRIMARY KEY (cod_tip_pago);


--
-- TOC entry 1795 (class 2606 OID 3194772)
-- Dependencies: 1508 1785 1502
-- Name: fk_aportes_reference_socios; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aportes
    ADD CONSTRAINT fk_aportes_reference_socios FOREIGN KEY (nro_socio) REFERENCES socios(nro_socio) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1796 (class 2606 OID 3194777)
-- Dependencies: 1787 1503 1509
-- Name: fk_creditos_reference_solicitu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY creditos
    ADD CONSTRAINT fk_creditos_reference_solicitu FOREIGN KEY (nro_solicitud) REFERENCES solicitudes(nro_solicitud) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1797 (class 2606 OID 3194782)
-- Dependencies: 1789 1510 1503
-- Name: fk_creditos_reference_tip_cred; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY creditos
    ADD CONSTRAINT fk_creditos_reference_tip_cred FOREIGN KEY (cod_tip_credito) REFERENCES tip_creditos(cod_tip_credito) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1799 (class 2606 OID 3194792)
-- Dependencies: 1781 1505 1504
-- Name: fk_cuo_paga_reference_cuotas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuo_pagadas
    ADD CONSTRAINT fk_cuo_paga_reference_cuotas FOREIGN KEY (nro_cuota) REFERENCES cuotas(nro_cuota) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1798 (class 2606 OID 3194787)
-- Dependencies: 1783 1505 1507
-- Name: fk_cuo_paga_reference_pagos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuo_pagadas
    ADD CONSTRAINT fk_cuo_paga_reference_pagos FOREIGN KEY (cod_pago) REFERENCES pagos(cod_pago) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1801 (class 2606 OID 3194802)
-- Dependencies: 1783 1506 1507
-- Name: fk_det_pago_reference_pagos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY det_pagos
    ADD CONSTRAINT fk_det_pago_reference_pagos FOREIGN KEY (cod_pago) REFERENCES pagos(cod_pago) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1800 (class 2606 OID 3194797)
-- Dependencies: 1793 1506 1512
-- Name: fk_det_pago_reference_tip_pago; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY det_pagos
    ADD CONSTRAINT fk_det_pago_reference_tip_pago FOREIGN KEY (cod_tip_pago) REFERENCES tip_pagos(cod_tip_pago) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1802 (class 2606 OID 3194807)
-- Dependencies: 1779 1507 1503
-- Name: fk_pagos_reference_creditos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT fk_pagos_reference_creditos FOREIGN KEY (nro_credito) REFERENCES creditos(nro_credito) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1803 (class 2606 OID 3194812)
-- Dependencies: 1507 1508 1785
-- Name: fk_pagos_reference_socios; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT fk_pagos_reference_socios FOREIGN KEY (nro_socio) REFERENCES socios(nro_socio) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1804 (class 2606 OID 3194817)
-- Dependencies: 1791 1511 1508
-- Name: fk_socios_reference_tip_docu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY socios
    ADD CONSTRAINT fk_socios_reference_tip_docu FOREIGN KEY (cod_tip_documento) REFERENCES tip_documento(cod_tip_documento) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1805 (class 2606 OID 3194822)
-- Dependencies: 1509 1785 1508
-- Name: fk_solicitu_reference_socios; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitudes
    ADD CONSTRAINT fk_solicitu_reference_socios FOREIGN KEY (nro_socio) REFERENCES socios(nro_socio) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1810 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-07-14 23:19:41

--
-- PostgreSQL database dump complete
--

