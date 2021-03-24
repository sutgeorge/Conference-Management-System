package com.CMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "Proposal")
public class Proposal {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "PaperID")
    private Paper paper;

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Column(name = "Status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Proposal(Long id, Paper paper, String status) {
        this.id = id;
        this.paper = paper;
        this.status = status;
    }
}
