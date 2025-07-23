package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OxefoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiApplication.class, args);
	}
	

}

/*

Gerenciamento de Componentes
Vamos entender como o Spring gerencia os componentes de sua aplicação, facilitando a vida do desenvolvedor.

@Component: Use em qualquer classe que você quer que o Spring gerencie. É como se fosse o "coringa" das anotações.
@Service: Especializa @Component para serviços. Coloque toda a lógica de negócio aqui. Simplifica a identificação de classes de serviço.
@Repository: Outra especialização de @Component, mas voltada para acesso a dados. É o braço direito do seu banco de dados.
@Controller: Gerencia requisições HTTP. A base para construir aplicações web.
Configuração e Beans
Como configurar e gerenciar os beans, que são os componentes essenciais da sua aplicação Spring.

@Configuration: Marca a classe com métodos que configuram beans. É aqui que você define como seus componentes vão se comportar.
@Bean: Dentro de uma classe com @Configuration, use @Bean para dizer ao Spring: "Ei, gerencie esse cara aqui!".
@PropertySource: Adiciona uma fonte de propriedades ao ambiente Spring. Facilita o uso de arquivos de configuração externos.
@Value: Injeta valores de propriedades em campos, métodos ou parâmetros de construtor. Super útil para configurar valores de forma dinâmica.
Injeção de Dependências
Simplifique o gerenciamento de dependências na sua aplicação com essas anotações.
@Autowired: Muito útil! Injeção de dependência automática. O Spring injeta os objetos necessários sem você precisar suar.
@Qualifier: Usado junto com @Autowired para resolver ambiguidades quando há múltiplos beans do mesmo tipo. Especifica exatamente qual bean deve ser injetado.
@Lazy: A injeção de dependências acontece de forma preguiçosa, ou seja, só quando realmente necessário. Usado para economizar recursos.
Manipulação de Requisições Web
Gerencie facilmente as requisições web no Spring.

@RequestMapping: Mapeia as URLs para métodos do seu controller. Pode ser usada na classe ou no método. Essencial para roteamento.
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: São os verbos HTTP, usados para mandar o tipo da requisição. Facilita a leitura e manutenção do código.
@RestController: Combina @Controller e @ResponseBody. Indica que a classe lida com requisições REST e retorna dados no corpo da resposta.
@PathVariable: Extrai variáveis da URL e passa como parâmetros para os métodos do controller. Prático para rotas dinâmicas.
@RequestParam: Acessa parâmetros da requisição. Útil para capturar dados de requisições GET e POST.
@RequestBody: Converte automaticamente o corpo da requisição HTTP em um objeto Java. Perfeito para APIs REST que lidam com JSON.
@ResponseBody: Indica que o retorno de um método deve ser serializado diretamente no corpo da resposta HTTP.
Tarefas e Transações
Automatize tarefas e gerencie transações de forma eficiente.

@Scheduled: Marca métodos para execução em intervalos regulares. Ideal para tarefas automáticas como limpeza de cache.
@Transactional: Garante que métodos sejam executados dentro de uma transação de banco de dados. Crucial para manter a consistência dos dados.
@Async: Permite a execução assíncrona de métodos. Super útil para operações que podem ser executadas em paralelo sem bloquear o fluxo principal.
Segurança e Validação
Implemente segurança e validação de forma prática e eficaz.

@Secured: Especifica regras de segurança em métodos. Define quem pode acessar o quê.
@PreAuthorize: Uma anotação mais poderosa que @Secured, permitindo expressões complexas para definir regras de segurança.
@Valid: Usada para ativar a validação de beans no Spring. Garante que os dados estão corretos antes de prosseguir com a lógica de negócios.
Chamadas Remotas
Facilite a comunicação com serviços externos.

@FeignClient: Marca uma interface como um cliente Feign, permitindo a chamada de serviços remotos de forma declarativa.

@crossorigin é usada no desenvolvimento web para permitir o compartilhamento de recursos (como imagens ou APIs) entre diferentes domínios, através de uma configuração de CORS (Cross-Origin Resource Sharing). Ela é comumente utilizada no servidor para liberar esse tipo de acesso.

@Data: Gera automaticamente os métodos toString(), equals(), hashCode(), além dos getters e setters para todos os campos da classe.

@Builder: Cria um padrão de construção (builder) para a classe, permitindo a criação de objetos de forma fluente e legível, com a possibilidade de definir valores para os campos de forma personalizada.

@NoArgsConstructor: Gera um construtor sem argumentos para a classe.

@AllArgsConstructor: Gera um construtor com um argumento para cada campo da classe.

@Entity: Marca a classe como uma entidade JPA (Java Persistence API), indicando que ela será mapeada para uma tabela no banco de dados.

@SQLRestriction("habilitado = true"): Especifica uma restrição SQL personalizada para a entidade. No caso, filtra os resultados da consulta para retornar apenas as entidades onde o campo habilitado seja true.

@Builder: Gera um padrão de construção (builder) para a classe, permitindo criar objetos de forma fluente e personalizada.

@Getter: Gera automaticamente os métodos getters para todos os campos da classe.

@Setter: Gera automaticamente os métodos setters para todos os campos da classe.
 



/*
  public class Cliente {

 @ManyToOne
 @JoinColumn(nullable = false)
 private Usuario usuario;
 @Column(nullable = false, length = 100)
 private String nome;

 @Column
 private LocalDate dataNascimento;
 @Column(unique = true)
 private String cpf;
 @Column
 private String fone;
 @Column
 private String foneAlternativo;

}
public class ClienteRequest {
 @NotNull(message = "O Nome é de preenchimento obrigatório")
 @NotBlank(message = "O Nome é de preenchimento obrigatório")
 private String nome;
 @NotBlank(message = "O e-mail é de preenchimento obrigatório")
 @Email
 private String email;
 @NotBlank(message = "A senha é de preenchimento obrigatório")
 private String password;

 @NotNull(message = "O CPF é de preenchimento obrigatório")
 @NotBlank(message = "O CPF é de preenchimento obrigatório")
 @CPF
 private String cpf;

 @JsonFormat(pattern = "dd/MM/yyyy")
 private LocalDate dataNascimento;
 private String fone;
 private String foneAlternativo;
}
a) Como pode ser observado, as duas classes possuem anotações de validação colocadas em
determinados atributos da classe. Qual a diferença entre colocar essas validações na classe Cliente
e colocar na classe ClienteRequest ? (0,5 ponto)
Resposta:
Na Cliente as anotações vão ter efeito no banco, na ClienteRequest vai definir parâmetros de
validação para o campo aonde a anotação esta.
b) Explique o que significa cada validação colocada nas classes acima. (0,5 ponto)
Resposta:
@ManyToOne – muitos para um, @JoinColumn(nullable = false)- Define se a coluna pode aceitar valores nulos.
@Column(unique = true)- Define se os valores na coluna devem ser únicos. Cria uma restrição de unicidade na coluna,
@NotNull - Garante que o valor não seja null, @NotBlank - Garante que a string não seja nula e não seja composta apenas
por espaços em branco, @CPF – garantir que seja um cpf válido, @JsonFormat(pattern = "dd/MM/yyyy") Valida a string com
base em uma expressão regular.
c) Qual seria a validação que precisaríamos acrescentar ao campo foneAlternativo para validar o
tamanho máximo do campo para não permitir mais que 30 caracteres? (0,5 ponto)
Resposta:
@Length(min = 8, max = 30, message = "O campo Fixo deve ter entre {min} e
 // {max} caracteres")
02) Considerando os conceitos aprendidos na aula “C18 - Back-end - Relacionando Entidades”,
implemente um relacionamento de “um para muitos” bidirecional entre as classes Empresa e Cliente
de forma que:
⚫ um cliente tenha uma empresa;
⚫ uma empresa tenha uma lista de clientes
Faça a alteração no código das classes abaixo (1,0 ponto)
public class Cliente extends EntidadeAuditavel {
 @JsonIgnore
 @ManyToOne
 @Column(nullable = false, length = 100)
 private String nome;

 @Column
 private LocalDate dataNascimento;
 @Column(unique = true)
 private String cpf;
 @Column
 private String fone;
 @Column
 private String foneAlternativo;

}
public class Empresa extends EntidadeAuditavel {

 @OneToMany(mappedBy = "cliente", orphanRemoval = true,
fetch = FetchType.EAGER)
 @Column
 private String site;
 @Column
 private String cnpj;
 @Column
 private String inscricaoEstadual;
 @Column
 private String nomeEmpresarial;
 @Column
 private String nomeFantasia;
 @Column
 private String fone;
 @Column
 private String foneAlternativo;
}
03) Considerando o método abaixo, modifique o código para permitir:
⚫ Acesso público ao endpoint no Controller que consulta uma empresa por ID. (0,5 ponto)
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 http
 .httpBasic().disable().csrf().disable().cors().and().sessionManagement()
 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
 .authenticationEntryPoint(authenticationEntryPoint).and().authorizeRequests()
 .antMatchers(AUTH_WHITELIST).permitAll()
 .requestMatchers(HttpMethod.GET, "/api/empresa/*").permitAll()
 .anyRequest()
 .hasAnyAuthority(Usuario.ROLE_CLIENTE, Usuario.ROLE_EMPRESA, Usuario.ROLE_CLIENTE)
 .and().addFilterBefore(
 new JwtTokenAuthenticationFilter(jwtTokenProvider),
UsernamePasswordAuthenticationFilter.class);
 return http.build();
 }
04) No contexto da aula de Controle de Acesso, qual a diferença entre autenticação, autorização e
auditoria? (1,0 ponto)
Resposta:
AUTENTICAÇÃO – o usuário precisa esta cadastrado para poder ter acesso por login e senha
para acessar a plataforma.
AUTORIZAÇÃO – o usuário precisa ter permissão para acessar determinadas rotas, sem essa
autorização ele só consegue acessar determinadas rotas que se enquadrem no seu perfil de
usuário.
AUDITORIA – possível ver quem foi que fez determinada atividade como por exemplo, quem
editou um cadastro ou quem adicionou um produto.
05) Durante a implementação do projeto trabalhado ao longo da disciplina nós criamos um
arquivo .env e o colocamos na raiz do projeto. Responda:
a) Para que serve este arquivo? Qual a vantagem/importância dele? (0,5 ponto)
Resposta:
Serve para colocarmos configurações que não queremos que seja publica por exemplo ao
versionar no github, importante caso nas configurações do projeto tenha senhas ou informações
que não se devem deixar publicas. Assim o usuário que tiver acesso precisa fazer essas de acordo
com sua necessidade colocando suas configurações como por ex.: host, porta, nome e senha do
banco.
b) No arquivo onde definimos as configurações do projeto, escreva abaixo a linha em que informamos
ao spring que o projeto poderá utilizar (ou não) um arquivo .env (0,5 ponto)
Resposta:
spring.config.import=optional:file:.env[.properties]
06) Observando o código abaixo, responda:
“caso ocorra um erro e seja levantado alguma exceção na linha 9, os objetos inseridos nas linhas 4 e
7 serão gravados no banco de dados, pois os comandos são executados antes da linha 9.”
A afirmação acima é verdadeira? Justifique sua resposta. (1,0 ponto)
1
2
3
4
5
6
7
8
9
10
11
12
@Transactional
public Cliente save(Cliente cliente) {
 usuarioService.save(cliente.getUsuario());
 super.preencherCamposAuditoria(cliente);
 Cliente clienteSalvo = repository.save(cliente);
 emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);
 return clienteSalvo;
}
Resposta:
Não, por causa do @Transacional, essa anotação garante que as operações sejam executadas.
07) Observando o código abaixo, responda:
“Após criada esta interface (ClienteRepository), já é possível ter acesso a métodos para consultar
um cliente por id, consultar todos os clientes, incluir, alterar e remover um cliente no banco de dados.”
A afirmação acima é verdadeira? Justifique sua resposta. (1,0 ponto)
1
2
3
4
5
6
7
8
9
10
package br.com.ifpe.oxefood.modelo.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface ClienteRepository extends JpaRepository<Cliente,
Long>,JpaSpecificationExecutor<Cliente> {

}
Resposta:
Sim, porque esta dando extends no JpaRepository.
08) Considerando a classe abaixo:
1
2
3
4
5
6
7
public class CategoriaProduto extends EntidadeAuditavel {
 @NotNull
 @Column(nullable = false, length = 100)
 private String descricao;
}
a) O código abaixo funciona? Se não funcionar, explique o porquê. (0,5 ponto)
1
2
3
4
5
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
 List<CategoriaProduto> findByChaveEmpresaOrderByNome(String chaveEmpresa);
}
Resposta:
Não,porque na classe não tem String chaveEmpresa
b) O código abaixo funciona? Se não funcionar, explique o porquê. (0,5 ponto)
1
2
3
4
5
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
 List<CategoriaProduto> findByChaveEmpresaOrderByDescricao();
}
Resposta:
Não, porque esta faltando o parâmetro em findByChaveEmpresaOrderByDescricao()que seria String
descricao
09) Na aula de controle de acesso do projeto do front-end, implementamos um componente para
restringir o acesso não autenticado às telas do sistema, posteriormente esse componente foi
adicionado em cada definição <Route> no arquivo Rotas.js. Qual foi o componente criado e como
ele foi utilizado no arquivo Rotas.js ? (1,0 ponto)
Resposta:
ProtectedRoute, ele foi usado encapsulando o nome da pagina com ProtectedRoute deixando a
rota protegida. ex.: <ProtectedRoute> <Home/> <ProtectedRoute>.
10) O que é uma API WEB considerada RESTful? (1,0 ponto)
Resposta:
Esta API apresenta funcionalidades expostas através de métodos HTTP tais como GET, POST ou
PUT e pode ser consumida em qualquer linguagem moderna, seja por aplicativos Web,
dispositivos móveis ou dispositivos da Internet das coisas. E deve seguir alguns certas
recomendações para ser considerada RESTfull. Como: Evite adicionar na URI o formato desejado
da representação do recurso, Evite adicionar na URI a operação a ser realizada no recurso, entre
outras.
*/
