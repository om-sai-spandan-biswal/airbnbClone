package com.codingshuttle.projects.airbnbClone.entity;

import com.codingshuttle.projects.airbnbClone.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user ;

    @Column(nullable = false)
    private Long name ;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender ;

    @CreationTimestamp
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    private LocalDateTime updatedAt ;
}
