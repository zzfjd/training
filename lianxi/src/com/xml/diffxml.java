package com.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.custommonkey.xmlunit.Diff;
import org.xml.sax.SAXException;

public class diffxml {
	
	public static void main(String[] args) {
		compare();
	}

	public static void compare() {

		try {
			Reader r1 = new FileReader("xml1.xml");
			Reader r2 = new FileReader("xml2.xml");

			Diff diff = new Diff(r1, r2);

			StringBuffer buf = diff.appendMessage(new StringBuffer());

			System.out.println(buf.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
