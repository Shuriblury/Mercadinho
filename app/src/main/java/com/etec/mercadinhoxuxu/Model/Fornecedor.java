package com.etec.mercadinhoxuxu.Model;

public class Fornecedor {
    /*
CNPJ
Nome fantasia
Razão Social
Telefone 1
Telefone 2
Endereço
*/



  //construtor
  public Fornecedor(int id, String cnpj, String nome_fantasia, String razao_social, String telefone_1, String telefone_2, String endereco) {
    this.id = id;
    this.cnpj = cnpj;
    this.nome_fantasia = nome_fantasia;
    this.razao_social = razao_social;
    this.telefone_1 = telefone_1;
    this.telefone_2 = telefone_2;
    this.endereco = endereco;
  }

  public Fornecedor() {
  }

  private int id;
  private String cnpj;
  private String nome_fantasia;
  private String razao_social;
  private String telefone_1;
  private String telefone_2;
  private String endereco;




  //getter e setter

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getNome_fantasia() {
    return nome_fantasia;
  }

  public void setNome_fantasia(String nome_fantasia) {
    this.nome_fantasia = nome_fantasia;
  }

  public String getRazao_social() {
    return razao_social;
  }

  public void setRazao_social(String razao_social) {
    this.razao_social = razao_social;
  }

  public String getTelefone_1() {
    return telefone_1;
  }

  public void setTelefone_1(String telefone_1) {
    this.telefone_1 = telefone_1;
  }

  public String getTelefone_2() {
    return telefone_2;
  }

  public void setTelefone_2(String telefone_2) {
    this.telefone_2 = telefone_2;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }


}
