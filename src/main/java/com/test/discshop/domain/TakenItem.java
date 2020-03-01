package com.test.discshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "taken_item")
public class TakenItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "disk_id")
    private Disk disk;

    public TakenItem() {
    }

    public TakenItem(User user, Disk disk) {
        this.user = user;
        this.disk = disk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }    
}