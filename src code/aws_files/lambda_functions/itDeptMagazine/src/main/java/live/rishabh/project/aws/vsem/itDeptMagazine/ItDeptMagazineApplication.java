package live.rishabh.project.aws.vsem.itDeptMagazine;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.google.gson.Gson;



public class ItDeptMagazineApplication implements RequestHandler<Object, String>{

    @Override
	public String handleRequest(Object input, Context context) {
		
         String data = input != null ? input.toString() : null;
        
        // String[] inputArray = input.split("@");

		// if(inputArray.length != 2 || inputArray[1] != "smit.smu.edu.in"){
        //     throw new Error("Illegal Email"); 
        // }
        // else{
        //     return data;
        // }
        Gson g = new Gson();
        

        if(data != null){
            // String[] inpuArray = new String[input.length]
            String p = g.toJson(input);
            System.out.println(p);
        }
        else{
            throw new Error("Illegal Email");
        }
        System.out.println(input);
       return data;
        
	}
}
