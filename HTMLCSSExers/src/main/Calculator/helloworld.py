[ERROR] Plugin org.apache.maven.plugins:maven-resources-plugin:2.6 or one of its dependencies could not be resolved: Failed to read artifact descriptor for org.apache.maven.plugins:maven-resources-plugin:jar:2.6: 
Could not transfer artifact org.apache.maven.plugins:maven-resources-plugin:pom:2.6 from/to central (https://repo.maven.apache.org/maven2): C:\Program Files\Maven\apache-maven-3.5.4\repository\org\apache\maven\plugins\maven-resources-plugin\2.6\maven-resources-plugin-2.6.pom.part.lock (Access is denied) -> [Help 1]


[ERROR] Plugin org.apache.maven.plugins:maven-resources-plugin:2.6 or one of its dependencies could not be resolved: Failed to read artifact descriptor for org.apache.maven.plugins:maven-resources-plugin:jar:2.6: Could not transfer artifact org.apache.maven.plugins:maven-resources-plugin:pom:2.6 from/to central (https://repo.maven.apache.org/maven2): C:\Program Files\Maven\apache-maven-3.5.4\repository\org\apache\maven\plugins\maven-resources-plugin\2.6\maven-resources-plugin-2.6.pom.part.lock (Access is denied) -> [Help 1]


<proxies>
    <proxy>
      <id>optional</id>
      <active>true</active>
      <protocol>http</protocol>
       <username></username>
      <host>proxy.tma.com.vn</host>
      <port>8080</port>
      <nonProxyHosts>local.net|some.host.com</nonProxyHosts>
    </proxy>
  </proxies>