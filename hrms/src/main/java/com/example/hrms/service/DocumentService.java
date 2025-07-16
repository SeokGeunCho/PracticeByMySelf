package com.example.hrms.service;

import com.example.hrms.entity.Document;
import com.example.hrms.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    public Optional<Document> findById(String docNo) {
        return documentRepository.findById(docNo);
    }

    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public void delete(String docNo) {
        documentRepository.deleteById(docNo);
    }
}
