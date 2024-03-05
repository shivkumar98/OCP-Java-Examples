package chapter_9.c_9_2_interacting_with_paths_files.java;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingToRealPath {

	public static void main(String[] args) {
		Path absolutePath = Paths
			    .get("C:\\Users\\Shiv\\Documents\\GitHub");
		try {
			System.out.println(absolutePath.toRealPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path fakePath = Paths.get("file-does-not-exist.txt");
		try {
			System.out.println(fakePath.toRealPath());
		} catch (IOException e) {
			System.out.println("path does not exist");
		}
		Path relativePath = Paths
				  .get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		try {
			System.out.println(relativePath.toRealPath());
			// C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\src\chapter_9\c_9_1_intro_nio2\javacode\file.txt

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
