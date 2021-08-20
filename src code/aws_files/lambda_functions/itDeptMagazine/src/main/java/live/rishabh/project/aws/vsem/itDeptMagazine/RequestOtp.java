package live.rishabh.project.aws.vsem.itDeptMagazine;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class RequestOtp implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

		String requestBody = input.getBody();
		System.out.println(requestBody);

		String splitRequestBody[] = requestBody.split(" ");

		System.out.println(splitRequestBody);

		for (int i = 0; i < splitRequestBody.length; i++) {
			System.out.println(splitRequestBody[i]);
		}

		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

		responseEvent.setStatusCode(200);
		responseEvent.setBody("{\"message\" : \" Working Properly \" }");

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");

		responseEvent.setHeaders(headers);

		return responseEvent;

	}

}
