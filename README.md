# Examen-EJB-WEB-EAR
Opération de base  sur un cv CRUD et reporting avec l'api itext

# Installation du Data source avec wildfly 26.1.3 Final

### Télécharger wildly https://www.wildfly.org/news/2023/01/18/WildFly2613-Released/

#### Ajout du mysql-connector dans le répertoire wildfly\modules\system\layers\base\com\mysql\main

https://dev.mysql.com/downloads/connector/j/

### Création de la base de donnée depuis mysql 
searchjob

### Répertoire wildfly/standalone/configuration/standalone.xml

````
<datasource jta="true" jndi-name="java:/MySqlDS" pool-name="MySqlDS" statistics-enabled="true">
   <connection-url>jdbc:mysql://localhost:3306/searchjob</connection-url>
   <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
   <driver>mysql</driver>
   <security>
      <user-name>root</user-name>
   </security>
   <validation>
      	<valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
	<validate-on-match>true</validate-on-match>
	<exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
    </validation>
</datasource>
````
# Téléchargement Jar
### iText pdf
https://mavenlibs.com/jar/file/com.itextpdf/itextpdf
````
<!-- https://mavenlibs.com/maven/dependency/com.itextpdf/itextpdf -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13.3</version>
</dependency>
````
### layout
https://mavenlibs.com/jar/file/com.itextpdf/layout
````
<!-- https://mavenlibs.com/maven/dependency/com.itextpdf/layout -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>layout</artifactId>
    <version>7.2.5</version>
</dependency>
````
