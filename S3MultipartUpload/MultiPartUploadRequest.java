package org.example;


import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;


@Log4j2
public class MultiPartUploadRequest {

    private final ThreadPoolExecutor executorService;
    private static final int DEFAULT_THREAD_COUNT = 4;
    private final String destBucketName;
    private final String filename;

    private final AmazonS3 s3Client;

    private final AtomicInteger uploadPartId = new AtomicInteger(0);

    private String uploadId;

    public MultiPartUploadRequest(String destBucketName, String filename, AmazonS3 s3Client) {
        this.executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(DEFAULT_THREAD_COUNT);
        this.destBucketName = destBucketName;
        this.filename = filename;
        this.s3Client = s3Client;
    }

    public boolean initiateUpload() {
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(destBucketName, filename);
        initRequest.setTagging(getObjectTagging());

        uploadId = s3Client.initiateMultipartUpload(initRequest).getUploadId();

        return false;
    }

    private ObjectTagging getObjectTagging() {
        return new ObjectTagging(new ArrayList<>());
    }

    public void uploadPartAsync(ByteArrayInputStream inputStream) {
        submitTaskForUploading(inputStream, false);
    }

    private void submitTaskForUploading(ByteArrayInputStream inputStream, boolean isFinalPart) {
        int eachPartId = uploadPartId.incrementAndGet();
        UploadPartRequest uploadRequest = new UploadPartRequest()
                .withBucketName(destBucketName)
                .withKey(filename)
                .withUploadId(uploadId)
                .withPartNumber(eachPartId)
                .withPartSize(inputStream.available())
                .withInputStream(inputStream);

        Create


        if (isFinalPart) {
            uploadRequest.withLastPart(true);
        }
    }

    public static void main(String[] args) {
        final int UPLOAD_PART_SIZE = 10 * Constants.MB;
        final String destBucketName = "_destination_bucket_name_";
        final String filename = "_filename_";

        AmazonS3 amazonS3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(Regions.DEFAULT_REGION)
                .build();




    }

}
