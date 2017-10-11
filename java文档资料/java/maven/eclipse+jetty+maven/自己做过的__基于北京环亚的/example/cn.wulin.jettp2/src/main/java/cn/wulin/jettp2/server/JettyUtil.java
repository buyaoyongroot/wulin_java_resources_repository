package cn.wulin.jettp2.server;

import java.io.File;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class JettyUtil {
	private static final String WEBDEFAULT_XML = "webdefault.xml";

	private static Server currentServer;
	public static boolean isStop = false;
	
	public static Server getCurrentServer() {
		return currentServer;
	}

	public static void setCurrentServer(Server currentServer) {
		JettyUtil.currentServer = currentServer;
	}
	
	public static Server createServer(String contextPath,int port){
		File projectFile;
		Server server;
		WebAppContext webContext;
		webContext = new WebAppContext();
		webContext.setMaxFormContentSize(-1);
		server = new Server();
		try {
			webContext.setContextPath(contextPath);
			projectFile =  new File(System.getProperty("user.dir"));
			File webapp = new File(projectFile,"webroot");
			webapp.mkdirs();
			Resource baseResource = Resource.newResource(webapp);
			webContext.setBaseResource(baseResource);
			webContext.setDefaultsDescriptor(WEBDEFAULT_XML);
			webContext.setConfigurations(new Configuration[] { new WebXmlConfiguration(),new PlatformAnnotationConfiguration()});
			
			//jetty8
			//SelectChannelConnector connector = new SelectChannelConnector();
			//connector.setPort(port);
			//connector.setMaxIdleTime(30000);
			//connector.setRequestHeaderSize(8192);
			//QueuedThreadPool threadPool = new QueuedThreadPool(30);
			//connector.setThreadPool(threadPool);
			//server.setConnectors(new Connector[] { connector });
			
			//jetty9
			ServerConnector connector = new ServerConnector(server);
			
			//https�������
			/*HttpConfiguration config = new HttpConfiguration();
			config.setSecureScheme("https");
			config.addCustomizer(new SecureRequestCustomizer());
			SslContextFactory sslContextFactory = new SslContextFactory();
			sslContextFactory.setKeyStorePath("keystore");
			sslContextFactory.setKeyStorePassword("OBF:1ini1k1j1jg620zj1jd41jyf1ikw");
			sslContextFactory.setKeyManagerPassword("OBF:1ini1k1j1jg620zj1jd41jyf1ikw");
			ServerConnector connector = new ServerConnector(server,new SslConnectionFactory(sslContextFactory,"http/1.1"),new HttpConnectionFactory(config));*/
	        
			QueuedThreadPool threadPool = new QueuedThreadPool(50);
			connector.setPort(port);
	        server.addConnector(connector);
	        server.addBean(threadPool);
			server.setHandler(webContext);
			server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
			server.setAttribute("org.mortbay.util.URI.charset", "utf-8");
			server.setStopAtShutdown(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return server;
	}

	public static Server createServer(String warPath, String contextPath, int port) {
		//File projectFile;
		Server server;
		WebAppContext webContext;
		webContext = new WebAppContext();
		server = new Server();
		try {
			webContext.setContextPath(contextPath);
			webContext.setWar(warPath);
//			SelectChannelConnector connector = new SelectChannelConnector();
//			connector.setPort(port);
//			connector.setMaxIdleTime(30000);
//			connector.setRequestHeaderSize(8192);
//			QueuedThreadPool threadPool = new QueuedThreadPool(30);
//			connector.setThreadPool(threadPool);
//			server.setConnectors(new Connector[] { connector });
			
			QueuedThreadPool threadPool = new QueuedThreadPool(50);
			ServerConnector connector=new ServerConnector(server);
	        connector.setPort(port);
	        server.setConnectors(new Connector[] { connector });
	        server.addBean(threadPool);
	        server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
			server.setAttribute("org.mortbay.util.URI.charset", "utf-8");
			server.setHandler(webContext);
			server.setStopAtShutdown(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return server;
	}
}


///////////////////////////////

