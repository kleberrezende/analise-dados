# Análise de Dados
Analisar conteúdo do arquivo na pasta de entrada(/home/kleber/data/in) 
e colocar o resultado em uma pasta de saída(/home/kleber/data/out).

O sistema irá verificar novos arquivos a cada de 30 segundos.

Caso o arquivo de saída seja excluído e ainda existir na pasta de entrada o arquivo será processado novamente.

# Executar
```
No terminal navegar até a pasta /analise-dados-api

Executar: $ mvn clean install spring-boot:run
```

# Exemplo de arquivos:
```
salvar em: /home/seu_nome/data/in/file01
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
```
```
salvar em: /home/seu_nome/data/in/file02
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
001ç1234567801234çAndreç50000
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
002ç2345675434544340çManuelçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
003ç11ç[1-10-100,2-30-2.50,3-40-3.10]çAndre
```

```
salvar em: /home/seu_nome/data/in/file03
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
001ç1234567801234çAndreç50000
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
002ç2345675434544340çManuelçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
003ç11ç[1-34-10,2-33-1.50,3-40-0.10]çAndre
```
