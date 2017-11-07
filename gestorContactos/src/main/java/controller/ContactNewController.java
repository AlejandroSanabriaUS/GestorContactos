package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import model.repository.ContactRepository;

/**
 * Servlet implementation class ContactNewController
 */
public class ContactNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());
	
    public ContactNewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO: Read request parameters
		String nombre=request.getParameter("name");
                String telefono= request.getParameter("phone");
                
                if(nombre == null || nombre.equals("")|| telefono==null || telefono.equals("")){
                    request.setAttribute("message","Los datos introducidos no son válidos");
                    request.getRequestDispatcher("contactEditView").forward(request, response);
                
                }
                
                System.out.println("Vamos a crear un contacto: "+ nombre + "telefono: " + telefono);
		ContactRepository bd= ContactRepository.getInstance();
                bd.addContact(nombre, telefono);
		// TODO: Forward to contact list view		request.setAttribute("message", "Contacto creado con éxito");
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
