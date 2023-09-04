package br.com.afonso.purchase.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePurchaseDto {

    @NotNull
    private Double price;

    @NotNull
    private String type;

    @NotNull
    private Long userId;
}
