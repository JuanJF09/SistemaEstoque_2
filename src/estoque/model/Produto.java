/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque.model;

/*clase normal que apresenta os produtos do codigo
nada fora do normal codigo simples */

public class Produto {
    private int id;
    private String Nome;
    private double Preco;
    private int Quantidade;
    private double PrecoCusto;
    private String Material;
    private String Categoria;
    private String Descricao;

    public Produto(String Nome, int id, double Preco, double PrecoCusto, String Material, String Categoria, String Descricao) {
        this.id = id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Quantidade = Quantidade;
        this.PrecoCusto = PrecoCusto;
        this.Material = Material;
        this.Categoria = Categoria;
        this.Descricao = Descricao;
        
    }

    public Produto() {}

    public Produto(int novoId, String nome, int quantidade, double precoCusto, double preco, String material, String categoria, String descricao) {
       this.id = novoId;
       this.Nome = nome;
       this.Preco = preco;
       this.Quantidade = quantidade;
       this.PrecoCusto = precoCusto;
       this.Material = material;
       this.Categoria = categoria;
       this.Descricao = descricao;
       
    }

    // Id
    public int getId() 
    { return id; }
    public void setId(int id) 
    { this.id = id; }
    
    // Nome
    public String getNome() 
    { return Nome; }
    public void setNome(String Nome) 
    { this.Nome = Nome; }
    
    //Preco
    public double getPreco() 
    { return Preco; }
    public void setPreco(double Preco) 
    { this.Preco = Preco; }
    
    //Quantidade
    public int getQuantidade() 
    { return Quantidade; }
    public void setQuantidade(int Quantidade) 
    { this.Quantidade = Quantidade; }

    //Preco de custo
    public double getPrecoCusto() 
    { return PrecoCusto; }
    public void setPrecoCusto(double PrecoCusto) 
    { this.PrecoCusto = PrecoCusto; }
    
    //Material
    public String getMaterial() 
    { return Material; }
    public void setMaterial(String Material) 
    { this.Material = Material; }
    
    //Categoria
    public String getCategoria() 
    { return Categoria; }
    public void setCategoria(String Categoria) 
    { this.Categoria = Categoria; }
    
    //Descricao
    public String getDescricao() 
    { return Descricao; }
    public void setDescricao(String Descricao) 
    { this.Descricao = Descricao; }
    

    
}