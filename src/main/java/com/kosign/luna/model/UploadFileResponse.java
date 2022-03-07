package com.kosign.luna.model;

public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileView;
    private String fileType;
    private long size;


    public UploadFileResponse() {
    }

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileView, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileView = fileView;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return this.fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileView() {
        return this.fileView;
    }

    public void setFileView(String fileView) {
        this.fileView = fileView;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public UploadFileResponse fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

    public UploadFileResponse fileDownloadUri(String fileDownloadUri) {
        setFileDownloadUri(fileDownloadUri);
        return this;
    }

    public UploadFileResponse fileView(String fileView) {
        setFileView(fileView);
        return this;
    }

    public UploadFileResponse fileType(String fileType) {
        setFileType(fileType);
        return this;
    }

    public UploadFileResponse size(long size) {
        setSize(size);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " fileName='" + getFileName() + "'" +
            ", fileDownloadUri='" + getFileDownloadUri() + "'" +
            ", fileView='" + getFileView() + "'" +
            ", fileType='" + getFileType() + "'" +
            ", size='" + getSize() + "'" +
            "}";
    }
    
}