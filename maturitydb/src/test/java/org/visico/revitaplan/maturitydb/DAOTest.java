package org.visico.revitaplan.maturitydb;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.visico.revitaplan.maturitydb.dao.MaturitySurveyDAO;
import org.visico.revitaplan.maturitydb.model.Groupings;
import org.visico.revitaplan.maturitydb.model.Question;

public class DAOTest {
	
	@Test
	public void questionsDAOTest()
	{
		MaturitySurveyDAO dao = new MaturitySurveyDAO();
		List<Question> questions = dao.getQuestions();
		assertNotNull(questions);
		
		for (Question q : questions)
			System.out.println(q.getEnglish() + "; " + q.getFormat());
	}
	
	@Test
	public void groupingsDAOTest()
	{
		MaturitySurveyDAO dao = new MaturitySurveyDAO();
		List<Groupings> groupings = dao.getGroupings();
		assertNotNull(groupings);
		
		for (Groupings g : groupings)
			System.out.println(g.getFirstquestion() + " - " + g.getLastquestion());
	}
}
