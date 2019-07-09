package com.ubaid.app.decorator.exporter;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ubaid.entity.User;

@Component
public class GraphExporter extends DOTExporter<User, DefaultEdge>
{


	/**
	 * @param vertexIDProvider
	 * @param vertexLabelProvider
	 * @param edgeLabelProvider
	 */
	@Autowired
	public GraphExporter(@Qualifier("vertexId") ComponentNameProvider<User> vertexIDProvider,
							@Qualifier("vertexLabel") ComponentNameProvider<User> vertexLabelProvider,
								@Qualifier("edgeLabel") ComponentNameProvider<DefaultEdge> edgeLabelProvider)
	
	{
		super(vertexIDProvider, vertexLabelProvider, edgeLabelProvider);
		
	}
	
}
