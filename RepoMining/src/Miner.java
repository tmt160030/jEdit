import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Miner {
	public static void main(String [] args) {
		try {
			int i=0;
			Scanner s = new Scanner(new File("log.txt"));
			ArrayList<commit> commits = new ArrayList<commit>();
			ArrayList<String> files=new ArrayList<String>();
			String commitnum="";
			System.out.println("Parsing Change log");
			while(s.hasNextLine()) {
				String line=s.nextLine();
				if(line.isEmpty()) {
					line=s.nextLine();
				}
				if(line.charAt(0)=='c') {
					if(i!=0) {
						if(!files.isEmpty()) {
							commits.add(new commit(commitnum,files));
							files.clear();
						}
					}
					line=line.substring(7);
					commitnum=line;
					i++;
				}
				else if(line.charAt(0)=='M'||(line.charAt(0)=='A'&&line.charAt(1)!='u')) {
					line=line.substring(1);
					files.add(line);
				}
			}
			commits.add(new commit(commitnum, files));
			System.out.println("Done Parsing Change log");
			s.close();
			
			System.out.println("Commits Found: "+commits.size());
			for(i=0;i<commits.size();i++) {
				System.out.println(commits.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
