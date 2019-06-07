create or replace PACKAGE BODY CAPACITACION AS

    -- PRO_GET_ALL_ALUMNOS
    PROCEDURE "PRO_GET_ALL_ALUMNOS" (vAlum OUT SYS_REFCURSOR) IS
    BEGIN
        OPEN vAlum FOR
            SELECT ALU.* FROM ALUMNOS ALU;
    END;
    
    -- PRO_GET_ALUMNO
    PROCEDURE "PRO_GET_ALUMNO" (vAlum OUT SYS_REFCURSOR, pMatricula IN ALUMNOS.MATRICULA%TYPE) IS
    BEGIN
        OPEN vAlum FOR
        SELECT ALU.* FROM ALUMNOS ALU where ALU.MATRICULA = pMatricula;
    END;  
    
    -- PRO_EDIT_ALUMNO
    --Actualiza un registro en la tabla ALUMNOS.  
    PROCEDURE "PRO_EDIT_ALUMNO"(
            pMatricula in ALUMNOS.MATRICULA%TYPE,
            pNombres IN ALUMNOS.NOMBRES%TYPE,
            pApellidoPaterno IN ALUMNOS.APELLIDOPATERNO%TYPE,
            pApellidoMaterno IN ALUMNOS.APELLIDOMATERNO%TYPE,
            pModificadoPor IN ALUMNOS.MODIFICADOPOR%TYPE
    ) IS
    BEGIN
        UPDATE ALUMNOS SET 
            NOMBRES               = pNombres, 
            APELLIDOPATERNO       = pApellidoPaterno, 
            APELLIDOMATERNO       = pApellidoMaterno, 
            MODIFICADOPOR         = pModificadoPor, 
            FECHAHORAMODIFICACION = sysdate
        WHERE MATRICULA = pMatricula;
    END;
    
    -- PRO_DEL_ALUMNO
    -- Elimina un registro en la tabla ALUMNOS.   
    PROCEDURE "PRO_DEL_ALUMNO" (pMatricula IN ALUMNOS.MATRICULA%TYPE) IS
    BEGIN
        DELETE FROM ALUMNOS WHERE MATRICULA = pMatricula;
    END;
    
    FUNCTION "FUN_ADD_ALUMNO" (
        pNombres in ALUMNOS.NOMBRES%TYPE,
        pApellidoPaterno in ALUMNOS.APELLIDOPATERNO%TYPE,
        pApellidoMaterno in ALUMNOS.APELLIDOMATERNO%TYPE,
        pCreadoPor in ALUMNOS.CREADOPOR%TYPE
    )  RETURN NUMBER IS vMatricula NUMBER;
    
    --FUN_ADD_ALUMNO
    --Agrega un registro en la tabla ALUMNOS.   
    --Regresa la matricula insertada.
    BEGIN
    
        vMatricula := FUN_GET_NEXT_MATRICULA;
        /*
        SELECT MATRICULA into vMatricula FROM ALUMNOS WHERE rownum = 1
            ORDER BY FECHAHORACAPTURA DESC;
            
        vMatricula := vMatricula + 1;
        */
        INSERT INTO ALUMNOS(MATRICULA, NOMBRES, APELLIDOPATERNO, APELLIDOMATERNO, ACTIVO, CREADOPOR, FECHAHORACAPTURA, FECHAHORAMODIFICACION) 
            VALUES(vMatricula, pNombres, pApellidoPaterno, pApellidoMaterno, 'Si', pCreadoPor, SYSDATE, SYSDATE);
    RETURN vMatricula;
    END;
    
    
    FUNCTION FUN_GET_NEXT_MATRICULA RETURN NUMBER IS
        vMatricula NUMBER(8);
    BEGIN
        SELECT COALESCE(MAX(MATRICULA),0)+1 INTO vMatricula
            FROM ALUMNOS;
        RETURN vMatricula;
    END;
        
        
    
    
END CAPACITACION;