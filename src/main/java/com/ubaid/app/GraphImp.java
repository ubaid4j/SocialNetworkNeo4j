package com.ubaid.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Random;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.ExportException;
import org.jgrapht.io.GraphExporter;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.ubaid.user.User;

public class GraphImp
{
	private static final int LIMIT = 5;
	
	public void createGraph()
	{
		Graph<User, DefaultEdge> graph = new DefaultDirectedGraph<User, DefaultEdge>(DefaultEdge.class);
		
		User[] users = getUsers();

		for(User user : users)
		{
			graph.addVertex(user);
		}
		
		Random random = new Random();
		
		for(int i = 0; i < LIMIT; i++)
		{
			graph.addEdge(users[random.nextInt(LIMIT)], users[random.nextInt(LIMIT)]);
		}
		
		ComponentNameProvider<User> vertexIdProvider = new ComponentNameProvider<User>()
        {
            public String getName(User user)
            {
                return user.getName().replace('.', '_').replace(" ", "_");
            }
        };
        
        ComponentNameProvider<User> vertexLabelProvider = new ComponentNameProvider<User>()
        {
            public String getName(User user)
            {
                return user.toString();
            }
        };
        
        
        GraphExporter<User, DefaultEdge> exporter =
            new DOTExporter<>(vertexIdProvider, vertexLabelProvider, null);
        Writer writer = new StringWriter();
        
        DOTExporter<User, DefaultEdge> exporter2 = new DOTExporter<User, DefaultEdge>();
        String targetDirectory = "testresults/graph/";
        new File(targetDirectory).mkdirs();
//        exporter2.export(new FileWriter(targetDirectory + "initial-graph.dot"), graph);

        Writer writer2 = null;
        try {
			writer2 = new FileWriter(targetDirectory + "i1.dot");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        exporter2.exportGraph(graph, writer2);
        
        try {
			exporter.exportGraph(graph, writer);
		} catch (ExportException e) {
			e.printStackTrace();
		}
        
        System.out.println(writer.toString());
		        
	}
	
	private User[] getUsers()
	{
		String[] batch = {"bese16", "bscs16", "bee16","bese18", "bscs18", "bee18","bese17", "bscs17", "bee17"};
		User[] users = new User[LIMIT];
		Random random = new Random();
		Faker faker = new Faker(new Locale("en-PAK"));

		for(int i = 0; i < LIMIT; i++)
		{
			Name nameObj = faker.name();
			String name = nameObj.fullName();
			String firstName = nameObj.firstName();
			String lastName = nameObj.lastName();
			String email = String.format("%s%s.%sseecs@seecs.edu.pk", lastName, firstName, batch[random.nextInt(9)]);
			int age = random.nextInt(6) + 18;
			users[i] = new User(0, age, email, name);
		}
		
		return users;
	}
}
