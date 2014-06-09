package com.dreamsys.pos.Licensor;

public class SerialKeyGenerator {
	
	private String serialKey;
	private String key= "SERIALKEYWORD";
	
public String GenerateSerialKey(String customerCode){
	
	StringBuffer buffer = new StringBuffer();
	
	
	String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int charactersLength = characters.length();

	for (int i = 0; i < 4; i++) {
		double index = Math.random() * charactersLength;
		buffer.append(characters.charAt((int) index));
		
	}

	System.out.println(customerCode);
  
   serialKey =encipher(customerCode,key);
   serialKey =buffer.toString().substring(0, 2).concat(serialKey).concat(buffer.toString().substring(2, 4)).toUpperCase();
	System.out.println(serialKey);
 serialKey = serialKey.substring(0, 4).concat("-").concat(serialKey.substring(4, 8).concat("-").concat(serialKey.substring(8,12)));
	
 
    
    System.out.println(serialKey);
	return serialKey;
	
	
}	

//Sets the key explicitly for encryption 	
public void setKey(String key){
	key =key.replaceAll("[^a-zA]", "");
	key =key.toUpperCase();
	this.key=key;
}

//returns the key being used for encryption
public String getKey(){
	
	return this.key;
}

// encryption method
public static String encipher(String s, String key){

StringBuilder builder = new StringBuilder();

for(int i = 0; i < s.length(); i ++){

if(s.charAt(i) < 65 || s.charAt(i) > 90){ //ASCII character (capital letter)

throw new IllegalArgumentException("" +

"Open text must contain only capital letters");

}

//add shift modularly

char encyphered = s.charAt(i) + getShift(key, i) > 90 ? (char)((s.charAt(i) + getShift(key, i)) - 26) : (char)(s.charAt(i) + getShift(key, i));

builder.append(encyphered);

}

return builder.toString();

}

private static int getShift(String key, int i) {

if(key.charAt(i % key.length()) < 65 || key.charAt(i % key.length()) > 90){

throw new IllegalArgumentException("" +

"Key phrase must contain only capital letters");

}

return ((int)key.charAt(i % key.length())) - 65;

}

	
	public static void main(String[] args){
		
		
		 // use case
		// Instantiate the class 
	   //  Invoke the method  GenerateSerialKey supplying the customer code as parameter
	  //   Key for encryption can also be explicitly defined  using setkey method 
	 //	provided that same key is used for decryption in validation
		SerialKeyGenerator generate = new  SerialKeyGenerator();
		generate.GenerateSerialKey("EFCFACDF");
		
		
		
	}

}
