# AlgoritmoCYK
Algoritmo CYK para o reconhecimento de palavras


## Execução 
  * Faça o clone ou download do arquivo zip do projeto;
  * Abra-o utilizando uma IDE;
  * Com o projeto já aberto, clique no local correspondente à execução de projetos da sua IDE. Se estiver usando NetBeans, basta clicar em (Run/Executar Projeto) ou clicar em F6;
  * Um panel será aberto e pergutará se deseja informar uma gramática ou não. Caso seja a primeira execução, clique em "Sim" para cadastrá-la;
  * Um notepad será aberto para que você informe a gramática (Deve estar na forma normal de chomsky);
  * Salve o arquivo e feche-o;
  * Em seguida um outro panel será aberto para que você informe a palavra que será validade, escreva no campo correspondente e clique em "Ok";
  * Se a palavra for aceita, uma mensagem positiva será mostrada, caso contrário, uma mensagem negativa será mostrada;
  * Para fazer uma outra validação, execute o algoritmo outra vez;
  * Caso deseje utilizar a mesma gramática cadastrada na última vez, basta clicar na opção "Não" quando o panel de "Criar nova gramática" aparecer;
  * Caso deseje utilizar uma outra gramática, basta clicar na opção "Sim" quando o panel de "Criar nova gramática" aparecer;
  
## Modelo padrão para descrição da gramática
#### Obs: Para que a gramática seja reconhecida pelo algoritmo e o mesmo consiga processar as palavras inputadas, a gramática precisa estar na formal normal de chomysk.

O seguinte padrão precisa ser adotado para que o algoritmo consiga interpretar a gramática informada:
  
    S => XB | AB
    X => AS
    A => a
    B => b
    
   1 - O símbolo inicial (símbolo de partida da gramática) deve ser o primeiro deescrito, ou seja, deve estar na primeira linha do arquivo;
   
   2 - Para separar os símbolos não terminais da esquerda dos símbolos da direita, os seguintes operadores "=>" devem ser utilizados;
   
   3 - Caso um símbolo não terminal da esquerda gere mais de uma regra, como o não terminal "S" do exemplo,
      
      S => XB
      S => AB
      
  as regras devem ser deescritas na mesma linha usando o "|" para separá-las:
  
    S => XB | AB
