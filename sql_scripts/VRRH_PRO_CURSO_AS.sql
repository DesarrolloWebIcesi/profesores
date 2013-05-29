DROP MATERIALIZED VIEW PSISRHP.VRRH_PRO_CURSO_AS;
CREATE MATERIALIZED VIEW PSISRHP.VRRH_PRO_CURSO_AS (SISTEMA,PERIODO_ACAD,PERIODO_CONSECUTIVO,MATERIA_CODIGO,GRUPO,NOMBRE_MATERIA,PROFESOR_CEDULA,PROGRAMA_POST,DEPTO_ACAD_PRE,NUM_MATRICULADOS,HORAS_MATERIA,HORAS_DICTADAS,HORAS_ADICIONALES,CREDITOS,ACTIVIDAD,MAT_N_ENG)
TABLESPACE TABLAS_DELFI
PCTUSED    0
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          640K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOCACHE
LOGGING
NOCOMPRESS
NOPARALLEL
BUILD IMMEDIATE
REFRESH COMPLETE ON DEMAND
WITH PRIMARY KEY
AS 
/* Formatted on 23/05/2013 09:46:59 a.m. (QP5 v5.240.12305.39476) */
select 'POS' sistema, profec.periodo_acad, 0 periodo_consecutivo, profec.cod_materia materia_codigo, profec.grupo,
       fposbus_nombre_mat (profec.cod_materia, 'E') nombre_materia, profec.ced_profesor profesor_cedula,
       prog.programa_responsable programa_post, ' ' depto_acad_pre,
       fposcal_num_matriculados (profec.periodo_acad, profec.cod_materia, profec.grupo) num_matriculados,
       mate.numero_horas horas_materia,
       fposbus_horasprof (profec.periodo_acad, profec.ced_profesor, profec.cod_materia, profec.grupo, 'T') horas_dictadas,
       fposbus_horasprof (profec.periodo_acad, profec.ced_profesor, profec.cod_materia, profec.grupo, 'A') horas_adicionales,
       mate.numero_creditos creditos, prog.actividad, mate.nombre_ingles mat_n_eng
  from profesor_curso profec, programacion prog, materia mate
where profec.cod_materia = prog.codigo_mat
   and mate.codigo = profec.cod_materia
   and profec.ced_profesor not like '00000%'
union
select 'PRE' sistema, tbases.periodo_periodo_acad periodo_acad, tbases.periodo_consecutivo, ' ' materia_codigo, 0 grupo,
       fprebus_descrip_mat ('', '01151', '03', '') nombre_materia, tbases.profesor_cedula profesor_cedula, ' ' programa_post,
       fprebus_materias ('01151', '04', '') depto_acad_pre,
       fprecal_estxas (tbases.periodo_periodo_acad, tbases.profesor_cedula) num_matriculados, 0 horas_materia, 0 horas_dictadas,
       0 horas_adicionales, 0 creditos, ' ' actividad, fprebus_descrip_mat ('', '01151', '09', '') mat_n_eng
  from tbas_asesor_contr tbases
where profesor_cedula not like '00000%';
 
 
COMMENT ON MATERIALIZED VIEW PSISRHP.VRRH_PRO_CURSO_AS IS 'snapshot table for snapshot SISRHP.VRRH_PRO_CURSO_AS';
 
CREATE OR REPLACE SYNONYM PDELFI.VRRH_PRO_CURSO_AS FOR PSISRHP.VRRH_PRO_CURSO_AS;
 
CREATE OR REPLACE SYNONYM CONSULTAHVPROF.VRRH_PRO_CURSO_AS FOR PSISRHP.VRRH_PRO_CURSO_AS;
 
GRANT SELECT ON PSISRHP.VRRH_PRO_CURSO_AS TO CONSULTAHVPROF;
