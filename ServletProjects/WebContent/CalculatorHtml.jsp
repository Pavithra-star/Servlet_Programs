<%
		int fno=Integer.parseInt(request.getParameter("fno"));
		int sno=Integer.parseInt(request.getParameter("sno"));

		String bValue = request.getParameter("b1");
		if(bValue.equalsIgnoreCase("ADD")){
			out.println("Addiotion " +(fno+sno));
		}


		
		else 	 if(bValue.equalsIgnoreCase("SUB")){
			out.println(" Subtraction "+(fno-sno));
		}

		
		
		else 	if(bValue.equalsIgnoreCase("MUL")){
			out.println(" Muleiplication " +(fno*sno));
		}

		
		
		if(bValue.equalsIgnoreCase("DIV")){
			out.println("Division " +(fno/sno));
		}

		
		
		if(bValue.equalsIgnoreCase("PER")){
			out.println(" Percentage " +(fno%sno));
		}
		
		






%>
















