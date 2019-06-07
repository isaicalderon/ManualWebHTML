create or replace PACKAGE CAPACITACION AS 

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
    PROCEDURE "PRO_GET_ALL_ALUMNOS" (vAlum OUT SYS_REFCURSOR);
    
    PROCEDURE "PRO_GET_ALUMNO" (vAlum OUT SYS_REFCURSOR, pMatricula IN ALUMNOS.MATRICULA%TYPE);
    
    PROCEDURE "PRO_EDIT_ALUMNO"(
            pMatricula in ALUMNOS.MATRICULA%TYPE,
            pNombres IN ALUMNOS.NOMBRES%TYPE,
            pApellidoPaterno IN ALUMNOS.APELLIDOPATERNO%TYPE,
            pApellidoMaterno IN ALUMNOS.APELLIDOMATERNO%TYPE,
            pModificadoPor IN ALUMNOS.MODIFICADOPOR%TYPE
    );
    PROCEDURE "PRO_DEL_ALUMNO" (pMatricula IN ALUMNOS.MATRICULA%TYPE) ;
    
    FUNCTION "FUN_ADD_ALUMNO" (
        pNombres in ALUMNOS.NOMBRES%TYPE,
        pApellidoPaterno in ALUMNOS.APELLIDOPATERNO%TYPE,
        pApellidoMaterno in ALUMNOS.APELLIDOMATERNO%TYPE,
        pCreadoPor in ALUMNOS.CREADOPOR%TYPE
    )RETURN NUMBER;
    
    FUNCTION FUN_GET_NEXT_MATRICULA RETURN NUMBER;
    
    
END CAPACITACION;