package br.com.afonso.purchase.model;

import br.com.afonso.util.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

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
