package com.groupeisi.controller;


import java.io.IOException;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.entities.Contact;
import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Experience;
import com.groupeisi.entities.Formation;
import com.groupeisi.entities.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class PrintCvServlet
 */
@WebServlet("/pdf")
public class PrintCvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   @EJB
       private ICvLocal cv_dao;
       @EJB
       private IContactLocal contact_dao;
       @EJB
       private IExperienceLocal exp_dao;
       @EJB
       private IFormationLocal form_dao;
     
       @EJB
       private IUserLocal user_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		try {
			Document doc=new Document();
			//font  family-size-color
			BaseColor myColor = new BaseColor(84, 175, 228, 1);
			Font descFont=new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,myColor.darker());
			Font textFont=new Font(Font.FontFamily.TIMES_ROMAN,14,Font.NORMAL,BaseColor.BLACK);
			Font headFont=new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLACK);
			Font titleFont=new Font(Font.FontFamily.HELVETICA,40,Font.BOLD,BaseColor.BLACK);
			
			Formation formation=new Formation();
			 Experience exp=new Experience();
			 Cookie[] ck=request.getCookies();
			 //on récupère l'id user depuis la session
	  		int	user_id=Integer.parseInt(ck[2].getValue());
	  	
	  		
	  	// Appeler la méthode getCvByUserId de CVDAO pour récupérer le CV de l'utilisateur
	  		Cv resume = cv_dao.getCvByUserId(user_id);
	  		int cv_id=resume.getId();
	  	
	  		int contact_id=cv_dao.get(cv_id,resume).getContact().getId();
	  		form_dao.getFormationByIdCv(cv_id);
	  		
	  		User u=new User();
	  		Contact c=new Contact();
	  		
	  	
	  		String email=ck[1].getValue();
	  		
	  		//contact get values adresse tel
	  		
	  		Contact contact=contact_dao.get(contact_id, c);
			String adresse=contact.getAdresse();
			String tel=contact.getTelephoneSpecialite();
			
			//cv
		
			String nom=resume.getNom().toUpperCase();
			String prenom=resume.getPrenom().toUpperCase();
			String skills=resume.getSkills().toUpperCase();
			String interets=resume.getInterets().substring(0,1).toUpperCase()+resume.getInterets().substring(1);
			exp.setCv(resume);
			
			//on réccupère l'instence du document
			PdfWriter.getInstance(doc, response.getOutputStream());
			
			doc.open();//ouverture du document
			//création des paragraph nom complet email  tel adresse
			
			
			Paragraph fullName=new Paragraph(nom+"  "+prenom,titleFont);
			Paragraph contactP=new Paragraph("Email: "+email+"  "+"|"+" "+"Telephone: +221"+tel+"  "+"|"+" "+"Adresse: "+adresse +"\n",textFont);
			Paragraph title2=new Paragraph("\nEXPERIENCE PROFESSIONNELLE",descFont);
			
			//titre du document
			doc.addTitle(prenom+" "+nom);
			//ajout du paragraph dans document
			doc.add(fullName);
			doc.add(contactP);
			
			
			//experience get Values
			List<Experience> experiences= exp_dao.getExperiencesByCvId(cv_id);
			//ajout du titre
			doc.add(title2);
			for(Experience experience: experiences) {
				
				String	society=experience.getSociete();
				String	city=experience.getVille();
				String	deb=experience.getDatedb();
				String	fn=experience.getDatefn();
				String	poste=experience.getPoste().substring(0, 1).toUpperCase() + experience.getPoste().substring(1);
				Paragraph societyP=new Paragraph("\n"+society.toUpperCase(),headFont);
				Paragraph cityP=new Paragraph(city,textFont);
				Paragraph dateP=new Paragraph(deb+"	/ "+fn,textFont);
				Paragraph posteP=new Paragraph(poste,headFont);
				/**
				 * margin left padding-top
				 */
				posteP.setIndentationLeft(350);
				posteP.setMultipliedLeading(0.1f); 
				//ajout paragraph experience
				doc.add(societyP);
				doc.add(posteP);
				doc.add(cityP);
				doc.add(dateP);
			}
					
			//formation get values from list
			List<Formation> formations=  form_dao.getFormationByIdCv(cv_id);
	
			//education
			Paragraph title1=new Paragraph("\nEDUCATION\n",descFont);
			doc.add(title1);
			for(Formation f:formations) {
				String school = f.getEcole().toUpperCase();
				String	year=f.getAnnee();
				String 	degree=f.getNiveauEtude();
				//paragraph education 
				Paragraph schoolP=new Paragraph(school,headFont);
				Paragraph yearP=new Paragraph(year,textFont);
				Paragraph degreeP=new Paragraph(degree,textFont);
				//ajout des paragraph titre ,ecole,annee et niveau etude dans le document
				doc.add(schoolP);
				doc.add(degreeP);
				doc.add(yearP);
			}
		
			
			//cr&ation	paragraph	competences ou skills 
			Paragraph title3=new Paragraph("\nSkills ",descFont);
			Paragraph skillsP=new Paragraph(skills,textFont);
			
			//ajout des paraagraph skills dans le document
			doc.add(title3);
			doc.add(skillsP);
			
			Paragraph title4=new Paragraph("\nInterêts ",descFont);
			Paragraph interestP=new Paragraph(interets,textFont);
			
			//ajout des paragraph titre ,intertes dans le document
			doc.add(title4);
			doc.add(interestP);
			doc.close();
			 
		  
		} catch ( Exception e) {
			// TODO: handle exception
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
