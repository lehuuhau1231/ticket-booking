package com.lhh.ticket_booking.infrastructure.persistence.entity;

import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class EventJpaEntity extends BaseJpaEntity {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityJpaEntity city;

    @OneToMany(mappedBy = "event")
    private List<ShowtimeJpaEntity> showtimeJpaEntities;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "poster_url", length = 500)
    private String posterUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 30)
    private EventCategory category;

    @Column(name = "location_name", length = 255)
    private String locationName;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private EventStatus status = EventStatus.UPCOMING;
}
