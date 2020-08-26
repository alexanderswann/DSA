public class MyStringArrayList {

	


	private String[] arr;
   public MyStringArrayList(){
		arr = new String[10];

	}
	public void add(String item){
      resize();
      for(int i = 0; i < arr.length ; i++){
         if(arr[i] == null){
            arr[i] = item;
            i += arr.length;
         } 
                  
      }
   }
   


	public String get(int ind){
      resize();
      if(ind <= arr.length){
         return arr[ind];
      }else {
         return "you did something wrong";
      }
   }
   
	public void remove(int ind){
      for(int i = ind; i < arr.length -1 ; i++){
         arr[i] = arr[i+1];
      }
      arr[arr.length -1] = null;
   }
	public void removeAll(String value){
   
      if (valueTest(value)){
         for(int i = 0; i < arr.length; i++){
            if(arr[i] == value){
               remove(i);
            }
         }
       }
      
   }
	public void set(int ind, String item){
      if (ind >= arr.length ){
         System.out.println("ind too big for set method");
      }else {
         arr[ind] = item;
      }
   }
   
   public boolean valueTest(String item){
      if(item == null){
         System.out.println("retry and enter a string");
         return false;
      }else if(item.getClass(). getName()!= "java.lang.String") {
         System.out.println("retry and enter a string");
         return false;
      }
      else{
         return true;
      }  
   }
   
   
   
	public String toString(){
      String tp = "";
      for (int i = 0; i < arr.length ; i++) {
					if(arr[i]==null){
						tp += " null ";
					}else{
                  tp += arr[i] + " ";
               }
				}
       return tp;

   }
	public void resize(){
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==null){
						x++;
			}
		}
      
      if(x == 0){
         String[] arr2 = new String[arr.length*2];
         for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
         }
         arr = arr2;
      }
   }
   
      public void add(int ind, String item){
      
      for(int i = arr.length; i <= ind; i--){
         arr[i] = arr[i-1];
      }
      set(ind, item);
   }
		//should make the array twice as big + copy data
			//make sure your instance variables are okay!

	//always remember:
		//Is this a valid ind?
		//Do I have space? Do I need to resize?

}