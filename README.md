# Requisições de Cliente:

# POST /cliente
Cria um cliente no sistema.
Request Body
{
    "name": "Nicollas Gabriel"
}
Response 201
{
    "id": 1,
    "name": "Nicollas Gabriel"
}

# GET /cliente/{id}
Exibe um cliente do sistema
Response 200
{
    "id": 1,
    "name": "Nicollas Gabriel"
}

Requisições de cartão:

# POST /cartao
Cria um cartão no sistema.
Request Body
{
    "numero": "012730871",
    "clienteId": 1
}
Response 201
{
    "id": 1,
    "numero": "012730871",
    "clienteId": 1,
    "ativo": false
}

# PATCH /cartao/{numero}
Ativa/Desativa um cartão do sistema.
Request Body
{
    "ativo": true
}
Response 200
{
    "id": 1,
    "numero": "012730871",
    "clienteId": 1,
    "ativo": true
}

# GET /cartao/{numero}
Exibe um cartão do sistema
Response 200
{
    "id": 1,
    "numero": "012730871",
    "clienteId": 1
}

Requisições de pagamento:

# POST /pagamento
Cria um pagamento no sistema.
Request Body
{
    "cartao_id": 1,
    "descricao": "cerveja",
    "valor": 10.5 
}
Response 201
{
    "id": 1,
    "cartao_id": 1,
    "descricao": "cerveja",
    "valor": 10.5 
}

# GET /pagamentos/{id_cartao}
Exibe os pagamentos de um Cartão (extrato)
Response 200
[
    {
        "id": 1,
        "cartao_id": 1,
        "descricao": "pizza",
        "valor": 20.5 
    },
    {
        "id": 2,
        "cartao_id": 1,
        "descricao": "cerveja",
        "valor": 10.5 
    }
]
