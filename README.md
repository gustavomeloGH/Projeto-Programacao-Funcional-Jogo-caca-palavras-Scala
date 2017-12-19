<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Projeto de Programação Funcional - Jogo Caça Palavras utilizando Scala</h3>
<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Tecnologias Usadas: </h3>

<ul>
  <li>
    <p>Scala</p>
  </li>
  <li>
    <p>Java</p>
  </li>
</ul>

<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Especificações do projeto: </h3>
<ul>
  <li>
    <p>Projeto feito para cadeira de programação funcional na Faculdade Nova Roma.</p>
  </li>
  <li>
    <p>O jogo Caça Palavras possui 3 níveis - Fácil, Médio, Difícil.</p>
  </li>
  <li>
    <p>Para cada nível, é criado aleatoriamente uma matriz fixa e colocada nela as palavras também de forma aleatoriamente.
    </p>
  </li>
  <li>
    <p>Tamanho das matrizes e quantidade de palavras, respectivamente: Nível Fácil - 12x12, 6 palavras | Nível Médio - 15x15, 8 palavras | Nível Difícil - 18x18, 12 palavras.</p>
  </li>
  <li>
    <p>O jogador precisa seguir o passo a passo para informar as palavras e assim que o jogo é encerrado, é mostrado o resultado
    do jogo, a matriz só com as respostas para conferir.</p>
  </li>
</ul>

<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Especificações das pastas do projeto: </h3>
<ul>
  <li>
    <p>Main</p>
    <ul>
      <li>
        <p>Inicializa o jogo</p>
      </li>
    </ul>
  </li>
  <li>
    <p>Project</p>
    <ul>
      <li>
        <p>Jogo é dividido em duas partes: 1 - Implementação, 2 - GUI, 3 - WordList</p>
      </li>
      <li>
        <p>1 - Implementação - Está a codificação do jogo em si, criação de matrizes, inserção de palavras e letras aleatórias.</p>
      </li>
      <li>
        <p>2 - GUI - Parte em está toda a codificação referente a apresentação do jogo (feito em modo Console). Menus, inputs e 
        exibir resultados.</p>
      </li>
      <li>
        <p>3 - WordList - Implementação de métodos para gerar lista aleatória contendo palavras da lista de palavras.</p>
      </li>
    </ul>
  </li>
  <li>
    <p>TraitProject</p>
    <ul>
      <li>
        <p>Toda parte de Interface (Contratos) da implementação.</p>
      </li>
    </ul>
  </li>
  <li>
    <p>Util</p>
    <ul>
      <li>
        <p>Toda parte de Enumeração, utilizada no código, para facilitar a leitura.</p>
      </li>
    </ul>
  </li>
  <li>
    <p>Resources</p>
    <ul>
      <li>
        <p>Pasta com arquivo que contém todas as palavras armazenadas nele, afim de utilização pela implementação da classe WildList.</p>
      </li>
    </ul>
  </li>
</ul>
