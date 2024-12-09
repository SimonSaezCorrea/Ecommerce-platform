INSERT INTO public."DataSourceConfig"(
	id, name, url, username, password, "driverClassName", initialize)
	VALUES (1, 
			'multitenant-1', 
			'jdbc:postgresql://localhost:5432/multitenant-1?ApplicationName=multitenant',
		   	'postgres',
		    'Simon_789',
			'org.postgresql.Driver',
		   	true);
			
INSERT INTO public."DataSourceConfig"(
	id, name, url, username, password, "driverClassName", initialize)
	VALUES (2, 
			'multitenant-2', 
			'jdbc:postgresql://localhost:5432/multitenant-2?ApplicationName=multitenant',
		   	'postgres',
		    'Simon_789',
			'org.postgresql.Driver',
		   	true);