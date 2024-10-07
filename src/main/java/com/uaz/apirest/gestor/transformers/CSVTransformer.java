package com.uaz.apirest.gestor.transformers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.uaz.apirest.gestor.loaders.AlumnoLoader;
import com.uaz.apirest.nodes.Alumno.Alumno;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Service
public class CSVTransformer {
    @Autowired
    private SparkSession sparkSession;
    @Autowired
    AlumnoLoader loader;

    public void runEtlPipeline(MultipartFile file) throws Exception {
         File tempFile = File.createTempFile("upload", ".csv");
        
        try (InputStream inputStream = file.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        // Load CSV into a Spark DataFrame from InputStream
        Dataset<Row> csvData = sparkSession.read()
                .format("csv")
                .option("header", "true")
                .option("inferSchema", "true")
                .load(tempFile.getAbsolutePath());

        csvData.show();

        List<Alumno> alumnos = csvData.collectAsList().stream()
                .map(row -> new Alumno(row.getAs("matricula"), 
                row.getAs("nombres"),
                row.getAs("apellido1"),
                row.getAs("apellido2"),
                row.getAs("generacion"),
                row.getAs("graduacion"),
                null
                //row.getAs("titulo")                
                )).collect(Collectors.toList());
        loader.saveNodes(alumnos);
        }
}
