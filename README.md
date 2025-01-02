
# Screen phrase

Aplicação para criar frases e retornar uma aleatória


## Documentação da API

#### Retorna todas as frases

```http
  GET /series/frases
```


#### Cria uma frase

```http
  POST /series/frases/create
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `titulo`      | `string` | **Obrigatório** Nome da serie|
| `frase`      | `string` | **Obrigatório** Frase |
| `personagem`      | `string` | **Obrigatório** Personagem que disse a frase |
| `poster`      | `string` | **Obrigatório** Url do poster |



## Aprendizados

- Implementar requisições GET e POST usando o spring boot web



## Apêndice


Aplicação criada para fins de aprendizado


## Licença

[MIT](https://choosealicense.com/licenses/mit/)

