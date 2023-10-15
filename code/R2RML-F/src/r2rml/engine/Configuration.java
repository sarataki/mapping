package r2rml.engine;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Configuration Class.
 * 
 * @author Christophe Debruyne
 * @version 0.1
 *
 */
public class Configuration {
	
	private static Logger logger = LogManager.getLogger(Configuration.class);
	
	/*String baseURI = "http://foo.example/DB/";
     conn = DriverManager.getConnection(url, username, password);
     System.out.println("Connection successful!");
     String output= "C://Users//staki//Dropbox//My PC (eichler-doc-01)//Desktop//Run//Destination//generatedM.n3";
	String r2rmlFile = "C://Users//staki//Dropbox//My PC (eichler-doc-01)//Desktop//Run//R2RML//N//r2rml.ttl";*/

	/*public Configuration(String path) throws R2RMLException {
		Properties properties = new Properties();
		
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(new File(path));
			properties.load(inputstream);
		} catch (IOException e) {
			throw new R2RMLException(e.getMessage(), e);
		} finally {
		    if (inputstream != null) {
		    	try {
					inputstream.close();
				} catch (IOException e) {
					throw new R2RMLException("Problem closing the configuration file.", e);
				}
		    }
		}
		
		connectionURL = properties.getProperty("connectionURL");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		mappingFile = properties.getProperty("mappingFile");
		outputFile = properties.getProperty("outputFile");
		prefixFile = properties.getProperty("prefixFile");
		format = properties.getProperty("format", "TURTLE");
		setFilePerGraph("true".equals(properties.getProperty("filePerGraph", "false").toLowerCase()));
		baseIRI = properties.getProperty("baseIRI");
		
		String files = properties.getProperty("CSVFiles");
		if(files != null && !"".equals(files)) {
			StringTokenizer tk = new StringTokenizer(files, ";");
			while(tk.hasMoreTokens()) {
				CSVFiles.add(tk.nextToken());
			}
		}
	}
	
	// Getting configuration from argument (picocli CliOptions)
	public Configuration(CliOptions cli) throws R2RMLException {

		connectionURL = cli.connectionURL;
		user = cli.user;
		password = cli.password;
		mappingFile = cli.mappingFile;
		outputFile = cli.outputFile;
		format = cli.format;	// TURTLE default define in CliOptions
		filePerGraph = cli.filePerGraph;
		baseIRI = cli.baseIRI;
		
		String files = cli.CSVFiles;
		if(files != null && !"".equals(files)) {
			StringTokenizer tk = new StringTokenizer(files, ";");
			while(tk.hasMoreTokens()) {
				CSVFiles.add(tk.nextToken());
			}
		}
	}*/
	
	
		private String connectionURL;
		private String user;
		private String password;
		private String mappingFile;
		private String outputFile;
		private String prefixFile = null;
		private String format = "TURTLE";
		private String baseIRI = "http://foo.example/DB/";
		private boolean filePerGraph = false;
		private List<String> CSVFiles = null;
		public Configuration() {	
			//connectionURL = "jdbc:mysql://localhost/twitter?";
			connectionURL="jdbc:mysql://localhost:3306/twitter?useSSL=false&serverTimezone=UTC";
		    user = "root";
			password ="abcd";
			mappingFile = "C://Users//staki//Dropbox//My PC (eichler-doc-01)//Desktop//Test//r2rmlv1.ttl";
			outputFile = "C://Users//staki//Dropbox//My PC (eichler-doc-01)//Desktop//Test//N//new.ttl";
			prefixFile = null;
			format = "TURTLE";
			baseIRI = "http://foo.example/DB/";
           filePerGraph = false;
			
	}

	public String getConnectionURL() {
		return connectionURL;
	}
	
	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMappingFile() {
		return mappingFile;
	}
	
	public void setMappingFile(String mappingFile) {
		this.mappingFile = mappingFile;
	}
	
	public String getOutputFile() {
		return outputFile;
	}
	
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}

	public String getBaseIRI() {
		return baseIRI;
	}

	public void setBaseIRI(String baseIRI) {
		if(baseIRI.contains("#"))
			logger.warn("Base IRIs should not contain a \"#\".");
		if(baseIRI.contains("?"))
			logger.warn("Base IRIs should not contain a \"?\".");
		if(!baseIRI.endsWith("/"))
			logger.warn("Base IRIs should end with a \"/\".");
		this.baseIRI = baseIRI;
	}

	public boolean isFilePerGraph() {
		return filePerGraph;
	}

	public void setFilePerGraph(boolean filePerGraph) {
		this.filePerGraph = filePerGraph;
	}
	
	public List<String> getCSVFiles() {
		return CSVFiles;
	}

	public void setCSVFiles(List<String> cSVFiles) {
		CSVFiles = cSVFiles;
	}

	public boolean hasConnectionURL() {
		return connectionURL != null && !"".equals(connectionURL);
	}

	public boolean hasCSVFiles() {
		return CSVFiles != null && CSVFiles.size() > 0;
	}

	public String getPrefixFile() {
		return prefixFile;
	}

	public void setPrefixFile(String prefixFile) {
		this.prefixFile = prefixFile;
	}
	
}
