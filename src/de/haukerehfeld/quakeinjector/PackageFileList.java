/*
Copyright 2009 Hauke Rehfeld


This file is part of QuakeInjector.

QuakeInjector is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

QuakeInjector is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with QuakeInjector.  If not, see <http://www.gnu.org/licenses/>.
*/
package de.haukerehfeld.quakeinjector;

import java.util.Iterator;
import java.util.TreeSet;

public class PackageFileList implements Iterable<String> {
	/**
	 * other classes rely on the sorted iteration this provides
	 */
	private TreeSet<String> files = new TreeSet<String>();

	private String id;

	public PackageFileList(String id) {
		this.id = id;
	}

	public void add(String file) {
		files.add(clean(file));
	}

	public void remove(String file) {
		files.remove(clean(file));
	}

	public int size() {
		return files.size();
	}

	/**
	 * iterate the files in ascending order by their filename
	 */
	public Iterator<String> iterator() {
		return files.iterator();
	}

	public Iterator<String> descendingIterator() {
		return files.descendingIterator();
	}
	
	public String getId() {
		return id;
	}

	public String clean(String file) {
		return file.replace('\\', '/');		
	}
}