package br.com.afonso.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotNull
    private String name;

    @NotNull
    private String document;

    @NotNull
    private String username;

    @NotNull
    private String password;


}
