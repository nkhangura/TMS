package com.users;

public class poProfile {

		private int idPO;
		private String poName;
		private String poEmail;
		private String poProjects;
		public poProfile(int idPO, String poName, String poEmail, String poProjects) {
			super();
			this.idPO = idPO;
			this.poName = poName;
			this.poEmail = poEmail;
			this.poProjects = poProjects;
		}
		public poProfile() {
			// TODO Auto-generated constructor stub
		}
		public int getIdPO() {
			return idPO;
		}
		public void setIdPO(int idPO) {
			this.idPO = idPO;
		}
		public String getPoName() {
			return poName;
		}
		public void setPoName(String poName) {
			this.poName = poName;
		}
		public String getPoEmail() {
			return poEmail;
		}
		public void setPoEmail(String poEmail) {
			this.poEmail = poEmail;
		}
		public String getPoProjects() {
			return poProjects;
		}
		public void setPoProjects(String poProjects) {
			this.poProjects = poProjects;
		}
		@Override
		public String toString() {
			return "poProfile [idPO=" + idPO + ", poName=" + poName + ", poEmail=" + poEmail + ", poProjects="
					+ poProjects + "]";
		}
		
		public void display() {
			System.out.println("****Welcom:"+ poName +"!****");
			System.out.println("Employee ID: "+idPO);
			System.out.println("E-Mail: "+ poEmail);
			System.out.println("Current Project: " + poProjects);
			
		}
}
