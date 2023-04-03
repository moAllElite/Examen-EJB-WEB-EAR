Examen-EJB-WEB-EAR
==============

### Opération de base  sur un cv CRUD et reporting avec l'api iText

---
# Installation du Data source avec wildfly 26.1.3 Final

![wildfly](https://www.wildfly.org/news/2023/01/18/WildFly2613-Released/)


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



## Création d'un utilisateur 
#### Run `call wildfly/bin/add-user.bat`
````
What type of user do you wish to add?
 a) Management User (mgmt-users.properties)
 b) Application User (application-users.properties)
 (a):
````

Run `a`

````
Enter the details of the new user to add.
Using realm 'ManagementRealm' as discovered from the existing property files.
Username :
````
---
# Téléchargement Jar
**[iText pdf](https://itextpdf.com/products/itext-7/itext-7-core)**

**[iText jar](https://mavenlibs.com/jar/file/com.itextpdf/itextpdf)**

---

## Configutation iText
### Création du document
```` java
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

response.setContentType("application/pdf");
Document doc=new Document();
Font headFont=new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLACK);
````

````
String nom=resume.getNom().toUpperCase();
String prenom=resume.getPrenom().toUpperCase();
String skills=resume.getSkills().toUpperCase();
String interets=resume.getInterets().substring(0,1).toUpperCase()+resume.getInterets().substring(1);
exp.setCv(resume);
````
### Ajout des paragraphes dans le document

````
Paragraph fullName=new Paragraph(nom+"  "+prenom,titleFont);
doc.addTitle(prenom+" "+nom);
````
-----

## Démarrage du projet 
Run `http://localhost:8080/SearchJobs`
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
-------
