package com.uaz.apirest.gestor.transformers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.uaz.apirest.gestor.loaders.AlumnoLoader;
import com.uaz.apirest.nodes.Alumno.*;

@Service
public class CSVTransformer {
    
    @Autowired
    private AlumnoRepository alumnoRepository;

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

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(tempFile))
                .withSkipLines(1)  // Skip header row
                .build()) {
            String[] nextLine;
            List<Alumno> alumnos = new ArrayList<>();

            while ((nextLine = csvReader.readNext()) != null) {
                Alumno alumno = new Alumno(
                    nextLine[0],  // matricula
                    nextLine[1],  // nombres
                    nextLine[2],  // apellido1
                    nextLine[3],  // apellido2
                    LocalDate.parse(nextLine[4]),  // generacion
                    null,  // graduacion
                    null          // titulo
                );
                alumnos.add(alumno);
            }

            saveNodes(alumnos);
        }
    }
    public void saveNodes(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            alumnoRepository.save(alumno);
        }
    }
}
