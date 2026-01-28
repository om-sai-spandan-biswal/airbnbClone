package com.codingshuttle.projects.airbnbClone.entity;


import com.codingshuttle.projects.airbnbClone.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.EmbeddedTable;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private String city ;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "TEXT[]")
    private List<String>  photos ;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "TEXT[]")
    private List<String> amenities ;

    @Column(nullable = false)
    private Boolean active ;

    @Embedded
    private HotelContactInfo hotelContactInfo ;

    @CreationTimestamp
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    private LocalDateTime updatedAt ;
}
