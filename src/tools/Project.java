package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author FDws
 * @date 2017年11月13日 下午5:40:06
 * @title 生成本项目的README文件
 */
public class Project {
	private ProjectFile files = null;
	private String prefix = "https://github.com/FDws/Algorithm-Analysis/tree/master/src";

	public Project() {
		getSource();
		make();
	}

	public void getSource() {
		File source = new File("./project.json");
		if (!source.exists()) {
			files = new ProjectFile(new File("./src"));
		} else {
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.INDENT_OUTPUT, true);
			try {
				files = om.readValue(new FileInputStream(source), ProjectFile.class);
				files.update(new File("./src"));
				om.writeValue(new BufferedWriter(new FileWriter(source)), files);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void make() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("./README.md"));
			files.write(1, prefix, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new Project();
	}
}
