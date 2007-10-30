								COMPONENTE ADMINISTRACAO DE CURSO
								
		Este componente e responsavel pela manutencao e cadastro de cursos, disciplinas, 
		turmas, alunos, docentes, secretarios e confirmação de matriculas.
		
		O componente admc possui dependencia das bibliotecas KAD_LIBS. Para a realizacao 
		dos comandos abaixo listados e necessario que o ambiente esteja montado. 
		Verifique em http://kyrios.sourceforge.net/kad-tools.html as ferramentas adotadas
		neste projeto.
		
		ESTRUTURA DO COMPONENTE
		
		1) src : arquivos fontes .java e arquivos .xml e .properties de configuracao;
		2) build: arquivos binarios .class e arquivos .xml e .properties de configuracao;
		3) deploy: arquivos .war para publicacao web e .jar.
		  Obs.: O arquivo admc.jar contem as interfaces de acesso do componente, e o arquivo
		  admc-data.jar e a implementacao das interfaces do projeto.
		  
		4) docs: contem arquivos de documentacao;
		5) test: contem os testes executados no componente;
		6) web: contem arquivos para para composicao da camada de visao do componente;  
		
		IMPLANTACAO
		
		Para a implantacao sera utilizada a ferramenta Ant. Para visualizar os alvos do 
		componente localize o arquivo build.xml. 
		
		Execute o comando: ant -p build.xml.
		
		Sera listados todos os alvos do componente.
		
		Execute o comando: ant db-start . Para inicializar o banco de dados HSQLDB
		Execute o comando: ant db-schema. Para exportar as tabelas para o banco de dados
		Execute o comando: ant db-manager. Para inicializar o Gerenciador do banco HSQLDB
		Execute o comando: ant. Para construir o projeto.
		
		 
		
		
		
		
		
		
