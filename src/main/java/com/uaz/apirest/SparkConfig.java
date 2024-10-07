package com.uaz.apirest;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.hadoop.yarn.api.ApplicationConstants.Environment;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

@Configuration
public class SparkConfig {
    @Autowired
    private Environment env;

    @Value("${app.name:jigsaw}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri:local}")
    private String masterUri;
    
    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setSparkHome(sparkHome)
                .setMaster(masterUri)
                ;
         
        return sparkConf;
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }
   
    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder()
                .sparkContext(javaSparkContext().sc())
                .appName("apirest")
                .getOrCreate();
    }
}
