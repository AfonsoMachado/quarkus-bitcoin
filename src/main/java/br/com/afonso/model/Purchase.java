package br.com.afonso.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchase")
public class Purchase extends BaseEntity {

    @Column(name = "price")
    private Double price;

    @Column(name = "order_type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "user_id")
    private Long userId;
}
