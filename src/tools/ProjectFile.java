package tools;

/**
 * @author FDws
 * @date 2017年11月13日 下午8:17:59
 * @title 项目文件类
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectFile {
	private String title = "";
	private Map<String, ProjectFile> children = null;

	ProjectFile(File thisFile) {
		if (thisFile.isFile()) {
			getTitle(thisFile);
		} else {
			children = new LinkedHashMap<>();
			for (File child : thisFile.listFiles()) {
				children.put(child.getName(), new ProjectFile(child));
			}
		}
	}

	ProjectFile() {

	}

	private void getTitle(File file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.matches(".*\\*.*@title .+")) {
					break;
				}
			}
			if (line != null) {
				Matcher match = Pattern.compile(".*@title (.*)").matcher(line);
				if (match.find()) {
					title = match.group(1).trim();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void update(File thisFile) {
		if (thisFile.isFile()) {
			getTitle(thisFile);
		} else {
			Map<String, ProjectFile> newChild = new LinkedHashMap<>();
			for (File child : thisFile.listFiles()) {
				ProjectFile pro = children.get(child.getName());
				if (pro == null) {
					pro = new ProjectFile(child);
				}
				pro.update(child);
				newChild.put(child.getName(), pro);
			}
			if (children != null) {
				children.clear();
			}
			children = newChild;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, ProjectFile> getChildren() {
		return children;
	}

	public void setChildren(Map<String, ProjectFile> children) {
		this.children = children;
	}

	public void write(int deepth, String prefix, BufferedWriter writer) {
		StringBuilder sb = new StringBuilder();
		if (children == null) {
			sb.append("> ");
		} else {
			toLen(deepth, '#', sb);
			sb.append(" ");
		}
		sb.append("[");
		sb.append(title);
		sb.append("](");
		sb.append(prefix);
		sb.append(")\t\t");
		sb.append("\n\n");

		try {
			writer.write(sb.toString());
			if (children != null) {
				for (String name : children.keySet()) {
					children.get(name).write(deepth + 1, prefix + "/" + name, writer);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toLen(int len, char symbol, StringBuilder sb) {
		while (len-- != 0) {
			sb.append(symbol);
		}
	}

	public static void main(String[] args) {

	}
}
