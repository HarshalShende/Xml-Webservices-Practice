package JaxbPractice;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TestEmployee {
	public static void main(String[] args) throws JAXBException {
		
		//Marshalling: Converting Java Objects Into XML
		Employee employee=new Employee();
		employee.setEmpNo(301);
		employee.setName("Rama");
		employee.setSalary(23000.0);
		
		//Create JAXB Context Object
		//To create JAXBContext Object we can use
		//newInstance Method From JAXBContext class
		//The newInstance Method Is a static Factory Method
		
		JAXBContext context=JAXBContext.newInstance(Employee.class);
		
		//Create MArshaller Object From JAXBContext
		Marshaller marshaller=context.createMarshaller();
		
		//(1) Call Marshal(-) from Marshaller Object
		marshaller.marshal(employee, System.out);
		System.out.println("Done 1");
		System.out.println();
		
		//(2) Store XML in file
		File file=new File("E:\\XML WEBSERVICES\\JAXB_Test\\src\\JaxbPractice\\emp.xml");
		marshaller.marshal(employee,file);
		System.out.println("Done 2");
		System.out.println();
		
		//(3) Get The Generated XML in the form of a string by using StringWriter
		StringWriter writer=new StringWriter();
		marshaller.marshal(employee,writer);
		String xml=writer.toString();
		System.out.println(xml);
		System.out.println("Done 3");
		System.out.println();
	}
	
	
}
