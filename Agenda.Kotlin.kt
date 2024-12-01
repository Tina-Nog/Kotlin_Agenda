class PessoaAltura(val nome: String, val altura: Double)
class Pessoa(val nome: String, val endereco: String, val telefone: String)
class Aluno(val nome: String, val notas: List<Double>) {
    val media: Double =notas.average() // Calcula a média das notas
    val situacao: String = if (media >= 5) "Aprovado" else "Reprovado"
}




class Cadastro {

    private val registrosPessoas = mutableListOf<Pessoa>()
    private val registrosAlunos = mutableListOf<Aluno>()
    private val registrosAltura = mutableListOf<PessoaAltura>()

    fun inicio() {
        while (true) {
            println("\nMenu:")
            println("1. Cadastro de Pessoas (Nome, Endereço e Telefone)")
            println("2. Cadastro de Alunos (Notas e Situação)")
            println("3. Cadastro de Pessoas com Altura")
            println("4. Sair")
            val opcao = readLine()?.toIntOrNull() ?: 0

            when (opcao) {
                1 -> cadastroPessoas()
                2 -> cadastroAlunos()
                3 -> cadastroAltura()
                4 -> {
                    println("Saindo do programa...")
                    return
                }

                else -> println("Opção inválida! Tente novamente.")
            }
        }
    }
    fun cadastroPessoas() {
        if (registrosPessoas.size < 10) {
            println("Digite o nome da pessoa:")
            val nome = readLine() ?: ""
            println("Digite o endereço da pessoa:")
            val endereco = readLine() ?: ""
            println("Digite o telefone da pessoa:")
            val telefone = readLine() ?: ""
            registrosPessoas.add(Pessoa(nome, endereco, telefone))
            println("$nome cadastrado com sucesso!")
        } else {
            println("Já foram cadastradas 10 pessoas.")
        }
    }
    fun cadastroAlunos() {
        if (registrosAlunos.size < 20) { // Vai falar a quantidade de registro
            println("Digite o nome do aluno:")
            val nome = readLine() ?: ""
            val notas = mutableListOf<Double>()
            for (i in 1..4) {
                println("Digite a nota do bimestre $i:")
                val nota = readLine()?.toDoubleOrNull() ?: 0.0
                notas.add(nota) // Vai adicionar
       }
            registrosAlunos.add(Aluno(nome, notas))
            registrosAlunos.sortBy { it.nome } // Ele organiza a dor maior ao menor
            println("$nome cadastrado com sucesso!")
    } else {
            println("Já foram cadastrados 20 alunos.")
        }
    }

fun cadastroAltura() {
    if (registrosAltura.size < 15) {
    println("Digite o nome da pessoa:")
      val nome = readLine() ?: ""
      println("Digite a altura da pessoa:")
       val altura = readLine()?.toDoubleOrNull() ?: 0.0
       registrosAltura.add(PessoaAltura(nome, altura))
   println("$nome cadastrado com sucesso!")
        } else {
            println("Já foram cadastradas 15 pessoas.")
        }
}


    fun RegistroPessoas() {
        if (registrosPessoas.isEmpty()) { // Ele verifica se a lista está vazia
            println("Nenhuma pessoa cadastrada.")
        } else {
            registrosPessoas.forEach { println("Nome: ${it.nome}, Endereço: ${it.endereco}, Telefone: ${it.telefone}") }
        } //Usada para percorrer e verificar
}
    fun RegistroAlunos() {
        if (registrosAlunos.isEmpty()) {
            println("Nenhum aluno cadastrado.")
        } else {
            registrosAlunos.forEach {
                println("${it.nome} - Média: ${it.media}, Situação: ${it.situacao}")
            }
    }

 }// Filter ele seleciona
    fun AlturaMenor() {
        registrosAltura.filter { it.altura <= 1.5 }.forEach { println("${it.nome} - ${it.altura}m") }
    }
    fun AlturaMaior() {
        registrosAltura.filter { it.altura > 1.5 }.forEach { println("${it.nome} - ${it.altura}m") }
 }
   fun Altura() {
        registrosAltura.filter { it.altura in 1.5..2.0 }.forEach { println("${it.nome} - ${it.altura}m") }
 }fun MediaAltura() {
        val media = registrosAltura.map { it.altura }.average()
        println("A média das alturas é: $media")
    }

}

fun main() {
    val cadastro = Cadastro()
    cadastro.inicio()
}
