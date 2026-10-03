class Ingrediente(
    val nome: String,
    val preco: Double
)

class Pizza(
    val sabor: String,
    val tamanho: Int,
    val bordaRecheada: String?
)

class PedidoPizzaria(
    val pizza: Pizza,
    val ingredientes: List<Ingrediente>,
    val tercaFeira: Boolean
) {

    fun calcularTotal(): Double {

        var preco = 0.0

        // Escolha do tamanho
        when (pizza.tamanho) {
            1 -> preco = 35.0
            2 -> preco = 50.0
            3 -> preco = 65.0
        }

        // Soma os ingredientes
        for (ingrediente in ingredientes) {
            preco = preco + ingrediente.preco
        }

        // Borda recheada
        if (pizza.bordaRecheada != null) {
            preco = preco + 9.0
        }

        // Promoção de terça-feira
        if (tercaFeira) {
            preco = preco * 0.90
        } else {
            preco = preco
        }

        return preco
    }

    fun mostrarPedido() {

        println("===== PIZZARIA ARTESANAL =====")
        println("Sabor: ${pizza.sabor}")

        when (pizza.tamanho) {
            1 -> println("Tamanho: Pequena")
            2 -> println("Tamanho: Média")
            3 -> println("Tamanho: Grande")
        }

        println("Ingredientes:")

        for (ingrediente in ingredientes) {
            println("- ${ingrediente.nome}: R$ ${ingrediente.preco}")
        }

        if (pizza.bordaRecheada != null) {
            println("Borda recheada: ${pizza.bordaRecheada}")
            println("Valor da borda: R$ 9.00")
        } else {
            println("Sem borda recheada")
        }

        if (tercaFeira) {
            println("Promoção: 10% de desconto")
        } else {
            println("Sem promoção")
        }

        println("Total: R$ ${calcularTotal()}")
    }
}

fun main() {

    val ingrediente1 = Ingrediente("Bacon", 5.0)
    val ingrediente2 = Ingrediente("Catupiry", 6.0)

    val ingredientes = listOf(
        ingrediente1,
        ingrediente2
    )

    val pizza = Pizza(
        "Frango com Catupiry",
        3,
        "Cheddar"
    )

    val pedido = PedidoPizzaria(
        pizza,
        ingredientes,
        true
    )

    pedido.mostrarPedido()
}