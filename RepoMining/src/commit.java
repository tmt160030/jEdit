import java.util.ArrayList;

public class commit {
	private String commitnum;
	private ArrayList<String> files;
	
	public commit() {
		setCommitNum("");
		files=new ArrayList<String>();
	}
	
	public commit(String s) {
		setCommitNum(s);
		files=new ArrayList<String>();
	}
	
	public commit(String s, ArrayList<String> f)
	{
		setCommitNum(s);
		setFiles(f);
	}
	
	public void setFiles(ArrayList<String> f) {
		if(!f.isEmpty()) {
			this.files.addAll(f);
		}
	}
	
	public void setCommitNum(String s) {
		commitnum=s;
	}
	
	public String getCommitNum() {
		return commitnum;
	}
	
	public ArrayList<String> getFiles(){
		return files;
	}
	
	public int getNumFiles() {
		return files.size();
	}
	
	public String getFile(int i) {
		if(i<files.size()) {
			return files.get(i);
		}
		else {
			return("Invalid file index");
		}
	}
	
	public String getFilesString() {
		return files.toString();
	}
	
	public void addFile(String f) {
		files.add(f);
	}
	
	public void clearFiles() {
		files.clear();
	}
	public String toString() {
		return(getCommitNum()+"\n"+getFilesString());
	}
}