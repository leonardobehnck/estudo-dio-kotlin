import java.math.BigDecimal

//Classe produto para criação dos itens
class Produto (val nome: String, val preco: Double) {
  //Função para retornar o nome do produto no print
  override fun toString(): String {
    return nome
  }
}

//Classe para criação do cliente
class Cliente (val nome: String, val cpf: String)

//Classe para criação do pedido
class Pedido(val cliente: Cliente) {
  private val listaDeProdutos = mutableListOf<ItemPedido>()
  //Variavel para encapsular a lista de produtos original
  val itens
    get() = listaDeProdutos.toMutableList()

  //Função para adicionar o produto a variavel original
  fun adicionarProduto(itemPedido: ItemPedido) {
    listaDeProdutos.add(itemPedido)
  }
}

//Classe para criar função padrão para trocar double pelo BigDecimal
class ProdutoFactory {
  companion object {
    fun create(nome: String, preco: Double): Produto {
    return Produto(nome, preco//.toBigDecimal()
    )
    }
  }  
}

//Classe de dados
data class ItemPedido (val produto: Produto, var quantidade: Int = 0)




fun main() {

  //Criar os produtos
  val arroz = ProdutoFactory.create("Arroz", 9.99)
  val feijao = ProdutoFactory.create("Feijão", 5.90)
  val leite = ProdutoFactory.create("Leite", 4.99)

  //Criar o usuário
  val joao = Cliente(nome = "João", cpf = "999.999.999-99")
  
  //Criar o pedido
  val pedido = Pedido(joao)
  
  //Criar os pedidos
  val itemPedidoArroz = ItemPedido(arroz, quantidade = 1)
  val itemPedidoFeijao = ItemPedido(feijao, quantidade = 2)
  val itemPedidoLeite = ItemPedido(leite, quantidade = 3)

  //Adicionar o pedido
  pedido.adicionarProduto(itemPedidoArroz)
  pedido.adicionarProduto(itemPedidoFeijao)
  pedido.adicionarProduto(itemPedidoLeite)


  pedido.itens.forEach { item -> println(item.produto.nome) }
}

