package com.hangarapi.hangarapi.model;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

  @Entity
  @Table(name = "tb_hangar")

  public class Carro implements Serializable {
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private String ano;

    public Carro() {
    }

    public Carro(String vin, String placa, String modelo, String marca, String Ano) {
        this.vin = vin;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

      public String getModelo() {
          return modelo;
      }

      public void setModelo(String modelo) {
          this.modelo = modelo;
      }

      public String getMarca() {
          return marca;
      }

      public void setMarca(String marca) {
          this.marca = marca;
      }

      public String getAno() {
          return ano;
      }

      public void setAno(String ano) {
          this.ano = ano;
      }

      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(vin, carro.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

      @Override
      public String toString() {
          return "Carro{" +
                  "vin='" + vin + '\'' +
                  ", placa='" + placa + '\'' +
                  ", modelo='" + modelo + '\'' +
                  ", marca='" + marca + '\'' +
                  ", ano=" + ano +
                  '}';
      }

  }

