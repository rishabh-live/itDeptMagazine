package live.rishabh.project.aws.vsem.itDeptMagazine;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class RequestOtp implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

		String requestBody = input.getBody();
		System.out.println(requestBody);

		String splitRequestBody[] = requestBody.split(" ");

		System.out.println(splitRequestBody);
		String email = "";
		String otp = "";

		// System.out.println(splitRequestBody[i]);

		if (splitRequestBody[0].equals("email") // check if the request is for email
				&& (splitRequestBody[2].equals("access-code") // check if the request is for access code
						&& (splitRequestBody[3].equals("java-app-build-001") // check if the request is for the java app
																				// build
								|| splitRequestBody[3].equals("android-app-v2") // check if the request is for the
																				// android app
						)) && splitRequestBody[4].equals("otp")) {
			email = splitRequestBody[1];
			otp = splitRequestBody[5];
			System.out.println(email);

			SendEmail sendEmail = new SendEmail();
			boolean sendEmailresp;

			sendEmailresp = sendEmail.requestEmail(email,otp);

			if (sendEmailresp) {
				responseEvent.setStatusCode(200);
				responseEvent.setBody("{\"message\" : \"Email Delivered\" }");
			} else {
				responseEvent.setStatusCode(500);
				responseEvent.setBody("{\"message\" : \"Failed to send Email\" }");

			}

			Map<String, String> headers = new HashMap<String, String>();
			headers.put("content-type", "application/json");

			responseEvent.setHeaders(headers);

			return responseEvent;

		} else {
			responseEvent.setStatusCode(405);
			responseEvent.setBody("{\"message\" : \"Method not Allowed\" }");
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("content-type", "application/json");

			responseEvent.setHeaders(headers);

			return responseEvent;
		}

	}

}
