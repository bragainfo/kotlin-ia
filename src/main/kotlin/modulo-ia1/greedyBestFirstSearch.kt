

import kotlin.collections.mutableSetOf

// Classe para representar um nó no grafo com seu nome e heurística
data class Node(val name: String, val heuristic: Int)

// Classe para representar as arestas do grafo e seus custos
data class Edge(val to: Node, val cost: Int)

// Classe para representar o grafo como um mapa de nós para suas arestas
class Graph {
    private val adjacencyList: MutableMap<Node, MutableList<Edge>> = mutableMapOf()

    // Adiciona um nó ao grafo
    fun addNode(node: Node) {
        adjacencyList[node] = mutableListOf()
    }

    // Adiciona uma aresta entre dois nós
    fun addEdge(from: Node, to: Node, cost: Int) {
        adjacencyList[from]?.add(Edge(to, cost))
    }

    fun getListNode(node: Node?): MutableList<Edge>{
       return  adjacencyList[node]?.toMutableList() ?: mutableListOf()
    }

    fun searchTheBestPath(nodeStart: Node?, nodeEnd: Node,listFinal: MutableSet<String>){

        val nameStart = nodeStart?.name.toString();
        listFinal.add(nameStart)

        var nodeList = getListNode(nodeStart).toList().minByOrNull { it.to.heuristic }


        val nameCurrent: String =nodeList?.to?.name ?:""
        val nameEnd = nodeEnd.name;

            if(nameEnd != nameCurrent || nameCurrent ==""){
                var node = nodeList?.to
                listFinal.add(nameCurrent)
                searchTheBestPath(node,nodeEnd,listFinal)

        }else{
                listFinal.add(nameCurrent)
                println(listFinal)
            }
    }


}



fun main() {
    // Cria nós com suas heurísticas
    val arad = Node("Arad", 366)
    val zerind = Node("Zerind", 374)
    val oradea = Node("Oradea", 380)
    val sibiu = Node("Sibiu", 253)
    val timisoara = Node("Timisoara", 329)
    val lugoj = Node("Lugoj", 244)
    val mehadia = Node("Mehadia", 241)
    val dobreta = Node("Dobreta", 242)
    val craiova = Node("Craiova", 160)
    val rimnicu = Node("Rimnicu", 193)
    val fagaras = Node("Fagaras", 178)
    val pitesti = Node("Pitesti", 98)
    val bucharest = Node("Bucharest", 0)
    val giurgiu = Node("Giurgiu", 77)

    // Cria o grafo e adiciona nós
    val graph = Graph()
    graph.addNode(arad)
    graph.addNode(zerind)
    graph.addNode(oradea)
    graph.addNode(sibiu)
    graph.addNode(timisoara)
    graph.addNode(lugoj)
    graph.addNode(mehadia)
    graph.addNode(dobreta)
    graph.addNode(craiova)
    graph.addNode(rimnicu)
    graph.addNode(fagaras)
    graph.addNode(pitesti)
    graph.addNode(bucharest)
    graph.addNode(giurgiu)




    // Adiciona arestas com custos
    graph.addEdge(arad, sibiu, 140)
    graph.addEdge(arad, zerind, 75)
    graph.addEdge(arad, timisoara, 118)
    graph.addEdge(zerind, arad, 75)
    graph.addEdge(zerind, oradea, 71)
    graph.addEdge(oradea, zerind, 71)
    graph.addEdge(oradea, sibiu, 151)
    graph.addEdge(sibiu, oradea, 151)
    graph.addEdge(sibiu, arad, 140)
    graph.addEdge(sibiu, fagaras, 99)
    graph.addEdge(sibiu, rimnicu, 80)
    graph.addEdge(timisoara, arad, 118)
    graph.addEdge(timisoara, lugoj, 111)
    graph.addEdge(lugoj, timisoara, 118)
    graph.addEdge(lugoj, mehadia, 70)
    graph.addEdge(mehadia, lugoj, 70)
    graph.addEdge(mehadia, dobreta, 75)
    graph.addEdge(dobreta, mehadia, 75)
    graph.addEdge(dobreta, craiova, 120)
    graph.addEdge(craiova, dobreta, 120)
    graph.addEdge(craiova, pitesti, 138)
    graph.addEdge(rimnicu, craiova, 146)
    graph.addEdge(rimnicu, sibiu, 80)
    graph.addEdge(rimnicu, pitesti, 97)
    graph.addEdge(fagaras, sibiu, 99)
    graph.addEdge(fagaras, bucharest, 211)
    graph.addEdge(pitesti, rimnicu, 97)
    graph.addEdge(pitesti, craiova, 138)
    graph.addEdge(pitesti, bucharest, 101)
    graph.addEdge(bucharest, fagaras, 211)
    graph.addEdge(bucharest, pitesti, 101)
    graph.addEdge(bucharest, giurgiu, 90)

    var list:MutableSet<String> = mutableSetOf();
    graph.searchTheBestPath(timisoara,bucharest, list)
}
