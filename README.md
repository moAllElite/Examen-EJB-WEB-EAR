# Examen-EJB-WEB-EAR
Opération de base  sur un cv CRUD et reporting avec l'api itext
#Installation du Data source avec wildfly 26.1.3 Final


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
