package com.Game.Helpers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

public class FileLoader
{
	public void getFilesFromFolder(String prefix, List<File> dirs, ClassLoader classLoader)
	{
		try
		{
			Enumeration<URL> resources = classLoader.getResources(prefix.replace(".","/"));
			while (resources.hasMoreElements())
			{
				URL resource = resources.nextElement();
				dirs.add(new File(resource.getFile()));
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
