package com.uaz.apirest.Graduacion;

import java.sql.Date;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
@Node
public class Graduacion {
    @Id private Date fecha_graduacion;
    @Id private int matricula;

}
