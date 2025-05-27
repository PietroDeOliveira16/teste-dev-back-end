# **Uso das APIs**

O sistema está configurado para localhost:8080

### **Problema 01 - API do Dashboard**

Os IDs dos clientes e dos módulos estão iguais aos do PDF.

**Capturar tickets agrupados do Mês e Ano especificados:**

localhost:8080/api/dashboard/{mes}-{ano} *(ex.: localhost:8080/api/dashboard/03-2021)*

**Criar novo ticket (coloque "_" entre palavras no titulo para gerar espaços na hora de salvar):**

localhost:8080/api/dashboard/{titulo}-{id_cliente}-{id_modulo} *(ex.: localhost:8080/api/dashboard/teste-1-1)*

***

### **Problema 02 - API de Receitas**

localhost:8080/api/receitas/{nome_do_prato} *(ex.: localhost:8080/api/receitas/pizza)*
