# myRetail 

Rest API that provides product ID and description by retrieving it from RedSky API and combines with pricing information available through a NoSQL DB.

#Technologies Used
1. Java 1.8
2. Mongo DB for NOSQL Db
3. Spring-boot

Instructions to run this on a local instance 
1. Install MongoDB (https://www.mongodb.com/download-center#community)
2. Run MongDB instance using command mongod then in another terminal run a mongo shell with command mongo. By default it will connect to test. Use test DB.
3. Seed the DB with data stored in SampleProductFile.json using the following command (instead of mongoimport as it won't preserve the data type)
  - db.price.insert({"_id":16696652,"current_price": 201.99,"currency_code":"USD"})
  - db.price.insert({"_id":15117729,"current_price": 1.99,"currency_code":"USD"})
  - db.price.insert({"_id":51265453,"current_price": 269.99,"currency_code":"USD"})
  - db.price.insert({"_id":13860428,"current_price": 13.49,"currency_code":"USD"})

4. Verify data in db by db.price.find()

After cloning the code to local repository, use the port 8090 and run the application 'MyRetailApplication'

Sample rest API links:

1.(Valid Product and Valid Price in DB)- 

http://localhost:8090/product/16696652 
http://localhost:8090/product/13860428
   
2. Valid Product but no price available in DB - 

http://localhost:8090/product/13568163
  
3. Invalid Product ID/Non-existent Product ID - 

http://localhost:8090/product/1669665233
http://localhost:8090/product/16696652w

