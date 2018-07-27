package message.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Send {
	
	private static String getMessage(String[] strings)
	{
		if(strings.length < 1)
		{
			return "Hello World!";
		}
		return joinStrings(strings, " ");
	}
	
	private static String joinStrings(String[] strings, String delimiter)
	{
		int length = strings.length;
		if(length == 0)
		{
			return "";
		}
		StringBuilder words = new StringBuilder(strings[0]);
		for(int i=1; i < length; i++)
		{
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}
	
	private static final String QUEUE_NAME="hello";
	
	public static void main(String ...args) throws IOException, TimeoutException
	{
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();

		boolean durable=true;
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		String message="Hello World!";
		
		//int prefetchCount=1;
		//channel.basicQos(prefetchCount);
		channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		
		System.out.println("[x] Sent: '"+message+"'");
		
		channel.close();
		connection.close();
	}
}
