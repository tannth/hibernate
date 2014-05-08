package util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class ServiceLookup {
	private static Context initialContext;
	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);

			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}

	public static void listLookup() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			NamingEnumeration<NameClassPair> list = ctx.list("");
			while (list.hasMore()) {
				System.out.println("LOOKUPNAME: " + list.next().getName());
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getLookupName(String beanName1, String interfaceName1) {
		/*
		 * The app name is the EAR name of the deployed EJB without .ear suffix.
		 * Since we haven't deployed the application as a .ear, the app name for
		 * us will be an empty string
		 */
		String appName = "mantechEAR";

		/*
		 * The module name is the JAR name of the deployed EJB without the .jar
		 * suffix.
		 */
		String moduleName = "mod_biz";
		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */

		String distinctName = "";

		/*
		 * // The EJB bean implementation class name String beanName =
		 * LibrarySessionBean.class.getSimpleName();
		 */
		String beanName = beanName1;

		// Fully qualified remote interface name
		/*
		 * final String interfaceName =
		 * LibrarySessionBeanRemote.class.getName();
		 */
		String interfaceName = interfaceName1;

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + beanName
				+ "!" + interfaceName;

		return name;
	}
}
