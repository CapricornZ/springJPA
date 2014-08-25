springJPA
=========

1. META-INF/persistence.xml 这个文件在ear部署的时候会被weblogic自动加载，
我里面写了HibernatePersistence，所以加载的时候就报错了

2. 做法就是把persistence.xml改名，然后在applicationContext-jpa.xml里LocalContainerEntityManagerFactoryBean配置persistenceXmlLocation属性
	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"> 
		<!-- <property name="dataSource" ref="dataSource"/> -->
		<property name="persistenceXmlLocation" value="classpath:META-INF/my-persistence.xml"/>
		<property name="persistenceUnitName" value="springJPA"/>
		<property name="jpaVendorAdapter" ref="hibernateJpaVendorAdapter"/>
		<property name="packagesToScan" value="cn.ibeans"/><!--待扫描的实体类包，不再需要persistence.xml了-->
		<property name="jpaProperties">
			<props>
				<prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.hbm2ddl.auto">update</prop>
			</props>
		</property>
	</bean>
	
3. 部署的时候，让weblogic加载类的时候优先使用ear包里的class。增加src/main/java/webapp/WEB-INF/weblogic.xml，内容如下：
	<?xml version="1.0" encoding="UTF-8"?>
	<weblogic-web-app>
		<container-descriptor>
			<prefer-web-inf-classes>true</prefer-web-inf-classes>
		</container-descriptor>
	</weblogic-web-app>
