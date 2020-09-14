
**FootBall API**
  
Este projeto foi construído com o intuíto do servir de laboratório de testes.  
  
_Disclaimer: Dado o propósito deste projeto, ele estará em constante evolução._
  
***Banco de dados***  
  
  Neste momento a aplicação usa um banco de dados H2 em memória.  
  
***Documentação dos endpoints***  
  
  Esta api usa swagger e reconhecimento automático dos endpoints através da biblioteca [springdoc-openapi](https://springdoc.org/)
  Documentação acessível em `localhost:8080/swagger-ui.html`


***TODO***
- [ ] Melhorar endpoints de criação(POST) com retorno de location do resource criado.
- [ ] Banco de dados postgresql para profile de produção
- [ ] Criar docker-compose para a aplicação
- [ ] Criar ControllerAdvice para tratamento de exceções na camada REST

