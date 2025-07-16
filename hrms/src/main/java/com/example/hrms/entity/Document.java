package com.example.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "document")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    @Id
    private String docNo;

    private String docName;
    private String docForm;

    @Lob
    private String docContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_wrtier")
    private Employee docWriter;

    private LocalDateTime docDate;
}
