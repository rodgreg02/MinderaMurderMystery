public class Story {
     static void startStory(Player player){
        System.out.println("\t\t\t\t\tMindera Murder Mystery");
        System.out.println("""
                \tNuma noite o detetive  """ + " "+ player.getName()+ """
                  foi chamado para um caso complicado.
                \tA policia ligou-lhe para ir a casa do Sr Flávio pois o mesmo foi assassinado.
                
                \tA policia precisa da sua ajuda para resolver o caso pois:
                \t-Todos os suspeitos se dizem "inocentes" e não encontram provas em contrario;
                \t-Todos os lugares da casa foram limpos pela equipa de limpeza antes do tempo;
                \t-A policia também não consegue encontrar a arma do crime.
                """);
    }

    static void goodEnding(){
        System.out.println("\tGraças a ti a policia encontrou o assassino, a arma, e o local do crime.");
    }
    static void badEnding(){
        System.out.println("\tPor tua causa policia prendeu uma pessoa inocente.");
        System.out.println("\tO verdadeiro culpado matou-o na piscina da casa.");
    }
}
