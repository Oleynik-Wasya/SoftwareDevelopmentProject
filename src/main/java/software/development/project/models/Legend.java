package software.development.project.models;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Legend
{
	private Map<String, Color> subjects;
	private List<Color> colors = new ArrayList<>();

	{
		colors.add(Color.decode("#BCE567"));
		colors.add(Color.decode("#D1D2D5"));
		colors.add(Color.decode("#A8A9AD"));
		colors.add(Color.decode("#DDF2B3"));
		colors.add(Color.decode("#808285"));
		colors.add(Color.decode("#8FD302"));
	}

	public Legend(Set<String> subjects)
	{
		this.subjects = new HashMap<>();
		int i = 0;
		for (String subject : subjects)
		{
			this.subjects.put(subject, colors.get(i));
			i++;
		}
	}

	public Color getColor(String nameSubject)
	{
		return this.subjects.get(nameSubject);
	}

	public Map<String, Color> getSubjects()
	{
		return subjects;
	}

	public void setSubjects(Map<String, Color> subjects)
	{
		this.subjects = subjects;
	}

	@Override public String toString()
	{
		return "Legend{" + "subjects=" + subjects + '}';
	}
}
