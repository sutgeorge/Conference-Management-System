package com.imps.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "Bid")
public class Bid {

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
    @JoinColumn(name = "ProposalID")
    private Proposal proposal;

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "bidStatus")
    @Enumerated(EnumType.STRING)
    private BidStatus bidStatus;

    public BidStatus getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }

    public Bid() {

    }

    public Bid(Proposal proposal, User user, BidStatus bidStatus)
    {
        this.proposal = proposal;
        this.user = user;
        this.bidStatus = bidStatus;
    }
}
