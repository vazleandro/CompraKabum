![Cucumber Logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNLP1uKFI4KKqqCh6CMXJqtvZnfHjriSn9HG-dZC6ALsSVT_MrRg)

# Descrição:
O Projeto visa apresentar uma maneira de realizar teste automatizados de um Ecommerce e de aplicações Web com Selenium.
É utilizado a ferramenta Cucumber para executar os testes automatizados e o Gherkin para escrever os cenários de testes.


# Relatório:
Ao final de execução dos Cenários é possivel gerar um relatorio com informações da execução. Conforme exemplo abaixo: 

![Relatorio_cucumber_Logo](https://wiki.jenkins.io/download/thumbnails/65671111/1-feature-overview.png?version=2&modificationDate=1475430977000&api=v2)

Para isso, é necessário realizar configuração do Plugin no arquivo pom.xml

```xml
<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.22.0</version>
				<configuration>
					<testFailureIgnore>true</testFailureIgnore>
					<testSourceDirectory>/src/test/java</testSourceDirectory>
					<includes>
					<include>**/*.java</include>
					</includes>
				</configuration>
			</plugin>
			<plugin>
				<groupId>net.masterthought</groupId>
				<artifactId>maven-cucumber-reporting</artifactId>
				<version>3.4.0</version>
				<executions>
					<execution>
						<id>execution</id>
						<phase>verify</phase>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<projectName>ExecuteAutomation</projectName>
							<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
							<cucumberOutput>${project.build.directory}/cucumber-reports/cucumber.json</cucumberOutput>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
 ```
  
Para executar, pode utilizar o comando: MVN VERIFY
