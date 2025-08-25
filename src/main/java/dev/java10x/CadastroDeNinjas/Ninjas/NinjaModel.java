package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//Entity= Transforma uma classe em uma entidade para o BD
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "img_url")
        private String imgUrl;

        @Column(unique = true)
        private String email;

        @Column(name = "idade")
        private int idade;

        //@ManyToOne - Um ninja pode ter varias missões
        @ManyToOne
        @JoinColumn(name = "missoes_id")
        private MissoesModel missoes;
}