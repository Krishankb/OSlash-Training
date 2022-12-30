package org.example;
//import software.amazon.*;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

import javax.annotation.processing.Generated;
import java.io.File;

@Generated("software.amazon.awssdk:codegen")
public final class CreateMultipartUploadRequest {
    //ClientConfiguration client = AmazonS3Client.builder().getClientConfiguration();
    AmazonS3 amazonS3 = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new DefaultAWSCredentialsProviderChain())
            .withRegion(Regions.DEFAULT_REGION)
            .build();
    TransferManager tm = TransferManagerBuilder.standard()
            .withS3Client(amazonS3)
            .withMultipartUploadThreshold((long) (1*1024*1024*1024))
            .build();

    String bucketName = "Bucket-building";
    String keyName = "S3upload.jpg";
    File file  = new File("S3upload.jpg");
    Upload upload = tm.upload(bucketName,keyName, file);




}
