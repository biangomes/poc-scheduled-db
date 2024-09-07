## 1. Criar função postgresql para automatizar inserts na base

Scripts feitos até então:

```sql
--create table pessoa (id bigserial primary key, nome varchar(100), email varchar(255));
-- criar 5 registros
insert into pessoa (nome, email)
values 	('Igor Leandro Raul Freitas', 'igor.leandro.freitas@paginacom.com.br'),
		('Diego Kaique Moraes', 'diego_kaique_moraes@cpfl.com.br'),
		('Cristiane Marli da Silva', 'cristiane.marli.dasilva@vilasites.com.br'),
		('Ruan Isaac Vicente Oliveira', 'ruan_isaac_oliveira@danielstrauch.com'),
		('Alice Letícia Cecília da Costa', 'alice.leticia.dacosta@abbott.com');
select *
from pessoa;
```

Referência oficial: https://www.postgresql.org/docs/current/sql-createfunction.html

**Função para automatizar o insert em uma base postgresql**

```sql
create or replace function automaticInsert(novoNome character varying, 
																						novoEmail character varying)
	returns character varying
	language 'plpgsql'
	as $body$
	declare
	begin 
		insert into pessoa(nome, email)
		values (novoNome, novoEmail);
	return 'insert successfully';
end
$body$;
```

## 2. Como chamar essa função nativamente no BD?

```sql
select automaticInsert('Felipe Pedro Henrique Henrique Silveira','felipepedrosilveira@yahoo.se');

```

*Obs.: não foi possível inserir múltiplos registros na função.*

## 3. Scheduled

**Como habilitar o scheduling:**

Na classe principal, anotar com `@EnableScheduling`

---

**Referência:**

[The @Scheduled Annotation in Spring | Baeldung](https://www.baeldung.com/spring-scheduled-tasks)

Regras para um método ter a anotação `@Scheduled`:

- O método não deve ter retorno (ou seja, ser `void`). Caso contrário, o valor retornado será ignorado.
- O método não deve receber parâmetros.

## Scheduled com tempo fixo

Exemplo de configuração de uma task para rodar após um tempo específico:

```java
@Scheduled(fixedDelay = 1000)
public void scheduleFixedDelayTask() {
	System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
}
```

Nessa situação, a duração entre a última execução e a próxima é **fixo**. A próxima task sempre esperará a última concluir.

## Scheduled com uma intervalo de tempo fixo

Exemplo de configuração de uma task com intervalo de tempo fixo:

```java
@Scheduled(fixedRate = 1000)
public void scheduleFixedRateTask() {
	System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
}
```

Essa opção é utilizada quando cada execução da task é independente.

Ainda assim, essas tarefas não são executadas paralelamente por padrão. Sendo assim, mesmo utilizando `fixedRate`, a próxima task não deve ser invocada até que a anterior seja finalizada.

## Parametrização de schedule

Exemplo:

```java
@Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")

@Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")

@Scheduled(cron = "${cron.expression}")
```

Outra referência potencialmente boa:

[Agendando coisas em programas SpringBoot com Scheduled](https://mmarcosab.medium.com/agendando-coisas-em-programas-springboot-com-scheduled-1410bea2dda9)

[Cron Job Scheduler in Spring Boot](https://medium.com/@bhageshwaridevnani/cron-job-scheduler-in-spring-boot-1853017c5a86)