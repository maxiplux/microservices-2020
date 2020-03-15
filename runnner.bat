start java -jar admin\adminserver\target\adminserver-0.0.1-SNAPSHOT.jar
start java -jar eurekaserver\target\eurekaserver-0.0.1-SNAPSHOT.jar
start java -jar zuul\target\zuul-0.0.1-SNAPSHOT.jar
start docker run -d -p 9411:9411 openzipkin/zipkin