package com.example.studyservice.exception;

public class StudyNotFoundException extends RuntimeException {
    public StudyNotFoundException(Long id) {
        super("Study not found with id: " + id);
    }
}
