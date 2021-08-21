package itDeptMagazine;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RequestOtp {
	
	public void send(String email) throws MalformedURLException {
		int otpVal = otpGenerator();
		
		writeToFile(email, otpVal);
		requester(email,Integer.toString(otpVal));
	}
	
	private int otpGenerator() {
		int otp = 0;
		int max = 999999;
		int min = 100000;
		otp = (int) ((Math.random() * (max - min)) + min);
		return otp;
	}
	
	private void writeToFile(String email, int data) {
		try {
		      FileWriter myWriter = new FileWriter("data/" + email + ".txt");
		      myWriter.write(Integer.toString(data));
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}
	

	private boolean requester(String email, String otp) throws MalformedURLException
	{	
		
		URL url = new URL("https://oju0a1ilvd.execute-api.ap-south-1.amazonaws.com/dev/request-otp");
		try {
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "text/plain; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			String reqbody = "email "+email+" access-code java-app-build-001 otp "+otp;
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = reqbody.getBytes("utf-8");
			    os.write(input, 0, input.length);			
			}
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    System.out.println(response.toString());
					}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return false;
		}
		
		
	}
}