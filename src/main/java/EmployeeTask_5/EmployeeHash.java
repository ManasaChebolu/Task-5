package EmployeeTask_5;

import java.util.*;

class  PermanentEmployees {
	int empId;
	String empName;
	int empSalary;
	String empType;
	PermanentEmployees(int empId,String empName,int empSalary,String empType) {
		this.empId=empId;
		this.empName=empName;
		this.empSalary=empSalary;
		this.empType=empType;
	}
	@Override
	public String toString() {
		return "PermanentEmployees [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empType=" + empType + "]";
	}
}

class PartTimeEmployees  {
	int empId;
	String empName;
	int empSalary;
	String empType;
	PartTimeEmployees(int empId,String empName,int empSalary,String empType) {
		this.empId=empId;
		this.empName=empName;
		this.empSalary=empSalary;
		this.empType=empType;
	}
	@Override
	public String toString() {
		return "PartTimeEmployees [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empType=" + empType + "]";
	}
}
class ContractEmployees  {
	int empId;
	String empName;
	int empSalary;
	String empType;
	ContractEmployees(int empId,String empName,int empSalary,String empType) {
		this.empId=empId;
		this.empName=empName;
		this.empSalary=empSalary;
		this.empType=empType;
	}
	@Override
	public String toString() {
		return "ContractEmployees [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empType="
				+ empType + "]";
	}
}

public class EmployeeHash  {
	static Hashtable<Integer,PermanentEmployees> permanentHashtable=new Hashtable<>();
	static Hashtable<Integer,PartTimeEmployees> partTimeHashtable=new Hashtable<>();
	static Hashtable<Integer,ContractEmployees> contractHashtable=new Hashtable<>();

public void add(int empId,String empName,int empSalary,String empType) {
		 if(empType.equals("permanent")) 
			 permanentHashtable.put(empId, new PermanentEmployees(empId,empName,empSalary,empType));		
		 else if(empType.equals("parttime")) 
			 partTimeHashtable.put(empId, new PartTimeEmployees(empId,empName,empSalary,empType));
		 else if(empType.equals("contract")) 
			 contractHashtable.put(empId, new ContractEmployees(empId,empName,empSalary,empType));	
		 else
		    System.out.println("No Such Type");
	 }

public  Object checkId(int id) {
	if(permanentHashtable.containsKey(id)) {
		Object ob= permanentHashtable.get(id);
		 return ob;
	}
	else if(partTimeHashtable.containsKey(id)) {
		Object ob= partTimeHashtable.get(id);
		return ob;
	}
	else if(contractHashtable.containsKey(id)) {
		  Object ob= contractHashtable.get(id);
		   return ob;
	}
	else
		return "No Employee found with that ID";
}
}





